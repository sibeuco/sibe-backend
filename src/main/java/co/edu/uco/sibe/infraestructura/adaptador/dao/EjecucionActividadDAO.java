package co.edu.uco.sibe.infraestructura.adaptador.dao;

import co.edu.uco.sibe.infraestructura.adaptador.entidad.EjecucionActividadEntidad;
import co.edu.uco.sibe.infraestructura.adaptador.entidad.ParticipanteEntidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;
import java.util.UUID;
import static co.edu.uco.sibe.dominio.transversal.constante.PersistenciaConstante.CONSULTAR_PARTICIPANTES_POR_EJECUCION_ACTIVIDAD;
import static co.edu.uco.sibe.dominio.transversal.constante.PersistenciaConstante.EJECUCION_ACTIVIDAD_PARAMETRO;

public interface EjecucionActividadDAO extends JpaRepository<EjecucionActividadEntidad, UUID> {
    List<EjecucionActividadEntidad> findByActividadIdentificador(UUID actividadId);

    @Query(CONSULTAR_PARTICIPANTES_POR_EJECUCION_ACTIVIDAD)
    List<ParticipanteEntidad> findParticipantesByEjecucionActividadId(
            @Param(EJECUCION_ACTIVIDAD_PARAMETRO) UUID ejecucionActividadId
    );
}