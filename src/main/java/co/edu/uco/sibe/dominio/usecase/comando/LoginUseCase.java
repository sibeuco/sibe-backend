package co.edu.uco.sibe.dominio.usecase.comando;

import co.edu.uco.sibe.dominio.puerto.consulta.PersonaRepositorioConsulta;
import co.edu.uco.sibe.dominio.puerto.servicio.EncriptarClaveServicio;
import co.edu.uco.sibe.dominio.transversal.excepcion.AuthorizationException;
import co.edu.uco.sibe.dominio.transversal.utilitarios.Mensajes;
import co.edu.uco.sibe.dominio.transversal.utilitarios.UtilObjeto;

import java.util.UUID;

public class LoginUseCase {
    private final PersonaRepositorioConsulta personaRepositorioConsulta;
    private final EncriptarClaveServicio encriptarClaveServicio;

    public LoginUseCase(PersonaRepositorioConsulta personaRepositorioConsulta, EncriptarClaveServicio encriptarClaveServicio) {
        this.personaRepositorioConsulta = personaRepositorioConsulta;
        this.encriptarClaveServicio = encriptarClaveServicio;
    }

    public UUID ejecutar(String correo) {
        validarSiNoExisteUsuarioConCorreo(correo);

        return personaRepositorioConsulta.consultarUsuarioPorCorreo(correo).getIdentificador();
    }

    private void validarSiNoExisteUsuarioConCorreo(String email) {
        if (UtilObjeto.getInstance().esNulo(this.personaRepositorioConsulta.consultarUsuarioPorCorreo(email))) {
            throw new AuthorizationException(Mensajes.USUARIO_O_CLAVE_INCORRECTO);
        }
    }

}
