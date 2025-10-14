package co.edu.uco.sibe.infraestructura.adaptador.dao;

import co.edu.uco.sibe.infraestructura.adaptador.entidad.ActividadEntidad;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface ActividadDAO extends JpaRepository<ActividadEntidad, UUID> {
}