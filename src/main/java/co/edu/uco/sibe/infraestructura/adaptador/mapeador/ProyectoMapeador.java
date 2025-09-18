package co.edu.uco.sibe.infraestructura.adaptador.mapeador;

import co.edu.uco.sibe.infraestructura.adaptador.entidad.ProyectoEntidad;
import org.springframework.stereotype.Component;

@Component
public class ProyectoMapeador {

    public ProyectoDTO construirDTO(ProyectoEntidad proyecto){
        return new ProyectoDTO(proyecto.getIdentificador(), proyecto.getNumeroProyecto(), proyecto.getNombre(), proyecto.getObjetivo());
    }

    public ProyectoEntidad construirEntidad(Proyecto proyecto){
        return new ProyectoEntidad(proyecto.getIdentificador(), proyecto.getNumeroProyecto(), proyecto.getNombre(), proyecto.getObjetivo());
    }

}
