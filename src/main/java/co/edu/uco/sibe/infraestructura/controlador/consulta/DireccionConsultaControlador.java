package co.edu.uco.sibe.infraestructura.controlador.consulta;

import co.edu.uco.sibe.aplicacion.consulta.ConsultarDireccionesManejador;
import co.edu.uco.sibe.dominio.dto.DireccionDTO;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static co.edu.uco.sibe.dominio.transversal.constante.TextoConstante.DIRECCION;
import static co.edu.uco.sibe.dominio.transversal.constante.TextoConstante.HAS_USER_OR_AREA_ADMIN_OR_ADMIN_GET_AUTHORITY;

@RestController
@AllArgsConstructor
@RequestMapping(DIRECCION)
public class DireccionConsultaControlador {
    private final ConsultarDireccionesManejador consultarDireccionesManejador;

    @PreAuthorize(HAS_USER_OR_AREA_ADMIN_OR_ADMIN_GET_AUTHORITY)
    @GetMapping
    public List<DireccionDTO> consultarTodos(){
        return consultarDireccionesManejador.ejecutar();
    }
}
