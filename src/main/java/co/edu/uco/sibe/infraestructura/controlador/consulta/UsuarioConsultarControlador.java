package co.edu.uco.sibe.infraestructura.controlador.consulta;

import co.edu.uco.sibe.aplicacion.consulta.*;
import co.edu.uco.sibe.dominio.dto.*;
import lombok.AllArgsConstructor;
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

    @GetMapping("/{identificador}")
    public UsuarioDTO consultarUsuarioPorIdentificador(@PathVariable UUID identificador){
        return consultarUsuarioPorIdentificadorManejador.ejecutar(identificador);
    }

    @GetMapping("/usuarios")
    public List<UsuarioDTO> consultarUsuarios(){
        return consultarUsuariosManejador.ejecutar();
    }

    @GetMapping("/usuario/correo/{correo}")
    public UsuarioDTO consultarUsuarioPorCorreo(@PathVariable String correo){
        return consultarUsuarioPorCorreoManejador.ejecutar(correo);
    }

    @GetMapping("/persona/id/{identificador}")
    public PersonaDTO consultarPersonaPorIdentificador(@PathVariable UUID identificador){
        return consultarPersonaPorIdentificadorManejador.ejecutar(identificador);
    }

    @GetMapping("/persona/documento/{documento}")
    public PersonaDTO consultarPersonaPorDocumento(@PathVariable String documento){
        return consultarPersonaPorDocumentoManejador.ejecutar(documento);
    }

    @GetMapping("/personas")
    public List<PersonaDTO> consultarPersonas(){
        return consultarPersonasManejador.ejecutar();
    }

    @GetMapping("/tipo-usuario/{identificador}")
    public TipoUsuarioDTO consultarTipoUsuarioPorIdentificador(@PathVariable UUID identificador){
        return consultarTipoUsuarioPorIdentificadorManejador.ejecutar(identificador);
    }

    @GetMapping("/tipos-usuario")
    public List<TipoUsuarioDTO> consultarTiposUsuario(){
        return consultarTiposUsuarioManejador.ejecutar();
    }

    @GetMapping("/area/{identificador}")
    public AreaDTO consultarAreaPorIdentificador(@PathVariable UUID identificador){
        return consultarAreaPorIdentificadorManejador.ejecutar(identificador);
    }

    @GetMapping("/areas")
    public List<AreaDTO> consultarAreas(){
        return consultarAreasManejador.ejecutar();
    }

    @GetMapping("/tipo-identificacion/{identificador}")
    public TipoIdentificacionDTO consultarTipoIdentificacionPorIdentificador(@PathVariable UUID identificador){
        return consultarTipoIdentificacionPorIdentificadorManejador.ejecutar(identificador);
    }

    @GetMapping("/tipos-identificacion")
    public List<TipoIdentificacionDTO> consultarTiposIdentificacion(){
        return consultarTiposIdentificacionManejador.ejecutar();
    }

}
