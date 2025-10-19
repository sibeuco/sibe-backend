package co.edu.uco.sibe.aplicacion.comando.manejador;

import co.edu.uco.sibe.aplicacion.comando.fabrica.TemporalidadFabrica;
import co.edu.uco.sibe.aplicacion.transversal.ComandoRespuesta;
import co.edu.uco.sibe.aplicacion.transversal.manejador.ManejadorComandoRespuesta;
import co.edu.uco.sibe.dominio.puerto.comando.TemporalidadRepositorioComando;
import co.edu.uco.sibe.dominio.regla.TipoOperacion;
import co.edu.uco.sibe.dominio.regla.fabrica.MotoresFabrica;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@AllArgsConstructor
public class GuardarTemporalidadManejador implements ManejadorComandoRespuesta<String, ComandoRespuesta<UUID>> {
    private final TemporalidadRepositorioComando temporalidadRepositorioComando;
    private final TemporalidadFabrica temporalidadFabrica;

    @Override
    public ComandoRespuesta<UUID> ejecutar(String comando) {
        var temporalidad = this.temporalidadFabrica.construir(comando);

        MotoresFabrica.MOTOR_TEMPORALIDAD.ejecutar(temporalidad, TipoOperacion.CREAR);

        return new ComandoRespuesta<>(this.temporalidadRepositorioComando.guardar(temporalidad));
    }
}