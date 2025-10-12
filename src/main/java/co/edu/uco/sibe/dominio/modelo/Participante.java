package co.edu.uco.sibe.dominio.modelo;

import co.edu.uco.sibe.dominio.transversal.utilitarios.UtilUUID;
import co.edu.uco.sibe.dominio.transversal.utilitarios.ValidadorObjeto;
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
        return new Participante(identificador, ValidadorObjeto.obtenerValorPorDefecto(miembro, Miembro.construir()));
    }

    public static Participante construir() {
        return new Participante(UtilUUID.obtenerValorDefecto(), Miembro.construir());
    }
}