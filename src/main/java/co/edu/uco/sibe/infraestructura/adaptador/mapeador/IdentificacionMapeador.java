package co.edu.uco.sibe.infraestructura.adaptador.mapeador;

import co.edu.uco.sibe.dominio.dto.IdentificacionDTO;
import co.edu.uco.sibe.dominio.modelo.Identificacion;
import co.edu.uco.sibe.dominio.transversal.utilitarios.UtilUUID;
import co.edu.uco.sibe.infraestructura.adaptador.dao.IdentificacionTipoIdentificacionDAO;
import co.edu.uco.sibe.infraestructura.adaptador.entidad.IdentificacionEntidad;
import co.edu.uco.sibe.infraestructura.adaptador.entidad.IdentificacionTipoIdentificacionEntidad;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import java.util.UUID;

@Component
@AllArgsConstructor
public class IdentificacionMapeador {
    private final TipoIdentificacionMapeador tipoIdentificacionMapeador;
    private final IdentificacionTipoIdentificacionDAO identificacionTipoIdentificacionDAO;

    public void modificarEntidad(IdentificacionEntidad entidad, Identificacion modelo) {
        entidad.setNumeroIdentificacion(modelo.getNumeroIdentificacion());

        this.tipoIdentificacionMapeador.modificarEntidad(entidad.getTipoIdentificacion(), modelo.getTipoIdentificacion());
    }

    public Identificacion construirModelo(IdentificacionEntidad entidad) {
        var tipoIdentificacion = tipoIdentificacionMapeador.construirModelo(entidad.getTipoIdentificacion().getTipoIdentificacion());

        return Identificacion.construir(entidad.getIdentificador(), entidad.getNumeroIdentificacion(), tipoIdentificacion);
    }

    public IdentificacionEntidad construirEntidad(Identificacion identificacion) {
        var tipoIdentificacion = tipoIdentificacionMapeador.construirEntidad(identificacion.getTipoIdentificacion());
        var identificacionTipoIdentificacion = new IdentificacionTipoIdentificacionEntidad(
                generarNuevoUUIDIdentificacionTipoIdentificacion(),
                tipoIdentificacion
        );

        return new IdentificacionEntidad(identificacion.getIdentificador(), identificacion.getNumeroIdentificacion(), identificacionTipoIdentificacion);
    }

    public UUID generarNuevoUUIDIdentificacionTipoIdentificacion() {
        UUID nuevoUUID;
        do {
            nuevoUUID = UtilUUID.generarNuevoUUID();
        } while (identificacionTipoIdentificacionDAO.findById(nuevoUUID).orElse(null) != null);
        return nuevoUUID;
    }

    public IdentificacionDTO construirDTO(IdentificacionEntidad identificacion) {
        var tipoIdentificacion = tipoIdentificacionMapeador.construirDTO(identificacion.getTipoIdentificacion().getTipoIdentificacion());

        return new IdentificacionDTO(identificacion.getIdentificador(), identificacion.getNumeroIdentificacion(), tipoIdentificacion);
    }
}