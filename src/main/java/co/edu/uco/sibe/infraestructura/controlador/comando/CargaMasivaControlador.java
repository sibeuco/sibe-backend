package co.edu.uco.sibe.infraestructura.controlador.comando;

import co.edu.uco.sibe.aplicacion.comando.ArchivoEmpleadoComando;
import co.edu.uco.sibe.aplicacion.comando.ArchivoEstudianteComando;
import co.edu.uco.sibe.aplicacion.comando.manejador.CargarMasivamenteEmpleadosManejador;
import co.edu.uco.sibe.aplicacion.comando.manejador.CargarMasivamenteEstudiantesManejador;
import co.edu.uco.sibe.aplicacion.transversal.ComandoRespuesta;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.UUID;
import static co.edu.uco.sibe.dominio.transversal.constante.TextoConstante.*;

@RestController
@AllArgsConstructor
@RequestMapping(CARGA_MASIVA)
public class CargaMasivaControlador {
    private final CargarMasivamenteEmpleadosManejador cargarMasivamenteEmpleadosManejador;
    private final CargarMasivamenteEstudiantesManejador cargarMasivamenteEstudiantesManejador;

    @PreAuthorize(HAS_USER_OR_ADMIN_UPDATE_AUTHORITY)
    @PostMapping(EMPLEADOS)
    public ComandoRespuesta<List<UUID>> cargarMasivamenteEmpleados(@RequestBody ArchivoEmpleadoComando archivoEmpleadoComando){
        return this.cargarMasivamenteEmpleadosManejador.ejecutar(archivoEmpleadoComando);
    }

    @PreAuthorize(HAS_USER_OR_ADMIN_UPDATE_AUTHORITY)
    @PostMapping(ESTUDIANTES)
    public ComandoRespuesta<List<UUID>> cargarMasivamenteEstudiantes(@RequestBody ArchivoEstudianteComando archivoEstudianteComando){
        return this.cargarMasivamenteEstudiantesManejador.ejecutar(archivoEstudianteComando);
    }
}