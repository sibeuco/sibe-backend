package co.edu.uco.sibe.dominio.dto;

import co.edu.uco.sibe.dominio.transversal.utilitarios.UtilObjeto;
import co.edu.uco.sibe.dominio.transversal.utilitarios.UtilTexto;
import co.edu.uco.sibe.dominio.transversal.utilitarios.UtilUUID;

import java.util.UUID;
import lombok.Getter;

@Getter
public class IndicadorDTO {
    private UUID identificador;
    private String nombre;
    private TipoIndicadorDTO tipoIndicador;
    private TemporalidadDTO temporalidad;
    private ProyectoDTO proyecto;
    private PublicoInteresDTO publicoInteres;

    public IndicadorDTO(){
        setIdentificador(UtilUUID.obtenerValorDefecto());
        setNombre(UtilTexto.getInstance().obtenerValorDefecto());
        setTipoIndicador(TipoIndicadorDTO.obtenerValorDefecto());
        setTemporalidad(TemporalidadDTO.obtenerValorDefecto());
        setProyecto(ProyectoDTO.obtenerValorDefecto());
        setPublicoInteres(PublicoInteresDTO.obtenerValorDefecto());
    }

    private IndicadorDTO(UUID identificador, String nombre, TipoIndicadorDTO tipoIndicador, TemporalidadDTO temporalidad, ProyectoDTO proyecto, PublicoInteresDTO publicoInteres) {
        setIdentificador(identificador);
        setNombre(nombre);
        setTipoIndicador(tipoIndicador);
        setTemporalidad(temporalidad);
        setProyecto(proyecto);
        setPublicoInteres(publicoInteres);
    }

    public static IndicadorDTO obtenerValorDefecto(){
        return new IndicadorDTO();
    }

    public static IndicadorDTO obtenerValorDefecto(final IndicadorDTO indicador){
        return UtilObjeto.getInstance().obtenerValorDefecto(indicador, obtenerValorDefecto());
    }

    public static IndicadorDTO construir(UUID identificador, String nombre, TipoIndicadorDTO tipoIndicador, TemporalidadDTO temporalidad, ProyectoDTO proyecto, PublicoInteresDTO publicoInteres){
        return new IndicadorDTO(identificador, nombre, tipoIndicador, temporalidad, proyecto, publicoInteres);
    }

    private void setIdentificador(UUID identificador) {
        this.identificador = UtilUUID.obtenerValorDefecto(identificador);
    }

    private void setNombre(String nombre) {
        this.nombre = UtilTexto.getInstance().quitarEspaciosBlancoInicioFin(nombre);
    }

    private void setTipoIndicador(TipoIndicadorDTO tipoIndicador) {
        this.tipoIndicador = TipoIndicadorDTO.obtenerValorDefecto(tipoIndicador);
    }

    private void setTemporalidad(TemporalidadDTO temporalidad) {
        this.temporalidad = TemporalidadDTO.obtenerValorDefecto(temporalidad);
    }

    private void setProyecto(ProyectoDTO proyecto) {
        this.proyecto = ProyectoDTO.obtenerValorDefecto(proyecto);
    }

    private void setPublicoInteres(PublicoInteresDTO publicoInteres) {
        this.publicoInteres = PublicoInteresDTO.obtenerValorDefecto(publicoInteres);
    }
}
