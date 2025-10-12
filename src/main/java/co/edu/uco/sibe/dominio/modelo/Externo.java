package co.edu.uco.sibe.dominio.modelo;

import lombok.Getter;
import java.util.UUID;

@Getter
public class Externo extends Miembro {
    private Externo(UUID identificador, String nombreCompleto, String numeroIdentificacion) {
        super(identificador, nombreCompleto, numeroIdentificacion);
    }

    public static Externo construir(UUID identificador, String nombreCompleto, String numeroIdentificacion) {
        return new Externo(identificador, nombreCompleto, numeroIdentificacion);
    }
}