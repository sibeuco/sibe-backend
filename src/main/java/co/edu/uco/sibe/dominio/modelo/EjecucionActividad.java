package co.edu.uco.sibe.dominio.modelo;

import co.edu.uco.sibe.dominio.transversal.utilitarios.UtilFecha;
import co.edu.uco.sibe.dominio.transversal.utilitarios.UtilUUID;
import co.edu.uco.sibe.dominio.transversal.utilitarios.ValidadorObjeto;
import lombok.Getter;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

@Getter
public class EjecucionActividad {
    private UUID identificador;
    private LocalDate fechaProgramada;
    private LocalDate fechaRealizacion;
    private LocalTime horaInicio;
    private LocalTime horaFin;
    private EstadoActividad estadoActividad;
    private Actividad actividad;

    private EjecucionActividad(
            UUID identificador,
            LocalDate fechaProgramada,
            LocalDate fechaRealizacion,
            LocalTime horaInicio,
            LocalTime horaFin,
            EstadoActividad estadoActividad,
            Actividad actividad
    ) {
        this.fechaProgramada = fechaProgramada;
        this.identificador = identificador;
        this.fechaRealizacion = fechaRealizacion;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.estadoActividad = estadoActividad;
        this.actividad = actividad;
    }

    public static EjecucionActividad construir(
            UUID identificador,
            LocalDate fechaProgramada,
            LocalDate fechaRealizacion,
            LocalTime horaInicio,
            LocalTime horaFin,
            EstadoActividad estadoActividad,
            Actividad actividad
    ) {
        return new EjecucionActividad(
                identificador,
                UtilFecha.obtenerValorFechaPorDefecto(fechaProgramada),
                UtilFecha.obtenerValorFechaPorDefecto(fechaRealizacion),
                UtilFecha.obtenerValorHoraPorDefecto(horaInicio),
                UtilFecha.obtenerValorHoraPorDefecto(horaFin),
                ValidadorObjeto.obtenerValorPorDefecto(estadoActividad, EstadoActividad.construir()),
                ValidadorObjeto.obtenerValorPorDefecto(actividad, Actividad.construir())
        );
    }

    public static EjecucionActividad construir() {
        return new EjecucionActividad(
                UtilUUID.obtenerValorDefecto(),
                UtilFecha.obtenerFechaDefecto(),
                UtilFecha.obtenerFechaDefecto(),
                UtilFecha.obtenerHoraDefecto(),
                UtilFecha.obtenerHoraDefecto(),
                EstadoActividad.construir(),
                Actividad.construir()
        );
    }
}