package co.edu.uco.sibe.infraestructura.controlador.comando;

import co.edu.uco.sibe.aplicacion.comando.UsuarioComando;
import co.edu.uco.sibe.aplicacion.comando.UsuarioModificacionComando;
import co.edu.uco.sibe.aplicacion.comando.manejador.AgregarNuevoUsuarioManejador;
import co.edu.uco.sibe.aplicacion.comando.manejador.EliminarPersonaManejador;
import co.edu.uco.sibe.aplicacion.comando.manejador.ModificarUsuarioManejador;
import co.edu.uco.sibe.aplicacion.transversal.ComandoRespuesta;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

import static co.edu.uco.sibe.dominio.transversal.constante.TextoConstante.*;

@RestController
@AllArgsConstructor
@RequestMapping(USER_API)
public class UsuarioComandoControlador {
    private final AgregarNuevoUsuarioManejador agregarNuevoUsuarioManejador;
    private final EliminarPersonaManejador eliminarPersonaManejador;
    private final ModificarUsuarioManejador modificarUsuarioManejador;

    @PreAuthorize(HAS_ADMIN_CREATE_AUTHORITY)
    @PostMapping
    public ComandoRespuesta<UUID> agregarNuevoUsuario(@RequestBody UsuarioComando usuario){
        return this.agregarNuevoUsuarioManejador.ejecutar(usuario);
    }

    @PreAuthorize(HAS_USER_OR_ADMIN_UPDATE_AUTHORITY)
    @PutMapping(USUARIO_IDENTIFICADOR)
    public ComandoRespuesta<UUID> modificarUsuario(@RequestBody UsuarioModificacionComando usuario, @PathVariable(IDENTIFICADOR) UUID identificador){
        return modificarUsuarioManejador.ejecutar(usuario, identificador);
    }

    @PreAuthorize(HAS_ADMIN_DELETE_AUTHORITY)
    @DeleteMapping(USUARIO_IDENTIFICADOR)
    public ComandoRespuesta<UUID> eliminarUsuario(@PathVariable UUID identificador){
        return this.eliminarPersonaManejador.ejecutar(identificador);
    }
}