package co.edu.uco.sibe.infraestructura.adaptador.dao;

import co.edu.uco.sibe.infraestructura.adaptador.entidad.PersonaEntidad;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PersonaDAO extends JpaRepository<PersonaEntidad, UUID> {
}
