package co.edu.uco.sibe.infraestructura.adaptador.dao;

import co.edu.uco.sibe.infraestructura.adaptador.entidad.PersonaEntidad;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.UUID;

public interface PersonaDAO extends JpaRepository<PersonaEntidad, UUID> {

    @Query(value = """
    SELECT identificador,
           tipo_identificacion,
           documento,
           primer_nombre,
           segundo_nombre,
           primer_apellido,
           segundo_apellido
    FROM persona
    WHERE identificador = :identificador
    """, nativeQuery = true)
    PersonaEntidad consultarPersonaPorIdentificador(UUID identificador);

    @Modifying
    @Transactional
    @Query(value = """
    UPDATE persona
    SET tipo_identificacion = :tipo_identificacion,
        documento = :documento,
        primer_nombre = :primerNombre,
        segundo_nombre = :segundoNombre,
        primer_apellido = :primerApellido,
        segundo_apellido = :segundoApellido
    WHERE identificador = :identificador
    """, nativeQuery = true)
    void modificarPersona(UUID tipo_identificacion, String documento, String primerNombre, String segundoNombre, String primerApellido, String segundoApellido, UUID identificador);

}
