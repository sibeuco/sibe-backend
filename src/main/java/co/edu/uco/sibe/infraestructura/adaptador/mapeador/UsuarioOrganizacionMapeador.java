package co.edu.uco.sibe.infraestructura.adaptador.mapeador;

import co.edu.uco.sibe.infraestructura.adaptador.dao.UsuarioOrganizacionDAO;
import co.edu.uco.sibe.infraestructura.adaptador.entidad.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import static co.edu.uco.sibe.dominio.transversal.utilitarios.UtilUUID.generar;
import static co.edu.uco.sibe.dominio.transversal.utilitarios.ValidadorObjeto.esNulo;

@Component
@AllArgsConstructor
public class UsuarioOrganizacionMapeador {
    private final UsuarioOrganizacionDAO usuarioOrganizacionDAO;

    public UsuarioOrganizacionEntidad construirEntidadVinculadaConDireccion(UsuarioEntidad usuario, DireccionEntidad direccion){
        return new UsuarioOrganizacionEntidad(
                generar(uuid -> !esNulo(usuarioOrganizacionDAO.findById(uuid).orElse(null))),
                usuario, direccion,
                null,
                null
        );
    }

    public void cambiarEntidadVinculadaConDireccion(UsuarioOrganizacionEntidad usuarioOrganizacionEntidad, DireccionEntidad direccion){
        usuarioOrganizacionEntidad.setDireccion(direccion);
        usuarioOrganizacionEntidad.setArea(null);
        usuarioOrganizacionEntidad.setSubarea(null);
    }

    public UsuarioOrganizacionEntidad construirEntidadVinculadaConArea(UsuarioEntidad usuario, AreaEntidad area){
        return new UsuarioOrganizacionEntidad(generar(uuid -> !esNulo(usuarioOrganizacionDAO.findById(uuid).orElse(null))),
                usuario,
                null,
                area,
                null
        );
    }

    public void cambiarEntidadVinculadaConArea(UsuarioOrganizacionEntidad usuarioOrganizacionEntidad, AreaEntidad area){
        usuarioOrganizacionEntidad.setDireccion(null);
        usuarioOrganizacionEntidad.setArea(area);
        usuarioOrganizacionEntidad.setSubarea(null);
    }


    public UsuarioOrganizacionEntidad construirEntidadVinculadaConSubarea(UsuarioEntidad usuario, SubareaEntidad subarea){
        return new UsuarioOrganizacionEntidad(
                generar(uuid -> !esNulo(usuarioOrganizacionDAO.findById(uuid).orElse(null))),
                usuario,
                null,
                null,
                subarea
        );
    }

    public void cambiarEntidadVinculadaConArea(UsuarioOrganizacionEntidad usuarioOrganizacionEntidad, SubareaEntidad subarea){
        usuarioOrganizacionEntidad.setDireccion(null);
        usuarioOrganizacionEntidad.setArea(null);
        usuarioOrganizacionEntidad.setSubarea(subarea);
    }
}