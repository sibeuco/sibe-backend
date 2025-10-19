package co.edu.uco.sibe.aplicacion.comando.manejador;

import co.edu.uco.sibe.aplicacion.comando.AreaBaseComando;
import co.edu.uco.sibe.aplicacion.comando.fabrica.AreaFabrica;
import co.edu.uco.sibe.aplicacion.transversal.ComandoRespuesta;
import co.edu.uco.sibe.aplicacion.transversal.manejador.ManejadorComandoRespuesta;
import co.edu.uco.sibe.dominio.puerto.comando.AreaRepositorioComando;
import co.edu.uco.sibe.dominio.regla.TipoOperacion;
import co.edu.uco.sibe.dominio.regla.fabrica.MotoresFabrica;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.UUID;

@Component
@AllArgsConstructor
public class GuardarAreaManejador implements ManejadorComandoRespuesta<AreaBaseComando, ComandoRespuesta<UUID>> {
    private final AreaRepositorioComando areaRepositorioComando;
    private final AreaFabrica areaFabrica;

    @Override
    public ComandoRespuesta<UUID> ejecutar(AreaBaseComando comando) {
        var area = this.areaFabrica.construir(comando.getNombre(), comando.getSubareas(), new ArrayList<>());

        MotoresFabrica.MOTOR_AREA.ejecutar(area, TipoOperacion.CREAR);

        return new ComandoRespuesta<>(this.areaRepositorioComando.guardar(area));
    }
}