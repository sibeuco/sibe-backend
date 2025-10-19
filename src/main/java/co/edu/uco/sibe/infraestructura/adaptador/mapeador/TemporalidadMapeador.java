package co.edu.uco.sibe.infraestructura.adaptador.mapeador;

import co.edu.uco.sibe.dominio.modelo.Temporalidad;
import co.edu.uco.sibe.infraestructura.adaptador.entidad.TemporalidadEntidad;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class TemporalidadMapeador {
    public TemporalidadEntidad construirEntidad(Temporalidad temporalidad){
        return new TemporalidadEntidad(temporalidad.getIdentificador(), temporalidad.getNombre());
    }

    public Temporalidad construirModelo(TemporalidadEntidad temporalidad){
        return Temporalidad.construir(temporalidad.getIdentificador(), temporalidad.getNombre());
    }
}