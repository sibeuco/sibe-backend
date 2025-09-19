package co.edu.uco.sibe.infraestructura.adaptador.mapeador;

import org.springframework.stereotype.Component;

@Component
public class TemporalidadMapeador {

    public TemporalidadDTO construirDTO(TemporalidadEntidad temporalidad){
        return new TemporalidadDTO(temporalidad.getIdentificador(), temporalidad.getNombre());
    }

    public TemporalidadEntidad construirEntidad(Temporalidad temporalidad){
        return new TemporalidadEntidad(temporalidad.getIdentificador(), temporalidad.getNombre());
    }

}
