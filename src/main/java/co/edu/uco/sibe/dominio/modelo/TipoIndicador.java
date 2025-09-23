package co.edu.uco.sibe.dominio.modelo;

import co.edu.uco.sibe.dominio.transversal.utilitarios.ValidadorNumero;
import co.edu.uco.sibe.dominio.transversal.utilitarios.ValidadorTexto;

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
        ValidadorTexto.validarObligatorio(naturalezaIndicador, "");
        ValidadorTexto.validarTextoValido(naturalezaIndicador, "");
        ValidadorNumero.validarNumeroEntre(naturalezaIndicador.length(), 5, 20, "");

        this.naturalezaIndicador = naturalezaIndicador;
    }

    private void setTipologiaIndicador(String tipologiaIndicador) {
        ValidadorTexto.validarObligatorio(tipologiaIndicador, "");
        ValidadorTexto.validarTextoValido(tipologiaIndicador, "");
        ValidadorNumero.validarNumeroEntre(tipologiaIndicador.length(), 5, 15, "");

        this.tipologiaIndicador = tipologiaIndicador;
    }
}