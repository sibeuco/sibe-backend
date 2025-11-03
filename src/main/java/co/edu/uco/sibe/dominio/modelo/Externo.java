package co.edu.uco.sibe.dominio.modelo;

import co.edu.uco.sibe.dominio.transversal.utilitarios.UtilUUID;
import co.edu.uco.sibe.dominio.transversal.utilitarios.ValidadorTexto;
import lombok.Getter;
import java.util.UUID;
import static co.edu.uco.sibe.dominio.transversal.constante.TextoConstante.VACIO;

@Getter
public class Externo extends Miembro {
    private Externo(UUID identificador, String nombreCompleto, String numeroIdentificacion) {
        super(identificador, nombreCompleto, numeroIdentificacion);
    }

    public static Externo construir(UUID identificador, String nombreCompleto, String numeroIdentificacion) {
        return new Externo(
                identificador,
                ValidadorTexto.obtenerValorPorDefecto(nombreCompleto),
                ValidadorTexto.obtenerValorPorDefecto(numeroIdentificacion)
        );
    }

    public static Externo construir() {
        return new Externo(
                UtilUUID.obtenerValorDefecto(),
                VACIO,
                VACIO
        );
    }
}