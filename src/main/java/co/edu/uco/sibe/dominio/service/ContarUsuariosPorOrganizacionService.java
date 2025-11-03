package co.edu.uco.sibe.dominio.service;

import co.edu.uco.sibe.dominio.modelo.Area;
import co.edu.uco.sibe.dominio.modelo.Direccion;
import co.edu.uco.sibe.dominio.modelo.Subarea;
import co.edu.uco.sibe.dominio.puerto.consulta.UsuarioOrganizacionRepositorioConsulta;

public class ContarUsuariosPorOrganizacionService {

    private final UsuarioOrganizacionRepositorioConsulta usuarioOrganizacionRepositorioConsulta;

    public ContarUsuariosPorOrganizacionService(UsuarioOrganizacionRepositorioConsulta usuarioOrganizacionRepositorioConsulta) {
        this.usuarioOrganizacionRepositorioConsulta = usuarioOrganizacionRepositorioConsulta;
    }

    public long contarUsuariosPorDireccion(Direccion direccion) {
        long total = usuarioOrganizacionRepositorioConsulta.contarPorDireccion(direccion.getIdentificador());
        total += direccion.getAreas().stream()
                .mapToLong(this::contarUsuariosPorArea)
                .sum();
        return total;
    }

    public long contarUsuariosPorArea(Area area) {
        long total = usuarioOrganizacionRepositorioConsulta.contarPorArea(area.getIdentificador());
        total += area.getSubareas().stream()
                .mapToLong(this::contarUsuariosPorSubarea)
                .sum();
        return total;
    }

    public long contarUsuariosPorSubarea(Subarea subarea) {
        return usuarioOrganizacionRepositorioConsulta.contarPorSubarea(subarea.getIdentificador());
    }
}