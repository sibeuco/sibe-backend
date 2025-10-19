package co.edu.uco.sibe.aplicacion.comando.manejador;

import co.edu.uco.sibe.aplicacion.comando.TipoIdentificacionComando;
import co.edu.uco.sibe.aplicacion.comando.fabrica.TipoIdentificacionFabrica;
import co.edu.uco.sibe.aplicacion.transversal.ComandoRespuesta;
import co.edu.uco.sibe.aplicacion.transversal.manejador.ManejadorComandoRespuesta;
import co.edu.uco.sibe.dominio.puerto.comando.TipoIdentificacionRepositorioComando;
import co.edu.uco.sibe.dominio.regla.TipoOperacion;
import co.edu.uco.sibe.dominio.regla.fabrica.MotoresFabrica;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import java.util.UUID;

@Component
@AllArgsConstructor
public class GuardarTipoIdentificacionManejador implements ManejadorComandoRespuesta<TipoIdentificacionComando, ComandoRespuesta<UUID>> {
    private final TipoIdentificacionRepositorioComando tipoIdentificacionRepositorioComando;
    private final TipoIdentificacionFabrica tipoIdentificacionFabrica;

    @Override
    public ComandoRespuesta<UUID> ejecutar(TipoIdentificacionComando comando) {
        var tipoIdentificacion = this.tipoIdentificacionFabrica.construir(comando);

        MotoresFabrica.MOTOR_TIPO_IDENTIFICACION.ejecutar(tipoIdentificacion, TipoOperacion.CREAR);

        return new ComandoRespuesta<>(this.tipoIdentificacionRepositorioComando.guardar(tipoIdentificacion));
    }
}