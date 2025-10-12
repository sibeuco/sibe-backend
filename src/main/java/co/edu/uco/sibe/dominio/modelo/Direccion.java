package co.edu.uco.sibe.dominio.modelo;

import lombok.Getter;

import java.util.List;
import java.util.UUID;

@Getter
public class Direccion {
    private UUID identificador;
    private String nombre;
    private List<Area> areas;
    private List<Actividad> actividades;

    private Direccion(UUID identificador, String nombre, List<Area> areas, List<Actividad> actividades) {
        this.identificador = identificador;
        this.nombre = nombre;
        this.areas = areas;
        this.actividades = actividades;
    }

    public static Direccion construir(UUID identificador, String nombre, List<Area> areas, List<Actividad> actividades) {
        return new Direccion(identificador, nombre, areas, actividades);
    }
}