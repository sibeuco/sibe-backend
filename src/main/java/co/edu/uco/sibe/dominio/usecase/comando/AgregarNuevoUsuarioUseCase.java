package co.edu.uco.sibe.dominio.usecase.comando;

import co.edu.uco.sibe.dominio.modelo.Usuario;
import co.edu.uco.sibe.dominio.puerto.comando.PersonaRepositorioComando;
import co.edu.uco.sibe.dominio.puerto.consulta.PersonaRepositorioConsulta;
import co.edu.uco.sibe.dominio.transversal.excepcion.ValorDuplicadoExcepcion;
import co.edu.uco.sibe.dominio.transversal.excepcion.ValorInvalidoExcepcion;
import co.edu.uco.sibe.dominio.transversal.utilitarios.Mensajes;
import co.edu.uco.sibe.dominio.transversal.utilitarios.UtilObjeto;

import java.util.UUID;

public class AgregarNuevoUsuarioUseCase {
    private final PersonaRepositorioComando personaRepositorioComando;
    private final PersonaRepositorioConsulta personaRepositorioConsulta;

    public AgregarNuevoUsuarioUseCase(PersonaRepositorioComando personaRepositorioComando, PersonaRepositorioConsulta personaRepositorioConsulta) {
        this.personaRepositorioComando = personaRepositorioComando;
        this.personaRepositorioConsulta = personaRepositorioConsulta;
    }

    public UUID ejecutar(Usuario usuario){
        validarUsuarioExisteConCorreo(usuario.getCorreo());
        validarPersonaExisteConDocumento(usuario.getPersona().getDocumento());
        return this.personaRepositorioComando.agregarNuevoUsuario(usuario);
    }

    private void validarUsuarioExisteConCorreo(String correo) {
        if (!UtilObjeto.getInstance().esNulo(this.personaRepositorioConsulta.consultarUsuarioPorCorreo(correo))){
            throw new ValorDuplicadoExcepcion(Mensajes.CORREO_EXISTENTE);
        }
    }

    private void validarPersonaExisteConDocumento(String documento) {
        if (!UtilObjeto.getInstance().esNulo(this.personaRepositorioConsulta.consultarPersonaPorDocumento(documento))){
            throw new ValorInvalidoExcepcion(Mensajes.DOCUMENTO_EXISTENTE);
        }
    }

}
