package co.edu.uco.sibe.dominio.modelo;

import lombok.Getter;

import java.util.UUID;

@Getter
public class CiudadResidencia {
    private UUID identificador;
    private String descripcion;

    private CiudadResidencia(UUID identificador, String descripcion) {
        this.identificador = identificador;
        this.descripcion = descripcion;
    }

    public static CiudadResidencia construir(UUID identificador, String descripcion) {
        return new CiudadResidencia(identificador, descripcion);
    }
}