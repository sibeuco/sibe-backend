package co.edu.uco.sibe.dominio.modelo;

import lombok.Getter;

import java.util.List;
import java.util.UUID;

@Getter
public class Area {
    private UUID identificador;
    private String nombre;
    private List<Subarea> subareas;
    private List<Actividad> actividades;

    private Area(UUID identificador, String nombre, List<Subarea> subareas, List<Actividad> actividades) {
        this.identificador = identificador;
        this.nombre = nombre;
        this.subareas = subareas;
        this.actividades = actividades;
    }

    public static Area construir(UUID identificador, String nombre, List<Subarea> subareas, List<Actividad> actividades) {
        return new Area(identificador, nombre, subareas, actividades);
    }
}