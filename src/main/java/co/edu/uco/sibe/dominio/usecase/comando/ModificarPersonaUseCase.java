package co.edu.uco.sibe.dominio.usecase.comando;

import co.edu.uco.sibe.dominio.puerto.comando.PersonaRepositorioComando;
import co.edu.uco.sibe.dominio.puerto.consulta.PersonaRepositorioConsulta;
import co.edu.uco.sibe.dominio.transversal.excepcion.ValorDuplicadoExcepcion;
import co.edu.uco.sibe.dominio.transversal.excepcion.ValorInvalidoExcepcion;
import co.edu.uco.sibe.dominio.transversal.utilitarios.Mensajes;
import co.edu.uco.sibe.dominio.transversal.utilitarios.ValidadorObjeto;

import java.util.UUID;

public class ModificarPersonaUseCase {

    private final PersonaRepositorioComando personaRepositorioComando;
    private final PersonaRepositorioConsulta personaRepositorioConsulta;

    public ModificarPersonaUseCase(PersonaRepositorioComando personaRepositorioComando, PersonaRepositorioConsulta personaRepositorioConsulta) {
        this.personaRepositorioComando = personaRepositorioComando;
        this.personaRepositorioConsulta = personaRepositorioConsulta;
    }

    public UUID ejecutar(Persona persona, UUID identificador){
        validarSiNoExistePersonaConId(identificador);
        validarQueExistaUsuarioConDocumento(persona);

        return this.personaRepositorioComando.modificarPersona(persona, identificador);
    }

    private void validarSiNoExistePersonaConId(UUID identificador) {
        if (ValidadorObjeto.getInstance().esNulo(this.personaRepositorioConsulta.consultarPersonaPorIdentificador(identificador))) {
            throw new ValorInvalidoExcepcion(Mensajes.obtenerNoExistePersonaConId(identificador));
        }
    }

    private void validarQueExistaUsuarioConDocumento(Persona persona) {
        var personaExistente = this.personaRepositorioConsulta.consultarPersonaPorDocumento(persona.getDocumento());

        if (!ValidadorObjeto.getInstance().esNulo(personaExistente) &&
                !personaExistente.getIdentificador().equals(persona.getDocumento())) {
            throw new ValorDuplicadoExcepcion(Mensajes.CORREO_EXISTENTE);
        }
    }

}
