package co.edu.uco.sibe.dominio.modelo;

import java.util.List;
import java.util.UUID;

public class Direccion {
    private UUID identificador;
    private String nombre;
    private List<Area> areas;
    private List<Actividad> actividades;

    private Direccion(UUID identificador, String nombre, List<Area> areas, List<Actividad> actividades) {
        setIdentificador(identificador);
        setNombre(nombre);
        setAreas(areas);
        setActividades(actividades);
    }

    public static Direccion construir(UUID identificador, String nombre, List<Area> areas, List<Actividad> actividades) {
        return new Direccion(identificador, nombre, areas, actividades);
    }

    public UUID getIdentificador() {
        return identificador;
    }

    public String getNombre() {
        return nombre;
    }

    public List<Area> getAreas() {
        return areas;
    }

    public List<Actividad> getActividades() {
        return actividades;
    }

    private void setIdentificador(UUID identificador) {
        this.identificador = identificador;
    }

    private void setNombre(String nombre) {
        this.nombre = nombre;
    }

    private void setAreas(List<Area> areas) {
        this.areas = areas;
    }

    private void setActividades(List<Actividad> actividades) {
        this.actividades = actividades;
    }
}