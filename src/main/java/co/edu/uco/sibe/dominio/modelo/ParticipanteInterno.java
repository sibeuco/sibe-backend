package co.edu.uco.sibe.dominio.modelo;

import lombok.Getter;

import java.util.UUID;

@Getter
public class ParticipanteInterno extends Participante {
    private CiudadResidencia ciudadResidencia;
    private String idCarnet;
    private String sexo;

    protected ParticipanteInterno(UUID identificador, Miembro miembro, CiudadResidencia ciudadResidencia, String idCarnet, String sexo) {
        super(identificador, miembro);
        this.ciudadResidencia = ciudadResidencia;
        this.idCarnet = idCarnet;
        this.sexo = sexo;
    }

    public static ParticipanteInterno construir(UUID identificador, Miembro miembro, CiudadResidencia ciudadResidencia, String idCarnet, String sexo) {
        return new ParticipanteInterno(identificador, miembro, ciudadResidencia, idCarnet, sexo);
    }
}