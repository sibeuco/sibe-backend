package co.edu.uco.sibe.infraestructura.controlador.comando;

import co.edu.uco.sibe.aplicacion.comando.ActividadComando;
import co.edu.uco.sibe.aplicacion.comando.ActividadModificacionComando;
import co.edu.uco.sibe.aplicacion.comando.manejador.GuardarActividadManejador;
import co.edu.uco.sibe.aplicacion.comando.manejador.ModificarActividadManejador;
import co.edu.uco.sibe.aplicacion.transversal.ComandoRespuesta;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

import static co.edu.uco.sibe.dominio.transversal.constante.TextoConstante.*;
import static co.edu.uco.sibe.dominio.transversal.utilitarios.UtilUUID.textoAUUID;

@RestController
@AllArgsConstructor
@RequestMapping(ACTIVIDADES)
public class ActividadComandoControlador {

    private final GuardarActividadManejador guardarActividadManejador;
    private final ModificarActividadManejador modificarActividadManejador;

    @PreAuthorize(HAS_ADMIN_CREATE_AUTHORITY)
    @PostMapping
    public ComandoRespuesta<UUID> guardar(@RequestBody ActividadComando comando) {
        return this.guardarActividadManejador.ejecutar(comando);
    }

    @PreAuthorize(HAS_ADMIN_CREATE_AUTHORITY)
    @PutMapping(IDENTIFICADOR_PATH)
    public ComandoRespuesta<UUID> modificar(@RequestBody ActividadModificacionComando comando, @PathVariable String identificador) {
        return this.modificarActividadManejador.ejecutar(comando, textoAUUID(identificador));
    }
}