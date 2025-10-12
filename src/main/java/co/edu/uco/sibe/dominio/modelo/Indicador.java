package co.edu.uco.sibe.dominio.modelo;

import lombok.Getter;

import java.util.UUID;

@Getter
public class Indicador {
    private UUID identificador;
    private String nombre;
    private TipoIndicador tipoIndicador;
    private Temporalidad temporalidad;
    private Proyecto proyecto;
    private PublicoInteres publicoInteres;

    private Indicador(UUID identificador, String nombre, TipoIndicador tipoIndicador, Temporalidad temporalidad, Proyecto proyecto, PublicoInteres publicoInteres) {
        this.identificador = identificador;
        this.nombre = nombre;
        this.tipoIndicador = tipoIndicador;
        this.temporalidad = temporalidad;
        this.proyecto = proyecto;
        this.publicoInteres = publicoInteres;
    }

    public static Indicador construir(UUID identificador, String nombre, TipoIndicador tipoIndicador, Temporalidad temporalidad, Proyecto proyecto, PublicoInteres publicoInteres) {
        return new Indicador(identificador, nombre, tipoIndicador, temporalidad, proyecto, publicoInteres);
    }
}