package co.edu.uco.sibe.dominio.transversal.utilitarios;

import java.time.LocalDate;
import java.time.LocalTime;

public final class UtilFecha {
    private static final LocalDate FECHA_DEFECTO = LocalDate.of(1900, 1, 1);
    private static final LocalTime HORA_DEFECTO = LocalTime.of(0, 0, 0);

    private UtilFecha() {
        super();
    }

    public static LocalDate obtenerFechaActual(){
        return LocalDate.now();
    }

    public static LocalDate obtenerFechaDefecto(){
        return FECHA_DEFECTO;
    }

    public static LocalTime obtenerHoraDefecto(){
        return HORA_DEFECTO;
    }

    public static LocalDate obtenerValorFechaPorDefecto(LocalDate fecha) {
        return ValidadorObjeto.obtenerValorPorDefecto(fecha, FECHA_DEFECTO);
    }

    public static LocalTime obtenerValorHoraPorDefecto(LocalTime hora) {
        return ValidadorObjeto.obtenerValorPorDefecto(hora, HORA_DEFECTO);
    }

    public static LocalDate formatearTextoAFecha(String texto) {
        return obtenerValorFechaPorDefecto(LocalDate.parse(texto));
    }
}