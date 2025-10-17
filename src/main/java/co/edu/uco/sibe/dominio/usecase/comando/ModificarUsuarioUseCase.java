package co.edu.uco.sibe.dominio.usecase.comando;

import co.edu.uco.sibe.dominio.enums.TipoArea;
import co.edu.uco.sibe.dominio.modelo.Persona;
import co.edu.uco.sibe.dominio.modelo.Usuario;
import co.edu.uco.sibe.dominio.puerto.comando.PersonaRepositorioComando;
import co.edu.uco.sibe.dominio.puerto.consulta.PersonaRepositorioConsulta;
import co.edu.uco.sibe.dominio.service.ModificarVinculacionUsuarioConAreaService;
import co.edu.uco.sibe.dominio.transversal.excepcion.ValorDuplicadoExcepcion;
import co.edu.uco.sibe.dominio.transversal.excepcion.ValorInvalidoExcepcion;
import co.edu.uco.sibe.dominio.transversal.utilitarios.UtilMensaje;
import co.edu.uco.sibe.dominio.transversal.utilitarios.ValidadorObjeto;
import java.util.UUID;

public class ModificarUsuarioUseCase {
    private final PersonaRepositorioComando personaRepositorioComando;
    private final PersonaRepositorioConsulta personaRepositorioConsulta;
    private final ModificarVinculacionUsuarioConAreaService modificarVinculacionUsuarioConAreaService;

    public ModificarUsuarioUseCase(PersonaRepositorioComando personaRepositorioComando, PersonaRepositorioConsulta personaRepositorioConsulta, ModificarVinculacionUsuarioConAreaService modificarVinculacionUsuarioConAreaService) {
        this.personaRepositorioComando = personaRepositorioComando;
        this.personaRepositorioConsulta = personaRepositorioConsulta;
        this.modificarVinculacionUsuarioConAreaService = modificarVinculacionUsuarioConAreaService;
    }

    public UUID ejecutar(Usuario usuario, Persona persona, UUID area, TipoArea tipoArea, UUID identificador){
        validarSiNoExistePersonaConId(identificador);
        validarQueExistaUsuarioConDocumento(persona);
        validarQueExistaUsuarioConCorreo(persona);

        this.personaRepositorioComando.modificarUsuario(usuario, persona);

        this.modificarVinculacionUsuarioConAreaService.ejecutar(identificador, area, tipoArea);

        return identificador;
    }

    private void validarSiNoExistePersonaConId(UUID identificador) {
        if (ValidadorObjeto.esNulo(this.personaRepositorioConsulta.consultarPersonaPorIdentificador(identificador))) {
            throw new ValorInvalidoExcepcion(UtilMensaje.obtenerNoExistePersonaConId(identificador));
        }
    }

    private void validarQueExistaUsuarioConDocumento(Persona persona) {
        var personaExistente = this.personaRepositorioConsulta.consultarPersonaPorDocumento(persona.getIdentificacion().getNumeroIdentificacion());

        if (!ValidadorObjeto.esNulo(personaExistente) &&
                !personaExistente.getIdentificador().equals(persona.getIdentificador())) {
            throw new ValorDuplicadoExcepcion(UtilMensaje.DOCUMENTO_EXISTENTE);
        }
    }

    private void validarQueExistaUsuarioConCorreo(Persona persona) {
        var personaExistente = this.personaRepositorioConsulta.consultarPersonaPorCorreo(persona.getCorreo());

        if (!ValidadorObjeto.esNulo(personaExistente) &&
                !personaExistente.getIdentificador().equals(persona.getIdentificador())) {
            throw new ValorDuplicadoExcepcion(UtilMensaje.CORREO_EXISTENTE);
        }
    }
}