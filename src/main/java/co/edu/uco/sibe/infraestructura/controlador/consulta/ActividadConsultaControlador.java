package co.edu.uco.sibe.infraestructura.controlador.consulta;

import co.edu.uco.sibe.aplicacion.consulta.ConsultarActividadesPorAreaManejador;
import co.edu.uco.sibe.aplicacion.consulta.ConsultarActividadesPorDireccionManejador;
import co.edu.uco.sibe.aplicacion.consulta.ConsultarActividadesPorSubareaManejador;
import co.edu.uco.sibe.aplicacion.consulta.ConsultarEjecucionesPorActividadManejador;
import co.edu.uco.sibe.dominio.dto.ActividadDTO;
import co.edu.uco.sibe.dominio.dto.EjecucionActividadDTO;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import static co.edu.uco.sibe.dominio.transversal.constante.ApiEndpointConstante.*;
import static co.edu.uco.sibe.dominio.transversal.constante.SeguridadConstante.HAS_USER_OR_AREA_ADMIN_OR_ADMIN_GET_AUTHORITY;

@RestController
@AllArgsConstructor
@RequestMapping(ACTIVIDADES)
public class ActividadConsultaControlador {

    private final ConsultarActividadesPorAreaManejador consultarActividadesPorAreaManejador;
    private final ConsultarActividadesPorDireccionManejador consultarActividadesPorDireccionManejador;
    private final ConsultarActividadesPorSubareaManejador consultarActividadesPorSubareaManejador;
    private final ConsultarEjecucionesPorActividadManejador consultarEjecucionesPorActividadManejador;

    @PreAuthorize(HAS_USER_OR_AREA_ADMIN_OR_ADMIN_GET_AUTHORITY)
    @GetMapping(ACTIVIDADES_AREA)
    public List<ActividadDTO> consultarPorArea(@PathVariable String identificador) {
        return this.consultarActividadesPorAreaManejador.ejecutar(identificador);
    }

    @PreAuthorize(HAS_USER_OR_AREA_ADMIN_OR_ADMIN_GET_AUTHORITY)
    @GetMapping(ACTIVIDADES_DIRECCION)
    public List<ActividadDTO> consultarPorDireccion(@PathVariable String identificador) {
        return this.consultarActividadesPorDireccionManejador.ejecutar(identificador);
    }

    @PreAuthorize(HAS_USER_OR_AREA_ADMIN_OR_ADMIN_GET_AUTHORITY)
    @GetMapping(ACTIVIDADES_SUBAREA)
    public List<ActividadDTO> consultarPorSubarea(@PathVariable String identificador) {
        return this.consultarActividadesPorSubareaManejador.ejecutar(identificador);
    }

    @PreAuthorize(HAS_USER_OR_AREA_ADMIN_OR_ADMIN_GET_AUTHORITY)
    @GetMapping(ACTIVIDADES_EJECUCIONES)
    public List<EjecucionActividadDTO> consultarEjecuciones(@PathVariable String identificador) {
        return this.consultarEjecucionesPorActividadManejador.ejecutar(identificador);
    }
}