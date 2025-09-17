package co.edu.uco.sibe.dominio.usecase.comando;

import co.edu.uco.sibe.dominio.puerto.comando.PersonaRepositorioComando;
import co.edu.uco.sibe.dominio.puerto.consulta.PersonaRepositorioConsulta;
import co.edu.uco.sibe.dominio.puerto.servicio.EncriptarClaveServicio;
import co.edu.uco.sibe.dominio.transversal.excepcion.ValorDuplicadoExcepcion;
import co.edu.uco.sibe.dominio.transversal.utilitarios.Mensajes;
import co.edu.uco.sibe.dominio.transversal.utilitarios.UtilObjeto;

import java.util.UUID;

public class AgregarNuevoUsuarioUseCase {
    private final PersonaRepositorioComando personaRepositorioComando;
    private final PersonaRepositorioConsulta personaRepositorioConsulta;
    private final EncriptarClaveServicio encriptarClaveServicio;

    public AgregarNuevoUsuarioUseCase(PersonaRepositorioComando personaRepositorioComando, PersonaRepositorioConsulta personaRepositorioConsulta, EncriptarClaveServicio encriptarClaveServicio) {
        this.personaRepositorioComando = personaRepositorioComando;
        this.personaRepositorioConsulta = personaRepositorioConsulta;
        this.encriptarClaveServicio = encriptarClaveServicio;
    }

    public UUID ejecutar(Usuario usuario, Persona persona){
        validarUsuarioExisteConCorreo(usuario.getCorreo());

        var contrasenaEncriptada = this.encriptarClaveServicio.ejecutar(usuario.getContrasena());

        return this.personaRepositorioComando.agregarNuevoUsuario(usuario, persona, contrasenaEncriptada);
    }

    private void validarUsuarioExisteConCorreo(String correo) {
        if (!UtilObjeto.getInstance().esNulo(this.personaRepositorioConsulta.consultarUsuarioPorCorreo(correo))){
            throw new ValorDuplicadoExcepcion(Mensajes.CORREO_EXISTENTE);
        }
    }

}
