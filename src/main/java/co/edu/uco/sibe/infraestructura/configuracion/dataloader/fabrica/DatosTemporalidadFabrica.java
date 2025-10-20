package co.edu.uco.sibe.infraestructura.configuracion.dataloader.fabrica;

import java.util.List;

public final class DatosTemporalidadFabrica {
    private DatosTemporalidadFabrica() {
        super();
    }

    public static List<String> obtenerTemporalidades() {
        return List.of(
                "Diaria",
                "Semanal",
                "Mensual",
                "Trimestral",
                "Anual"
        );
    }
}