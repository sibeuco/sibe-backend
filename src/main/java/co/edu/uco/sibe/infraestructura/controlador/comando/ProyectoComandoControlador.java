package co.edu.uco.sibe.infraestructura.controlador.comando;

import co.edu.uco.sibe.aplicacion.comando.ProyectoComando;
import co.edu.uco.sibe.aplicacion.comando.ProyectoModificacionComando;
import co.edu.uco.sibe.aplicacion.comando.manejador.AgregarNuevoProyectoManejador;
import co.edu.uco.sibe.aplicacion.comando.manejador.ModificarProyectoManejador;
import co.edu.uco.sibe.aplicacion.transversal.ComandoRespuesta;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.util.UUID;
import static co.edu.uco.sibe.dominio.transversal.constante.TextoConstante.*;
import static co.edu.uco.sibe.dominio.transversal.utilitarios.UtilUUID.textoAUUID;

@RestController
@AllArgsConstructor
@RequestMapping(PROYECTOS)
public class ProyectoComandoControlador {
    private final AgregarNuevoProyectoManejador agregarNuevoProyectoManejador;
    private final ModificarProyectoManejador modificarProyectoManejador;

    @PreAuthorize(HAS_ADMIN_CREATE_AUTHORITY)
    @PostMapping
    public ComandoRespuesta<UUID> agregarNuevo(@RequestBody ProyectoComando proyecto){
        return this.agregarNuevoProyectoManejador.ejecutar(proyecto);
    }

    @PreAuthorize(HAS_ADMIN_CREATE_AUTHORITY)
    @PutMapping(IDENTIFICADOR_PATH)
    public ComandoRespuesta<UUID> modificar(@RequestBody ProyectoModificacionComando proyecto, @PathVariable String identificador){
        return this.modificarProyectoManejador.ejecutar(proyecto, textoAUUID(identificador));
    }
}
