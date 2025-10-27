package co.edu.uco.sibe.aplicacion.comando.manejador;

import co.edu.uco.sibe.aplicacion.comando.ArchivoEmpleadoComando;
import co.edu.uco.sibe.aplicacion.comando.fabrica.EmpleadoFabrica;
import co.edu.uco.sibe.aplicacion.puerto.servicio.ProcesadorArchivoEmpleadoServicio;
import co.edu.uco.sibe.aplicacion.transversal.ComandoRespuesta;
import co.edu.uco.sibe.aplicacion.transversal.manejador.ManejadorComandoRespuesta;
import co.edu.uco.sibe.dominio.usecase.comando.CargarMasivamenteEmpleadosUseCase;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
@AllArgsConstructor
public class CargarMasivamenteEmpleadosManejador implements ManejadorComandoRespuesta<ArchivoEmpleadoComando, ComandoRespuesta<List<UUID>>> {
    private final ProcesadorArchivoEmpleadoServicio procesadorArchivoEmpleadoServicio;
    private final EmpleadoFabrica empleadoFabrica;
    private final CargarMasivamenteEmpleadosUseCase cargarMasivamenteEmpleadosUseCase;

    @Override
    public ComandoRespuesta<List<UUID>> ejecutar(ArchivoEmpleadoComando comando) {
        var empleadosComando = procesadorArchivoEmpleadoServicio.procesar(comando.getArchivo());
        var empleados = empleadoFabrica.construirTodos(empleadosComando);

        return new ComandoRespuesta<>(
                this.cargarMasivamenteEmpleadosUseCase.ejecutar(empleados)
        );
    }
}