package co.edu.uco.sibe.infraestructura.controlador.consulta;

import co.edu.uco.sibe.aplicacion.consulta.ConsultarTiposUsuarioManejador;
import co.edu.uco.sibe.dominio.dto.TipoUsuarioDTO;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static co.edu.uco.sibe.dominio.transversal.constante.TextoConstante.HAS_USER_OR_AREA_ADMIN_OR_ADMIN_GET_AUTHORITY;
import static co.edu.uco.sibe.dominio.transversal.constante.TextoConstante.TIPOS_USUARIO;

@RestController
@AllArgsConstructor
@RequestMapping(TIPOS_USUARIO)
public class TipoUsuarioConsultaControlador {
    private final ConsultarTiposUsuarioManejador consultarTiposUsuarioManejador;

    @PreAuthorize(HAS_USER_OR_AREA_ADMIN_OR_ADMIN_GET_AUTHORITY)
    @GetMapping()
    public List<TipoUsuarioDTO> consultarTiposUsuario(){
        return consultarTiposUsuarioManejador.ejecutar();
    }
}