package co.edu.uco.sibe.dominio.modelo;

import co.edu.uco.sibe.dominio.transversal.utilitarios.ValidadorNumero;
import co.edu.uco.sibe.dominio.transversal.utilitarios.ValidadorTexto;

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
        ValidadorTexto.validarObligatorio(idCarnet, "");
        ValidadorTexto.validarTextoAlfanumericoValido(idCarnet, "");
        ValidadorNumero.validarNumeroEntre(idCarnet.length(), 1, 20, "");

        this.idCarnet = idCarnet;
    }

    private void setSexo(String sexo) {
        ValidadorTexto.validarObligatorio(sexo, "");
        ValidadorTexto.validarTextoValido(sexo, "");
        ValidadorNumero.validarNumeroEntre(sexo.length(), 1, 1, "");

        this.sexo = sexo;
    }
}