package co.edu.uco.sibe.infraestructura.adaptador.dao;

import co.edu.uco.sibe.infraestructura.adaptador.entidad.ParticipanteEntidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.UUID;

public interface ParticipanteDAO extends JpaRepository<ParticipanteEntidad, UUID> {
    @Query("SELECT p FROM ParticipanteEntidad p WHERE p.miembro.numeroIdentificacion = :documento")
    ParticipanteEntidad findByMiembroNumeroIdentificacion(@Param("documento") String documento);
}