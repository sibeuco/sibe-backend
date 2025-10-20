package co.edu.uco.sibe.infraestructura.adaptador.mapeador;

import co.edu.uco.sibe.dominio.modelo.Accion;
import co.edu.uco.sibe.infraestructura.adaptador.dao.ProyectoAccionDAO;
import co.edu.uco.sibe.infraestructura.adaptador.entidad.ProyectoAccionEntidad;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import java.util.List;
import static co.edu.uco.sibe.dominio.transversal.utilitarios.UtilUUID.generar;
import static co.edu.uco.sibe.dominio.transversal.utilitarios.ValidadorObjeto.esNulo;

@Component
@AllArgsConstructor
public class ProyectoAccionMapeador {
    private final AccionMapeador accionMapeador;
    private final ProyectoAccionDAO proyectoAccionDAO;

    public ProyectoAccionEntidad construirEntidad(Accion accion) {
        return new ProyectoAccionEntidad(
                generar(uuid -> !esNulo(proyectoAccionDAO.findById(uuid).orElse(null))),
                this.accionMapeador.construirEntidad(accion)
        );
    }

    public List<ProyectoAccionEntidad> construirEntidades(List<Accion> acciones){
        return acciones.stream().map(this::construirEntidad).toList();
    }

    public Accion construirModelo(ProyectoAccionEntidad accion) {
        return this.accionMapeador.construriModelo(accion.getAccion());
    }

    public List<Accion> construirModelos(List<ProyectoAccionEntidad> acciones){
        return acciones.stream().map(this::construirModelo).toList();
    }
}