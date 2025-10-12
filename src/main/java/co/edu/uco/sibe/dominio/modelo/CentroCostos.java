package co.edu.uco.sibe.dominio.modelo;

import co.edu.uco.sibe.dominio.transversal.constante.TextoConstante;
import co.edu.uco.sibe.dominio.transversal.utilitarios.UtilUUID;
import co.edu.uco.sibe.dominio.transversal.utilitarios.ValidadorTexto;
import lombok.Getter;

import java.util.UUID;

@Getter
public class CentroCostos {
    private UUID identificador;
    private String codigo;
    private String descripcion;

    private CentroCostos(UUID identificador, String codigo, String descripcion) {
        this.identificador = identificador;
        this.codigo = codigo;
        this.descripcion = descripcion;
    }

    public static CentroCostos construir(UUID identificador, String codigo, String descripcion) {
        return new CentroCostos(identificador, ValidadorTexto.obtenerValorPorDefecto(codigo), ValidadorTexto.obtenerValorPorDefecto(descripcion));
    }

    public static CentroCostos construir() {
        return new CentroCostos(UtilUUID.obtenerValorDefecto(), TextoConstante.VACIO, TextoConstante.VACIO);
    }
}