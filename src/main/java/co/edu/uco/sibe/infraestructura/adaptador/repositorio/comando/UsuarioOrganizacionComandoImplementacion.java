package co.edu.uco.sibe.infraestructura.adaptador.repositorio.comando;

import co.edu.uco.sibe.dominio.puerto.comando.UsuarioOrganizacionComando;
import co.edu.uco.sibe.dominio.transversal.utilitarios.ValidadorObjeto;
import co.edu.uco.sibe.infraestructura.adaptador.dao.*;
import co.edu.uco.sibe.infraestructura.adaptador.mapeador.UsuarioOrganizacionMapeador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.UUID;

@Repository
public class UsuarioOrganizacionComandoImplementacion implements UsuarioOrganizacionComando {
    @Autowired
    UsuarioDAO usuarioDAO;

    @Autowired
    DireccionDAO direccionDAO;

    @Autowired
    AreaDAO areaDAO;

    @Autowired
    SubareaDAO subareaDAO;

    @Autowired
    UsuarioOrganizacionDAO usuarioOrganizacionDAO;

    @Autowired
    UsuarioOrganizacionMapeador usuarioOrganizacionMapeador;

    @Override
    public UUID vincularUsuarioConDireccion(UUID usuario, UUID direccion) {
        var usuarioEntidad = usuarioDAO.findById(usuario).orElse(null);
        var direccionEntidad = direccionDAO.findById(direccion).orElse(null);

        assert !ValidadorObjeto.esNulo(usuarioEntidad) && !ValidadorObjeto.esNulo(direccionEntidad);
        var entidad = usuarioOrganizacionMapeador.construirEntidadVinculadaConDireccion(usuarioEntidad, direccionEntidad);

        return this.usuarioOrganizacionDAO.save(entidad).getIdentificador();
    }

    @Override
    public UUID vincularUsuarioConArea(UUID usuario, UUID area) {
        var usuarioEntidad = usuarioDAO.findById(usuario).orElse(null);
        var areaEntidad = areaDAO.findById(area).orElse(null);

        assert !ValidadorObjeto.esNulo(usuarioEntidad) && !ValidadorObjeto.esNulo(areaEntidad);
        var entidad = usuarioOrganizacionMapeador.construirEntidadVinculadaConArea(usuarioEntidad, areaEntidad);

        return this.usuarioOrganizacionDAO.save(entidad).getIdentificador();
    }

    @Override
    public UUID vincularUsuarioConSubarea(UUID usuario, UUID subarea) {
        var usuarioEntidad = usuarioDAO.findById(usuario).orElse(null);
        var subareaEntidad = subareaDAO.findById(subarea).orElse(null);

        assert !ValidadorObjeto.esNulo(usuarioEntidad) && !ValidadorObjeto.esNulo(subareaEntidad);
        var entidad = usuarioOrganizacionMapeador.construirEntidadVinculadaConSubarea(usuarioEntidad, subareaEntidad);

        return this.usuarioOrganizacionDAO.save(entidad).getIdentificador();
    }
}
