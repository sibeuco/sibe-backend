package co.edu.uco.sibe.aplicacion.comando.fabrica;

import co.edu.uco.sibe.aplicacion.comando.PersonaComando;
import co.edu.uco.sibe.dominio.dto.TipoIdentificacionDTO;
import co.edu.uco.sibe.dominio.modelo.Persona;
import co.edu.uco.sibe.dominio.modelo.TipoIdentificacion;
import co.edu.uco.sibe.dominio.puerto.consulta.PersonaRepositorioConsulta;
import co.edu.uco.sibe.dominio.puerto.consulta.TipoIdentificacionRepositorioConsulta;
import co.edu.uco.sibe.dominio.transversal.utilitarios.UtilUUID;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@AllArgsConstructor
public class PersonaFabrica {

    private final TipoIdentificacionRepositorioConsulta tipoIdentificacionRepositorioConsulta;
    private final PersonaRepositorioConsulta personaRepositorioConsulta;


    public Persona construir(PersonaComando persona){
        var identificadorPersona = generarNuevoUUIDUnico();
        TipoIdentificacionDTO tipoIdentificacionDTO = tipoIdentificacionRepositorioConsulta.consultarTipoIdentificacionPorIdentificador
                (persona.getTipoIdentificacion());
        TipoIdentificacion tipoIdentificacion = TipoIdentificacion.construir
                (tipoIdentificacionDTO.getIdentificador(),
                        tipoIdentificacionDTO.getSigla(),
                        tipoIdentificacionDTO.getDescripcion());
        return Persona.construir(identificadorPersona, tipoIdentificacion, persona.getDocumento(), persona.getPrimerNombre(), persona.getSegundoNombre(), persona.getPrimerApellido(), persona.getSegundoApellido());
    }

    public Persona construirActualizar(PersonaComando persona, UUID identificador){
        TipoIdentificacionDTO tipoIdentificacionDTO = tipoIdentificacionRepositorioConsulta.consultarTipoIdentificacionPorIdentificador
                (persona.getTipoIdentificacion());
        TipoIdentificacion tipoIdentificacion = TipoIdentificacion.construir
                (tipoIdentificacionDTO.getIdentificador(),
                        tipoIdentificacionDTO.getSigla(),
                        tipoIdentificacionDTO.getDescripcion());
        return Persona.construir(identificador, tipoIdentificacion, persona.getDocumento(), persona.getPrimerNombre(), persona.getSegundoNombre(), persona.getPrimerApellido(), persona.getSegundoApellido());
    }

    public UUID generarNuevoUUIDUnico() {
        UUID nuevoUUID;
        do {
            nuevoUUID = UtilUUID.generarNuevoUUID();
        } while (personaRepositorioConsulta.consultarPersonaPorIdentificador(nuevoUUID) != null);
        return nuevoUUID;
    }
}
