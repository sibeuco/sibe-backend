package co.edu.uco.sibe.dominio.modelo;

import lombok.Getter;
import java.util.UUID;

@Getter
public class Identificacion {
    private UUID identificador;
    private String numeroIdentificacion;
    private TipoIdentificacion tipoIdentificacion;

    private Identificacion(UUID identificador, String numeroIdentificacion, TipoIdentificacion tipoIdentificacion) {
        this.identificador = identificador;
        this.numeroIdentificacion = numeroIdentificacion;
        this.tipoIdentificacion = tipoIdentificacion;
    }

    public static Identificacion construir(UUID identificador, String numeroIdentificacion, TipoIdentificacion tipoIdentificacion) {
        return new Identificacion(identificador, numeroIdentificacion, tipoIdentificacion);
    }
}