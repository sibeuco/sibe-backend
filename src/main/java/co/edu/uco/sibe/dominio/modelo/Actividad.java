package co.edu.uco.sibe.dominio.modelo;

import co.edu.uco.sibe.dominio.transversal.utilitarios.UtilFecha;
import co.edu.uco.sibe.dominio.transversal.utilitarios.UtilTexto;
import co.edu.uco.sibe.dominio.transversal.utilitarios.UtilUUID;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.UUID;

@Getter
public class Actividad {
    private UUID identificador;
    private String nombreCapacitacionOEvento;
    private String Objetivo;
    private Usuario colaborador;
    private Usuario creador;
    private Indicador indicador;
    private LocalDateTime fechaCreacion;
    private LocalDate fechaProgramada;
    private LocalDate fechaRealizacion;
    private LocalTime horaInicio;
    private LocalTime horaFin;
    private EstadoActividad estadoActividad;
    private Area area;
    private String rutaInsumos;

    public Actividad(String nombreCapacitacionOEvento, String objetivo, Usuario colaborador, Usuario creador, Indicador indicador, LocalDateTime fechaCreacion, LocalDate fechaProgramada, LocalDate fechaRealizacion, LocalTime horaInicio, LocalTime horaFin, EstadoActividad estadoActividad, Area area, String rutaInsumos){
        setIdentificador();
        setNombreCapacitacionOEvento(nombreCapacitacionOEvento);
        setObjetivo(objetivo);
        setColaborador(colaborador);
        setCreador(creador);
        setIndicador(indicador);
        setFechaCreacion(fechaCreacion);
        setFechaProgramada(fechaProgramada);
        setFechaRealizacion(fechaRealizacion);
        setHoraInicio(horaInicio);
        setHoraFin(horaFin);
        setEstadoActividad(estadoActividad);
        setArea(area);
        setRutaInsumos(rutaInsumos);
    }

    public static Actividad construir(String nombreCapacitacionOEvento, String objetivo, Usuario colaborador, Indicador indicador, LocalDate fechaProgramada, Area area, String rutaInsumos){
        return new Actividad(nombreCapacitacionOEvento, objetivo, colaborador, null, indicador, UtilFecha.getInstance().obtenerHoraFechaDefecto(), fechaProgramada, UtilFecha.getInstance().obtenerFechaDefecto(), UtilFecha.getInstance().obtenerHoraDefecto(), UtilFecha.getInstance().obtenerHoraDefecto(), null, area, rutaInsumos);
    }

    public void setIdentificador() {
        this.identificador = UtilUUID.generarNuevoUUID();
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
        this.fechaCreacion = fechaCreacion;
    }

    public void setFechaProgramada(LocalDate fechaProgramada) {
        this.fechaProgramada = fechaProgramada;
    }

    public void setFechaRealizacion(LocalDate fechaRealizacion) {
        this.fechaRealizacion = fechaRealizacion;
    }

    public void setHoraInicio(LocalTime horaInicio) {
        this.horaInicio = horaInicio;
    }

    public void setHoraFin(LocalTime horaFin) {
        this.horaFin = horaFin;
    }

    public void setEstadoActividad(EstadoActividad estadoActividad) {
        this.estadoActividad = estadoActividad;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    public void setRutaInsumos(String rutaInsumos) {
        this.rutaInsumos = UtilTexto.getInstance().quitarEspaciosBlancoInicioFin(rutaInsumos);
    }
}
