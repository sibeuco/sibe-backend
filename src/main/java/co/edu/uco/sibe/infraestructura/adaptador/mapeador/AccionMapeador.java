package co.edu.uco.sibe.infraestructura.adaptador.mapeador;

import co.edu.uco.sibe.dominio.dto.AccionDTO;
import co.edu.uco.sibe.dominio.modelo.Accion;
import co.edu.uco.sibe.infraestructura.adaptador.entidad.AccionEntidad;
import org.springframework.stereotype.Component;

@Component
public class AccionMapeador {
    private final ProyectoMapeador proyectoMapeador;

    public AccionMapeador(ProyectoMapeador proyectoMapeador){
        this.proyectoMapeador = proyectoMapeador;
    }

    public AccionDTO construirDTO(AccionEntidad accion){
        return new AccionDTO(accion.getIdentificador(), accion.getDetalle(), accion.getObjetivo(), this.proyectoMapeador.construirDTO(accion.getProyecto()));
    }

    public AccionEntidad construirEntidad(Accion accion){
        return new AccionEntidad(accion.getIdentificador(), accion.getDetalle(), accion.getObjetivo(), this.proyectoMapeador.construirEntidad(accion.getProyecto()));
    }
}
