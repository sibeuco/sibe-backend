package co.edu.uco.sibe.dominio.usecase.comando;

import co.edu.uco.sibe.dominio.modelo.Area;
import co.edu.uco.sibe.dominio.puerto.comando.AreaRepositorioComando;
import co.edu.uco.sibe.dominio.regla.TipoOperacion;
import co.edu.uco.sibe.dominio.regla.fabrica.MotoresFabrica;
import java.util.UUID;

public class GuardarAreaUseCase {
    private final AreaRepositorioComando areaRepositorioComando;

    public GuardarAreaUseCase(AreaRepositorioComando areaRepositorioComando) {
        this.areaRepositorioComando = areaRepositorioComando;
    }

    public UUID ejecutar(Area area) {
        MotoresFabrica.MOTOR_AREA.ejecutar(area, TipoOperacion.CREAR);

        return this.areaRepositorioComando.guardar(area);
    }
}
