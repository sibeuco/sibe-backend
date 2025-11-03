package co.edu.uco.sibe.dominio.modelo;

import static co.edu.uco.sibe.dominio.transversal.constante.TextoConstante.VACIO;
import co.edu.uco.sibe.dominio.transversal.utilitarios.UtilUUID;
import co.edu.uco.sibe.dominio.transversal.utilitarios.ValidadorObjeto;
import co.edu.uco.sibe.dominio.transversal.utilitarios.ValidadorTexto;
import lombok.Getter;
import java.util.ArrayList;
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
        return new Area(
                identificador,
                ValidadorTexto.obtenerValorPorDefecto(nombre),
                ValidadorObjeto.obtenerValorPorDefecto(subareas, new ArrayList<>()),
                ValidadorObjeto.obtenerValorPorDefecto(actividades, new ArrayList<>())
        );
    }

    public static Area construir() {
        return new Area(
                UtilUUID.obtenerValorDefecto(),
                VACIO,
                new ArrayList<>(),
                new ArrayList<>()
        );
    }
}