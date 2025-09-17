package co.edu.uco.sibe.dominio.modelo;

import java.util.UUID;

public class Participante {
    private UUID identificador;
    private Miembro miembro;

    protected Participante(UUID identificador, Miembro miembro) {
        setIdentificador(identificador);
        setMiembro(miembro);
    }

    public static Participante construir(UUID identificador, Miembro miembro) {
        return new Participante(identificador, miembro);
    }

    public UUID getIdentificador() {
        return identificador;
    }

    public Miembro getMiembro() {
        return miembro;
    }

    private void setIdentificador(UUID identificador) {
        this.identificador = identificador;
    }

    private void setMiembro(Miembro miembro) {
        this.miembro = miembro;
    }
}