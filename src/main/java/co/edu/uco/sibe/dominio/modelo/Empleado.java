package co.edu.uco.sibe.dominio.modelo;

import co.edu.uco.sibe.dominio.transversal.constante.TextoConstante;
import co.edu.uco.sibe.dominio.transversal.utilitarios.UtilUUID;
import co.edu.uco.sibe.dominio.transversal.utilitarios.ValidadorObjeto;
import co.edu.uco.sibe.dominio.transversal.utilitarios.ValidadorTexto;
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
        return new Empleado(
                identificador,
                ValidadorTexto.obtenerValorPorDefecto(nombreCompleto),
                ValidadorTexto.obtenerValorPorDefecto(numeroIdentificacion),
                ValidadorObjeto.obtenerValorPorDefecto(ciudadResidencia, CiudadResidencia.construir()),
                ValidadorTexto.obtenerValorPorDefecto(idCarnet),
                ValidadorTexto.obtenerValorPorDefecto(sexo),
                ValidadorObjeto.obtenerValorPorDefecto(relacionLaboral, RelacionLaboral.construir()),
                ValidadorObjeto.obtenerValorPorDefecto(centroCostos, CentroCostos.construir())
        );
    }

    public static Empleado construir() {
        return new Empleado(
                UtilUUID.obtenerValorDefecto(),
                TextoConstante.VACIO,
                TextoConstante.VACIO,
                CiudadResidencia.construir(),
                TextoConstante.VACIO,
                TextoConstante.VACIO,
                RelacionLaboral.construir(),
                CentroCostos.construir()
        );
    }
}