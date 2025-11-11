package co.edu.uco.sibe.infraestructura.adaptador.dao;

import co.edu.uco.sibe.infraestructura.adaptador.entidad.MiembroEntidad;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
import java.util.UUID;

public interface MiembroDAO extends JpaRepository<MiembroEntidad, UUID> {
    Optional<MiembroEntidad> findByNumeroIdentificacion(String numeroIdentificacion);
}