package co.edu.uco.sibe.infraestructura.controlador.comando;

import co.edu.uco.sibe.aplicacion.comando.ProyectoComando;
import co.edu.uco.sibe.aplicacion.comando.manejador.AgregarNuevoProyectoManejador;
import co.edu.uco.sibe.aplicacion.transversal.ComandoRespuesta;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

import static co.edu.uco.sibe.dominio.transversal.constante.TextoConstante.*;

@RestController
@AllArgsConstructor
@RequestMapping(PROYECTOS)
public class ProyectoComandoControlador {
    private final AgregarNuevoProyectoManejador agregarNuevoProyectoManejador;

    @PreAuthorize(HAS_ADMIN_CREATE_AUTHORITY)
    @PostMapping
    public ComandoRespuesta<UUID> agregarNuevoProyecto(@RequestBody ProyectoComando proyecto){
        return this.agregarNuevoProyectoManejador.ejecutar(proyecto);
    }
}
