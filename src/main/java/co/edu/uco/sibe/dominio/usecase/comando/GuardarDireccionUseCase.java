package co.edu.uco.sibe.dominio.usecase.comando;

import co.edu.uco.sibe.dominio.modelo.Direccion;
import co.edu.uco.sibe.dominio.puerto.comando.DireccionRepositorioComando;
import co.edu.uco.sibe.dominio.regla.TipoOperacion;
import co.edu.uco.sibe.dominio.regla.fabrica.MotoresFabrica;
import java.util.UUID;

public class GuardarDireccionUseCase {
    private final DireccionRepositorioComando direccionRepositorioComando;

    public GuardarDireccionUseCase(DireccionRepositorioComando direccionRepositorioComando) {
        this.direccionRepositorioComando = direccionRepositorioComando;
    }

    public UUID ejecutar(Direccion direccion) {
        MotoresFabrica.MOTOR_DIRECCION.ejecutar(direccion, TipoOperacion.CREAR);

        return this.direccionRepositorioComando.guardar(direccion);
    }
}
