package co.edu.uco.sibe.dominio.puerto.consulta;

import java.util.List;
import java.util.UUID;

public interface PersonaRepositorioConsulta {

    PersonaDTO consultarPersonaPorIdentificador(UUID identificador);

    PersonaDTO consultarPersonaPorDocumento(String documento);

    PersonaDTO consultarPersonaPorCorreo(String correo);

    UsuarioDTO consultarUsuarioPorIdentificador(UUID identificador);

    UsuarioDTO consultarUsuarioPorCorreo(String correo);

    List<PersonaDTO> consultarPersonas();

    List<UsuarioDTO> consultarUsuarios();

}
