package co.edu.uco.sibe.dominio.usecase.comando;

import co.edu.uco.sibe.dominio.modelo.Subarea;
import co.edu.uco.sibe.dominio.puerto.comando.SubareaRepositorioComando;
import co.edu.uco.sibe.dominio.regla.TipoOperacion;
import co.edu.uco.sibe.dominio.regla.fabrica.MotoresFabrica;

import java.util.UUID;

public class GuardarSubareaUseCase {
    private final SubareaRepositorioComando subareaRepositorioComando;

    public GuardarSubareaUseCase(SubareaRepositorioComando subareaRepositorioComando) {
        this.subareaRepositorioComando = subareaRepositorioComando;
    }

    public UUID ejecutar(Subarea subarea) {
        MotoresFabrica.MOTOR_SUBAREA.ejecutar(subarea, TipoOperacion.CREAR);

        return this.subareaRepositorioComando.guardar(subarea);
    }
}
