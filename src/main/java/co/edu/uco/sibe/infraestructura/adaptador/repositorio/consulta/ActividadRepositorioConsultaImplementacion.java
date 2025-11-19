package co.edu.uco.sibe.infraestructura.adaptador.repositorio.consulta;

import co.edu.uco.sibe.dominio.dto.ActividadDTO;
import co.edu.uco.sibe.dominio.dto.EjecucionActividadDTO;
import co.edu.uco.sibe.dominio.dto.ParticipanteDTO;
import co.edu.uco.sibe.dominio.modelo.*;
import co.edu.uco.sibe.dominio.puerto.consulta.ActividadRepositorioConsulta;
import co.edu.uco.sibe.dominio.transversal.utilitarios.ValidadorTexto;
import co.edu.uco.sibe.infraestructura.adaptador.dao.ActividadDAO;
import co.edu.uco.sibe.infraestructura.adaptador.dao.EjecucionActividadDAO;
import co.edu.uco.sibe.infraestructura.adaptador.dao.ParticipanteDAO;
import co.edu.uco.sibe.infraestructura.adaptador.entidad.ParticipanteEntidad;
import co.edu.uco.sibe.infraestructura.adaptador.mapeador.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import java.time.Year;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.UUID;
import static co.edu.uco.sibe.dominio.transversal.constante.DatoConstante.FINALIZADA;
import static co.edu.uco.sibe.dominio.transversal.utilitarios.ValidadorObjeto.esNulo;

@Repository
@AllArgsConstructor
public class ActividadRepositorioConsultaImplementacion implements ActividadRepositorioConsulta {
    private static final DateTimeFormatter FORMATO_MES_ANIO = DateTimeFormatter.ofPattern("MMMM yyyy", new Locale("es", "CO"));

    private final ActividadDAO actividadDAO;
    private final ActividadMapeador actividadMapeador;
    private final EjecucionActividadDAO ejecucionActividadDAO;
    private final ParticipanteDAO participanteDAO;
    private final EjecucionActividadMapeador ejecucionActividadMapeador;
    private final SubareaMapeador subareaMapeador;
    private final AreaMapeador areaMapeador;
    private final DireccionMapeador direccionMapeador;
    private final ParticipanteDetalladoMapeador participanteDetalladoMapeador;

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

    @Override
    public List<ParticipanteDTO> consultarParticipantesPorEjecucionActividad(UUID ejecucionActividad) {
        List<ParticipanteEntidad> participantes = this.ejecucionActividadDAO.findParticipantesByEjecucionActividadId(ejecucionActividad);

        return this.participanteDetalladoMapeador.construirDTOs(participantes);
    }

    @Override
    public List<String> consultarMesesEjecucionesFinalizadas() {
        var fechas = ejecucionActividadDAO.findFechasRealizacionByEstadoNombre(FINALIZADA);

        return fechas.stream()
                .map(YearMonth::from)
                .distinct()
                .sorted((a, b) -> b.compareTo(a))
                .map(yearMonth -> {
                    String fechaTexto = yearMonth.format(FORMATO_MES_ANIO);
                    return fechaTexto.substring(0, 1).toUpperCase() + fechaTexto.substring(1);
                })
                .toList();
    }

    @Override
    public List<String> consultarAnnosEjecucionesFinalizadas() {
        var fechas = ejecucionActividadDAO.findFechasRealizacionByEstadoNombre(FINALIZADA);

        return fechas.stream()
                .map(fecha -> Year.from(fecha).getValue())
                .distinct()
                .sorted(Comparator.reverseOrder())
                .map(String::valueOf)
                .toList();
    }

    @Override
    public List<String> consultarSemestresEstudiantesEnEjecucionesFinalizadas() {
        return participanteDAO.findSemestresEstudiantesByEstadoEjecucion(FINALIZADA);
    }

    @Override
    public List<String> consultarCentrosCostosEmpleadosEnEjecucionesFinalizadas() {
        return participanteDAO.findCentrosCostosEmpleadosByEstadoEjecucion(FINALIZADA);
    }

    @Override
    public List<String> consultarTiposParticipantesEnEjecucionesFinalizadas() {
        return participanteDAO.findTiposParticipantesByEstadoEjecucion(FINALIZADA);
    }

    @Override
    public List<String> consultarProgramasAcademicosEstudiantesEnEjecucionesFinalizadas() {
        return participanteDAO.findProgramasAcademicosEstudiantesByEstadoEjecucion(FINALIZADA);
    }

    @Override
    public List<String> consultarNivelesFormacionEstudiantesEnEjecucionesFinalizadas() {
        List<String> programas = participanteDAO.findProgramasAcademicosEstudiantesByEstadoEjecucion(FINALIZADA);

        return programas.stream()
                .map(ValidadorTexto::obtenerTipoPrograma)
                .distinct()
                .sorted(Comparator.reverseOrder())
                .toList();
    }

    @Override
    public List<String> consultarIndicadoresEnEjecucionesFinalizadas() {
        return ejecucionActividadDAO.findNombresIndicadoresByEstadoEjecucion(FINALIZADA);
    }
}