package co.edu.uco.sibe.dominio.usecase.consulta;

import co.edu.uco.sibe.dominio.dto.UsuarioDTO;
import co.edu.uco.sibe.dominio.puerto.consulta.PersonaRepositorioConsulta;
import co.edu.uco.sibe.dominio.transversal.excepcion.ValorInvalidoExcepcion;
import co.edu.uco.sibe.dominio.transversal.utilitarios.Mensajes;
import co.edu.uco.sibe.dominio.transversal.utilitarios.ValidadorObjeto;

public class ConsultarUsuarioPorCorreoUseCase {
    private final PersonaRepositorioConsulta personaRepositorioConsulta;

    public ConsultarUsuarioPorCorreoUseCase(PersonaRepositorioConsulta personaRepositorioConsulta) {
        this.personaRepositorioConsulta = personaRepositorioConsulta;
    }

    public UsuarioDTO ejecutar(String correo){
        validarSiNoExisteUsuarioConCorreo(correo);

        return personaRepositorioConsulta.consultarUsuarioPorCorreoDTO(correo);

    }

    private void validarSiNoExisteUsuarioConCorreo(String correo) {
        if (ValidadorObjeto.esNulo(this.personaRepositorioConsulta.consultarUsuarioPorCorreo(correo))) {
            throw new ValorInvalidoExcepcion(Mensajes.obtenerNoExisteUsuarioConCorreo(correo));
        }
    }
}