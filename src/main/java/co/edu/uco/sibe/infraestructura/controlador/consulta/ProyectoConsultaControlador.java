package co.edu.uco.sibe.infraestructura.controlador.consulta;

import co.edu.uco.sibe.aplicacion.consulta.ConsultarProyectosManejador;
import co.edu.uco.sibe.dominio.dto.ProyectoDTO;
import co.edu.uco.sibe.dominio.dto.RespuestaPaginada;
import co.edu.uco.sibe.dominio.dto.SolicitudPaginacion;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import static co.edu.uco.sibe.dominio.transversal.constante.ApiEndpointConstante.*;
import static co.edu.uco.sibe.dominio.transversal.constante.SeguridadConstante.HAS_USER_OR_AREA_ADMIN_OR_ADMIN_GET_AUTHORITY;

@RestController
@AllArgsConstructor
@RequestMapping(PROYECTOS)
public class ProyectoConsultaControlador {
    private final ConsultarProyectosManejador consultarProyectosManejador;

    @PreAuthorize(HAS_USER_OR_AREA_ADMIN_OR_ADMIN_GET_AUTHORITY)
    @GetMapping
    public List<ProyectoDTO> consultarTodos(){
        return consultarProyectosManejador.ejecutar();
    }

    @PreAuthorize(HAS_USER_OR_AREA_ADMIN_OR_ADMIN_GET_AUTHORITY)
    @GetMapping(PROYECTOS_PAGINADO)
    public RespuestaPaginada<ProyectoDTO> consultarTodosPaginado(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(required = false) String busqueda,
            @RequestParam(required = false) String sort,
            @RequestParam(required = false) String direction) {
        SolicitudPaginacion solicitud = new SolicitudPaginacion(page, size, busqueda, sort, direction);
        return consultarProyectosManejador.ejecutar(solicitud);
    }
}