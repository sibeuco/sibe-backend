package co.edu.uco.sibe.dominio.modelo;

import lombok.Getter;
import java.util.UUID;

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
        return new RelacionLaboral(identificador, codigo, descripcion);
    }
}