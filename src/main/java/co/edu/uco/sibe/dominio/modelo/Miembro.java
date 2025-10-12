package co.edu.uco.sibe.dominio.modelo;

import co.edu.uco.sibe.dominio.transversal.constante.TextoConstante;
import co.edu.uco.sibe.dominio.transversal.utilitarios.UtilUUID;
import co.edu.uco.sibe.dominio.transversal.utilitarios.ValidadorTexto;
import lombok.Getter;

import java.util.UUID;

@Getter
public class Miembro {
    private UUID identificador;
    private String nombreCompleto;
    private String numeroIdentificacion;

    protected Miembro(UUID identificador, String nombreCompleto, String numeroIdentificacion) {
        this.identificador = identificador;
        this.nombreCompleto = nombreCompleto;
        this.numeroIdentificacion = numeroIdentificacion;
    }

    public static Miembro construir(UUID identificador, String nombreCompleto, String numeroIdentificacion) {
        return new Miembro(identificador, ValidadorTexto.obtenerValorPorDefecto(nombreCompleto), ValidadorTexto.obtenerValorPorDefecto(numeroIdentificacion));
    }

    public static Miembro construir() {
        return new Miembro(UtilUUID.obtenerValorDefecto(), TextoConstante.VACIO, TextoConstante.VACIO);
    }
}