package co.edu.uco.sibe.infraestructura.configuracion.dataloader.fabrica;

import co.edu.uco.sibe.aplicacion.comando.AreaBaseComando;
import co.edu.uco.sibe.dominio.modelo.Subarea;

import java.util.ArrayList;
import java.util.List;

public final class DatosAreaFabrica {
    public static final String NOMBRE_AREA_BIENESTAR = "Bienestar";
    public static final String NOMBRE_AREA_EVANGELIZACION = "Evangelización";
    public static final String NOMBRE_AREA_HOGAR_JUVENIL = "Hogar Juvenil Santa María";
    public static final String NOMBRE_AREA_SERVICIO_USUARIO = "Servicio y atención al usuario";

    private DatosAreaFabrica() {
        super();
    }

    public static AreaBaseComando crearBienestar(List<Subarea> subareas) {
        return new AreaBaseComando(
                NOMBRE_AREA_BIENESTAR,
                subareas
        );
    }

    public static AreaBaseComando crearEvangelizacion() {
        return new AreaBaseComando(
                NOMBRE_AREA_EVANGELIZACION,
                new ArrayList<>()
        );
    }

    public static AreaBaseComando crearHogarJuvenil() {
        return new AreaBaseComando(
                NOMBRE_AREA_HOGAR_JUVENIL,
                new ArrayList<>()
        );
    }

    public static AreaBaseComando crearServicioAtencionUsuario() {
        return new AreaBaseComando(
                NOMBRE_AREA_SERVICIO_USUARIO,
                new ArrayList<>()
        );
    }
}