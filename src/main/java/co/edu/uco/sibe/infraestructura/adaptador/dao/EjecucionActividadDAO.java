package co.edu.uco.sibe.infraestructura.adaptador.dao;

import co.edu.uco.sibe.infraestructura.adaptador.entidad.EjecucionActividadEntidad;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface EjecucionActividadDAO extends JpaRepository<EjecucionActividadEntidad, UUID> {
}
