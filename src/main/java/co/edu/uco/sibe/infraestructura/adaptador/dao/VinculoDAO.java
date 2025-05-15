package co.edu.uco.sibe.infraestructura.adaptador.dao;

import co.edu.uco.sibe.infraestructura.adaptador.entidad.VinculoEntidad;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface VinculoDAO extends JpaRepository<VinculoEntidad, UUID> {
}
