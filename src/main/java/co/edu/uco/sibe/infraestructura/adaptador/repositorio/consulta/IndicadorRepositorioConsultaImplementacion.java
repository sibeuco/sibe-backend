package co.edu.uco.sibe.infraestructura.adaptador.repositorio.consulta;

import co.edu.uco.sibe.dominio.dto.IndicadorDTO;
import co.edu.uco.sibe.dominio.dto.RespuestaPaginada;
import co.edu.uco.sibe.dominio.dto.SolicitudPaginacion;
import co.edu.uco.sibe.dominio.modelo.Indicador;
import co.edu.uco.sibe.dominio.puerto.consulta.IndicadorRepositorioConsulta;
import co.edu.uco.sibe.dominio.transversal.constante.IndicadorConstante;
import co.edu.uco.sibe.infraestructura.adaptador.dao.IndicadorDAO;
import co.edu.uco.sibe.infraestructura.adaptador.mapeador.IndicadorMapeador;
import co.edu.uco.sibe.infraestructura.adaptador.repositorio.util.PaginacionUtil;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.UUID;
import static co.edu.uco.sibe.dominio.transversal.utilitarios.ValidadorObjeto.esNulo;

@Repository
@AllArgsConstructor
public class IndicadorRepositorioConsultaImplementacion implements IndicadorRepositorioConsulta {
    private final IndicadorDAO indicadorDAO;
    private final IndicadorMapeador indicadorMapeador;

    @Override
    public List<IndicadorDTO> consultarDTOs() {
        var entidades = indicadorDAO.findAll();

        return this.indicadorMapeador.construirDTOs(entidades);
    }

    @Override
    public List<IndicadorDTO> consultarDTOsParaActividades() {
        return consultarDTOs().stream()
                .filter(dto -> !IndicadorConstante.esIndicadorGlobal(dto.getNombre()))
                .toList();
    }

    @Override
    public Indicador consultarPorIdentificador(UUID identificador) {
        var entidad = this.indicadorDAO.findById(identificador).orElse(null);

        if(esNulo(entidad)) {
            return null;
        }

        return this.indicadorMapeador.construriModelo(entidad);
    }

    @Override
    public Indicador consultarPorNombre(String nombre) {
        var entidad = this.indicadorDAO.findByNombre(nombre);

        if(esNulo(entidad)) {
            return null;
        }

        return this.indicadorMapeador.construriModelo(entidad);
    }

    @Override
    public RespuestaPaginada<IndicadorDTO> consultarDTOsPaginado(SolicitudPaginacion solicitud) {
        var pageRequest = PaginacionUtil.crearPageRequest(solicitud, Sort.by(Sort.Direction.ASC, "nombre"));
        String busqueda = solicitud.getBusqueda();

        var pagina = (busqueda == null || busqueda.isBlank())
                ? indicadorDAO.findAll(pageRequest)
                : indicadorDAO.buscarPaginado(busqueda, pageRequest);

        return PaginacionUtil.convertir(pagina, indicadorMapeador::construirDTO);
    }
}