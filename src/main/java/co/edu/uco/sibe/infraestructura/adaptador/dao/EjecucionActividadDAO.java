package co.edu.uco.sibe.infraestructura.adaptador.dao;

import co.edu.uco.sibe.infraestructura.adaptador.entidad.EjecucionActividadEntidad;
import co.edu.uco.sibe.infraestructura.adaptador.entidad.ParticipanteEntidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import static co.edu.uco.sibe.dominio.transversal.constante.PersistenciaConstante.*;

public interface EjecucionActividadDAO extends JpaRepository<EjecucionActividadEntidad, UUID> {
    List<EjecucionActividadEntidad> findByActividadIdentificador(UUID actividadId);

    @Query(CONSULTAR_PARTICIPANTES_POR_EJECUCION_ACTIVIDAD)
    List<ParticipanteEntidad> findParticipantesByEjecucionActividadId(
            @Param(EJECUCION_ACTIVIDAD_PARAMETRO) UUID ejecucionActividadId
    );

    @Query(CONSULTAR_FECHAS_REALIZACION_POR_ESTADO)
    List<LocalDate> findFechasRealizacionByEstadoNombre(@Param(ESTADO_PARAMETRO) String nombreEstado);

    @Query(CONSULTAR_INDICADORES_EJECUCIONES_FINALIZADAS)
    List<String> findNombresIndicadoresByEstadoEjecucion(@Param(ESTADO_PARAMETRO) String estado);

    @Query(CONSULTAR_SEMESTRES_ACTIVIDADES_FINALIZADAS)
    List<String> findSemestresActividadesByEstadoEjecucion(@Param(ESTADO_PARAMETRO) String estado);
}