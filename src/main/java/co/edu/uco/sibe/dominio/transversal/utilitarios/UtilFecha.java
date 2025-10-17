package co.edu.uco.sibe.dominio.transversal.utilitarios;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public final class UtilFecha {
    private static final LocalDate FECHA_DEFECTO = LocalDate.of(1900, 1, 1);
    private static final LocalTime HORA_DEFECTO = LocalTime.of(0, 0, 0);
    private static final LocalDateTime FECHA_HORA_DEFECTO = LocalDateTime.of(FECHA_DEFECTO, HORA_DEFECTO);
    private static final DateTimeFormatter FORMATO_FECHA = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private static final DateTimeFormatter FORMATO_HORA = DateTimeFormatter.ofPattern("HH:mm:ss");
    private static final DateTimeFormatter FORMATO_FECHA_HORA = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    private UtilFecha() {
        super();
    }

    public static LocalDate obtenerFechaDefecto(){
        return FECHA_DEFECTO;
    }

    public static LocalTime obtenerHoraDefecto(){
        return HORA_DEFECTO;
    }

    public static LocalDateTime obtenerFechaHoraDefecto() {
        return FECHA_HORA_DEFECTO;
    }

    public static LocalDate obtenerValorFechaPorDefecto(LocalDate fecha) {
        return ValidadorObjeto.obtenerValorPorDefecto(fecha, FECHA_DEFECTO);
    }

    public static LocalTime obtenerValorHoraPorDefecto(LocalTime hora) {
        return ValidadorObjeto.obtenerValorPorDefecto(hora, HORA_DEFECTO);
    }

    public static LocalDateTime obtenerValorFechaHoraPorDefecto(LocalDateTime fechaHora) {
        return ValidadorObjeto.obtenerValorPorDefecto(fechaHora, FECHA_HORA_DEFECTO);
    }

    public static String formatearFechaATexto(LocalDate fecha) {
        return obtenerValorFechaPorDefecto(fecha).format(FORMATO_FECHA);
    }

    public static LocalDate formatearTextoAFecha(String texto) {
        return obtenerValorFechaPorDefecto(LocalDate.parse(texto));
    }

    public static String formatearHoraATexto(LocalTime hora) {
        return obtenerValorHoraPorDefecto(hora).format(FORMATO_HORA);
    }

    public static LocalTime formatearTextoAHora(String texto) {
        return obtenerValorHoraPorDefecto(LocalTime.parse(texto));
    }

    public static String formatearFechaHoraATexto(LocalDateTime fechaHora) {
        return obtenerValorFechaHoraPorDefecto(fechaHora).format(FORMATO_FECHA_HORA);
    }

    public static LocalDateTime formatearTextoAFechaHora(String texto) {
        return obtenerValorFechaHoraPorDefecto(LocalDateTime.parse(texto));
    }
}