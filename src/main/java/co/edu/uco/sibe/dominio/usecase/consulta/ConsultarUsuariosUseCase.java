package co.edu.uco.sibe.dominio.usecase.consulta;

import co.edu.uco.sibe.dominio.dto.UsuarioDTO;
import co.edu.uco.sibe.dominio.puerto.consulta.PersonaRepositorioConsulta;
import co.edu.uco.sibe.dominio.transversal.excepcion.ValorInvalidoExcepcion;
import co.edu.uco.sibe.dominio.transversal.utilitarios.Mensajes;
import java.util.List;

public class ConsultarUsuariosUseCase {
    private final PersonaRepositorioConsulta personaRepositorioConsulta;

    public ConsultarUsuariosUseCase(PersonaRepositorioConsulta personaRepositorioConsulta) {
        this.personaRepositorioConsulta = personaRepositorioConsulta;
    }

    public List<UsuarioDTO> ejecutar(){

        List<UsuarioDTO> usuarios = personaRepositorioConsulta.consultarUsuariosDTO();

        if (usuarios.isEmpty()) {
            throw new ValorInvalidoExcepcion(Mensajes.NO_SE_ECONTRARON_USUARIOS);
        }

        return usuarios;

    }
}