package co.edu.uco.sibe.dominio.modelo;

import lombok.Getter;

import java.util.UUID;

@Getter
public class Temporalidad {
    private UUID identificador;
    private String nombre;

    private Temporalidad(UUID identificador, String nombre) {
        this.identificador = identificador;
        this.nombre = nombre;
    }

    public static Temporalidad construir(UUID identificador, String nombre) {
        return new Temporalidad(identificador, nombre);
    }
}