package co.edu.uco.sibe.infraestructura.controlador.comando;

import co.edu.uco.sibe.aplicacion.comando.UsuarioComando;
import co.edu.uco.sibe.aplicacion.comando.UsuarioModificacionComando;
import co.edu.uco.sibe.aplicacion.comando.manejador.AgregarNuevoUsuarioManejador;
import co.edu.uco.sibe.aplicacion.comando.manejador.EliminarPersonaManejador;
import co.edu.uco.sibe.aplicacion.comando.manejador.ModificarUsuarioManejador;
import co.edu.uco.sibe.aplicacion.transversal.ComandoRespuesta;
import co.edu.uco.sibe.dominio.transversal.constante.TextoConstante;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping(TextoConstante.USER_API)
public class UsuarioComandoControlador {
    private final AgregarNuevoUsuarioManejador agregarNuevoUsuarioManejador;
    private final EliminarPersonaManejador eliminarPersonaManejador;
    private final ModificarUsuarioManejador modificarUsuarioManejador;

    @PreAuthorize(TextoConstante.HAS_ADMIN_CREATE_AUTHORITY)
    @PostMapping
    public ComandoRespuesta<UUID> agregarNuevoUsuario(@RequestBody UsuarioComando usuario){
        return this.agregarNuevoUsuarioManejador.ejecutar(usuario);
    }

    @PreAuthorize(TextoConstante.HAS_USER_OR_ADMIN_UPDATE_AUTHORITY)
    @PutMapping("/usuario/{identificador}")
    public ComandoRespuesta<UUID> modificarUsuario(@RequestBody UsuarioModificacionComando usuario, @PathVariable("identificador") UUID identificador){
        return modificarUsuarioManejador.ejecutar(usuario, identificador);
    }

    @PreAuthorize(TextoConstante.HAS_ADMIN_DELETE_AUTHORITY)
    @DeleteMapping
    public ComandoRespuesta<UUID> eliminarUsuario(@PathVariable UUID identificador){
        return this.eliminarPersonaManejador.ejecutar(identificador);
    }
}
