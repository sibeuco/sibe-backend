package co.edu.uco.sibe.dominio.dto;

import co.edu.uco.sibe.dominio.transversal.utilitarios.UtilObjeto;
import co.edu.uco.sibe.dominio.transversal.utilitarios.UtilTexto;
import co.edu.uco.sibe.dominio.transversal.utilitarios.UtilUUID;

import java.util.UUID;
import lombok.Getter;

@Getter
public class TipoIndicadorDTO {
    private UUID identificador;
    private String naturalezaIndicador;
    private String tipologiaIndicador;

    public TipoIndicadorDTO(){
        setIdentificador(UtilUUID.obtenerValorDefecto());
        setNaturalezaIndicador(UtilTexto.getInstance().obtenerValorDefecto());
        setTipologiaIndicador(UtilTexto.getInstance().obtenerValorDefecto());
    }

    public TipoIndicadorDTO(UUID identificador, String naturalezaIndicador, String tipologiaIndicador){
        setIdentificador(identificador);
        setNaturalezaIndicador(naturalezaIndicador);
        setTipologiaIndicador(tipologiaIndicador);
    }

    public static TipoIndicadorDTO obtenerValorDefecto(){
        return new TipoIndicadorDTO();
    }

    public static TipoIndicadorDTO obtenerValorDefecto(final TipoIndicadorDTO tipoIndicador){
        return UtilObjeto.getInstance().obtenerValorDefecto(tipoIndicador, obtenerValorDefecto());
    }

    public static TipoIndicadorDTO construir(UUID identificador, String naturalezaIndicador, String tipologiaIndicador){
        return new TipoIndicadorDTO(identificador, naturalezaIndicador, tipologiaIndicador);
    }

    private void setIdentificador(UUID identificador) {
        this.identificador = UtilUUID.obtenerValorDefecto(identificador);
    }

    private void setNaturalezaIndicador(String naturalezaIndicador) {
        this.naturalezaIndicador = UtilTexto.getInstance().quitarEspaciosBlancoInicioFin(naturalezaIndicador);
    }

    private void setTipologiaIndicador(String tipologiaIndicador) {
        this.tipologiaIndicador = UtilTexto.getInstance().quitarEspaciosBlancoInicioFin(tipologiaIndicador);
    }
}
