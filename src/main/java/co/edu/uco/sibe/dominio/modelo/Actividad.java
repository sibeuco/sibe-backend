package co.edu.uco.sibe.dominio.modelo;

import co.edu.uco.sibe.dominio.transversal.utilitarios.UtilFecha;
import co.edu.uco.sibe.dominio.transversal.utilitarios.UtilTexto;
import co.edu.uco.sibe.dominio.transversal.utilitarios.UtilUUID;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.UUID;

public class Actividad {
    private UUID identificador;
    private  String nombreCapacitacionOEvento;
    private String Objetivo;
    private Usuario colaborador;
    private Usuario creador;
    private Indicador indicador;
    private LocalDateTime fechaCreacion;
    private LocalDate fechaProgramada;
    private LocalDate fechaRealizacion;
    private LocalTime horaInicio;
    private LocalTime horafin;
    private EstadoActividad estadoActividad;
    private Area area;
    private String rutaInsumos;

    public void setIdentificador(UUID identificador) {
        this.identificador = UtilUUID.obtenerValorDefecto(identificador);
    }

    public void setNombreCapacitacionOEvento(String nombreCapacitacionOEvento) {
        this.nombreCapacitacionOEvento = UtilTexto.getInstance().quitarEspaciosBlancoInicioFin(nombreCapacitacionOEvento);
    }

    public void setObjetivo(String objetivo) {
        Objetivo = UtilTexto.getInstance().quitarEspaciosBlancoInicioFin(objetivo);
    }

    public void setColaborador(Usuario colaborador) {
        this.colaborador = colaborador;
    }

    public void setCreador(Usuario creador) {
        this.creador = creador;
    }

    public void setIndicador(Indicador indicador) {
        this.indicador = indicador;
    }

    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = (fechaCreacion != null) ? fechaCreacion : UtilFecha.getInstance().obtenerHoraFechaDefecto();
    }

    public void setFechaProgramada(LocalDate fechaProgramada) {
        this.fechaProgramada = (fechaProgramada != null) ? fechaProgramada : UtilFecha.getInstance().obtenerFechaDefecto();
    }

    public void setFechaRealizacion(LocalDate fechaRealizacion) {
        this.fechaRealizacion = (fechaRealizacion != null) ? fechaRealizacion : UtilFecha.getInstance().obtenerFechaDefecto();
    }

    public void setHoraInicio(LocalTime horaInicio) {
        this.horaInicio = (horaInicio != null) ? horaInicio : UtilFecha.getInstance().obtenerHoraDefecto();
    }

    public void setHorafin(LocalTime horafin) {
        this.horafin = (horafin != null) ? horafin : UtilFecha.getInstance().obtenerHoraDefecto();
    }

    public void setEstadoActividad(EstadoActividad estadoActividad) {
        this.estadoActividad = estadoActividad;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    public void setRutaInsumos(String rutaInsumos) {
        this.rutaInsumos = rutaInsumos;
    }
}
