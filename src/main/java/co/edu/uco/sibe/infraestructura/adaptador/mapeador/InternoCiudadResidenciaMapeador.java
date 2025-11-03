package co.edu.uco.sibe.infraestructura.adaptador.mapeador;

import co.edu.uco.sibe.dominio.modelo.CiudadResidencia;
import co.edu.uco.sibe.infraestructura.adaptador.dao.InternoCiudadResidenciaDAO;
import co.edu.uco.sibe.infraestructura.adaptador.entidad.CiudadResidenciaEntidad;
import co.edu.uco.sibe.infraestructura.adaptador.entidad.InternoCiudadResidenciaEntidad;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import static co.edu.uco.sibe.dominio.transversal.utilitarios.UtilUUID.generar;
import static co.edu.uco.sibe.dominio.transversal.utilitarios.ValidadorObjeto.esNulo;

@Component
@AllArgsConstructor
public class InternoCiudadResidenciaMapeador {
    private final CiudadResidenciaMapeador ciudadResidenciaMapeador;
    private final InternoCiudadResidenciaDAO internoCiudadResidenciaDAO;

    public InternoCiudadResidenciaEntidad construirEntidad(CiudadResidencia ciudadResidencia) {
        return new InternoCiudadResidenciaEntidad(
                generar(uuid -> !esNulo(internoCiudadResidenciaDAO.findById(uuid).orElse(null))),
                this.ciudadResidenciaMapeador.construirEntidad(ciudadResidencia)
        );
    }

    public CiudadResidencia construirModelo(InternoCiudadResidenciaEntidad internoCiudadResidenciaEntidad) {
        return ciudadResidenciaMapeador.construirModelo(internoCiudadResidenciaEntidad.getCiudadResidencia());
    }

    public void modificarEntidad(CiudadResidenciaEntidad ciudadResidencia, CiudadResidencia ciudadResidencia1) {
        ciudadResidencia.setDescripcion(ciudadResidencia1.getDescripcion());
    }
}