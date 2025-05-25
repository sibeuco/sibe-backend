package co.edu.uco.sibe.infraestructura.adaptador.dao;

import co.edu.uco.sibe.infraestructura.adaptador.entidad.AreaEntidad;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.UUID;

public interface AreaDAO extends JpaRepository<AreaEntidad, UUID> {

    @Query(value = "SELECT identificador, nombre_area, tipo_area, area_padre FROM area WHERE identificador = ?1",nativeQuery = true)
    AreaEntidad consultarAreaPorIdentificador(UUID identificador);

}
