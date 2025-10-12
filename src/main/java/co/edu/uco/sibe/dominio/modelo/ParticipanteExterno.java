package co.edu.uco.sibe.dominio.modelo;

import co.edu.uco.sibe.dominio.transversal.utilitarios.UtilUUID;
import co.edu.uco.sibe.dominio.transversal.utilitarios.ValidadorObjeto;
import lombok.Getter;
import java.util.UUID;

@Getter
public class ParticipanteExterno extends Participante {
    private ParticipanteExterno(UUID identificador, Miembro miembro) {
        super(identificador, miembro);
    }

    public static ParticipanteExterno construir(UUID identificador, Miembro miembro) {
        return new ParticipanteExterno(identificador, ValidadorObjeto.obtenerValorPorDefecto(miembro, Miembro.construir()));
    }

    public static ParticipanteExterno construir() {
        return new ParticipanteExterno(UtilUUID.obtenerValorDefecto(), Miembro.construir());
    }
}