package co.edu.uco.sibe.infraestructura.adaptador.repositorio.consulta;

import co.edu.uco.sibe.dominio.dto.ActividadDTO;
import co.edu.uco.sibe.dominio.dto.EjecucionActividadDTO;
import co.edu.uco.sibe.dominio.dto.FiltroEstadisticaDTO;
import co.edu.uco.sibe.dominio.dto.ParticipanteDTO;
import co.edu.uco.sibe.dominio.modelo.*;
import co.edu.uco.sibe.dominio.puerto.consulta.ActividadRepositorioConsulta;
import co.edu.uco.sibe.dominio.transversal.utilitarios.ValidadorTexto;
import co.edu.uco.sibe.infraestructura.adaptador.dao.ActividadDAO;
import co.edu.uco.sibe.infraestructura.adaptador.dao.EjecucionActividadDAO;
import co.edu.uco.sibe.infraestructura.adaptador.dao.ParticipanteDAO;
import co.edu.uco.sibe.infraestructura.adaptador.entidad.ParticipanteEmpleadoEntidad;
import co.edu.uco.sibe.infraestructura.adaptador.entidad.ParticipanteEntidad;
import co.edu.uco.sibe.infraestructura.adaptador.entidad.ParticipanteEstudianteEntidad;
import co.edu.uco.sibe.infraestructura.adaptador.entidad.ParticipanteExternoEntidad;
import co.edu.uco.sibe.infraestructura.adaptador.mapeador.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import java.time.Year;
import java.time.format.DateTimeFormatter;
import java.util.*;
import static co.edu.uco.sibe.dominio.transversal.constante.DatoConstante.FINALIZADA;
import static co.edu.uco.sibe.dominio.transversal.utilitarios.ValidadorObjeto.esNulo;
import static co.edu.uco.sibe.dominio.transversal.utilitarios.ValidadorTexto.estaCadenaVacia;

@Repository
@AllArgsConstructor
public class ActividadRepositorioConsultaImplementacion implements ActividadRepositorioConsulta {
    private static final DateTimeFormatter FORMATO_MES_ANIO = DateTimeFormatter.ofPattern("MMMM yyyy", new Locale("es", "CO"));

