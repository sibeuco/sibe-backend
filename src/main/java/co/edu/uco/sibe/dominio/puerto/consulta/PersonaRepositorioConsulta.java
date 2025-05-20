package co.edu.uco.sibe.dominio.puerto.consulta;

import co.edu.uco.sibe.dominio.dto.PersonaDTO;
import co.edu.uco.sibe.dominio.dto.UsuarioDTO;

import java.util.UUID;

public interface PersonaRepositorioConsulta {

    PersonaDTO consultarPersonaPorUUID(UUID identificador);

    UsuarioDTO consultarUsuarioPorUUID(UUID identificador);

}
