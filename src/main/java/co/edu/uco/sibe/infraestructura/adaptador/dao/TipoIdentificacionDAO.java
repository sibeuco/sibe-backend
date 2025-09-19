package co.edu.uco.sibe.infraestructura.adaptador.dao;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.UUID;

public interface TipoIdentificacionDAO extends JpaRepository<TipoIdentificacionEntidad, UUID> {

    @Query(value = "SELECT identificador, sigla, descripcion FROM tipo_identificacion WHERE identificador = ?1",nativeQuery = true)
    TipoIdentificacionEntidad consultarTipoIdentificacionPorIdentificador(UUID identificador);

    @Modifying
    @Transactional
    @Query(value = """
    UPDATE tipo_identificacion
    SET sigla = ?1,
        descripcion = ?2
    WHERE identificador = ?3
    """, nativeQuery = true)
    void modificarTipoIdentificacion(String nuevaSigla, String nuevaDescripcion,UUID identificador);


}
