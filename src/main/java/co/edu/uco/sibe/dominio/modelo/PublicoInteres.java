package co.edu.uco.sibe.dominio.modelo;

import co.edu.uco.sibe.dominio.transversal.utilitarios.UtilUUID;
import co.edu.uco.sibe.dominio.transversal.utilitarios.ValidadorTexto;
import lombok.Getter;

import java.util.UUID;

import static co.edu.uco.sibe.dominio.transversal.constante.TextoConstante.VACIO;

@Getter
public class PublicoInteres {
    private UUID identificador;
    private String nombre;

    public PublicoInteres(UUID identificador, String nombre) {
        this.identificador = identificador;
        this.nombre = nombre;
    }

    public static PublicoInteres construir(UUID identificador, String nombre) {
        return new PublicoInteres(
                identificador,
                ValidadorTexto.obtenerValorPorDefecto(nombre)
        );
    }

    public static PublicoInteres construir() {
        return new PublicoInteres(
                UtilUUID.obtenerValorDefecto(),
                VACIO
        );
    }
}