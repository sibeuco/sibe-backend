package co.edu.uco.sibe.dominio.modelo;

import co.edu.uco.sibe.dominio.transversal.utilitarios.ValidadorNumero;
import co.edu.uco.sibe.dominio.transversal.utilitarios.ValidadorTexto;

import java.util.UUID;

public class ParticipanteInterno extends Participante {
    private CiudadResidencia ciudadResidencia;
    private String idCarnet;
    private String sexo;

    protected ParticipanteInterno(UUID identificador, Miembro miembro, CiudadResidencia ciudadResidencia, String idCarnet, String sexo) {
        super(identificador, miembro);
        setCiudadResidencia(ciudadResidencia);
        setIdCarnet(idCarnet);
        setSexo(sexo);
    }

    public static ParticipanteInterno construir(UUID identificador, Miembro miembro, CiudadResidencia ciudadResidencia, String idCarnet, String sexo) {
        return new ParticipanteInterno(identificador, miembro, ciudadResidencia, idCarnet, sexo);
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
        ValidadorNumero.validarNumeroEntre(idCarnet.length(), 1, 50, "");

        this.idCarnet = idCarnet;
    }

    private void setSexo(String sexo) {
        ValidadorTexto.validarObligatorio(sexo, "");
        ValidadorTexto.validarTextoValido(sexo, "");
        ValidadorNumero.validarNumeroEntre(sexo.length(), 1, 1, "");

        this.sexo = sexo;
    }
}