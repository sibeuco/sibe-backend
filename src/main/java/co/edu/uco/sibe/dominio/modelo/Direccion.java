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
        return new Direccion(
                identificador,
                ValidadorTexto.obtenerValorPorDefecto(nombre),
                ValidadorObjeto.obtenerValorPorDefecto(areas, new ArrayList<>()),
                ValidadorObjeto.obtenerValorPorDefecto(actividades, new ArrayList<>())
        );
    }

    public static Direccion construir() {
        return new Direccion(
                UtilUUID.obtenerValorDefecto(),
                TextoConstante.VACIO,
                new ArrayList<>(),
                new ArrayList<>()
        );
    }
}