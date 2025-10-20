package co.edu.uco.sibe.infraestructura.adaptador.mapeador;

import co.edu.uco.sibe.dominio.modelo.EstadoActividad;
import co.edu.uco.sibe.infraestructura.adaptador.entidad.EstadoActividadEntidad;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class EstadoActividadMapeador {
    public EstadoActividadEntidad construirEntidad(EstadoActividad estadoActividad) {
        return new EstadoActividadEntidad(estadoActividad.getIdentificador(), estadoActividad.getNombre());
    }

    public EstadoActividad construriModelo(EstadoActividadEntidad estadoActividad) {
        return EstadoActividad.construir(estadoActividad.getIdentificador(), estadoActividad.getNombre());
    }
}
