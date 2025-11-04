package co.edu.uco.sibe.infraestructura.adaptador.dao;

import co.edu.uco.sibe.infraestructura.adaptador.entidad.ParticipanteEntidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.UUID;
import static co.edu.uco.sibe.dominio.transversal.constante.PersistenciaConstante.CONSULTAR_PARTICIPANTE_POR_NUMERO_IDENTIFICACION;

public interface ParticipanteDAO extends JpaRepository<ParticipanteEntidad, UUID> {
    @Query(CONSULTAR_PARTICIPANTE_POR_NUMERO_IDENTIFICACION)
    ParticipanteEntidad findByMiembroNumeroIdentificacion(@Param("documento") String documento);
}