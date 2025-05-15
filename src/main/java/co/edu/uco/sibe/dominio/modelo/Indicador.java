package co.edu.uco.sibe.dominio.modelo;

import co.edu.uco.sibe.dominio.transversal.utilitarios.UtilObjeto;
import co.edu.uco.sibe.dominio.transversal.utilitarios.UtilTexto;
import co.edu.uco.sibe.dominio.transversal.utilitarios.UtilUUID;

import java.util.UUID;
import lombok.Getter;

@Getter
public class Indicador {
    private UUID identificador;
    private String nombre;
    private TipoIndicador tipoIndicador;
    private Temporalidad temporalidad;
    private Proyecto proyecto;
    private PublicoInteres publicoInteres;

    public Indicador(){
        setIdentificador(UtilUUID.obtenerValorDefecto());
        setNombre(UtilTexto.getInstance().obtenerValorDefecto());
        setTipoIndicador(TipoIndicador.obtenerValorDefecto());
        setTemporalidad(Temporalidad.obtenerValorDefecto());
        setProyecto(Proyecto.obtenerValorDefecto());
        setPublicoInteres(PublicoInteres.obtenerValorDefecto());
    }

    private Indicador(UUID identificador, String nombre, TipoIndicador tipoIndicador, Temporalidad temporalidad, Proyecto proyecto, PublicoInteres publicoInteres) {
        setIdentificador(identificador);
        setNombre(nombre);
        setTipoIndicador(tipoIndicador);
        setTemporalidad(temporalidad);
        setProyecto(proyecto);
        setPublicoInteres(publicoInteres);
    }

    public static Indicador obtenerValorDefecto(){
        return new Indicador();
    }

    public static Indicador obtenerValorDefecto(final Indicador indicador){
        return UtilObjeto.getInstance().obtenerValorDefecto(indicador, obtenerValorDefecto());
    }

    public static Indicador construir(UUID identificador, String nombre, TipoIndicador tipoIndicador, Temporalidad temporalidad, Proyecto proyecto, PublicoInteres publicoInteres){
        return new Indicador(identificador, nombre, tipoIndicador, temporalidad, proyecto, publicoInteres);
    }

    public void setIdentificador(UUID identificador) {
        this.identificador = UtilUUID.obtenerValorDefecto(identificador);
    }

    public void setNombre(String nombre) {
        this.nombre = UtilTexto.getInstance().quitarEspaciosBlancoInicioFin(nombre);
    }

    public void setTipoIndicador(TipoIndicador tipoIndicador) {
        this.tipoIndicador = TipoIndicador.obtenerValorDefecto(tipoIndicador);
    }

    public void setTemporalidad(Temporalidad temporalidad) {
        this.temporalidad = Temporalidad.obtenerValorDefecto(temporalidad);
    }

    public void setProyecto(Proyecto proyecto) {
        this.proyecto = Proyecto.obtenerValorDefecto(proyecto);
    }

    public void setPublicoInteres(PublicoInteres publicoInteres) {
        this.publicoInteres = PublicoInteres.obtenerValorDefecto(publicoInteres);
    }
}
