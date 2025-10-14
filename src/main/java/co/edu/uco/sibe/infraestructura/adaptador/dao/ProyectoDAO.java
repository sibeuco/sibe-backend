package co.edu.uco.sibe.infraestructura.adaptador.dao;

import co.edu.uco.sibe.infraestructura.adaptador.entidad.ProyectoEntidad;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface ProyectoDAO extends JpaRepository<ProyectoEntidad, UUID> {
}