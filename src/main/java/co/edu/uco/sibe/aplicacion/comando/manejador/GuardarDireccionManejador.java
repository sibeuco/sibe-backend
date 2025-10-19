package co.edu.uco.sibe.aplicacion.comando.manejador;

import co.edu.uco.sibe.aplicacion.comando.DireccionBaseComando;
import co.edu.uco.sibe.aplicacion.comando.fabrica.DireccionFabrica;
import co.edu.uco.sibe.aplicacion.transversal.ComandoRespuesta;
import co.edu.uco.sibe.aplicacion.transversal.manejador.ManejadorComandoRespuesta;
import co.edu.uco.sibe.dominio.puerto.comando.DireccionRepositorioComando;
import co.edu.uco.sibe.dominio.regla.TipoOperacion;
import co.edu.uco.sibe.dominio.regla.fabrica.MotoresFabrica;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.UUID;

@Component
@AllArgsConstructor
public class GuardarDireccionManejador implements ManejadorComandoRespuesta<DireccionBaseComando, ComandoRespuesta<UUID>> {
    private final DireccionRepositorioComando direccionRepositorioComando;
    private final DireccionFabrica direccionFabrica;

    @Override
    public ComandoRespuesta<UUID> ejecutar(DireccionBaseComando comando) {
        var direccion = this.direccionFabrica.construir(comando.getNombre(), comando.getAreas(), new ArrayList<>());

        MotoresFabrica.MOTOR_DIRECCION.ejecutar(direccion, TipoOperacion.CREAR);

        return new ComandoRespuesta<>(this.direccionRepositorioComando.guardar(direccion));
    }
}