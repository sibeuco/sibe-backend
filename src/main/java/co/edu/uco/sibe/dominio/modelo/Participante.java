package co.edu.uco.sibe.dominio.modelo;

import lombok.Getter;

import java.util.UUID;

@Getter
public class Participante {
    private UUID identificador;
    private Miembro miembro;

    protected Participante(UUID identificador, Miembro miembro) {
        this.identificador = identificador;
        this.miembro = miembro;
    }

    public static Participante construir(UUID identificador, Miembro miembro) {
        return new Participante(identificador, miembro);
    }
}