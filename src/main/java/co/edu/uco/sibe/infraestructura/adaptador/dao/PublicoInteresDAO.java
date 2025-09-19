package co.edu.uco.sibe.infraestructura.adaptador.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PublicoInteresDAO extends JpaRepository<PublicoInteresEntidad, UUID> {
}
