package co.edu.uco.sibe.dominio.modelo;

import co.edu.uco.sibe.dominio.transversal.constante.TextoConstante;
import co.edu.uco.sibe.dominio.transversal.utilitarios.UtilUUID;
import co.edu.uco.sibe.dominio.transversal.utilitarios.ValidadorTexto;
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
        return new TipoIndicador(identificador, ValidadorTexto.obtenerValorPorDefecto(naturalezaIndicador), ValidadorTexto.obtenerValorPorDefecto(tipologiaIndicador));
    }

    public static TipoIndicador construir() {
        return new TipoIndicador(UtilUUID.obtenerValorDefecto(), TextoConstante.VACIO, TextoConstante.VACIO);
    }
}