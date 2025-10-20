package co.edu.uco.sibe.dominio.usecase.comando;

import co.edu.uco.sibe.dominio.modelo.EstadoActividad;
import co.edu.uco.sibe.dominio.puerto.comando.EstadoActividadRepositorioComando;
import co.edu.uco.sibe.dominio.regla.TipoOperacion;
import co.edu.uco.sibe.dominio.regla.fabrica.MotoresFabrica;

import java.util.UUID;

public class GuardarEstadoActividadUseCase {
    private final EstadoActividadRepositorioComando estadoActividadRepositorioComando;

    public GuardarEstadoActividadUseCase(EstadoActividadRepositorioComando estadoActividadRepositorioComando) {
        this.estadoActividadRepositorioComando = estadoActividadRepositorioComando;
    }

    public UUID ejecutar(EstadoActividad estadoActividad) {
        MotoresFabrica.MOTOR_ESTADO_ACTIVIDAD.ejecutar(estadoActividad, TipoOperacion.CREAR);

        return this.estadoActividadRepositorioComando.guardar(estadoActividad);
    }
}
