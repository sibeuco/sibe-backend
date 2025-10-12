package co.edu.uco.sibe.dominio.modelo;

import lombok.Getter;

import java.util.List;
import java.util.UUID;

@Getter
public class Subarea {
    private UUID identificador;
    private String nombre;
    private List<Actividad> actividades;

    private Subarea(UUID identificador, String nombre, List<Actividad> actividades) {
        this.identificador = identificador;
        this.nombre = nombre;
        this.actividades = actividades;
    }

    public static Subarea construir(UUID identificador, String nombre, List<Actividad> actividades) {
        return new Subarea(identificador, nombre, actividades);
    }
}