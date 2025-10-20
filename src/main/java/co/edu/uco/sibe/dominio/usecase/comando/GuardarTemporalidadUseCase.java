package co.edu.uco.sibe.dominio.usecase.comando;

import co.edu.uco.sibe.dominio.modelo.Temporalidad;
import co.edu.uco.sibe.dominio.puerto.comando.TemporalidadRepositorioComando;
import co.edu.uco.sibe.dominio.regla.TipoOperacion;
import co.edu.uco.sibe.dominio.regla.fabrica.MotoresFabrica;
import java.util.UUID;

public class GuardarTemporalidadUseCase {
    private final TemporalidadRepositorioComando temporalidadRepositorioComando;

    public GuardarTemporalidadUseCase(TemporalidadRepositorioComando temporalidadRepositorioComando) {
        this.temporalidadRepositorioComando = temporalidadRepositorioComando;
    }

    public UUID ejecutar(Temporalidad temporalidad) {
        MotoresFabrica.MOTOR_TEMPORALIDAD.ejecutar(temporalidad, TipoOperacion.CREAR);

        return this.temporalidadRepositorioComando.guardar(temporalidad);
    }
}