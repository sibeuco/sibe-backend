package co.edu.uco.sibe.dominio.puerto.consulta;

import co.edu.uco.sibe.dominio.dto.*;
import co.edu.uco.sibe.dominio.modelo.*;
import java.util.List;
import java.util.UUID;

public interface ActividadRepositorioConsulta {
    Actividad consultarPorIdentificador(UUID identificador);

    Actividad consultarPorNombreYSemestre(String nombre, String semestre);

    List<ActividadDTO> consultarPorSubarea(Subarea subarea);

    List<ActividadDTO> consultarPorArea(Area area);

    List<ActividadDTO> consultarPorDireccion(Direccion direccion);

    List<EjecucionActividadDTO> consultarFechasProgramadasPorActividad(Actividad actividad);

    EjecucionActividad consultarEjecucionActividadPorIdentificador(UUID identificador);

    List<ParticipanteDTO> consultarParticipantesPorEjecucionActividad(UUID ejecucionActividad);

    List<String> consultarMesesEjecucionesFinalizadas();

    List<String> consultarAnnosEjecucionesFinalizadas();

    List<String> consultarSemestresActividadesEnEjecucionesFinalizadas();

    List<String> consultarCentrosCostosEmpleadosEnEjecucionesFinalizadas();

    List<String> consultarTiposParticipantesEnEjecucionesFinalizadas();

    List<String> consultarProgramasAcademicosEstudiantesEnEjecucionesFinalizadas();

    List<String> consultarNivelesFormacionEstudiantesEnEjecucionesFinalizadas();

    List<String> consultarIndicadoresEnEjecucionesFinalizadas();

    Long contarParticipantesTotales(FiltroEstadisticaDTO filtro);

    Long contarAsistenciasTotales(FiltroEstadisticaDTO filtro);

    Long contarEjecucionesTotales(FiltroEstadisticaDTO filtro);

    List<EstadisticaDTO> consultarEstadisticasParticipantesPorEstructura(FiltroEstadisticaDTO filtro);

    List<EstadisticaMesDTO> consultarEstadisticasParticipantesPorMes(FiltroEstadisticaDTO filtro);
}