package co.edu.uco.sibe.dominio.transversal.utilitarios;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class UtilFecha {
    private static final UtilFecha instancia = new UtilFecha();
    private static final LocalDate FECHA_DEFECTO = LocalDate.of(1900, 1, 1);
    private static final LocalTime HORA_DEFECTO = LocalTime.of(0, 0, 0);
    private static final LocalDateTime FECHA_HORA_DEFECTO = LocalDateTime.of(FECHA_DEFECTO, HORA_DEFECTO);
    private static final DateTimeFormatter FORMATO_FECHA = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private static final DateTimeFormatter FORMATO_HORA = DateTimeFormatter.ofPattern("HH:mm:ss");
    private static final DateTimeFormatter FORMATO_FECHA_HORA = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    private UtilFecha() { }

    public static UtilFecha getInstance(){
        return instancia;
    }

    public LocalDate obtenerFechaDefecto(){
        return FECHA_DEFECTO;
    }

    public LocalTime obtenerHoraDefecto(){
        return HORA_DEFECTO;
    }

    public LocalDate obtenerValorFechaPorDefecto(LocalDate fecha) {
        return (fecha != null) ? fecha : FECHA_DEFECTO;
    }

    public LocalTime obtenerValorHoraPorDefecto(LocalTime hora) {
        return (hora != null) ? hora : HORA_DEFECTO;
    }

    public String formatearFecha(LocalDate fecha) {
        return (fecha != null ? fecha : FECHA_DEFECTO).format(FORMATO_FECHA);
    }

    public String formatearHora(LocalTime hora) {
        return (hora != null ? hora : HORA_DEFECTO).format(FORMATO_HORA);
    }

    public String formatearFechaHora(LocalDateTime fechaHora) {
        return (fechaHora != null ? fechaHora : FECHA_HORA_DEFECTO).format(FORMATO_FECHA_HORA);
    }
}