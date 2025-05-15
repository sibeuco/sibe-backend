package co.edu.uco.sibe.infraestructura.adaptador.dao;

import co.edu.uco.sibe.infraestructura.adaptador.entidad.TipoAreaEntidad;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TipoAreaDAO extends JpaRepository<TipoAreaEntidad, UUID> {
}
