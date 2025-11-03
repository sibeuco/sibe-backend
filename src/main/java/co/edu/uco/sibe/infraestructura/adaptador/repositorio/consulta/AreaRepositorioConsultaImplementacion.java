package co.edu.uco.sibe.infraestructura.adaptador.repositorio.consulta;

import co.edu.uco.sibe.dominio.dto.AreaDTO;
import co.edu.uco.sibe.dominio.dto.AreaDetalladaDTO;
import co.edu.uco.sibe.dominio.modelo.Actividad;
import co.edu.uco.sibe.dominio.modelo.Area;
import co.edu.uco.sibe.dominio.puerto.consulta.AreaRepositorioConsulta;
import co.edu.uco.sibe.dominio.transversal.utilitarios.ValidadorNumero;
import co.edu.uco.sibe.dominio.transversal.utilitarios.ValidadorObjeto;
import co.edu.uco.sibe.infraestructura.adaptador.dao.AreaDAO;
import co.edu.uco.sibe.infraestructura.adaptador.mapeador.AreaDetalladaMapeador;
import co.edu.uco.sibe.infraestructura.adaptador.mapeador.AreaMapeador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.UUID;
import static co.edu.uco.sibe.dominio.transversal.constante.NumeroConstante.CERO;
import static co.edu.uco.sibe.dominio.transversal.utilitarios.ValidadorObjeto.esNulo;

@Repository
public class AreaRepositorioConsultaImplementacion implements AreaRepositorioConsulta {
    @Autowired
    private AreaDAO areaDAO;

    @Autowired
    private AreaMapeador areaMapeador;

    @Autowired
    private AreaDetalladaMapeador areaDetalladaMapeador;

    @Override
    public List<AreaDTO> consultarDTOs() {
        var entidades = this.areaDAO.findAll();

        return this.areaMapeador.construirDTOs(entidades);
    }

    @Override
    public List<Area> consultarTodos() {
        var entidades = this.areaDAO.findAll();

        return this.areaMapeador.construirModelos(entidades);
    }

    @Override
    public Area consultarPorIdentificador(UUID identificador) {
        var entidad = this.areaDAO.findById(identificador).orElse(null);

        if(ValidadorObjeto.esNulo(entidad)) {
            return null;
        }

        return this.areaMapeador.construirModelo(entidad);
    }

    @Override
    public boolean hayDatos() {
        var cantidad = areaDAO.count();

        return ValidadorNumero.esNumeroMayor(cantidad, CERO);
    }

    @Override
    public Area consultarPorNombre(String nombre) {
        var entidad = this.areaDAO.findByNombre(nombre);

        if(ValidadorObjeto.esNulo(entidad)) {
            return null;
        }

        return this.areaMapeador.construirModelo(entidad);
    }

    @Override
    public Area consultarPorActividad(Actividad actividad) {
        var entidad = this.areaDAO.findByActividades_Identificador(actividad.getIdentificador());

        if(esNulo(entidad)) {
            return null;
        }

        return this.areaMapeador.construirModelo(entidad);
    }

    @Override
    public AreaDetalladaDTO consultarDetallePorIdentificador(UUID identificador) {
        var entidad = this.areaDAO.findById(identificador).orElse(null);

        if(esNulo(entidad)) {
            return null;
        }

        return this.areaDetalladaMapeador.construirDTO(entidad);
    }

    @Override
    public AreaDTO consultarPorNombreDTO(String nombre) {
        var entidad = this.areaDAO.findByNombre(nombre);

        if(esNulo(entidad)) {
            return null;
        }

        return this.areaMapeador.construirDTO(entidad);
    }
}