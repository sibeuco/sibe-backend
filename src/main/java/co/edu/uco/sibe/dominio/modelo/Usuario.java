package co.edu.uco.sibe.dominio.modelo;

import co.edu.uco.sibe.dominio.transversal.utilitarios.UtilUUID;
import co.edu.uco.sibe.dominio.transversal.utilitarios.ValidadorObjeto;
import co.edu.uco.sibe.dominio.transversal.utilitarios.ValidadorTexto;
import lombok.Getter;

import java.util.UUID;

import static co.edu.uco.sibe.dominio.transversal.constante.TextoConstante.VACIO;

@Getter
public class Usuario {
    private UUID identificador;
    private String correo;
    private String clave;
    private TipoUsuario tipoUsuario;
    private boolean estaActivo;

    private Usuario(UUID identificador, String correo, String clave, TipoUsuario tipoUsuario, boolean estaActivo) {
        this.identificador = identificador;
        this.correo = correo;
        this.clave = clave;
        this.tipoUsuario = tipoUsuario;
        this.estaActivo = estaActivo;
    }

    public static Usuario construir(UUID identificador, String correo, String clave, TipoUsuario tipoUsuario, boolean estaActivo) {
        return new Usuario(
                identificador,
                ValidadorTexto.obtenerValorPorDefecto(correo),
                ValidadorTexto.obtenerValorPorDefecto(clave),
                ValidadorObjeto.obtenerValorPorDefecto(tipoUsuario, TipoUsuario.construir()),
                estaActivo
        );
    }

    public static Usuario construir() {
        return new Usuario(
                UtilUUID.obtenerValorDefecto(),
                VACIO,
                VACIO,
                TipoUsuario.construir(),
                false
        );
    }
}