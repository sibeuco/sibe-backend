package co.edu.uco.sibe.aplicacion.comando.fabrica;

import co.edu.uco.sibe.aplicacion.comando.UsuarioComando;
import co.edu.uco.sibe.aplicacion.comando.UsuarioModificacionComando;
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


    public Persona construir(UsuarioComando persona){
        var identificadorPersona = generarNuevoUUIDUnico();
        TipoIdentificacionDTO tipoIdentificacionDTO = tipoIdentificacionRepositorioConsulta.consultarTipoIdentificacionPorIdentificador
                (persona.getTipoIdentificacion());
        TipoIdentificacion tipoIdentificacion = TipoIdentificacion.construir
                (tipoIdentificacionDTO.getIdentificador(),
                        tipoIdentificacionDTO.getSigla(),
                        tipoIdentificacionDTO.getDescripcion());
        return Persona.construir(identificadorPersona, tipoIdentificacion, persona.getDocumento(), persona.getPrimerNombre(), persona.getSegundoNombre(), persona.getPrimerApellido(), persona.getSegundoApellido(), persona.getCorreo());
    }

    public Persona construirActualizar(UsuarioModificacionComando persona, UUID identificador){
        TipoIdentificacionDTO tipoIdentificacionDTO = tipoIdentificacionRepositorioConsulta.consultarTipoIdentificacionPorIdentificador
                (persona.getTipoIdentificacion());
        TipoIdentificacion tipoIdentificacion = TipoIdentificacion.construir
                (tipoIdentificacionDTO.getIdentificador(),
                        tipoIdentificacionDTO.getSigla(),
                        tipoIdentificacionDTO.getDescripcion());
        return Persona.construir(identificador, tipoIdentificacion, persona.getDocumento(), persona.getPrimerNombre(), persona.getSegundoNombre(), persona.getPrimerApellido(), persona.getSegundoApellido(), persona.getCorreo());
    }

    public UUID generarNuevoUUIDUnico() {
        UUID nuevoUUID;
        do {
            nuevoUUID = UtilUUID.generarNuevoUUID();
        } while (personaRepositorioConsulta.consultarPersonaPorIdentificador(nuevoUUID) != null);
        return nuevoUUID;
    }
}
