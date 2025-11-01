package co.edu.uco.sibe.infraestructura.controlador.comando;

import co.edu.uco.sibe.aplicacion.comando.IndicadorComando;
import co.edu.uco.sibe.aplicacion.comando.manejador.GuardarIndicadorManejador;
import co.edu.uco.sibe.aplicacion.comando.manejador.ModificarIndicadorManejador;
import co.edu.uco.sibe.aplicacion.transversal.ComandoRespuesta;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.util.UUID;
import static co.edu.uco.sibe.dominio.transversal.constante.TextoConstante.*;
import static co.edu.uco.sibe.dominio.transversal.utilitarios.UtilUUID.textoAUUID;

@RestController
@AllArgsConstructor
@RequestMapping(INDICADORES)
public class IndicadorComandoControlador {
    private final GuardarIndicadorManejador guardarIndicadorManejador;
    private final ModificarIndicadorManejador modificarIndicadorManejador;

    @PreAuthorize(HAS_ADMIN_CREATE_AUTHORITY)
    @PostMapping
    public ComandoRespuesta<UUID> guardar(@RequestBody IndicadorComando indicador){
        return this.guardarIndicadorManejador.ejecutar(indicador);
    }

    @PreAuthorize(HAS_ADMIN_CREATE_AUTHORITY)
    @PutMapping(IDENTIFICADOR_PATH)
    public ComandoRespuesta<UUID> modificar(@RequestBody IndicadorComando indicador, @PathVariable String identificador){
        return this.modificarIndicadorManejador.ejecutar(indicador, textoAUUID(identificador));
    }
}