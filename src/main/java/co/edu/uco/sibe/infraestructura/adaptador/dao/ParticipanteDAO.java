package co.edu.uco.sibe.infraestructura.adaptador.dao;

import co.edu.uco.sibe.infraestructura.adaptador.entidad.ParticipanteEntidad;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface ParticipanteDAO extends JpaRepository<ParticipanteEntidad, UUID> {
}