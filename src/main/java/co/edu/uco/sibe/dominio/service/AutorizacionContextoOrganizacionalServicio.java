package co.edu.uco.sibe.dominio.service;

import co.edu.uco.sibe.dominio.dto.ContextoUsuarioAutenticado;
import co.edu.uco.sibe.dominio.modelo.Actividad;
import co.edu.uco.sibe.dominio.puerto.consulta.ActividadRepositorioConsulta;
import co.edu.uco.sibe.dominio.puerto.consulta.AreaRepositorioConsulta;
import co.edu.uco.sibe.dominio.puerto.consulta.SubareaRepositorioConsulta;
import co.edu.uco.sibe.dominio.puerto.consulta.UsuarioOrganizacionRepositorioConsulta;
import co.edu.uco.sibe.dominio.puerto.servicio.ContextoUsuarioProveedorServicio;
import co.edu.uco.sibe.dominio.transversal.excepcion.AuthorizationException;

import java.util.UUID;

import static co.edu.uco.sibe.dominio.transversal.constante.SeguridadConstante.*;

public class AutorizacionContextoOrganizacionalServicio {

    private final ContextoUsuarioProveedorServicio contextoProveedorServicio;
    private final AreaRepositorioConsulta areaRepositorioConsulta;
    private final SubareaRepositorioConsulta subareaRepositorioConsulta;
    private final ActividadRepositorioConsulta actividadRepositorioConsulta;
    private final UsuarioOrganizacionRepositorioConsulta usuarioOrganizacionRepositorioConsulta;

    public AutorizacionContextoOrganizacionalServicio(
            ContextoUsuarioProveedorServicio contextoProveedorServicio,
            AreaRepositorioConsulta areaRepositorioConsulta,
            SubareaRepositorioConsulta subareaRepositorioConsulta,
            ActividadRepositorioConsulta actividadRepositorioConsulta,
            UsuarioOrganizacionRepositorioConsulta usuarioOrganizacionRepositorioConsulta) {
        this.contextoProveedorServicio = contextoProveedorServicio;
        this.areaRepositorioConsulta = areaRepositorioConsulta;
        this.subareaRepositorioConsulta = subareaRepositorioConsulta;
        this.actividadRepositorioConsulta = actividadRepositorioConsulta;
        this.usuarioOrganizacionRepositorioConsulta = usuarioOrganizacionRepositorioConsulta;
    }

    public void validarAccesoADireccion(UUID direccionId) {
        var contexto = obtenerContexto();
        if (esAdministradorDireccion(contexto))
            return;
        throw new AuthorizationException("No tiene permisos para acceder a esta dirección");
    }

    public void validarAccesoAArea(UUID areaId) {
        var contexto = obtenerContexto();
        if (esAdministradorDireccion(contexto))
            return;
        if (esAdministradorArea(contexto) && areaId.equals(contexto.getAreaId()))
            return;
        throw new AuthorizationException("No tiene permisos para acceder a esta área");
    }

    public void validarAccesoASubarea(UUID subareaId) {
        var contexto = obtenerContexto();
        if (esAdministradorDireccion(contexto))
            return;
        if (esAdministradorArea(contexto)) {
            var subarea = subareaRepositorioConsulta.consultarPorIdentificador(subareaId);
            if (subarea != null) {
                var areaDeLaSubarea = areaRepositorioConsulta.consultarPorIdentificador(contexto.getAreaId());
                if (areaDeLaSubarea != null && areaDeLaSubarea.getSubareas() != null) {
                    boolean perteneceASuArea = areaDeLaSubarea.getSubareas().stream()
                            .anyMatch(s -> s.getIdentificador().equals(subareaId));
                    if (perteneceASuArea)
                        return;
                }
            }
            throw new AuthorizationException("No tiene permisos para acceder a esta sub-área");
        }
        if (esColaborador(contexto) && subareaId.equals(contexto.getSubareaId()))
            return;
        throw new AuthorizationException("No tiene permisos para acceder a esta sub-área");
    }

    public void validarAccesoAActividad(UUID actividadId) {
        var contexto = obtenerContexto();
        if (esAdministradorDireccion(contexto))
            return;

        var actividad = actividadRepositorioConsulta.consultarPorIdentificador(actividadId);
        if (actividad == null) {
            throw new AuthorizationException("Actividad no encontrada");
        }

        if (esAdministradorArea(contexto)) {
            var areaDeActividad = areaRepositorioConsulta.consultarPorActividad(actividad);
            if (areaDeActividad != null && areaDeActividad.getIdentificador().equals(contexto.getAreaId()))
                return;
            throw new AuthorizationException("No tiene permisos para acceder a esta actividad");
        }

        if (esColaborador(contexto)) {
            if (actividad.getColaborador() != null && actividad.getColaborador().equals(contexto.getIdentificador()))
                return;
            var subareaDeActividad = subareaRepositorioConsulta.consultarPorActividad(actividad);
            if (subareaDeActividad != null && subareaDeActividad.getIdentificador().equals(contexto.getSubareaId()))
                return;
            throw new AuthorizationException("No tiene permisos para acceder a esta actividad");
        }

        throw new AuthorizationException("No tiene permisos para acceder a esta actividad");
    }

    public void validarAccesoAEjecucionActividad(UUID ejecucionId) {
        var ejecucion = actividadRepositorioConsulta.consultarEjecucionActividadPorIdentificador(ejecucionId);
        if (ejecucion == null) {
            throw new AuthorizationException("Ejecución de actividad no encontrada");
        }
        validarAccesoAActividad(ejecucion.getActividad().getIdentificador());
    }

    public void validarAccesoAUsuario(UUID usuarioId) {
        var contexto = obtenerContexto();
        if (esAdministradorDireccion(contexto))
            return;
        if (esColaborador(contexto) && usuarioId.equals(contexto.getIdentificador()))
            return;
        if (esAdministradorArea(contexto)) {
            var areaDelUsuario = usuarioOrganizacionRepositorioConsulta.consultarAreaIdPorUsuarioId(usuarioId);
            if (areaDelUsuario != null && areaDelUsuario.equals(contexto.getAreaId()))
                return;
        }
        throw new AuthorizationException("No tiene permisos para acceder a este usuario");
    }

    public ContextoUsuarioAutenticado obtenerContexto() {
        return contextoProveedorServicio.obtenerContextoActual();
    }

    private boolean esAdministradorDireccion(ContextoUsuarioAutenticado contexto) {
        return ADMINISTRADOR_DIRECCION.equals(contexto.getRol());
    }

    private boolean esAdministradorArea(ContextoUsuarioAutenticado contexto) {
        return ADMINISTRADOR_AREA.equals(contexto.getRol());
    }

    private boolean esColaborador(ContextoUsuarioAutenticado contexto) {
        return COLABORADOR.equals(contexto.getRol());
    }
}
