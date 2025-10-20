package co.edu.uco.sibe.infraestructura.configuracion.dataloader.fabrica;

import co.edu.uco.sibe.aplicacion.comando.DireccionBaseComando;
import co.edu.uco.sibe.dominio.modelo.Area;
import java.util.List;

public final class DatosDireccionFabrica {
    public static final String NOMBRE_DIRECCION_BIENESTAR = "Dirección de Bienestar y Evangelización";

    private DatosDireccionFabrica() {
    }

    public static DireccionBaseComando crearDireccionBienestar(List<Area> areas) {
        return new DireccionBaseComando(
                NOMBRE_DIRECCION_BIENESTAR,
                areas
        );
    }
}