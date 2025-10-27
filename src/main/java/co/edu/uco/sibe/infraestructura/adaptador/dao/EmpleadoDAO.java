package co.edu.uco.sibe.infraestructura.adaptador.dao;

import co.edu.uco.sibe.infraestructura.adaptador.entidad.EmpleadoEntidad;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface EmpleadoDAO extends JpaRepository<EmpleadoEntidad, UUID> {
    EmpleadoEntidad findByNumeroIdentificacion(String numeroIdentificacion);
}