package co.edu.uco.sibe.dominio.modelo;

import co.edu.uco.sibe.dominio.transversal.constante.TextoConstante;
import co.edu.uco.sibe.dominio.transversal.utilitarios.UtilUUID;
import co.edu.uco.sibe.dominio.transversal.utilitarios.ValidadorObjeto;
import co.edu.uco.sibe.dominio.transversal.utilitarios.ValidadorTexto;
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
                ValidadorObjeto.obtenerValorPorDefecto(miembro, Miembro.construir()),
                ValidadorObjeto.obtenerValorPorDefecto(ciudadResidencia, CiudadResidencia.construir()),
                ValidadorTexto.obtenerValorPorDefecto(idCarnet),
                ValidadorTexto.obtenerValorPorDefecto(sexo),
                ValidadorObjeto.obtenerValorPorDefecto(relacionLaboral, RelacionLaboral.construir()),
                ValidadorObjeto.obtenerValorPorDefecto(centroCostos, CentroCostos.construir())
        );
    }

    public static ParticipanteEmpleado construir() {
        return new ParticipanteEmpleado(
                UtilUUID.obtenerValorDefecto(),
                Miembro.construir(),
                CiudadResidencia.construir(),
                TextoConstante.VACIO,
                TextoConstante.VACIO,
                RelacionLaboral.construir(),
                CentroCostos.construir()
        );
    }
}