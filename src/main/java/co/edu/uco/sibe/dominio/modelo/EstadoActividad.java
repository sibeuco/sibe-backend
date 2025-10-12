package co.edu.uco.sibe.dominio.modelo;

import lombok.Getter;

import java.util.UUID;

@Getter
public class EstadoActividad {
    private UUID identificador;
    private String nombre;

    private EstadoActividad(UUID identificador, String nombre) {
        this.identificador = identificador;
        this.nombre = nombre;
    }

    public static EstadoActividad construir(UUID identificador, String nombre) {
        return new EstadoActividad(identificador, nombre);
    }
}