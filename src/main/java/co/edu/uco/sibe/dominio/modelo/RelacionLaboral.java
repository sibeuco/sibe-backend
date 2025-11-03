package co.edu.uco.sibe.dominio.modelo;

import co.edu.uco.sibe.dominio.transversal.utilitarios.UtilUUID;
import co.edu.uco.sibe.dominio.transversal.utilitarios.ValidadorTexto;
import lombok.Getter;
import java.util.UUID;
import static co.edu.uco.sibe.dominio.transversal.constante.TextoConstante.VACIO;

@Getter
public class RelacionLaboral {
    private UUID identificador;
    private String codigo;
    private String descripcion;

    private RelacionLaboral(UUID identificador, String codigo, String descripcion) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.identificador = identificador;
    }

    public static RelacionLaboral construir(UUID identificador, String codigo, String descripcion) {
        return new RelacionLaboral(
                identificador,
                ValidadorTexto.obtenerValorPorDefecto(codigo),
                ValidadorTexto.obtenerValorPorDefecto(descripcion)
        );
    }

    public static RelacionLaboral construir() {
        return new RelacionLaboral(
                UtilUUID.obtenerValorDefecto(),
                VACIO,
                VACIO
        );
    }
}