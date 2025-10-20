package co.edu.uco.sibe.dominio.modelo;

import co.edu.uco.sibe.dominio.transversal.utilitarios.UtilUUID;
import co.edu.uco.sibe.dominio.transversal.utilitarios.ValidadorTexto;
import lombok.Getter;

import java.util.UUID;

import static co.edu.uco.sibe.dominio.transversal.constante.TextoConstante.VACIO;

@Getter
public class Temporalidad {
    private UUID identificador;
    private String nombre;

    private Temporalidad(UUID identificador, String nombre) {
        this.identificador = identificador;
        this.nombre = nombre;
    }

    public static Temporalidad construir(UUID identificador, String nombre) {
        return new Temporalidad(
                identificador,
                ValidadorTexto.obtenerValorPorDefecto(nombre)
        );
    }

    public static Temporalidad construir() {
        return new Temporalidad(
                UtilUUID.obtenerValorDefecto(),
                VACIO
        );
    }
}