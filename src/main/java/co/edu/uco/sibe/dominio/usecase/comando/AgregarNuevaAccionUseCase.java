package co.edu.uco.sibe.dominio.usecase.comando;

import co.edu.uco.sibe.dominio.modelo.Accion;
import co.edu.uco.sibe.dominio.puerto.comando.AccionRepositorioComando;
import co.edu.uco.sibe.dominio.regla.TipoOperacion;
import co.edu.uco.sibe.dominio.regla.fabrica.MotoresFabrica;

import java.util.UUID;

public class AgregarNuevaAccionUseCase {
    private final AccionRepositorioComando accionRepositorioComando;

    public AgregarNuevaAccionUseCase(AccionRepositorioComando accionRepositorioComando) {
        this.accionRepositorioComando = accionRepositorioComando;
    }

    public UUID ejecutar(Accion accion){
        MotoresFabrica.MOTOR_ACCION.ejecutar(accion, TipoOperacion.CREAR);

        return this.accionRepositorioComando.guardar(accion);
    }
}
