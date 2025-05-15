package co.edu.uco.sibe.dominio.modelo;

import co.edu.uco.sibe.dominio.transversal.utilitarios.UtilFecha;
import co.edu.uco.sibe.dominio.transversal.utilitarios.UtilObjeto;
import co.edu.uco.sibe.dominio.transversal.utilitarios.UtilTexto;
import co.edu.uco.sibe.dominio.transversal.utilitarios.UtilUUID;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.UUID;
import lombok.Getter;

@Getter
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
    private LocalTime horaFin;
    private EstadoActividad estadoActividad;
    private Area area;
    private String rutaInsumos;

    public Actividad(){
        setIdentificador(UtilUUID.obtenerValorDefecto());
        setNombreCapacitacionOEvento(UtilTexto.getInstance().obtenerValorDefecto());
        setObjetivo(UtilTexto.getInstance().obtenerValorDefecto());
        setColaborador(Usuario.obtenerValorDefecto());
        setCreador(Usuario.obtenerValorDefecto());
        setIndicador(Indicador.obtenerValorDefecto());
        setFechaCreacion(UtilFecha.getInstance().obtenerHoraFechaDefecto());
        setFechaProgramada(UtilFecha.getInstance().obtenerFechaDefecto());
        setFechaRealizacion(UtilFecha.getInstance().obtenerFechaDefecto());
        setHoraInicio(UtilFecha.getInstance().obtenerHoraDefecto());
        setHoraFin(UtilFecha.getInstance().obtenerHoraDefecto());
        setEstadoActividad(EstadoActividad.obtenerValorDefecto());
        setArea(Area.obtenerValorDefecto());
        setRutaInsumos(UtilTexto.getInstance().obtenerValorDefecto());
    }

    public Actividad(UUID identificador, String nombreCapacitacionOEvento, String objetivo, Usuario colaborador, Usuario creador, Indicador indicador, LocalDateTime fechaCreacion, LocalDate fechaProgramada, LocalDate fechaRealizacion, LocalTime horaInicio, LocalTime horaFin, EstadoActividad estadoActividad, Area area, String rutaInsumos){
        setIdentificador(identificador);
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
        setEstadoActividad(EstadoActividad.obtenerValorDefecto());
        setArea(Area.obtenerValorDefecto());
        setRutaInsumos(UtilTexto.getInstance().obtenerValorDefecto());
    }

    public static Actividad obtenerValorDefecto(){
        return new Actividad();
    }

    public static Actividad obtenerValorDefecto(final Actividad actividad){
        return UtilObjeto.getInstance().obtenerValorDefecto(actividad, obtenerValorDefecto());
    }

    public static Actividad construir(UUID identificador, String nombreCapacitacionOEvento, String objetivo, Usuario colaborador, Indicador indicador, LocalDate fechaProgramada, Area area, String rutaInsumos){
        return new Actividad(identificador, nombreCapacitacionOEvento, objetivo, colaborador, null, indicador, UtilFecha.getInstance().obtenerHoraFechaDefecto(), fechaProgramada, UtilFecha.getInstance().obtenerFechaDefecto(), UtilFecha.getInstance().obtenerHoraDefecto(), UtilFecha.getInstance().obtenerHoraDefecto(), null, area, rutaInsumos);
    }

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
        this.colaborador = Usuario.obtenerValorDefecto(colaborador);
    }

    public void setCreador(Usuario creador) {
        this.creador = Usuario.obtenerValorDefecto(creador);
    }

    public void setIndicador(Indicador indicador) {
        this.indicador = Indicador.obtenerValorDefecto(indicador);
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

    public void setHoraFin(LocalTime horaFin) {
        this.horaFin = (horaFin != null) ? horaFin : UtilFecha.getInstance().obtenerHoraDefecto();
    }

    public void setEstadoActividad(EstadoActividad estadoActividad) {
        this.estadoActividad = EstadoActividad.obtenerValorDefecto(estadoActividad);
    }

    public void setArea(Area area) {
        this.area = Area.obtenerValorDefecto(area);
    }

    public void setRutaInsumos(String rutaInsumos) {
        this.rutaInsumos = UtilTexto.getInstance().quitarEspaciosBlancoInicioFin(rutaInsumos);
    }
}
