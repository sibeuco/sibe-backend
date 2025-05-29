package co.edu.uco.sibe.dominio.usecase.comando;

import co.edu.uco.sibe.dominio.modelo.Usuario;
import co.edu.uco.sibe.dominio.puerto.comando.PersonaRepositorioComando;
import co.edu.uco.sibe.dominio.puerto.consulta.PersonaRepositorioConsulta;
import co.edu.uco.sibe.dominio.transversal.excepcion.ValorDuplicadoExcepcion;
import co.edu.uco.sibe.dominio.transversal.excepcion.ValorInvalidoExcepcion;
import co.edu.uco.sibe.dominio.transversal.utilitarios.Mensajes;
import co.edu.uco.sibe.dominio.transversal.utilitarios.UtilObjeto;

import java.util.UUID;

public class ModificarUsuarioUseCase {
    private final PersonaRepositorioComando personaRepositorioComando;
    private final PersonaRepositorioConsulta personaRepositorioConsulta;

    public ModificarUsuarioUseCase(PersonaRepositorioComando personaRepositorioComando, PersonaRepositorioConsulta personaRepositorioConsulta) {
        this.personaRepositorioComando = personaRepositorioComando;
        this.personaRepositorioConsulta = personaRepositorioConsulta;
    }

    public UUID ejecutar(Usuario usuario, UUID identificador){
        validarSiNoExisteUsuarioConId(identificador);
        validarQueExistaUsuarioConCorreo(usuario);

        return this.personaRepositorioComando.modificarUsuario(usuario, identificador);

    }

    private void validarSiNoExisteUsuarioConId(UUID identificador) {
        if (UtilObjeto.getInstance().esNulo(this.personaRepositorioConsulta.consultarUsuarioPorIdentificador(identificador))) {
            throw new ValorInvalidoExcepcion(Mensajes.obtenerNoExisteUsuarioConId(identificador));
        }
    }

    private void validarQueExistaUsuarioConCorreo(Usuario usuario) {
        var usuarioExistente = this.personaRepositorioConsulta.consultarUsuarioPorCorreo(usuario.getCorreo());

        if (!UtilObjeto.getInstance().esNulo(usuarioExistente) &&
                !usuarioExistente.getIdentificador().equals(usuario.getIdentificador())) {
            throw new ValorDuplicadoExcepcion(Mensajes.CORREO_EXISTENTE);
        }
    }

}
