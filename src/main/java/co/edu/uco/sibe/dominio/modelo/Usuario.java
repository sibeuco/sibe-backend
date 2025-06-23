package co.edu.uco.sibe.dominio.modelo;

import co.edu.uco.sibe.dominio.transversal.utilitarios.Mensajes;
import co.edu.uco.sibe.dominio.transversal.utilitarios.UtilTexto;
import co.edu.uco.sibe.dominio.transversal.utilitarios.UtilUUID;
import lombok.Getter;

import java.util.UUID;

@Getter
public class Usuario {
    private UUID identificador;
    private String correo;
    private String contrasena;
    private TipoUsuario tipoUsuario;
    private boolean estaActivo;

    private Usuario(UUID identificador, String correo, String contrasena, TipoUsuario tipoUsuario, boolean estaActivo) {
        setIdentificador(identificador);
        setCorreo(correo);
        setContrasena(contrasena);
        setTipoUsuario(tipoUsuario);
        setEstaActivo(estaActivo);
    }

    public static Usuario construir(UUID identificador, String correo, String contrasena, TipoUsuario tipoUsuario) {
        return new Usuario(identificador, correo, contrasena, tipoUsuario, true);
    }

    public void setIdentificador(UUID identificador) {
        this.identificador = UtilUUID.obtenerValorDefecto(identificador);
    }

    public void setCorreo(String correo) {
        UtilTexto.getInstance().validarObligatorio(correo, Mensajes.CORREO_USUARIO_VACIO);
        UtilTexto.getInstance().validarCorreoEsValido(correo, Mensajes.PATRON_CORREO_INVALIDO);
        this.correo = UtilTexto.getInstance().quitarEspaciosBlancoInicioFin(correo);
    }

    public void setContrasena(String contrasena) {
        UtilTexto.getInstance().validarObligatorio(contrasena, Mensajes.CONTRASENA_VACIA);
        UtilTexto.getInstance().validarContrasenaEsValida(contrasena, Mensajes.PATRON_CONTRASENA_INVALIDO);
        this.contrasena = UtilTexto.getInstance().quitarEspaciosBlancoInicioFin(contrasena);
    }

    public void setTipoUsuario(TipoUsuario tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public void setEstaActivo(boolean estaActivo) {
        this.estaActivo = estaActivo;
    }

}
