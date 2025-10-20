package co.edu.uco.sibe.infraestructura.adaptador.mapeador;

import co.edu.uco.sibe.dominio.modelo.Proyecto;
import co.edu.uco.sibe.infraestructura.adaptador.entidad.ProyectoEntidad;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ProyectoMapeador {
    private ProyectoAccionMapeador proyectoAccionMapeador;

    public ProyectoEntidad construirEntidad(Proyecto proyecto) {
        return new ProyectoEntidad(proyecto.getIdentificador(), proyecto.getNumeroProyecto(), proyecto.getNombre(), proyecto.getObjetivo(), proyectoAccionMapeador.construirEntidades(proyecto.getAcciones()));
    }

    public Proyecto construriModelo(ProyectoEntidad proyecto) {
        return Proyecto.construir(proyecto.getIdentificador(), proyecto.getNumeroProyecto(), proyecto.getNombre(), proyecto.getObjetivo(), proyectoAccionMapeador.construirModelos(proyecto.getAcciones()));
    }
}