package co.edu.uco.sibe.dominio.modelo;

import java.util.UUID;

public class Empleado extends Interno {
    private RelacionLaboral relacionLaboral;
    private CentroCostos centroCostos;

    private Empleado(
            UUID identificador,
            String nombreCompleto,
            String numeroIdentificacion,
            CiudadResidencia ciudadResidencia,
            String idCarnet,
            String sexo,
            RelacionLaboral relacionLaboral,
            CentroCostos centroCostos
    ) {
        super(identificador, nombreCompleto, numeroIdentificacion, ciudadResidencia, idCarnet, sexo);
        setRelacionLaboral(relacionLaboral);
        setCentroCostos(centroCostos);
    }

    public static Empleado construir(
            UUID identificador,
            String nombreCompleto,
            String numeroIdentificacion,
            CiudadResidencia ciudadResidencia,
            String idCarnet,
            String sexo,
            RelacionLaboral relacionLaboral,
            CentroCostos centroCostos
    ) {
        return new Empleado(identificador, nombreCompleto, numeroIdentificacion, ciudadResidencia, idCarnet, sexo, relacionLaboral, centroCostos);
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