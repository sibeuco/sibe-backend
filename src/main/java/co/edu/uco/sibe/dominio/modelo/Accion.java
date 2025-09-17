package co.edu.uco.sibe.dominio.modelo;

import java.util.UUID;

public class Accion {
    private UUID identificador;
    private String detalle;
    private String objetivo;

    private Accion(UUID identificador, String detalle, String objetivo) {
        setIdentificador(identificador);
        setDetalle(detalle);
        setObjetivo(objetivo);
    }

    public static Accion construir(UUID identificador, String detalle, String objetivo) {
        return new Accion(identificador, detalle, objetivo);
    }

    public UUID getIdentificador() {
        return identificador;
    }

    public String getDetalle() {
        return detalle;
    }

    public String getObjetivo() {
        return objetivo;
    }

    private void setIdentificador(UUID identificador) {
        this.identificador = identificador;
    }

    private void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    private void setObjetivo(String objetivo) {
        this.objetivo = objetivo;
    }
}