package co.edu.uco.sibe.dominio.modelo;

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
        return new TipoIdentificacion(identificador, sigla, descripcion);
    }
}