package co.edu.uco.sibe.infraestructura.controlador.consulta;

import co.edu.uco.sibe.aplicacion.consulta.ConsultarIndicadoresManejador;
import co.edu.uco.sibe.dominio.dto.IndicadorDTO;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import static co.edu.uco.sibe.dominio.transversal.constante.TextoConstante.HAS_USER_OR_AREA_ADMIN_OR_ADMIN_GET_AUTHORITY;
import static co.edu.uco.sibe.dominio.transversal.constante.TextoConstante.INDICADORES;

@RestController
@AllArgsConstructor
@RequestMapping(INDICADORES)
public class IndicadorConsultaControlador {
    private final ConsultarIndicadoresManejador consultarIndicadoresManejador;

    @PreAuthorize(HAS_USER_OR_AREA_ADMIN_OR_ADMIN_GET_AUTHORITY)
    @GetMapping
    public List<IndicadorDTO> consultarTodos(){
        return consultarIndicadoresManejador.ejecutar();
    }
}