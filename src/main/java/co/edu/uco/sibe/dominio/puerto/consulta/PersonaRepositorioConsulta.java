package co.edu.uco.sibe.dominio.puerto.consulta;

import co.edu.uco.sibe.dominio.dto.PersonaDTO;
import co.edu.uco.sibe.dominio.dto.UsuarioDTO;
import co.edu.uco.sibe.dominio.modelo.Persona;
import co.edu.uco.sibe.dominio.modelo.Usuario;

import java.util.List;
import java.util.UUID;

public interface PersonaRepositorioConsulta {
    PersonaDTO consultarPersonaPorIdentificadorDTO(UUID identificador);

    Persona consultarPersonaPorIdentificador(UUID identificador);

    PersonaDTO consultarPersonaPorCorreoDTO(String correo);

    Persona consultarPersonaPorCorreo(String correo);

    Persona consultarPersonaPorDocumento(String documento);

    UsuarioDTO consultarUsuarioPorIdentificadorDTO(UUID identificador);

    Usuario consultarUsuarioPorIdentificador(UUID identificador);

    UsuarioDTO consultarUsuarioPorCorreoDTO(String correo);

    Usuario consultarUsuarioPorCorreo(String correo);

    List<UsuarioDTO> consultarUsuariosDTO();
}