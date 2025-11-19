package co.edu.uco.sibe.dominio.puerto.consulta;

import co.edu.uco.sibe.dominio.dto.ActividadDTO;
import co.edu.uco.sibe.dominio.dto.EjecucionActividadDTO;
import co.edu.uco.sibe.dominio.dto.MiembroDTO;
import co.edu.uco.sibe.dominio.dto.ParticipanteDTO;
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

    List<String> consultarSemestresEstudiantesEnEjecucionesFinalizadas();

    List<String> consultarCentrosCostosEmpleadosEnEjecucionesFinalizadas();

    List<String> consultarTiposParticipantesEnEjecucionesFinalizadas();

    List<String> consultarProgramasAcademicosEstudiantesEnEjecucionesFinalizadas();

    List<String> consultarNivelesFormacionEstudiantesEnEjecucionesFinalizadas();

    List<String> consultarIndicadoresEnEjecucionesFinalizadas();
}