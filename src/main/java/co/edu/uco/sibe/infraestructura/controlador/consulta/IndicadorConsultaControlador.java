package co.edu.uco.sibe.infraestructura.controlador.consulta;

import co.edu.uco.sibe.aplicacion.consulta.ConsultarIndicadoresManejador;
import co.edu.uco.sibe.aplicacion.consulta.ConsultarIndicadoresParaActividadesManejador;
import co.edu.uco.sibe.dominio.dto.IndicadorDTO;
import co.edu.uco.sibe.dominio.dto.RespuestaPaginada;
import co.edu.uco.sibe.dominio.dto.SolicitudPaginacion;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import static co.edu.uco.sibe.dominio.transversal.constante.SeguridadConstante.HAS_USER_OR_AREA_ADMIN_OR_ADMIN_GET_AUTHORITY;
import static co.edu.uco.sibe.dominio.transversal.constante.ApiEndpointConstante.INDICADORES;
import static co.edu.uco.sibe.dominio.transversal.constante.ApiEndpointConstante.INDICADORES_PARA_ACTIVIDADES;
import static co.edu.uco.sibe.dominio.transversal.constante.ApiEndpointConstante.INDICADORES_PAGINADO;

@RestController
@AllArgsConstructor
@RequestMapping(INDICADORES)
public class IndicadorConsultaControlador {
    private final ConsultarIndicadoresManejador consultarIndicadoresManejador;
    private final ConsultarIndicadoresParaActividadesManejador consultarIndicadoresParaActividadesManejador;

    @PreAuthorize(HAS_USER_OR_AREA_ADMIN_OR_ADMIN_GET_AUTHORITY)
    @GetMapping
    public List<IndicadorDTO> consultarTodos(){
        return consultarIndicadoresManejador.ejecutar();
    }

    @PreAuthorize(HAS_USER_OR_AREA_ADMIN_OR_ADMIN_GET_AUTHORITY)
    @GetMapping(INDICADORES_PAGINADO)
    public RespuestaPaginada<IndicadorDTO> consultarTodosPaginado(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(required = false) String busqueda,
            @RequestParam(required = false) String sort,
            @RequestParam(required = false) String direction) {
        SolicitudPaginacion solicitud = new SolicitudPaginacion(page, size, busqueda, sort, direction);
        return consultarIndicadoresManejador.ejecutar(solicitud);
    }

    @PreAuthorize(HAS_USER_OR_AREA_ADMIN_OR_ADMIN_GET_AUTHORITY)
    @GetMapping(INDICADORES_PARA_ACTIVIDADES)
    public List<IndicadorDTO> consultarParaActividades(){
        return consultarIndicadoresParaActividadesManejador.ejecutar();
    }
}