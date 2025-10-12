package co.edu.uco.sibe.dominio.modelo;

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
        return new CentroCostos(identificador, codigo, descripcion);
    }
}