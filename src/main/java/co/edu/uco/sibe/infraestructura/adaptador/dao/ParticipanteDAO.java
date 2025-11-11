package co.edu.uco.sibe.infraestructura.adaptador.dao;

import co.edu.uco.sibe.infraestructura.adaptador.entidad.ParticipanteEntidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.Optional;
import java.util.UUID;
import static co.edu.uco.sibe.dominio.transversal.constante.PersistenciaConstante.*;

public interface ParticipanteDAO extends JpaRepository<ParticipanteEntidad, UUID> {
    @Query(CONSULTAR_PARTICIPANTE_POR_NUMERO_IDENTIFICACION)
    ParticipanteEntidad findByMiembroNumeroIdentificacion(
            @Param(DOCUMENTO_PARAMETRO) String documento
    );

    @Query(CONSULTAR_PARTICIPANTE_POR_DOCUMENTO_Y_SEMESTRE)
    Optional<ParticipanteEntidad> findByDocumentoAndSemestre(
            @Param(DOCUMENTO_PARAMETRO) String documento,
            @Param(SEMESTRE_PARAMETRO) String semestre
    );
}