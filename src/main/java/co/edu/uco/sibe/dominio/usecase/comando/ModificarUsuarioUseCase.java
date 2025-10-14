package co.edu.uco.sibe.dominio.usecase.comando;

import co.edu.uco.sibe.dominio.modelo.Persona;
import co.edu.uco.sibe.dominio.modelo.Usuario;
import co.edu.uco.sibe.dominio.puerto.comando.PersonaRepositorioComando;
import co.edu.uco.sibe.dominio.puerto.consulta.PersonaRepositorioConsulta;
import co.edu.uco.sibe.dominio.transversal.excepcion.ValorDuplicadoExcepcion;
import co.edu.uco.sibe.dominio.transversal.excepcion.ValorInvalidoExcepcion;
import co.edu.uco.sibe.dominio.transversal.utilitarios.Mensajes;
import co.edu.uco.sibe.dominio.transversal.utilitarios.ValidadorObjeto;
import java.util.UUID;

public class ModificarUsuarioUseCase {
    private final PersonaRepositorioComando personaRepositorioComando;
    private final PersonaRepositorioConsulta personaRepositorioConsulta;

    public ModificarUsuarioUseCase(PersonaRepositorioComando personaRepositorioComando, PersonaRepositorioConsulta personaRepositorioConsulta) {
        this.personaRepositorioComando = personaRepositorioComando;
        this.personaRepositorioConsulta = personaRepositorioConsulta;
    }

    public UUID ejecutar(Usuario usuario, Persona persona, UUID identificador){
        validarSiNoExistePersonaConId(identificador);
        validarQueExistaUsuarioConDocumento(persona);
        validarQueExistaUsuarioConCorreo(persona);

        return this.personaRepositorioComando.modificarUsuario(usuario, persona);
    }

    private void validarSiNoExistePersonaConId(UUID identificador) {
        if (ValidadorObjeto.esNulo(this.personaRepositorioConsulta.consultarPersonaPorIdentificador(identificador))) {
            throw new ValorInvalidoExcepcion(Mensajes.obtenerNoExistePersonaConId(identificador));
        }
    }

    private void validarQueExistaUsuarioConDocumento(Persona persona) {
        var personaExistente = this.personaRepositorioConsulta.consultarPersonaPorDocumento(persona.getIdentificacion().getNumeroIdentificacion());

        if (!ValidadorObjeto.esNulo(personaExistente) &&
                !personaExistente.getIdentificador().equals(persona.getIdentificador())) {
            throw new ValorDuplicadoExcepcion(Mensajes.DOCUMENTO_EXISTENTE);
        }
    }

    private void validarQueExistaUsuarioConCorreo(Persona persona) {
        var personaExistente = this.personaRepositorioConsulta.consultarPersonaPorCorreo(persona.getCorreo());

        if (!ValidadorObjeto.esNulo(personaExistente) &&
                !personaExistente.getIdentificador().equals(persona.getIdentificador())) {
            throw new ValorDuplicadoExcepcion(Mensajes.CORREO_EXISTENTE);
        }
    }
}