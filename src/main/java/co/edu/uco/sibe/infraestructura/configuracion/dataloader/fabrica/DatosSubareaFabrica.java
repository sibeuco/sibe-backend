package co.edu.uco.sibe.infraestructura.configuracion.dataloader.fabrica;

import java.util.List;

public final class DatosSubareaFabrica {
    private DatosSubareaFabrica() {
        super();
    }

    public static List<String> obtenerSubareas() {
        return List.of(
                "Deportes",
                "Cancha sintética",
                "Extensión cultural",
                "Banda Sinfónica",
                "Gimnasio",
                "Unidad de Salud",
                "Acompañamiento psicosocial",
                "Trabajo social"
        );
    }
}