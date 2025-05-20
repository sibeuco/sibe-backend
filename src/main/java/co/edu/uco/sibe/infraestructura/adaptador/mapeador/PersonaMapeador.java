package co.edu.uco.sibe.infraestructura.adaptador.mapeador;

import co.edu.uco.sibe.dominio.dto.PersonaDTO;
import co.edu.uco.sibe.dominio.modelo.Persona;
import co.edu.uco.sibe.infraestructura.adaptador.entidad.PersonaEntidad;
import org.springframework.stereotype.Component;

@Component
public class PersonaMapeador {
    private final TipoIdentificacionMapeador tipoIdentificacionMapeador;

    public PersonaMapeador(TipoIdentificacionMapeador tipoIdentificacionMapeador){
        this.tipoIdentificacionMapeador = tipoIdentificacionMapeador;
    }

    public PersonaDTO construirDTO(PersonaEntidad persona){
        return new PersonaDTO(persona.getIdentificador(), this.tipoIdentificacionMapeador.construirDTO(persona.getTipoIdentificacion()), persona.getDocumento(), persona.getPrimerNombre(), persona.getSegundoNombre(), persona.getPrimerApellido(), persona.getSegundoApellido());
    }

    public PersonaEntidad construirEntidad(Persona persona){
        return new PersonaEntidad(persona.getIdentificador(), this.tipoIdentificacionMapeador.construirEntidad(persona.getTipoIdentificacion()), persona.getDocumento(), persona.getPrimerNombre(), persona.getSegundoNombre(), persona.getPrimerApellido(), persona.getSegundoApellido());
    }

}
