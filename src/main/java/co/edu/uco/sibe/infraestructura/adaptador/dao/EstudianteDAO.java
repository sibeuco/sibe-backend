package co.edu.uco.sibe.infraestructura.adaptador.dao;

import co.edu.uco.sibe.infraestructura.adaptador.entidad.EstudianteEntidad;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface EstudianteDAO extends JpaRepository<EstudianteEntidad, UUID> {
    EstudianteEntidad findByNumeroIdentificacion(String numeroIdentificacion);
}