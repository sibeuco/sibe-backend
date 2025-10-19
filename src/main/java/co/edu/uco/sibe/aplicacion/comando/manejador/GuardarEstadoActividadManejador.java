package co.edu.uco.sibe.aplicacion.comando.manejador;

import co.edu.uco.sibe.aplicacion.comando.fabrica.EstadoActividadFabrica;
import co.edu.uco.sibe.aplicacion.transversal.ComandoRespuesta;
import co.edu.uco.sibe.aplicacion.transversal.manejador.ManejadorComandoRespuesta;
import co.edu.uco.sibe.dominio.puerto.comando.EstadoActividadRepositorioComando;
import co.edu.uco.sibe.dominio.regla.TipoOperacion;
import co.edu.uco.sibe.dominio.regla.fabrica.MotoresFabrica;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import java.util.UUID;

@Component
@AllArgsConstructor
public class GuardarEstadoActividadManejador implements ManejadorComandoRespuesta<String, ComandoRespuesta<UUID>> {
    private final EstadoActividadRepositorioComando estadoActividadRepositorioComando;
    private final EstadoActividadFabrica estadoActividadFabrica;

    @Override
    public ComandoRespuesta<UUID> ejecutar(String comando) {
        var estadoActividad = this.estadoActividadFabrica.construir(comando);

        MotoresFabrica.MOTOR_ESTADO_ACTIVIDAD.ejecutar(estadoActividad, TipoOperacion.CREAR);

        return new ComandoRespuesta<>(this.estadoActividadRepositorioComando.guardar(estadoActividad));
    }
}