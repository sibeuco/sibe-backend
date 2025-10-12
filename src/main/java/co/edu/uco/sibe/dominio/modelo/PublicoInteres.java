package co.edu.uco.sibe.dominio.modelo;

import lombok.Getter;

import java.util.UUID;

@Getter
public class PublicoInteres {
    private UUID identificador;
    private String nombre;

    public PublicoInteres(UUID identificador, String nombre) {
        this.identificador = identificador;
        this.nombre = nombre;
    }

    public static PublicoInteres construir(UUID identificador, String nombre) {
        return new PublicoInteres(identificador, nombre);
    }
}