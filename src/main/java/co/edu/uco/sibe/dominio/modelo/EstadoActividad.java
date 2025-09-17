package co.edu.uco.sibe.dominio.modelo;

import java.util.UUID;

public class EstadoActividad {

    private UUID identificador;
    private String nombre;

    private EstadoActividad(UUID identificador, String nombre) {
        setIdentificador(identificador);
        setNombre(nombre);
    }

    public static EstadoActividad construir(UUID identificador, String nombre) {
        return new EstadoActividad(identificador, nombre);
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