package co.edu.uco.sibe.infraestructura.adaptador.mapeador;

import co.edu.uco.sibe.infraestructura.adaptador.entidad.EstadoActividadEntidad;
import org.springframework.stereotype.Component;

@Component
public class EstadoActividadMapeador {

    public EstadoActividadDTO construirDTO(EstadoActividadEntidad estadoActividad){
        return new EstadoActividadDTO(estadoActividad.getIdentificador(), estadoActividad.getNombre());
    }

    public EstadoActividadEntidad construirEntidad(EstadoActividad estadoActividad){
        return new EstadoActividadEntidad(estadoActividad.getIdentificador(), estadoActividad.getNombre());
    }

}
