package co.edu.uco.sibe.dominio.modelo;

import co.edu.uco.sibe.dominio.transversal.constante.TextoConstante;
import co.edu.uco.sibe.dominio.transversal.utilitarios.UtilUUID;
import co.edu.uco.sibe.dominio.transversal.utilitarios.ValidadorTexto;
import lombok.Getter;
import java.util.UUID;

@Getter
public class TipoIndicador {
    private UUID identificador;
    private String naturaleza;
    private String tipologia;

    private TipoIndicador(UUID identificador, String naturaleza, String tipologia) {
        this.identificador = identificador;
        this.naturaleza = naturaleza;
        this.tipologia = tipologia;
    }

    public static TipoIndicador construir(UUID identificador, String naturalezaIndicador, String tipologiaIndicador) {
        return new TipoIndicador(
                identificador,
                ValidadorTexto.obtenerValorPorDefecto(naturalezaIndicador),
                ValidadorTexto.obtenerValorPorDefecto(tipologiaIndicador)
        );
    }

    public static TipoIndicador construir() {
        return new TipoIndicador(
                UtilUUID.obtenerValorDefecto(),
                TextoConstante.VACIO,
                TextoConstante.VACIO
        );
    }
}