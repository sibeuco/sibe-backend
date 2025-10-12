package co.edu.uco.sibe.dominio.modelo;

import lombok.Getter;

import java.util.UUID;

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
        return new Interno(identificador, nombreCompleto, numeroIdentificacion, ciudadResidencia, idCarnet, sexo);
    }
}