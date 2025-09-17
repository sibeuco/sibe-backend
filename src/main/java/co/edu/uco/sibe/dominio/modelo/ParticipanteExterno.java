package co.edu.uco.sibe.dominio.modelo;

import java.util.UUID;

public class ParticipanteExterno extends Participante {
    private ParticipanteExterno(UUID identificador, Miembro miembro) {
        super(identificador, miembro);
    }

    public static ParticipanteExterno construir(UUID identificador, Miembro miembro) {
        return new ParticipanteExterno(identificador, miembro);
    }
}