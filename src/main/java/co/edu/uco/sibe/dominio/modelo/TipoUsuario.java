package co.edu.uco.sibe.dominio.modelo;

import co.edu.uco.sibe.dominio.transversal.constante.TextoConstante;
import co.edu.uco.sibe.dominio.transversal.utilitarios.UtilUUID;
import co.edu.uco.sibe.dominio.transversal.utilitarios.ValidadorTexto;
import lombok.Getter;
import java.util.UUID;

@Getter
public class TipoUsuario {
    private UUID identificador;
    private String nombre;
    private boolean crear;
    private boolean modificar;
    private boolean eliminar;
    private boolean consultar;

    private TipoUsuario(UUID identificador, String nombre, boolean crear, boolean modificar, boolean eliminar, boolean consultar) {
        this.identificador = identificador;
        this.nombre = nombre;
        this.crear = crear;
        this.modificar = modificar;
        this.eliminar = eliminar;
        this.consultar = consultar;
    }

    public static TipoUsuario construir(UUID identificador, String nombre, boolean crear, boolean modificar, boolean eliminar, boolean consultar) {
        return new TipoUsuario(
                identificador,
                ValidadorTexto.obtenerValorPorDefecto(nombre),
                crear,
                modificar,
                eliminar,
                consultar
        );
    }

    public static TipoUsuario construir() {
        return new TipoUsuario(
                UtilUUID.obtenerValorDefecto(),
                TextoConstante.VACIO,
                false,
                false,
                false,
                false
        );
    }
}