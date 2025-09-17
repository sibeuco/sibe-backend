package co.edu.uco.sibe.dominio.modelo;

import java.util.UUID;

public class Interno extends Miembro {
    private CiudadResidencia ciudadResidencia;
    private String idCarnet;
    private String sexo;

    protected Interno(UUID identificador, String nombreCompleto, String numeroIdentificacion, CiudadResidencia ciudadResidencia, String idCarnet, String sexo) {
        super(identificador, nombreCompleto, numeroIdentificacion);
        setCiudadResidencia(ciudadResidencia);
        setIdCarnet(idCarnet);
        setSexo(sexo);
    }

    public static Interno construir(UUID identificador, String nombreCompleto, String numeroIdentificacion, CiudadResidencia ciudadResidencia, String idCarnet, String sexo) {
        return new Interno(identificador, nombreCompleto, numeroIdentificacion, ciudadResidencia, idCarnet, sexo);
    }

    public CiudadResidencia getCiudadResidencia() {
        return ciudadResidencia;
    }

    public String getIdCarnet() {
        return idCarnet;
    }

    public String getSexo() {
        return sexo;
    }

    private void setCiudadResidencia(CiudadResidencia ciudadResidencia) {
        this.ciudadResidencia = ciudadResidencia;
    }

    private void setIdCarnet(String idCarnet) {
        this.idCarnet = idCarnet;
    }

    private void setSexo(String sexo) {
        this.sexo = sexo;
    }
}