package co.edu.uco.sibe.dominio.puerto.consulta;

import co.edu.uco.sibe.dominio.dto.PersonaDTO;
import co.edu.uco.sibe.dominio.dto.UsuarioDTO;

import java.util.List;
import java.util.UUID;

public interface PersonaRepositorioConsulta {

    PersonaDTO consultarPersonaPorIdentificador(UUID identificador);

    PersonaDTO consultarPersonaPorDocumento(String docuemnto);

    UsuarioDTO consultarUsuarioPorIdentificador(UUID identificador);

    UsuarioDTO consultarUsuarioPorCorreo(String correo);

    List<PersonaDTO> consultarPersonas();

    List<UsuarioDTO> consultarUsuarios();

}
