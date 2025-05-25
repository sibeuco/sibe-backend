package co.edu.uco.sibe.dominio.modelo;

import java.util.UUID;

import co.edu.uco.sibe.dominio.transversal.utilitarios.UtilObjeto;
import co.edu.uco.sibe.dominio.transversal.utilitarios.UtilTexto;
import co.edu.uco.sibe.dominio.transversal.utilitarios.UtilUUID;
import lombok.Getter;

@Getter
public class TipoIndicador {
    private UUID identificador;
    private String naturalezaIndicador;
    private String tipologiaIndicador;

    public TipoIndicador(){
        this.identificador = UtilUUID.obtenerValorDefecto();
        setNaturalezaIndicador(UtilTexto.getInstance().obtenerValorDefecto());
        setTipologiaIndicador(UtilTexto.getInstance().obtenerValorDefecto());
    }

    private TipoIndicador(String naturalezaIndicador, String tipologiaIndicador){
        setIdentificador();
        setNaturalezaIndicador(naturalezaIndicador);
        setTipologiaIndicador(tipologiaIndicador);
    }

    public static TipoIndicador obtenerValorDefecto(){
        return new TipoIndicador();
    }

    public static TipoIndicador obtenerValorDefecto(final TipoIndicador tipoIndicador){
        return UtilObjeto.getInstance().obtenerValorDefecto(tipoIndicador, obtenerValorDefecto());
    }

    public static TipoIndicador construir(String naturalezaIndicador, String tipologiaIndicador){
        return new TipoIndicador(naturalezaIndicador, tipologiaIndicador);
    }

    public void setIdentificador() {
        this.identificador = UtilUUID.generarNuevoUUID();
    }

    public void setNaturalezaIndicador(String naturalezaIndicador) {
        this.naturalezaIndicador = UtilTexto.getInstance().quitarEspaciosBlancoInicioFin(naturalezaIndicador);
    }

    public void setTipologiaIndicador(String tipologiaIndicador) {
        this.tipologiaIndicador = UtilTexto.getInstance().quitarEspaciosBlancoInicioFin(tipologiaIndicador);
    }
}
