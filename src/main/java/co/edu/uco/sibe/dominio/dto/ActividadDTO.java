package co.edu.uco.sibe.dominio.dto;

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
public class ActividadDTO {
    private UUID identificador;
    private String nombreCapacitacionOEvento;
    private String Objetivo;
    private UsuarioDTO colaborador;
    private UsuarioDTO creador;
    private IndicadorDTO indicador;
    private LocalDateTime fechaCreacion;
    private LocalDate fechaProgramada;
    private LocalDate fechaRealizacion;
    private LocalTime horaInicio;
    private LocalTime horaFin;
    private EstadoActividadDTO estadoActividad;
    private AreaDTO area;
    private String rutaInsumos;

    public ActividadDTO(){
        setIdentificador(UtilUUID.obtenerValorDefecto());
        setNombreCapacitacionOEvento(UtilTexto.getInstance().obtenerValorDefecto());
        setObjetivo(UtilTexto.getInstance().obtenerValorDefecto());
        setColaborador(UsuarioDTO.obtenerValorDefecto());
        setCreador(UsuarioDTO.obtenerValorDefecto());
        setIndicador(IndicadorDTO.obtenerValorDefecto());
        setFechaCreacion(UtilFecha.getInstance().obtenerHoraFechaDefecto());
        setFechaProgramada(UtilFecha.getInstance().obtenerFechaDefecto());
        setFechaRealizacion(UtilFecha.getInstance().obtenerFechaDefecto());
        setHoraInicio(UtilFecha.getInstance().obtenerHoraDefecto());
        setHoraFin(UtilFecha.getInstance().obtenerHoraDefecto());
        setEstadoActividad(EstadoActividadDTO.obtenerValorDefecto());
        setArea(AreaDTO.obtenerValorDefecto());
        setRutaInsumos(UtilTexto.getInstance().obtenerValorDefecto());
    }

    public ActividadDTO(UUID identificador, String nombreCapacitacionOEvento, String objetivo, UsuarioDTO colaborador, UsuarioDTO creador, IndicadorDTO indicador, LocalDateTime fechaCreacion, LocalDate fechaProgramada, LocalDate fechaRealizacion, LocalTime horaInicio, LocalTime horaFin, EstadoActividadDTO estadoActividad, AreaDTO area, String rutaInsumos){
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
        setEstadoActividad(estadoActividad);
        setArea(area);
        setRutaInsumos(rutaInsumos);
    }

    public static ActividadDTO obtenerValorDefecto(){
        return new ActividadDTO();
    }

    public static ActividadDTO obtenerValorDefecto(final ActividadDTO actividad){
        return UtilObjeto.getInstance().obtenerValorDefecto(actividad, obtenerValorDefecto());
    }

    public static ActividadDTO construir(UUID identificador, String nombreCapacitacionOEvento, String objetivo, UsuarioDTO colaborador, IndicadorDTO indicador, LocalDate fechaProgramada, AreaDTO area, String rutaInsumos){
        return new ActividadDTO(identificador, nombreCapacitacionOEvento, objetivo, colaborador, null, indicador, UtilFecha.getInstance().obtenerHoraFechaDefecto(), fechaProgramada, UtilFecha.getInstance().obtenerFechaDefecto(), UtilFecha.getInstance().obtenerHoraDefecto(), UtilFecha.getInstance().obtenerHoraDefecto(), null, area, rutaInsumos);
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

    public void setColaborador(UsuarioDTO colaborador) {
        this.colaborador = UsuarioDTO.obtenerValorDefecto(colaborador);
    }

    public void setCreador(UsuarioDTO creador) {
        this.creador = UsuarioDTO.obtenerValorDefecto(creador);
    }

    public void setIndicador(IndicadorDTO indicador) {
        this.indicador = IndicadorDTO.obtenerValorDefecto(indicador);
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

    public void setEstadoActividad(EstadoActividadDTO estadoActividad) {
        this.estadoActividad = EstadoActividadDTO.obtenerValorDefecto(estadoActividad);
    }

    public void setArea(AreaDTO area) {
        this.area = AreaDTO.obtenerValorDefecto(area);
    }

    public void setRutaInsumos(String rutaInsumos) {
        this.rutaInsumos = UtilTexto.getInstance().quitarEspaciosBlancoInicioFin(rutaInsumos);
    }
}
