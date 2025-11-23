package co.edu.uco.sibe.infraestructura.adaptador.repositorio.consulta;

import co.edu.uco.sibe.dominio.dto.*;
import co.edu.uco.sibe.dominio.enums.TipoArea;
import co.edu.uco.sibe.dominio.enums.TipoInterno;
import co.edu.uco.sibe.dominio.enums.TipoParticipante;
import co.edu.uco.sibe.dominio.enums.TipoPrograma;
import co.edu.uco.sibe.dominio.modelo.*;
import co.edu.uco.sibe.dominio.puerto.consulta.ActividadRepositorioConsulta;
import co.edu.uco.sibe.dominio.transversal.utilitarios.ValidadorTexto;
import co.edu.uco.sibe.infraestructura.adaptador.dao.*;
import co.edu.uco.sibe.infraestructura.adaptador.entidad.*;
import co.edu.uco.sibe.infraestructura.adaptador.mapeador.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.time.Month;
import java.time.Year;
import java.time.format.TextStyle;
import java.time.temporal.ChronoField;
import java.util.*;
import static co.edu.uco.sibe.dominio.transversal.constante.DatoConstante.*;
import static co.edu.uco.sibe.dominio.transversal.constante.PersistenciaConstante.*;
import static co.edu.uco.sibe.dominio.transversal.utilitarios.ValidadorObjeto.esNulo;
import static co.edu.uco.sibe.dominio.transversal.utilitarios.ValidadorTexto.estaCadenaVacia;

