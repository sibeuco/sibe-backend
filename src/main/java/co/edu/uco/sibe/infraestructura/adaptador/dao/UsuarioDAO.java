package co.edu.uco.sibe.infraestructura.adaptador.dao;

import co.edu.uco.sibe.dominio.dto.UsuarioDTO;
import co.edu.uco.sibe.infraestructura.adaptador.entidad.UsuarioEntidad;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface UsuarioDAO extends JpaRepository<UsuarioEntidad, UUID> {

    @Query(value = """
    SELECT identificador,
           correo,
           contrasena,
           tipo_usuario,
           esta_activo
    FROM usuario
    WHERE identificador = ?1
    """, nativeQuery = true)
    UsuarioEntidad consultarUsuarioPorIdentificador(UUID identificador);

    @Query(value = """
    SELECT identificador,
           correo,
           contrasena,
           tipo_usuario,
           esta_activo
    FROM usuario
    WHERE correo = ?1
    """, nativeQuery = true)
    UsuarioEntidad consultarUsuarioPorCorreo(String correo);

    UsuarioEntidad findByCorreo(String correo);

    @Modifying
    @Transactional
    @Query(value = """
    UPDATE usuario
    SET tipo_usuario = :tipoUsuario,
        correo = :correo
    WHERE identificador = :identificador
    """, nativeQuery = true)
    void modificarUsuario(UUID tipoUsuario, String correo, UUID identificador);

    @Modifying
    @Transactional
    @Query(value = """
    UPDATE usuario
    SET contrasena = :nuevaContrasena
    WHERE identificador = :identificador
    """, nativeQuery = true)
    void cambiarContrasena(String nuevaContrasena, UUID identificador);


}
