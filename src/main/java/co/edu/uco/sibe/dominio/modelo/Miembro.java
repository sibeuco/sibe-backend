package co.edu.uco.sibe.dominio.modelo;

import java.util.UUID;

public class Miembro {
    private UUID identificador;
    private String nombreCompleto;
    private String numeroIdentificacion;

    protected Miembro(UUID identificador, String nombreCompleto, String numeroIdentificacion) {
        setIdentificador(identificador);
        setNombreCompleto(nombreCompleto);
        setNumeroIdentificacion(numeroIdentificacion);
    }

    public static Miembro construir(UUID identificador, String nombreCompleto, String numeroIdentificacion) {
        return new Miembro(identificador, nombreCompleto, numeroIdentificacion);
    }

    public UUID getIdentificador() {
        return identificador;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public String getNumeroIdentificacion() {
        return numeroIdentificacion;
    }

    private void setIdentificador(UUID identificador) {
        this.identificador = identificador;
    }

    private void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    private void setNumeroIdentificacion(String numeroIdentificacion) {
        this.numeroIdentificacion = numeroIdentificacion;
    }
}