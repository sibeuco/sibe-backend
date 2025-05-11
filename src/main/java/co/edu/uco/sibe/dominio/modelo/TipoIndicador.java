package co.edu.uco.sibe.dominio.modelo;

import java.util.UUID;

import co.edu.uco.sibe.dominio.transversal.utilitarios.UtilTexto;
import co.edu.uco.sibe.dominio.transversal.utilitarios.UtilUUID;
import lombok.Getter;

@Getter
public class TipoIndicador {
    private UUID identificador;
    private String naturalezaIndicador;
    private String tipologiaIndicador;

    private TipoIndicador(UUID identificador, String naturalezaIndicador, String tipologiaIndicador){
        setIdentificador(identificador);
        setNaturalezaIndicador(naturalezaIndicador);
        setTipologiaIndicador(tipologiaIndicador);
    }

    public static TipoIndicador construir(UUID identificador, String naturalezaIndicador, String tipologiaIndicador){
        return new TipoIndicador(identificador, naturalezaIndicador, tipologiaIndicador);
    }

    public void setIdentificador(UUID identificador) {
        this.identificador = UtilUUID.obtenerValorDefecto(identificador);
    }

    public void setNaturalezaIndicador(String naturalezaIndicador) {
        this.naturalezaIndicador = UtilTexto.getInstance().quitarEspaciosBlancoInicioFin(naturalezaIndicador);
    }

    public void setTipologiaIndicador(String tipologiaIndicador) {
        this.tipologiaIndicador = UtilTexto.getInstance().quitarEspaciosBlancoInicioFin(tipologiaIndicador);
    }
}
