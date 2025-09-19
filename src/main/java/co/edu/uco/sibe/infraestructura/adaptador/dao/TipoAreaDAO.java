package co.edu.uco.sibe.infraestructura.adaptador.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.UUID;

public interface TipoAreaDAO extends JpaRepository<TipoAreaEntidad, UUID> {

    @Query(value = "SELECT identificador, nombre, gestionable, nivel FROM tipo_area WHERE identificador = ?1",nativeQuery = true)
    TipoAreaEntidad consultarTipoAreaPorIdentificador(UUID identificador);
}
