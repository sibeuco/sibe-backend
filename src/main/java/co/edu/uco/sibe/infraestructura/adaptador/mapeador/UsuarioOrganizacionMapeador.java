package co.edu.uco.sibe.infraestructura.adaptador.mapeador;

import co.edu.uco.sibe.dominio.transversal.utilitarios.UtilUUID;
import co.edu.uco.sibe.infraestructura.adaptador.dao.UsuarioOrganizacionDAO;
import co.edu.uco.sibe.infraestructura.adaptador.entidad.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@AllArgsConstructor
public class UsuarioOrganizacionMapeador {
    private final UsuarioOrganizacionDAO usuarioOrganizacionDAO;

    public UsuarioOrganizacionEntidad construirEntidadVinculadaConDireccion(UsuarioEntidad usuario, DireccionEntidad direccion){
        return new UsuarioOrganizacionEntidad(generarNuevoUUIDUsuarioOrganizacion(), usuario, direccion, null, null);
    }

    public UsuarioOrganizacionEntidad construirEntidadVinculadaConArea(UsuarioEntidad usuario, AreaEntidad area){
        return new UsuarioOrganizacionEntidad(generarNuevoUUIDUsuarioOrganizacion(), usuario, null, area, null);
    }

    public UsuarioOrganizacionEntidad construirEntidadVinculadaConSubarea(UsuarioEntidad usuario, SubareaEntidad subarea){
        return new UsuarioOrganizacionEntidad(generarNuevoUUIDUsuarioOrganizacion(), usuario, null, null, subarea);
    }

    public UUID generarNuevoUUIDUsuarioOrganizacion() {
        UUID nuevoUUID;

        do {
            nuevoUUID = UtilUUID.generarNuevoUUID();
        } while (usuarioOrganizacionDAO.findById(nuevoUUID).orElse(null) != null);

        return nuevoUUID;
    }
}
