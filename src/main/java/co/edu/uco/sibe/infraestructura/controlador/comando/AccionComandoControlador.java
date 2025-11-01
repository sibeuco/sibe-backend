package co.edu.uco.sibe.infraestructura.controlador.comando;

import co.edu.uco.sibe.aplicacion.comando.AccionComando;
import co.edu.uco.sibe.aplicacion.comando.manejador.GuardarAccionManejador;
import co.edu.uco.sibe.aplicacion.comando.manejador.ModificarAccionManejador;
import co.edu.uco.sibe.aplicacion.transversal.ComandoRespuesta;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.util.UUID;
import static co.edu.uco.sibe.dominio.transversal.constante.TextoConstante.*;
import static co.edu.uco.sibe.dominio.transversal.utilitarios.UtilUUID.textoAUUID;

@RestController
@AllArgsConstructor
@RequestMapping(ACCIONES)
public class AccionComandoControlador {
    private final GuardarAccionManejador guardarAccionManejador;
    private final ModificarAccionManejador modificarAccionManejador;

    @PreAuthorize(HAS_ADMIN_CREATE_AUTHORITY)
    @PostMapping
    public ComandoRespuesta<UUID> guardar(@RequestBody AccionComando accion){
        return this.guardarAccionManejador.ejecutar(accion);
    }

    @PreAuthorize(HAS_ADMIN_CREATE_AUTHORITY)
    @PutMapping(IDENTIFICADOR_PATH)
    public ComandoRespuesta<UUID> modificar(@RequestBody AccionComando accion, @PathVariable String identificador){
        return this.modificarAccionManejador.ejecutar(accion, textoAUUID(identificador));
    }
}