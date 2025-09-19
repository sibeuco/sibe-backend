package co.edu.uco.sibe.infraestructura.adaptador.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ActividadDAO extends JpaRepository<ActividadEntidad, UUID> {
}
