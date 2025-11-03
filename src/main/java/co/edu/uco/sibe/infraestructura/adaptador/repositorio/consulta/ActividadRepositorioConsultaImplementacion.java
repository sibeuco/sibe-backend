package co.edu.uco.sibe.infraestructura.adaptador.repositorio.consulta;

import co.edu.uco.sibe.dominio.dto.ActividadDTO;
import co.edu.uco.sibe.dominio.dto.EjecucionActividadDTO;
import co.edu.uco.sibe.dominio.modelo.*;
import co.edu.uco.sibe.dominio.puerto.consulta.ActividadRepositorioConsulta;
import co.edu.uco.sibe.infraestructura.adaptador.dao.ActividadDAO;
import co.edu.uco.sibe.infraestructura.adaptador.dao.EjecucionActividadDAO;
import co.edu.uco.sibe.infraestructura.adaptador.mapeador.ActividadMapeador;
import co.edu.uco.sibe.infraestructura.adaptador.mapeador.AreaMapeador;
import co.edu.uco.sibe.infraestructura.adaptador.mapeador.DireccionMapeador;
import co.edu.uco.sibe.infraestructura.adaptador.mapeador.EjecucionActividadMapeador;
import co.edu.uco.sibe.infraestructura.adaptador.mapeador.SubareaMapeador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.UUID;
import static co.edu.uco.sibe.dominio.transversal.utilitarios.ValidadorObjeto.esNulo;

@Repository
public class ActividadRepositorioConsultaImplementacion implements ActividadRepositorioConsulta {

    @Autowired
    private ActividadDAO actividadDAO;
    @Autowired
    private ActividadMapeador actividadMapeador;
    @Autowired
    private EjecucionActividadDAO ejecucionActividadDAO;
    @Autowired
    private EjecucionActividadMapeador ejecucionActividadMapeador;
    @Autowired
    private SubareaMapeador subareaMapeador;
    @Autowired
    private AreaMapeador areaMapeador;
    @Autowired
    private DireccionMapeador direccionMapeador;


    @Override
    public Actividad consultarPorIdentificador(UUID identificador) {
        var entidad = this.actividadDAO.findById(identificador).orElse(null);

        if (esNulo(entidad)) {
            return null;
        }

        return this.actividadMapeador.construirModelo(entidad);
    }

    @Override
    public Actividad consultarPorNombreYSemestre(String nombre, String semestre) {
        var entidad = this.actividadDAO.findByNombreAndSemestre(nombre, semestre);

        if (esNulo(entidad)) {
            return null;
        }

        return this.actividadMapeador.construirModelo(entidad);
    }

    @Override
    public List<ActividadDTO> consultarPorSubarea(Subarea subarea) {
        var entidad = subareaMapeador.construirEntidad(subarea);

        return this.actividadMapeador.construirDTOs(entidad.getActividades());
    }

    @Override
    public List<ActividadDTO> consultarPorArea(Area area) {
        var entidad = areaMapeador.construirEntidad(area);

        return this.actividadMapeador.construirDTOs(entidad.getActividades());
    }

    @Override
    public List<ActividadDTO> consultarPorDireccion(Direccion direccion) {
        var entidad = direccionMapeador.construirEntidad(direccion);

        return this.actividadMapeador.construirDTOs(entidad.getActividades());
    }

    @Override
    public List<EjecucionActividadDTO> consultarFechasProgramadasPorActividad(Actividad actividad) {
        var entidades = this.ejecucionActividadDAO.findByActividadIdentificador(actividad.getIdentificador());

        return this.ejecucionActividadMapeador.construirDTOs(entidades);
    }

    @Override
    public EjecucionActividad consultarEjecucionActividadPorIdentificador(UUID identificador) {
        var entidad = this.ejecucionActividadDAO.findById(identificador).orElse(null);

        if (esNulo(entidad)) {
            return null;
        }

        return this.ejecucionActividadMapeador.construirModelo(entidad);
    }
}