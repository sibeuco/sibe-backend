package co.edu.uco.sibe.infraestructura.adaptador.mapeador;

import co.edu.uco.sibe.dominio.modelo.Proyecto;
import co.edu.uco.sibe.dominio.modelo.PublicoInteres;
import co.edu.uco.sibe.dominio.transversal.utilitarios.UtilUUID;
import co.edu.uco.sibe.infraestructura.adaptador.dao.IndicadorProyectoDAO;
import co.edu.uco.sibe.infraestructura.adaptador.dao.IndicadorPublicoInteresDAO;
import co.edu.uco.sibe.infraestructura.adaptador.entidad.IndicadorProyectoEntidad;
import co.edu.uco.sibe.infraestructura.adaptador.entidad.IndicadorPublicoInteresEntidad;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@AllArgsConstructor
public class IndicadorProyectoMapeador {
    private final ProyectoMapeador proyectoMapeador;
    private final IndicadorProyectoDAO indicadorProyectoDAO;

    public IndicadorProyectoEntidad construirEntidad(Proyecto proyecto) {
        return new IndicadorProyectoEntidad(
                generarNuevoUUID(),
                this.proyectoMapeador.construirEntidad(proyecto)
        );
    }

    public Proyecto construirModelo(IndicadorProyectoEntidad proyecto) {
        return this.proyectoMapeador.construriModelo(proyecto.getProyecto());
    }

    public UUID generarNuevoUUID() {
        UUID nuevoUUID;

        do {
            nuevoUUID = UtilUUID.generarNuevoUUID();
        } while (indicadorProyectoDAO.findById(nuevoUUID).orElse(null) != null);

        return nuevoUUID;
    }
}
