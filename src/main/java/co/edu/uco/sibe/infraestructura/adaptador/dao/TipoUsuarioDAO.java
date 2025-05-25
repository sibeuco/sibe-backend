package co.edu.uco.sibe.infraestructura.adaptador.dao;

import co.edu.uco.sibe.infraestructura.adaptador.entidad.TipoUsuarioEntidad;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.UUID;

public interface TipoUsuarioDAO extends JpaRepository<TipoUsuarioEntidad, UUID> {

    @Query(value = "SELECT identificador, nombre, crear, eliminar, modificar, consultar FROM tipo_usuario WHERE identificador = ?1",nativeQuery = true)
    TipoUsuarioEntidad consultarTipoUsuarioPorIdentificador(UUID identificador);

    @Modifying
    @Transactional
    @Query(value = """
    UPDATE tipo_usuario
    SET nombre = ?1,
        crear = ?2,
        modificar = ?3,
        eliminar = ?4,
        consultar = ?5
    WHERE identificador = ?6
    """, nativeQuery = true)
    void modificarTipoUsuario(String nuevoNombre, boolean crear,boolean modificar, boolean eliminar, boolean consultar, UUID id);

}
