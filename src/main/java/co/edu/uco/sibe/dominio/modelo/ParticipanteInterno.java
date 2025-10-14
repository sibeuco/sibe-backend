package co.edu.uco.sibe.dominio.modelo;

import co.edu.uco.sibe.dominio.transversal.constante.TextoConstante;
import co.edu.uco.sibe.dominio.transversal.utilitarios.UtilUUID;
import co.edu.uco.sibe.dominio.transversal.utilitarios.ValidadorObjeto;
import co.edu.uco.sibe.dominio.transversal.utilitarios.ValidadorTexto;
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
        return new ParticipanteInterno(
                identificador,
                ValidadorObjeto.obtenerValorPorDefecto(miembro, Miembro.construir()),
                ValidadorObjeto.obtenerValorPorDefecto(ciudadResidencia, CiudadResidencia.construir()),
                ValidadorTexto.obtenerValorPorDefecto(idCarnet),
                ValidadorTexto.obtenerValorPorDefecto(sexo)
        );
    }

    public static ParticipanteInterno construir() {
        return new ParticipanteInterno(
                UtilUUID.obtenerValorDefecto(),
                Miembro.construir(),
                CiudadResidencia.construir(),
                TextoConstante.VACIO,
                TextoConstante.VACIO
        );
    }
}