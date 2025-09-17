package co.edu.uco.sibe.dominio.modelo;

import java.util.UUID;

public class TipoIndicador {
    private UUID identificador;
    private String naturalezaIndicador;
    private String tipologiaIndicador;

    private TipoIndicador(UUID identificador, String naturalezaIndicador, String tipologiaIndicador) {
        setIdentificador(identificador);
        setNaturalezaIndicador(naturalezaIndicador);
        setTipologiaIndicador(tipologiaIndicador);
    }

    public static TipoIndicador construir(UUID identificador, String naturalezaIndicador, String tipologiaIndicador) {
        return new TipoIndicador(identificador, naturalezaIndicador, tipologiaIndicador);
    }

    public UUID getIdentificador() {
        return identificador;
    }

    public String getNaturalezaIndicador() {
        return naturalezaIndicador;
    }

    public String getTipologiaIndicador() {
        return tipologiaIndicador;
    }

    private void setIdentificador(UUID identificador) {
        this.identificador = identificador;
    }

    private void setNaturalezaIndicador(String naturalezaIndicador) {
        this.naturalezaIndicador = naturalezaIndicador;
    }

    private void setTipologiaIndicador(String tipologiaIndicador) {
        this.tipologiaIndicador = tipologiaIndicador;
    }
}