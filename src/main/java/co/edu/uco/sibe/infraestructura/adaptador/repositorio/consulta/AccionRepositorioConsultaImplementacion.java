package co.edu.uco.sibe.infraestructura.adaptador.repositorio.consulta;

import co.edu.uco.sibe.dominio.dto.AccionDTO;
import co.edu.uco.sibe.dominio.dto.RespuestaPaginada;
import co.edu.uco.sibe.dominio.dto.SolicitudPaginacion;
import co.edu.uco.sibe.dominio.modelo.Accion;
import co.edu.uco.sibe.dominio.puerto.consulta.AccionRepositorioConsulta;
import co.edu.uco.sibe.infraestructura.adaptador.dao.AccionDAO;
import co.edu.uco.sibe.infraestructura.adaptador.mapeador.AccionMapeador;
import co.edu.uco.sibe.infraestructura.adaptador.repositorio.util.PaginacionUtil;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.UUID;
import static co.edu.uco.sibe.dominio.transversal.utilitarios.ValidadorObjeto.esNulo;

@Repository
@AllArgsConstructor
public class AccionRepositorioConsultaImplementacion implements AccionRepositorioConsulta {
    private final AccionDAO accionDAO;
    private final AccionMapeador accionMapeador;

    @Override
    public List<AccionDTO> consultarDTOs() {
        var entidades = this.accionDAO.findAll();

        return this.accionMapeador.construirDTOs(entidades);
    }

    @Override
    public List<Accion> consultarTodosPorIdentificadores(List<UUID> identificadores) {
        var entidades = this.accionDAO.findAllById(identificadores);

        return this.accionMapeador.construirModelos(entidades);
    }

    @Override
    public Accion consultarPorIdentificador(UUID identificador) {
        var entidad = this.accionDAO.findById(identificador).orElse(null);

        if(esNulo(entidad)){
            return null;
        }

        return this.accionMapeador.construriModelo(entidad);
    }

    @Override
    public List<Accion> consultarTodos() {
        var entidades = this.accionDAO.findAll();

        return this.accionMapeador.construirModelos(entidades);
    }

    @Override
    public Accion consultarPorDetalle(String detalle) {
        var entidad = this.accionDAO.findByDetalle(detalle);

        if(esNulo(entidad)){
            return null;
        }

        return this.accionMapeador.construriModelo(entidad);
    }

    @Override
    public RespuestaPaginada<AccionDTO> consultarDTOsPaginado(SolicitudPaginacion solicitud) {
        var pageRequest = PaginacionUtil.crearPageRequest(solicitud, Sort.by(Sort.Direction.ASC, "detalle"));
        String busqueda = solicitud.getBusqueda();

        var pagina = (busqueda == null || busqueda.isBlank())
                ? accionDAO.findAll(pageRequest)
                : accionDAO.buscarPaginado(busqueda, pageRequest);

        return PaginacionUtil.convertir(pagina, accionMapeador::construirDTO);
    }
}