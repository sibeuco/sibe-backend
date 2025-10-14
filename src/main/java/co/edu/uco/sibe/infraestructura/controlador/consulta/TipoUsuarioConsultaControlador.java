package co.edu.uco.sibe.infraestructura.controlador.consulta;

import co.edu.uco.sibe.aplicacion.consulta.ConsultarTiposUsuarioManejador;
import co.edu.uco.sibe.dominio.dto.TipoUsuarioDTO;
import co.edu.uco.sibe.dominio.transversal.constante.TextoConstante;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/tipos_usuario")
public class TipoUsuarioConsultaControlador {
    private final ConsultarTiposUsuarioManejador consultarTiposUsuarioManejador;

    @PreAuthorize(TextoConstante.HAS_USER_OR_ADMIN_GET_AUTHORITY)
    @GetMapping()
    public List<TipoUsuarioDTO> consultarTiposUsuario(){
        return consultarTiposUsuarioManejador.ejecutar();
    }
}