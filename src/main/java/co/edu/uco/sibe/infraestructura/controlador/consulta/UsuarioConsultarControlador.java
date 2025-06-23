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
    private final ConsultarAreaPorIdentificadorManejador consultarAreaPorIdentificadorManejador;
    private final ConsultarAreasManejador consultarAreasManejador;
    private final ConsultarPersonaPorDocumentoManejador consultarPersonaPorDocumentoManejador;
    private final ConsultarPersonaPorIdentificadorManejador consultarPersonaPorIdentificadorManejador;
    private final ConsultarPersonasManejador consultarPersonasManejador;
    private final ConsultarTipoIdentificacionPorIdentificadorManejador consultarTipoIdentificacionPorIdentificadorManejador;
    private final ConsultarTiposIdentificacionManejador consultarTiposIdentificacionManejador;
    private final ConsultarTipoUsuarioPorIdentificadorManejador consultarTipoUsuarioPorIdentificadorManejador;
    private final ConsultarTiposUsuarioManejador consultarTiposUsuarioManejador;
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

    @PreAuthorize(TextoConstante.HAS_USER_OR_ADMIN_GET_AUTHORITY)
    @GetMapping("/persona/documento/{documento}")
    public PersonaDTO consultarPersonaPorDocumento(@PathVariable String documento){
        return consultarPersonaPorDocumentoManejador.ejecutar(documento);
    }

    @PreAuthorize(TextoConstante.HAS_USER_OR_ADMIN_GET_AUTHORITY)
    @GetMapping("/personas")
    public List<PersonaDTO> consultarPersonas(){
        return consultarPersonasManejador.ejecutar();
    }

    @PreAuthorize(TextoConstante.HAS_USER_OR_ADMIN_GET_AUTHORITY)
    @GetMapping("/tipo-usuario/{identificador}")
    public TipoUsuarioDTO consultarTipoUsuarioPorIdentificador(@PathVariable UUID identificador){
        return consultarTipoUsuarioPorIdentificadorManejador.ejecutar(identificador);
    }

    @PreAuthorize(TextoConstante.HAS_USER_OR_ADMIN_GET_AUTHORITY)
    @GetMapping("/tipos-usuario")
    public List<TipoUsuarioDTO> consultarTiposUsuario(){
        return consultarTiposUsuarioManejador.ejecutar();
    }

    @PreAuthorize(TextoConstante.HAS_USER_OR_ADMIN_GET_AUTHORITY)
    @GetMapping("/area/{identificador}")
    public AreaDTO consultarAreaPorIdentificador(@PathVariable UUID identificador){
        return consultarAreaPorIdentificadorManejador.ejecutar(identificador);
    }

    @PreAuthorize(TextoConstante.HAS_USER_OR_ADMIN_GET_AUTHORITY)
    @GetMapping("/areas")
    public List<AreaDTO> consultarAreas(){
        return consultarAreasManejador.ejecutar();
    }

    @PreAuthorize(TextoConstante.HAS_USER_OR_ADMIN_GET_AUTHORITY)
    @GetMapping("/tipo-identificacion/{identificador}")
    public TipoIdentificacionDTO consultarTipoIdentificacionPorIdentificador(@PathVariable UUID identificador){
        return consultarTipoIdentificacionPorIdentificadorManejador.ejecutar(identificador);
    }

    @PreAuthorize(TextoConstante.HAS_USER_OR_ADMIN_GET_AUTHORITY)
    @GetMapping("/tipos-identificacion")
    public List<TipoIdentificacionDTO> consultarTiposIdentificacion(){
        return consultarTiposIdentificacionManejador.ejecutar();
    }

}
