package co.edu.uco.sibe.dominio.usecase.comando;

import co.edu.uco.sibe.dominio.modelo.TipoIdentificacion;
import co.edu.uco.sibe.dominio.puerto.comando.TipoIdentificacionRepositorioComando;
import co.edu.uco.sibe.dominio.regla.TipoOperacion;
import co.edu.uco.sibe.dominio.regla.fabrica.MotoresFabrica;

import java.util.UUID;

public class GuardarTipoIdentificacionUseCase {
    private final TipoIdentificacionRepositorioComando tipoIdentificacionRepositorioComando;

    public GuardarTipoIdentificacionUseCase(TipoIdentificacionRepositorioComando tipoIdentificacionRepositorioComando) {
        this.tipoIdentificacionRepositorioComando = tipoIdentificacionRepositorioComando;
    }

    public UUID ejecutar(TipoIdentificacion tipoIdentificacion) {
        MotoresFabrica.MOTOR_TIPO_IDENTIFICACION.ejecutar(tipoIdentificacion, TipoOperacion.CREAR);

        return this.tipoIdentificacionRepositorioComando.guardar(tipoIdentificacion);
    }
}