@Repository
@AllArgsConstructor
@Transactional(readOnly = true)
public class ActividadRepositorioConsultaImplementacion implements ActividadRepositorioConsulta {
    private static final Locale LOCALE_CO = new Locale(IDIOMA_ES, PAIS_CO);

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
    private final DireccionDAO direccionDAO;
    private final AreaDAO areaDAO;
    private final SubareaDAO subareaDAO;

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
    public List<String> consultarAnnosEjecucionesFinalizadas() {
        var fechas = ejecucionActividadDAO.findFechasRealizacionByEstadoNombre(FINALIZADA);

        return fechas
                .stream()
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

        return programas
                .stream()
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
    public List<String> consultarMesesEjecucionesFinalizadas() {
        var fechas = ejecucionActividadDAO.findFechasRealizacionByEstadoNombre(FINALIZADA);

        return fechas.stream()
                .map(java.time.LocalDate::getMonth)
                .distinct()
                .sorted(Comparator.reverseOrder())
                .map(month -> {
                    String nombreMes = month.getDisplayName(TextStyle.FULL, LOCALE_CO);
                    return nombreMes.substring(0, 1).toUpperCase() + nombreMes.substring(1);
                })
                .toList();
    }

    @Override
    public Long contarParticipantesTotales(FiltroEstadisticaDTO filtro) {
        return ejecutarConsultaDinamica(SELECT_COUNT_DISTINCT_PARTICIPANTE, filtro);
    }

    @Override
    public Long contarAsistenciasTotales(FiltroEstadisticaDTO filtro) {
        return ejecutarConsultaDinamica(SELECT_COUNT_ASISTENCIA, filtro);
    }

    @Override
    public Long contarEjecucionesTotales(FiltroEstadisticaDTO filtro) {
        return ejecutarConsultaDinamica(SELECT_COUNT_DISTINCT_EJECUCION, filtro);
    }

    @Override
    public List<EstadisticaDTO> consultarEstadisticasParticipantesPorEstructura(FiltroEstadisticaDTO filtroOriginal) {
        List<EstadisticaDTO> estadisticas = new ArrayList<>();

        Set<UUID> direccionesPermitidas = new HashSet<>();
        Set<UUID> areasPermitidas = new HashSet<>();
        Set<UUID> subareasPermitidas = new HashSet<>();

        boolean hayFiltroEstructura = filtroOriginal.getIdArea() != null && !estaCadenaVacia(filtroOriginal.getTipoArea());

        if (hayFiltroEstructura) {
            String tipo = filtroOriginal.getTipoArea().toUpperCase();
            UUID id = filtroOriginal.getIdArea();

            if (TipoArea.DIRECCION.name().equals(tipo)) {
                direccionDAO.findById(id).ifPresent(dir -> {
                    direccionesPermitidas.add(dir.getIdentificador());
                    if (dir.getAreas() != null) {
                        for (AreaEntidad area : dir.getAreas()) {
                            areasPermitidas.add(area.getIdentificador());
                            if (area.getSubareas() != null) {
                                area.getSubareas().forEach(sub -> subareasPermitidas.add(sub.getIdentificador()));
                            }
                        }
                    }
                });
            } else if (TipoArea.AREA.name().equals(tipo)) {
                areaDAO.findById(id).ifPresent(area -> {
                    areasPermitidas.add(area.getIdentificador());
                    if (area.getSubareas() != null) {
                        area.getSubareas().forEach(sub -> subareasPermitidas.add(sub.getIdentificador()));
                    }
                });
            } else if (TipoArea.SUBAREA.name().equals(tipo)) {
                subareasPermitidas.add(id);
            }
        }

        var direcciones = direccionDAO.findAll();
        for (var direccion : direcciones) {
            boolean permitido = !hayFiltroEstructura || direccionesPermitidas.contains(direccion.getIdentificador());
            estadisticas.add(calcularEstadisticasNodo(filtroOriginal, direccion.getIdentificador(), TipoArea.DIRECCION.name(), direccion.getNombre(), permitido));
        }

        var areas = areaDAO.findAll();
        for (var area : areas) {
            boolean permitido = !hayFiltroEstructura || areasPermitidas.contains(area.getIdentificador());
            estadisticas.add(calcularEstadisticasNodo(filtroOriginal, area.getIdentificador(), TipoArea.AREA.name(), area.getNombre(), permitido));
        }

        var subareas = subareaDAO.findAll();
        for (var subarea : subareas) {
            boolean permitido = !hayFiltroEstructura || subareasPermitidas.contains(subarea.getIdentificador());
            estadisticas.add(calcularEstadisticasNodo(filtroOriginal, subarea.getIdentificador(), TipoArea.SUBAREA.name(), subarea.getNombre(), permitido));
        }

        return estadisticas;
    }

    @Override
    public List<EstadisticaMesDTO> consultarEstadisticasParticipantesPorMes(FiltroEstadisticaDTO filtroOriginal) {
        List<EstadisticaMesDTO> estadisticas = new ArrayList<>();

        for (Month mes : Month.values()) {
            String nombreMes = mes.getDisplayName(TextStyle.FULL, LOCALE_CO);
            nombreMes = nombreMes.substring(0, 1).toUpperCase() + nombreMes.substring(1);

            FiltroEstadisticaDTO filtroMes = new FiltroEstadisticaDTO(
                    nombreMes,
                    filtroOriginal.getAnno(),
                    filtroOriginal.getSemestre(),
                    filtroOriginal.getProgramaAcademico(),
                    filtroOriginal.getTipoProgramaAcademico(),
                    filtroOriginal.getCentroCostos(),
                    filtroOriginal.getTipoParticipante(),
                    filtroOriginal.getIndicador(),
                    filtroOriginal.getTipoArea(),
                    filtroOriginal.getIdArea()
            );

            Long totalParticipantes = contarParticipantesTotales(filtroMes);
            Long totalAsistencias = contarAsistenciasTotales(filtroMes);

            estadisticas.add(new EstadisticaMesDTO(nombreMes, totalParticipantes, totalAsistencias));
        }

        return estadisticas;
    }

    private EstadisticaDTO calcularEstadisticasNodo(FiltroEstadisticaDTO filtroBase, UUID idNodo, String tipoNodo, String nombreNodo, boolean esPermitido) {
        if (!esPermitido) {
            return new EstadisticaDTO(nombreNodo, tipoNodo, 0L, 0L);
        }

        FiltroEstadisticaDTO filtroNodo = new FiltroEstadisticaDTO(
                filtroBase.getMes(),
                filtroBase.getAnno(),
                filtroBase.getSemestre(),
                filtroBase.getProgramaAcademico(),
                filtroBase.getTipoProgramaAcademico(),
                filtroBase.getCentroCostos(),
                filtroBase.getTipoParticipante(),
                filtroBase.getIndicador(),
                tipoNodo,
                idNodo
        );

        Long totalParticipantes = contarParticipantesTotales(filtroNodo);
        Long totalAsistencias = contarAsistenciasTotales(filtroNodo);

        return new EstadisticaDTO(nombreNodo, tipoNodo, totalParticipantes, totalAsistencias);
    }

    private Long ejecutarConsultaDinamica(String selectClause, FiltroEstadisticaDTO filtro) {
        StringBuilder jpql = new StringBuilder();
        Map<String, Object> parametros = new HashMap<>();

        jpql.append(selectClause);
        jpql.append(FROM_JOIN_BASE_ESTADISTICAS);
        jpql.append(WHERE_ESTADO_ACTIVIDAD);
        parametros.put(ESTADO_PARAMETRO, FINALIZADA);

        if (filtro.getAnno() != null && filtro.getAnno() > 0) {
            jpql.append(AND_ANNO);
            parametros.put(PARAM_ANNO, filtro.getAnno());
        }

        if (!estaCadenaVacia(filtro.getMes())) {
            try {
                java.time.format.DateTimeFormatter parser = new java.time.format.DateTimeFormatterBuilder()
                        .parseCaseInsensitive()
                        .appendPattern(FORMATO_MES_PATTERN)
                        .toFormatter(LOCALE_CO);

                java.time.temporal.TemporalAccessor accessor = parser.parse(filtro.getMes());
                int numeroMes = accessor.get(ChronoField.MONTH_OF_YEAR);

                jpql.append(AND_MES_VALOR);
                parametros.put(PARAM_MES_VALOR, numeroMes);
            } catch (Exception ignored) {
            }
        }

        if (!estaCadenaVacia(filtro.getIndicador())) {
            jpql.append(AND_INDICADOR);
            parametros.put(PARAM_INDICADOR, filtro.getIndicador());
        }

        if (!estaCadenaVacia(filtro.getTipoParticipante())) {
            jpql.append(AND_TYPE_PARTICIPANTE);

            if (TipoInterno.ESTUDIANTE.name().equalsIgnoreCase(filtro.getTipoParticipante())) {
                parametros.put(PARAM_TIPO_ENTIDAD, ParticipanteEstudianteEntidad.class);
            } else if (TipoInterno.EMPLEADO.name().equalsIgnoreCase(filtro.getTipoParticipante())) {
                parametros.put(PARAM_TIPO_ENTIDAD, ParticipanteEmpleadoEntidad.class);
            } else if (TipoParticipante.EXTERNO.name().equalsIgnoreCase(filtro.getTipoParticipante())) {
                parametros.put(PARAM_TIPO_ENTIDAD, ParticipanteExternoEntidad.class);
            }
        }

        if (!estaCadenaVacia(filtro.getSemestre())) {
            jpql.append(AND_SEMESTRE);
            parametros.put(PARAM_SEMESTRE, filtro.getSemestre());
        }

        if (!estaCadenaVacia(filtro.getProgramaAcademico())) {
            jpql.append(AND_PROGRAMA);
            parametros.put(PARAM_PROGRAMA, filtro.getProgramaAcademico());
        }

        if (!estaCadenaVacia(filtro.getTipoProgramaAcademico())) {
            String tipo = filtro.getTipoProgramaAcademico().toUpperCase();

            if (TipoPrograma.POSTGRADO.name().equals(tipo)) {
                jpql.append(AND_POSTGRADO);
            } else if (TipoPrograma.PREGRADO.name().equals(tipo)) {
                jpql.append(AND_PREGRADO);
            }
        }

        if (!estaCadenaVacia(filtro.getCentroCostos())) {
            jpql.append(AND_CENTRO_COSTOS);
            parametros.put(PARAM_CENTRO_COSTOS, filtro.getCentroCostos());
        }

        if (filtro.getIdArea() != null && !estaCadenaVacia(filtro.getTipoArea())) {
            String tipoArea = filtro.getTipoArea().toUpperCase();

            if (TipoArea.AREA.name().equals(tipoArea)) {
                jpql.append(AND_EXISTS_AREA);
            } else if (TipoArea.SUBAREA.name().equals(tipoArea)) {
                jpql.append(AND_EXISTS_SUBAREA);
            } else if (TipoArea.DIRECCION.name().equals(tipoArea)) {
                jpql.append(AND_EXISTS_DIRECCION);
            }
            parametros.put(PARAM_ID_AREA, filtro.getIdArea());
        }

        Query query = entityManager.createQuery(jpql.toString());
        parametros.forEach(query::setParameter);

        return (Long) query.getSingleResult();
    }
}