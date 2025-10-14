package co.edu.uco.sibe.dominio.modelo;

import co.edu.uco.sibe.dominio.transversal.constante.TextoConstante;
import co.edu.uco.sibe.dominio.transversal.utilitarios.*;
import lombok.Getter;
import java.util.UUID;

@Getter
public class Actividad {
    private UUID identificador;
    private String nombre;
    private String objetivo;
    private String semestre;
    private String rutaInsumos;
    private Indicador indicador;
    private UUID colaborador;
    private UUID creador;

    private Actividad(
            UUID identificador,
            String nombre,
            String objetivo,
            String semestre,
            String rutaInsumos,
            Indicador indicador,
            UUID colaborador,
            UUID creador) {
        this.identificador = identificador;
        this.nombre = nombre;
        this.objetivo = objetivo;
        this.semestre = semestre;
        this.rutaInsumos = rutaInsumos;
        this.indicador = indicador;
        this.colaborador = colaborador;
        this.creador = creador;
    }

    public static Actividad construir(
            UUID identificador,
            String nombre,
            String objetivo,
            String semestre,
            String rutaInsumos,
            Indicador indicador,
            UUID colaborador,
            UUID creador
    ) {
        return new Actividad(
                identificador,
                ValidadorTexto.obtenerValorPorDefecto(nombre),
                ValidadorTexto.obtenerValorPorDefecto(objetivo),
                ValidadorTexto.obtenerValorPorDefecto(semestre),
                ValidadorTexto.obtenerValorPorDefecto(rutaInsumos),
                ValidadorObjeto.obtenerValorPorDefecto(indicador,Indicador.construir()),
                colaborador,
                creador
        );
    }

    public static Actividad construir() {
        return new Actividad(
                UtilUUID.obtenerValorDefecto(),
                TextoConstante.VACIO, TextoConstante.VACIO,
                TextoConstante.VACIO, TextoConstante.VACIO,
                Indicador.construir(), UtilUUID.obtenerValorDefecto(),
                UtilUUID.obtenerValorDefecto()
        );
    }
}