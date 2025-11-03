package co.edu.uco.sibe.dominio.modelo;

import static co.edu.uco.sibe.dominio.transversal.constante.TextoConstante.VACIO;
import co.edu.uco.sibe.dominio.transversal.utilitarios.*;
import lombok.Getter;

import java.time.LocalDate;
import java.util.UUID;

@Getter
public class Actividad {
    private UUID identificador;
    private String nombre;
    private String objetivo;
    private String semestre;
    private String rutaInsumos;
    private LocalDate fechaCreacion;
    private Indicador indicador;
    private UUID colaborador;
    private UUID creador;

    private Actividad(
            UUID identificador,
            String nombre,
            String objetivo,
            String semestre,
            String rutaInsumos,
            LocalDate fechaCreacion,
            Indicador indicador,
            UUID colaborador,
            UUID creador) {
        this.identificador = identificador;
        this.nombre = nombre;
        this.objetivo = objetivo;
        this.semestre = semestre;
        this.rutaInsumos = rutaInsumos;
        this.fechaCreacion = fechaCreacion;
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
            LocalDate fechaCreacion,
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
                UtilFecha.obtenerValorFechaPorDefecto(fechaCreacion),
                ValidadorObjeto.obtenerValorPorDefecto(indicador,Indicador.construir()),
                colaborador,
                creador
        );
    }

    public static Actividad construir() {
        return new Actividad(
                UtilUUID.obtenerValorDefecto(),
                VACIO,
                VACIO,
                VACIO,
                VACIO,
                UtilFecha.obtenerFechaDefecto(),
                Indicador.construir(),
                UtilUUID.obtenerValorDefecto(),
                UtilUUID.obtenerValorDefecto()
        );
    }
}