package co.edu.uco.sibe.dominio.modelo;

import co.edu.uco.sibe.dominio.transversal.utilitarios.UtilUUID;
import co.edu.uco.sibe.dominio.transversal.utilitarios.ValidadorObjeto;
import co.edu.uco.sibe.dominio.transversal.utilitarios.ValidadorTexto;
import lombok.Getter;

import java.util.UUID;

import static co.edu.uco.sibe.dominio.transversal.constante.TextoConstante.VACIO;

@Getter
public class Identificacion {
    private UUID identificador;
    private String numeroIdentificacion;
    private TipoIdentificacion tipoIdentificacion;

    private Identificacion(UUID identificador, String numeroIdentificacion, TipoIdentificacion tipoIdentificacion) {
        this.identificador = identificador;
        this.numeroIdentificacion = numeroIdentificacion;
        this.tipoIdentificacion = tipoIdentificacion;
    }

    public static Identificacion construir(UUID identificador, String numeroIdentificacion, TipoIdentificacion tipoIdentificacion) {
        return new Identificacion(
                identificador,
                ValidadorTexto.obtenerValorPorDefecto(numeroIdentificacion),
                ValidadorObjeto.obtenerValorPorDefecto(tipoIdentificacion, TipoIdentificacion.construir())
        );
    }

    public static Identificacion construir() {
        return new Identificacion(
                UtilUUID.obtenerValorDefecto(),
                VACIO, TipoIdentificacion.construir()
        );
    }
}