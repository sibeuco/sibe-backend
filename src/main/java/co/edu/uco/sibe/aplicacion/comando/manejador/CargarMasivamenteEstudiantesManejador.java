package co.edu.uco.sibe.aplicacion.comando.manejador;

import co.edu.uco.sibe.aplicacion.comando.ArchivoEstudianteComando;
import co.edu.uco.sibe.aplicacion.comando.fabrica.EstudianteFabrica;
import co.edu.uco.sibe.aplicacion.puerto.servicio.ProcesadorArchivoEstudianteServicio;
import co.edu.uco.sibe.aplicacion.transversal.ComandoRespuesta;
import co.edu.uco.sibe.aplicacion.transversal.manejador.ManejadorComandoRespuesta;
import co.edu.uco.sibe.dominio.usecase.comando.CargarMasivamenteEstudiantesUseCase;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
@AllArgsConstructor
public class CargarMasivamenteEstudiantesManejador implements ManejadorComandoRespuesta<ArchivoEstudianteComando, ComandoRespuesta<List<UUID>>> {
    private final ProcesadorArchivoEstudianteServicio procesadorArchivoEstudianteServicio;
    private final EstudianteFabrica estudianteFabrica;
    private final CargarMasivamenteEstudiantesUseCase cargarMasivamenteEstudiantesUseCase;

    @Override
    public ComandoRespuesta<List<UUID>> ejecutar(ArchivoEstudianteComando comando) {
        var estudiantesComando = procesadorArchivoEstudianteServicio.procesar(comando.getArchivo());
        var estudiantes = estudianteFabrica.construirTodos(estudiantesComando);

        return new ComandoRespuesta<>(
                this.cargarMasivamenteEstudiantesUseCase.ejecutar(estudiantes)
        );
    }
}