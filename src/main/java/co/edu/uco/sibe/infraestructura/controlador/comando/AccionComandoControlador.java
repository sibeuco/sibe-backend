package co.edu.uco.sibe.infraestructura.controlador.comando;

import co.edu.uco.sibe.aplicacion.comando.AccionComando;
import co.edu.uco.sibe.aplicacion.comando.manejador.AgregarNuevaAccionManejador;
import co.edu.uco.sibe.aplicacion.transversal.ComandoRespuesta;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

import static co.edu.uco.sibe.dominio.transversal.constante.TextoConstante.*;

@RestController
@AllArgsConstructor
@RequestMapping(ACCIONES)
public class AccionComandoControlador {
    private final AgregarNuevaAccionManejador agregarNuevaAccionManejador;

    @PreAuthorize(HAS_ADMIN_CREATE_AUTHORITY)
    @PostMapping
    public ComandoRespuesta<UUID> agregarNuevaAccion(@RequestBody AccionComando accion){
        return this.agregarNuevaAccionManejador.ejecutar(accion);
    }
}
