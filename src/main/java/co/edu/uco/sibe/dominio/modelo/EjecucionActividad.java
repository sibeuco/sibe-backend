package co.edu.uco.sibe.dominio.modelo;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

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
        setIdentificador(identificador);
        setFechaProgramada(fechaProgramada);
        setFechaRealizacion(fechaRealizacion);
        setHoraInicio(horaInicio);
        setHoraFin(horaFin);
        setEstadoActividad(estadoActividad);
        setActividad(actividad);
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
                fechaProgramada,
                fechaRealizacion,
                horaInicio,
                horaFin,
                estadoActividad,
                actividad
        );
    }

    public UUID getIdentificador() {
        return identificador;
    }

    public LocalDate getFechaProgramada() {
        return fechaProgramada;
    }

    public LocalDate getFechaRealizacion() {
        return fechaRealizacion;
    }

    public LocalTime getHoraInicio() {
        return horaInicio;
    }

    public LocalTime getHoraFin() {
        return horaFin;
    }

    public EstadoActividad getEstadoActividad() {
        return estadoActividad;
    }

    public Actividad getActividad() {
        return actividad;
    }

    private void setIdentificador(UUID identificador) {
        this.identificador = identificador;
    }

    private void setFechaProgramada(LocalDate fechaProgramada) {
        this.fechaProgramada = fechaProgramada;
    }

    private void setFechaRealizacion(LocalDate fechaRealizacion) {
        this.fechaRealizacion = fechaRealizacion;
    }

    private void setHoraInicio(LocalTime horaInicio) {
        this.horaInicio = horaInicio;
    }

    private void setHoraFin(LocalTime horaFin) {
        this.horaFin = horaFin;
    }

    private void setEstadoActividad(EstadoActividad estadoActividad) {
        this.estadoActividad = estadoActividad;
    }

    private void setActividad(Actividad actividad) {
        this.actividad = actividad;
    }
}