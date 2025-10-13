package co.edu.uco.sibe.infraestructura.controlador.consulta;

import co.edu.uco.sibe.aplicacion.consulta.*;
import co.edu.uco.sibe.dominio.dto.*;
import co.edu.uco.sibe.dominio.transversal.constante.TextoConstante;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping("/usuarios")
public class UsuarioConsultarControlador {
    private final ConsultarPersonaPorIdentificadorManejador consultarPersonaPorIdentificadorManejador;
    private final ConsultarUsuarioPorCorreoManejador consultarUsuarioPorCorreoManejador;
    private final ConsultarUsuarioPorIdentificadorManejador consultarUsuarioPorIdentificadorManejador;
    private final ConsultarUsuariosManejador consultarUsuariosManejador;

    @PreAuthorize(TextoConstante.HAS_USER_OR_ADMIN_GET_AUTHORITY)
    @GetMapping("/{identificador}")
    public UsuarioDTO consultarUsuarioPorIdentificador(@PathVariable UUID identificador){
        return consultarUsuarioPorIdentificadorManejador.ejecutar(identificador);
    }

    @PreAuthorize(TextoConstante.HAS_USER_OR_ADMIN_GET_AUTHORITY)
    @GetMapping("/usuarios")
    public List<UsuarioDTO> consultarUsuarios(){
        return consultarUsuariosManejador.ejecutar();
    }

    @PreAuthorize(TextoConstante.HAS_USER_OR_ADMIN_GET_AUTHORITY)
    @GetMapping("/usuario/correo/{correo}")
    public UsuarioDTO consultarUsuarioPorCorreo(@PathVariable String correo){
        return consultarUsuarioPorCorreoManejador.ejecutar(correo);
    }

    @PreAuthorize(TextoConstante.HAS_USER_OR_ADMIN_GET_AUTHORITY)
    @GetMapping("/persona/id/{identificador}")
    public PersonaDTO consultarPersonaPorIdentificador(@PathVariable UUID identificador){
        return consultarPersonaPorIdentificadorManejador.ejecutar(identificador);
    }

}
