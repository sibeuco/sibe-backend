package co.edu.uco.sibe.dominio.modelo;

import co.edu.uco.sibe.dominio.transversal.utilitarios.UtilUUID;
import co.edu.uco.sibe.dominio.transversal.utilitarios.ValidadorObjeto;
import co.edu.uco.sibe.dominio.transversal.utilitarios.ValidadorTexto;
import lombok.Getter;

import java.util.UUID;

import static co.edu.uco.sibe.dominio.transversal.constante.TextoConstante.VACIO;

@Getter
public class Interno extends Miembro {
    private CiudadResidencia ciudadResidencia;
    private String idCarnet;
    private String sexo;

    protected Interno(UUID identificador, String nombreCompleto, String numeroIdentificacion, CiudadResidencia ciudadResidencia, String idCarnet, String sexo) {
        super(identificador, nombreCompleto, numeroIdentificacion);
        this.ciudadResidencia = ciudadResidencia;
        this.idCarnet = idCarnet;
        this.sexo = sexo;
    }

    public static Interno construir(UUID identificador, String nombreCompleto, String numeroIdentificacion, CiudadResidencia ciudadResidencia, String idCarnet, String sexo) {
        return new Interno(
                identificador,
                ValidadorTexto.obtenerValorPorDefecto(nombreCompleto),
                ValidadorTexto.obtenerValorPorDefecto(numeroIdentificacion),
                ValidadorObjeto.obtenerValorPorDefecto(ciudadResidencia, CiudadResidencia.construir()),
                ValidadorTexto.obtenerValorPorDefecto(idCarnet),
                ValidadorTexto.obtenerValorPorDefecto(sexo)
        );
    }

    public static Interno construir() {
        return new Interno(
                UtilUUID.obtenerValorDefecto(),
                VACIO,
                VACIO,
                CiudadResidencia.construir(),
                VACIO,
                VACIO
        );
    }
}