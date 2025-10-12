package co.edu.uco.sibe.dominio.modelo;

import lombok.Getter;

import java.util.UUID;

@Getter
public class ParticipanteEmpleado extends ParticipanteInterno {
    private RelacionLaboral relacionLaboral;
    private CentroCostos centroCostos;

    private ParticipanteEmpleado(
            UUID identificador,
            Miembro miembro,
            CiudadResidencia ciudadResidencia,
            String idCarnet,
            String sexo,
            RelacionLaboral relacionLaboral,
            CentroCostos centroCostos
    ) {
        super(identificador, miembro, ciudadResidencia, idCarnet, sexo);
        this.relacionLaboral = relacionLaboral;
        this.centroCostos = centroCostos;
    }

    public static ParticipanteEmpleado construir(
            UUID identificador,
            Miembro miembro,
            CiudadResidencia ciudadResidencia,
            String idCarnet,
            String sexo,
            RelacionLaboral relacionLaboral,
            CentroCostos centroCostos
    ) {
        return new ParticipanteEmpleado(
                identificador,
                miembro,
                ciudadResidencia,
                idCarnet,
                sexo,
                relacionLaboral,
                centroCostos
        );
    }
}