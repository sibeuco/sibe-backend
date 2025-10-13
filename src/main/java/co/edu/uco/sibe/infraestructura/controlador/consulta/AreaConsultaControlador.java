package co.edu.uco.sibe.infraestructura.controlador.consulta;

import co.edu.uco.sibe.aplicacion.consulta.ConsultarAreasManejador;
import co.edu.uco.sibe.dominio.dto.AreaDTO;
import co.edu.uco.sibe.dominio.transversal.constante.TextoConstante;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/areas")
public class AreaConsultaControlador {
    private final ConsultarAreasManejador consultarAreasManejador;

    @PreAuthorize(TextoConstante.HAS_USER_OR_ADMIN_GET_AUTHORITY)
    @GetMapping()
    public List<AreaDTO> consultarAreas(){
        return consultarAreasManejador.ejecutar();
    }
}