    private final EntityManager entityManager;
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
                .map(java.time.LocalDate::getMonth)
                .distinct()
                .sorted(java.util.Comparator.reverseOrder())
                .map(month -> {
                    String nombreMes = month.getDisplayName(java.time.format.TextStyle.FULL, new java.util.Locale("es", "CO"));

                    return nombreMes.substring(0, 1).toUpperCase() + nombreMes.substring(1);
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
    public List<String> consultarSemestresActividadesEnEjecucionesFinalizadas() {
        return ejecucionActividadDAO.findSemestresActividadesByEstadoEjecucion(FINALIZADA);
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

    @Override
    public Long contarParticipantesTotales(FiltroEstadisticaDTO filtro) {
        String selectClause = "SELECT COUNT(DISTINCT p.identificador) ";

        return ejecutarConsultaDinamica(selectClause, filtro);
    }

    @Override
    public Long contarAsistenciasTotales(FiltroEstadisticaDTO filtro) {
        String selectClause = "SELECT COUNT(ra) ";

        return ejecutarConsultaDinamica(selectClause, filtro);
    }

    @Override
    public Long contarEjecucionesTotales(FiltroEstadisticaDTO filtro) {
        String selectClause = "SELECT COUNT(DISTINCT ea.identificador) ";
        return ejecutarConsultaDinamica(selectClause, filtro);
    }

    private Long ejecutarConsultaDinamica(String selectClause, FiltroEstadisticaDTO filtro) {
        StringBuilder jpql = new StringBuilder();
        Map<String, Object> parametros = new HashMap<>();

        jpql.append(selectClause);
        jpql.append("FROM RegistroAsistenciaEntidad ra ");
        jpql.append("JOIN ra.participante p ");
        jpql.append("JOIN ra.ejecucionActividad ea ");
        jpql.append("JOIN ea.actividad a ");
        jpql.append("LEFT JOIN ParticipanteEstudianteEntidad pe ON pe.identificador = p.identificador ");
        jpql.append("LEFT JOIN ParticipanteEmpleadoEntidad pem ON pem.identificador = p.identificador ");

        jpql.append("WHERE ea.estadoActividad.estadoActividad.nombre = :estado ");
        parametros.put("estado", FINALIZADA);

        if (filtro.getAnno() != null && filtro.getAnno() > 0) {
            jpql.append("AND YEAR(ea.fechaRealizacion) = :anno ");
            parametros.put("anno", filtro.getAnno());
        }

        if (!estaCadenaVacia(filtro.getMes())) {
            try {
                java.time.format.DateTimeFormatter parser = new java.time.format.DateTimeFormatterBuilder()
                        .parseCaseInsensitive()
                        .appendPattern("MMMM")
                        .toFormatter(new java.util.Locale("es", "CO"));

                java.time.temporal.TemporalAccessor accessor = parser.parse(filtro.getMes());
                int numeroMes = accessor.get(java.time.temporal.ChronoField.MONTH_OF_YEAR);

                jpql.append("AND MONTH(ea.fechaRealizacion) = :mesValor ");
                parametros.put("mesValor", numeroMes);
            } catch (Exception ignored) {
            }
        }

        if (!estaCadenaVacia(filtro.getIndicador())) {
            jpql.append("AND a.indicador.nombre = :indicador ");
            parametros.put("indicador", filtro.getIndicador());
        }

        if (!estaCadenaVacia(filtro.getTipoParticipante())) {
            jpql.append("AND TYPE(p) = :tipoEntidad ");

            if ("ESTUDIANTE".equalsIgnoreCase(filtro.getTipoParticipante())) {
                parametros.put("tipoEntidad", ParticipanteEstudianteEntidad.class);
            } else if ("EMPLEADO".equalsIgnoreCase(filtro.getTipoParticipante())) {
                parametros.put("tipoEntidad", ParticipanteEmpleadoEntidad.class);
            } else if ("EXTERNO".equalsIgnoreCase(filtro.getTipoParticipante())) {
                parametros.put("tipoEntidad", ParticipanteExternoEntidad.class);
            }
        }

        if (!estaCadenaVacia(filtro.getSemestre())) {
            jpql.append("AND a.semestre = :semestre ");
            parametros.put("semestre", filtro.getSemestre());
        }

        if (!estaCadenaVacia(filtro.getProgramaAcademico())) {
            jpql.append("AND pe.programaAcademico = :programa ");
            parametros.put("programa", filtro.getProgramaAcademico());
        }

        if (!estaCadenaVacia(filtro.getTipoProgramaAcademico())) {
            String tipo = filtro.getTipoProgramaAcademico().toUpperCase();

            if ("POSTGRADO".equals(tipo)) {
                jpql.append("AND (UPPER(pe.programaAcademico) LIKE '%ESPECIALIZACION%' " +
                        "OR UPPER(pe.programaAcademico) LIKE '%MAESTRIA%' " +
                        "OR UPPER(pe.programaAcademico) LIKE '%DOCTORADO%') ");
            } else if ("PREGRADO".equals(tipo)) {
                jpql.append("AND (UPPER(pe.programaAcademico) NOT LIKE '%ESPECIALIZACION%' " +
                        "AND UPPER(pe.programaAcademico) NOT LIKE '%MAESTRIA%' " +
                        "AND UPPER(pe.programaAcademico) NOT LIKE '%DOCTORADO%') ");
            }
        }

        if (!estaCadenaVacia(filtro.getCentroCostos())) {
            jpql.append("AND pem.centroCostos.centroCostos.descripcion = :centroCostos ");
            parametros.put("centroCostos", filtro.getCentroCostos());
        }

        if (filtro.getIdArea() != null && !estaCadenaVacia(filtro.getTipoArea())) {
            String tipoArea = filtro.getTipoArea().toUpperCase();

            switch (tipoArea) {
                case "SUBAREA" ->
                        jpql.append("AND EXISTS (SELECT 1 FROM SubareaEntidad sub JOIN sub.actividades act WHERE sub.identificador = :idArea AND act.identificador = a.identificador) ");

                case "AREA" ->
                        jpql.append("AND (")
                                .append("EXISTS (SELECT 1 FROM AreaEntidad ar JOIN ar.actividades act WHERE ar.identificador = :idArea AND act.identificador = a.identificador) ")
                                .append("OR EXISTS (SELECT 1 FROM AreaEntidad ar JOIN ar.subareas sub JOIN sub.actividades act WHERE ar.identificador = :idArea AND act.identificador = a.identificador)")
                                .append(") ");

                case "DIRECCION" ->
                        jpql.append("AND (")
                                .append("EXISTS (SELECT 1 FROM DireccionEntidad dir JOIN dir.actividades act WHERE dir.identificador = :idArea AND act.identificador = a.identificador) ")
                                .append("OR EXISTS (SELECT 1 FROM DireccionEntidad dir JOIN dir.areas ar JOIN ar.actividades act WHERE dir.identificador = :idArea AND act.identificador = a.identificador) ")
                                .append("OR EXISTS (SELECT 1 FROM DireccionEntidad dir JOIN dir.areas ar JOIN ar.subareas sub JOIN sub.actividades act WHERE dir.identificador = :idArea AND act.identificador = a.identificador)")
                                .append(") ");
            }
            parametros.put("idArea", filtro.getIdArea());
        }

        Query query = entityManager.createQuery(jpql.toString());
        parametros.forEach(query::setParameter);

        return (Long) query.getSingleResult();
    }
}