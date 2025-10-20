package co.edu.uco.sibe.infraestructura.configuracion.dataloader.fabrica;

import java.util.List;

public final class DatosEstadoActividadFabrica {
    private DatosEstadoActividadFabrica() {
        super();
    }

    public static List<String> obtenerEstadosActividad() {
        return List.of(
                "Pendiente",
                "En curso",
                "Finalizada"
        );
    }
}