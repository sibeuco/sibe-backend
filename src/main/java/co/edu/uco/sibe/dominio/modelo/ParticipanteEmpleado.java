package co.edu.uco.sibe.dominio.modelo;

import java.util.UUID;

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
        setRelacionLaboral(relacionLaboral);
        setCentroCostos(centroCostos);
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

    public RelacionLaboral getRelacionLaboral() {
        return relacionLaboral;
    }

    public CentroCostos getCentroCostos() {
        return centroCostos;
    }

    private void setRelacionLaboral(RelacionLaboral relacionLaboral) {
        this.relacionLaboral = relacionLaboral;
    }

    private void setCentroCostos(CentroCostos centroCostos) {
        this.centroCostos = centroCostos;
    }
}