package co.edu.uco.sibe.aplicacion.comando.fabrica;

import co.edu.uco.sibe.aplicacion.comando.PersonaComando;
import co.edu.uco.sibe.dominio.dto.TipoIdentificacionDTO;
import co.edu.uco.sibe.dominio.modelo.Persona;
import co.edu.uco.sibe.dominio.modelo.TipoIdentificacion;
import co.edu.uco.sibe.dominio.puerto.consulta.PersonaRepositorioConsulta;
import co.edu.uco.sibe.dominio.puerto.consulta.TipoIdentificacionRepositorioConsulta;
import co.edu.uco.sibe.dominio.transversal.utilitarios.UtilUUID;

import java.util.UUID;

public class PersonaFabrica {

    private final TipoIdentificacionRepositorioConsulta tipoIdentificacionRepositorioConsulta;
    private final PersonaRepositorioConsulta personaRepositorioConsulta;

    public PersonaFabrica(TipoIdentificacionRepositorioConsulta tipoIdentificacionRepositorioConsulta, PersonaRepositorioConsulta personaRepositorioConsulta) {
        this.tipoIdentificacionRepositorioConsulta = tipoIdentificacionRepositorioConsulta;
        this.personaRepositorioConsulta = personaRepositorioConsulta;
    }

    public Persona construir(PersonaComando persona){
        var identificadorPersona = generarNuevoUUIDUnico();
        TipoIdentificacionDTO tipoIdentificacionDTO = tipoIdentificacionRepositorioConsulta.consultarTipoIdentificacionPorIdentificador
                (persona.getTipoIdentificacion());
        TipoIdentificacion tipoIdentificacionDominio = TipoIdentificacion.construir
                (tipoIdentificacionDTO.getIdentificador(), tipoIdentificacionDTO.getSigla(), tipoIdentificacionDTO.getDescripcion());
        return Persona.construir(identificadorPersona, tipoIdentificacionDominio, persona.getDocumento(), persona.getPrimerNombre(), persona.getSegundoNombre(), persona.getPrimerApellido(), persona.getSegundoApellido());
    }

    public UUID generarNuevoUUIDUnico() {
        UUID nuevoUUID;
        do {
            nuevoUUID = UtilUUID.generarNuevoUUID();
        } while (personaRepositorioConsulta.consultarPersonaPorIdentificador(nuevoUUID) != null);
        return nuevoUUID;
    }
}
