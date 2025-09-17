package co.edu.uco.sibe.dominio.modelo;

import java.util.UUID;

public class PublicoInteres {
    private UUID identificador;
    private String nombre;

    private PublicoInteres(UUID identificador, String nombre) {
        setIdentificador(identificador);
        setNombre(nombre);
    }

    public static PublicoInteres construir(UUID identificador, String nombre) {
        return new PublicoInteres(identificador, nombre);
    }

    public UUID getIdentificador() {
        return identificador;
    }

    public String getNombre() {
        return nombre;
    }

    private void setIdentificador(UUID identificador) {
        this.identificador = identificador;
    }

    private void setNombre(String nombre) {
        this.nombre = nombre;
    }
}