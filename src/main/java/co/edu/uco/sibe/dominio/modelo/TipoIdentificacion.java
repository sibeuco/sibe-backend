package co.edu.uco.sibe.dominio.modelo;

import java.util.UUID;

import co.edu.uco.sibe.dominio.transversal.utilitarios.UtilObjeto;
import co.edu.uco.sibe.dominio.transversal.utilitarios.UtilTexto;
import co.edu.uco.sibe.dominio.transversal.utilitarios.UtilUUID;
import lombok.Getter;

@Getter
public class TipoIdentificacion {
    private UUID identificador;
    private String sigla;
    private String descripcion;

    public TipoIdentificacion(){
        this.identificador = UtilUUID.obtenerValorDefecto();
        setSigla(UtilTexto.getInstance().obtenerValorDefecto());
        setDescripcion(UtilTexto.getInstance().obtenerValorDefecto());
    }

    private TipoIdentificacion(String sigla, String descripcion){
        setIdentificador();
        setSigla(sigla);
        setDescripcion(descripcion);
    }

    public static TipoIdentificacion obtenerValorDefecto(){
        return new TipoIdentificacion();
    }

    public static TipoIdentificacion obtenerValorDefecto(final TipoIdentificacion tipoIdentificacion){
        return UtilObjeto.getInstance().obtenerValorDefecto(tipoIdentificacion, obtenerValorDefecto());
    }

    public static TipoIdentificacion construir(String sigla, String descripcion){
        return new TipoIdentificacion(sigla, descripcion);
    }

    public void setIdentificador() {
        this.identificador = UtilUUID.generarNuevoUUID();
    }

    public void setSigla(String sigla) {
        this.sigla = UtilTexto.getInstance().quitarEspaciosBlancoInicioFin(sigla);
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = UtilTexto.getInstance().quitarEspaciosBlancoInicioFin(descripcion);
    }
}
