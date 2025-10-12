package co.edu.uco.sibe.dominio.modelo;

import co.edu.uco.sibe.dominio.transversal.constante.TextoConstante;
import co.edu.uco.sibe.dominio.transversal.utilitarios.UtilUUID;
import co.edu.uco.sibe.dominio.transversal.utilitarios.ValidadorObjeto;
import co.edu.uco.sibe.dominio.transversal.utilitarios.ValidadorTexto;
import lombok.Getter;

import java.util.ArrayList;
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
        return new Subarea(identificador, ValidadorTexto.obtenerValorPorDefecto(nombre), ValidadorObjeto.obtenerValorPorDefecto(actividades, new ArrayList<Actividad>()));
    }

    public static Subarea construir() {
        return new Subarea(UtilUUID.obtenerValorDefecto(), TextoConstante.VACIO, new ArrayList<Actividad>());
    }
}