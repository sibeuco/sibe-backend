package co.edu.uco.sibe.infraestructura.adaptador.dao;

import co.edu.uco.sibe.infraestructura.adaptador.entidad.UsuarioEntidad;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.UUID;

public interface UsuarioDAO extends JpaRepository<UsuarioEntidad, UUID> {

    @Query(value = """
    SELECT identificador,
           correo,
           contrasena,
           tipo_usuario,
           esta_activo,
           area_o_direccion,
           persona
    FROM usuario
    WHERE identificador = ?1
    """, nativeQuery = true)
    UsuarioEntidad consultarUsuarioPorIdentificador(UUID identificador);

    @Query(value = """
    SELECT identificador,
           correo,
           contrasena,
           tipo_usuario,
           esta_activo,
           area_o_direccion,
           persona
    FROM usuario
    WHERE correo = ?1
    """, nativeQuery = true)
    UsuarioEntidad consultarUsuarioPorCorreo(String correo);

    @Modifying
    @Transactional
    @Query(value = """
    UPDATE usuario
    SET tipo_usuario = ?1,
        area_o_direccion = ?2
    WHERE identificador = ?3
    """, nativeQuery = true)
    void modificarUsuario(UUID tipoUsuario, UUID areaODireccion, UUID identificador);

    @Modifying
    @Transactional
    @Query(value = """
    UPDATE usuario
    SET contrasena = ?1
    WHERE identificador = ?2
    """, nativeQuery = true)
    void cambiarContrasena(String nuevaContrasena, UUID identificador);
}
