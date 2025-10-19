package co.edu.uco.sibe.aplicacion.comando.manejador;

import co.edu.uco.sibe.aplicacion.comando.TipoUsuarioComando;
import co.edu.uco.sibe.aplicacion.comando.fabrica.TipoUsuarioFabrica;
import co.edu.uco.sibe.aplicacion.transversal.ComandoRespuesta;
import co.edu.uco.sibe.aplicacion.transversal.manejador.ManejadorComandoRespuesta;
import co.edu.uco.sibe.dominio.puerto.comando.TipoUsuarioRepositorioComando;
import co.edu.uco.sibe.dominio.regla.TipoOperacion;
import co.edu.uco.sibe.dominio.regla.fabrica.MotoresFabrica;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import java.util.UUID;

@Component
@AllArgsConstructor
public class GuardarTipoUsuarioManejador implements ManejadorComandoRespuesta<TipoUsuarioComando, ComandoRespuesta<UUID>> {
    private final TipoUsuarioRepositorioComando tipoUsuarioRepositorioComando;
    private final TipoUsuarioFabrica tipoUsuarioFabrica;

    @Override
    public ComandoRespuesta<UUID> ejecutar(TipoUsuarioComando comando) {
        var tipoUsuario = this.tipoUsuarioFabrica.construir(comando);

        MotoresFabrica.MOTOR_TIPO_USUARIO.ejecutar(tipoUsuario, TipoOperacion.CREAR);

        return new ComandoRespuesta<>(this.tipoUsuarioRepositorioComando.guardar(tipoUsuario));
    }
}