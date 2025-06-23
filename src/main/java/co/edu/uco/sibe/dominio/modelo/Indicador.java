package co.edu.uco.sibe.dominio.modelo;

import co.edu.uco.sibe.dominio.transversal.utilitarios.UtilTexto;
import co.edu.uco.sibe.dominio.transversal.utilitarios.UtilUUID;
import lombok.Getter;

import java.util.UUID;

@Getter
public class Indicador {
    private UUID identificador;
    private String nombre;
    private TipoIndicador tipoIndicador;
    private Temporalidad temporalidad;
    private Proyecto proyecto;
    private PublicoInteres publicoInteres;

    private Indicador(String nombre, TipoIndicador tipoIndicador, Temporalidad temporalidad, Proyecto proyecto, PublicoInteres publicoInteres) {
        setIdentificador();
        setNombre(nombre);
        setTipoIndicador(tipoIndicador);
        setTemporalidad(temporalidad);
        setProyecto(proyecto);
        setPublicoInteres(publicoInteres);
    }

    public static Indicador construir(String nombre, TipoIndicador tipoIndicador, Temporalidad temporalidad, Proyecto proyecto, PublicoInteres publicoInteres){
        return new Indicador(nombre, tipoIndicador, temporalidad, proyecto, publicoInteres);
    }

    public void setIdentificador() {
        this.identificador = UtilUUID.generarNuevoUUID();
    }

    public void setNombre(String nombre) {
        this.nombre = UtilTexto.getInstance().quitarEspaciosBlancoInicioFin(nombre);
    }

    public void setTipoIndicador(TipoIndicador tipoIndicador) {
        this.tipoIndicador = tipoIndicador;
    }

    public void setTemporalidad(Temporalidad temporalidad) {
        this.temporalidad = temporalidad;
    }

    public void setProyecto(Proyecto proyecto) {
        this.proyecto = proyecto;
    }

    public void setPublicoInteres(PublicoInteres publicoInteres) {
        this.publicoInteres = publicoInteres;
    }
}
