package co.edu.uco.sibe.dominio.usecase.consulta;

import co.edu.uco.sibe.dominio.dto.UsuarioDTO;
import co.edu.uco.sibe.dominio.puerto.consulta.PersonaRepositorioConsulta;
import co.edu.uco.sibe.dominio.transversal.excepcion.ValorInvalidoExcepcion;
import java.util.List;
import static co.edu.uco.sibe.dominio.transversal.utilitarios.UtilMensaje.NO_SE_ECONTRARON_USUARIOS;

public class ConsultarUsuariosUseCase {
    private final PersonaRepositorioConsulta personaRepositorioConsulta;

    public ConsultarUsuariosUseCase(PersonaRepositorioConsulta personaRepositorioConsulta) {
        this.personaRepositorioConsulta = personaRepositorioConsulta;
    }

    public List<UsuarioDTO> ejecutar(){
        List<UsuarioDTO> usuarios = personaRepositorioConsulta.consultarUsuariosDTO();

        if (usuarios.isEmpty()) {
            throw new ValorInvalidoExcepcion(NO_SE_ECONTRARON_USUARIOS);
        }

        return usuarios;
    }
}