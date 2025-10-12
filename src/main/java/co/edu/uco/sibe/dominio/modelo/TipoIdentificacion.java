package co.edu.uco.sibe.dominio.modelo;

import co.edu.uco.sibe.dominio.transversal.constante.TextoConstante;
import co.edu.uco.sibe.dominio.transversal.utilitarios.UtilUUID;
import co.edu.uco.sibe.dominio.transversal.utilitarios.ValidadorTexto;
import lombok.Getter;

import java.util.UUID;

@Getter
public class TipoIdentificacion {
    private UUID identificador;
    private String sigla;
    private String descripcion;

    private TipoIdentificacion(UUID identificador, String sigla, String descripcion) {
        this.identificador = identificador;
        this.sigla = sigla;
        this.descripcion = descripcion;
    }

    public static TipoIdentificacion construir(UUID identificador, String sigla, String descripcion) {
        return new TipoIdentificacion(identificador, ValidadorTexto.obtenerValorPorDefecto(sigla), ValidadorTexto.obtenerValorPorDefecto(descripcion));
    }

    public static TipoIdentificacion construir() {
        return new TipoIdentificacion(UtilUUID.obtenerValorDefecto(), TextoConstante.VACIO, TextoConstante.VACIO);
    }
}