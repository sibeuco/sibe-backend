package co.edu.uco.sibe.infraestructura.controlador.consulta;

import co.edu.uco.sibe.aplicacion.consulta.ConsultarAccionesManejador;
import co.edu.uco.sibe.dominio.dto.AccionDTO;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static co.edu.uco.sibe.dominio.transversal.constante.TextoConstante.ACCIONES;
import static co.edu.uco.sibe.dominio.transversal.constante.TextoConstante.HAS_USER_OR_ADMIN_UPDATE_AUTHORITY;

@RestController
@AllArgsConstructor
@RequestMapping(ACCIONES)
public class AccionConsultaControlador {
    private final ConsultarAccionesManejador consultarAccionesManejador;

    @PreAuthorize(HAS_USER_OR_ADMIN_UPDATE_AUTHORITY)
    @GetMapping
    public List<AccionDTO> consultarTodos(){
        return consultarAccionesManejador.ejecutar();
    }
}
