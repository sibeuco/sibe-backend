package co.edu.uco.sibe.dominio.modelo;

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
        return new Miembro(identificador, nombreCompleto, numeroIdentificacion);
    }
}