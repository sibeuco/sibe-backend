package co.edu.uco.sibe.dominio.modelo;

import co.edu.uco.sibe.dominio.transversal.constante.TextoConstante;
import co.edu.uco.sibe.dominio.transversal.utilitarios.UtilUUID;
import co.edu.uco.sibe.dominio.transversal.utilitarios.ValidadorTexto;
import lombok.Getter;

import java.util.UUID;

@Getter
public class CiudadResidencia {
    private UUID identificador;
    private String descripcion;

    private CiudadResidencia(UUID identificador, String descripcion) {
        this.identificador = identificador;
        this.descripcion = descripcion;
    }

    public static CiudadResidencia construir(UUID identificador, String descripcion) {
        return new CiudadResidencia(
                identificador,
                ValidadorTexto.obtenerValorPorDefecto(descripcion)
        );
    }

    public static CiudadResidencia construir() {
        return new CiudadResidencia(
                UtilUUID.obtenerValorDefecto(),
                TextoConstante.VACIO
        );
    }
}