package co.edu.uco.sibe.dominio.modelo;

import lombok.Getter;

import java.util.UUID;

@Getter
public class TipoIndicador {
    private UUID identificador;
    private String naturalezaIndicador;
    private String tipologiaIndicador;

    private TipoIndicador(UUID identificador, String naturalezaIndicador, String tipologiaIndicador) {
        this.identificador = identificador;
        this.naturalezaIndicador = naturalezaIndicador;
        this.tipologiaIndicador = tipologiaIndicador;
    }

    public static TipoIndicador construir(UUID identificador, String naturalezaIndicador, String tipologiaIndicador) {
        return new TipoIndicador(identificador, naturalezaIndicador, tipologiaIndicador);
    }
}