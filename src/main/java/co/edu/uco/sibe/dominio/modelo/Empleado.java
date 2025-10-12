package co.edu.uco.sibe.dominio.modelo;

import lombok.Getter;

import java.util.UUID;

@Getter
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
        this.relacionLaboral = relacionLaboral;
        this.centroCostos = centroCostos;
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
}