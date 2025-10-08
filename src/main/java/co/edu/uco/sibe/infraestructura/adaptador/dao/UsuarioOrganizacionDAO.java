package co.edu.uco.sibe.infraestructura.adaptador.dao;

import co.edu.uco.sibe.infraestructura.adaptador.entidad.UsuarioOrganizacionEntidad;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface UsuarioOrganizacionDAO extends JpaRepository<UsuarioOrganizacionEntidad, UUID> {
}