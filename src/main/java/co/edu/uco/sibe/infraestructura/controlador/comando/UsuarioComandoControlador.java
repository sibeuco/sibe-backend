package co.edu.uco.sibe.infraestructura.controlador.comando;

import co.edu.uco.sibe.aplicacion.comando.PersonaComando;
import co.edu.uco.sibe.aplicacion.comando.UsuarioComando;
import co.edu.uco.sibe.aplicacion.comando.UsuarioModificacionComando;
import co.edu.uco.sibe.aplicacion.comando.manejador.AgregarNuevoUsuarioManejador;
import co.edu.uco.sibe.aplicacion.comando.manejador.EliminarPersonaManejador;
import co.edu.uco.sibe.aplicacion.comando.manejador.ModificarPersonaManejador;
import co.edu.uco.sibe.aplicacion.comando.manejador.ModificarUsuarioManejador;
import co.edu.uco.sibe.aplicacion.transversal.ComandoRespuesta;
import lombok.AllArgsConstructor;
import org.junit.jupiter.api.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping("/usuarios")
@Tag("Comando del Usuario Controlador")
public class UsuarioComandoControlador {
    private final AgregarNuevoUsuarioManejador agregarNuevoUsuarioManejador;
    private final EliminarPersonaManejador eliminarPersonaManejador;
    private final ModificarUsuarioManejador modificarUsuarioManejador;
    private final ModificarPersonaManejador modificarPersonaManejador;

    @PostMapping
    public ComandoRespuesta<UUID> agregarNuevoUsuario(@RequestBody UsuarioComando usuario){
        return this.agregarNuevoUsuarioManejador.ejecutar(usuario);
    }

    @PutMapping("/persona/{identificador}")
    public ComandoRespuesta<UUID> modificarPersona( @RequestBody PersonaComando persona, @PathVariable("id") UUID identificador){
        return modificarPersonaManejador.ejecutar(persona, identificador);
    }

    @PutMapping("/usuario/{identificador}")
    public ComandoRespuesta<UUID> modificarUsuario(@RequestBody UsuarioModificacionComando usuario, @PathVariable("id") UUID identificador){
        return modificarUsuarioManejador.ejecutar(usuario, identificador);
    }

    @DeleteMapping
    public ComandoRespuesta<UUID> eliminarUsuario(@PathVariable UUID identificador){
        return this.eliminarPersonaManejador.ejecutar(identificador);
    }
}
