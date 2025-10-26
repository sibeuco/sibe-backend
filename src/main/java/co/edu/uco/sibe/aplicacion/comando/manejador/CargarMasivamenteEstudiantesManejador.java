package co.edu.uco.sibe.aplicacion.comando.manejador;

import co.edu.uco.sibe.aplicacion.comando.ArchivoEstudianteComando;
import co.edu.uco.sibe.aplicacion.puerto.servicio.ProcesadorArchivoEstudianteServicio;
import co.edu.uco.sibe.aplicacion.transversal.ComandoRespuesta;
import co.edu.uco.sibe.aplicacion.transversal.manejador.ManejadorComandoRespuesta;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import java.util.UUID;

@Component
@AllArgsConstructor
public class CargarMasivamenteEstudiantesManejador implements ManejadorComandoRespuesta<ArchivoEstudianteComando, ComandoRespuesta<UUID>> {
    private final ProcesadorArchivoEstudianteServicio procesadorArchivoEstudianteServicio;

    @Override
    public ComandoRespuesta<UUID> ejecutar(ArchivoEstudianteComando comando) {
        var estudiantesComando = procesadorArchivoEstudianteServicio.procesar(comando.getArchivo());

        return new ComandoRespuesta<>(

        );
    }
}