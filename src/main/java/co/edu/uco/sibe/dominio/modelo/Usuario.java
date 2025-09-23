package co.edu.uco.sibe.dominio.modelo;

import co.edu.uco.sibe.dominio.transversal.utilitarios.Mensajes;
import co.edu.uco.sibe.dominio.transversal.utilitarios.ValidadorNumero;
import co.edu.uco.sibe.dominio.transversal.utilitarios.ValidadorTexto;

import java.util.UUID;

public class Usuario {
    private UUID identificador;
    private String correo;
    private String clave;
    private TipoUsuario tipoUsuario;
    private Boolean estaActivo;

    private Usuario(UUID identificador, String correo, String clave, TipoUsuario tipoUsuario, Boolean estaActivo) {
        setIdentificador(identificador);
        setCorreo(correo);
        setClave(clave);
        setTipoUsuario(tipoUsuario);
        setEstaActivo(estaActivo);
    }

    public static Usuario construir(UUID identificador, String correo, String clave, TipoUsuario tipoUsuario, Boolean estaActivo) {
        return new Usuario(identificador, correo, clave, tipoUsuario, estaActivo);
    }

    public UUID getIdentificador() {
        return identificador;
    }

    public String getCorreo() {
        return correo;
    }

    public String getClave() {
        return clave;
    }

    public TipoUsuario getTipoUsuario() {
        return tipoUsuario;
    }

    public Boolean getEstaActivo() {
        return estaActivo;
    }

    private void setIdentificador(UUID identificador) {
        this.identificador = identificador;
    }

    private void setCorreo(String correo) {
        ValidadorTexto.validarObligatorio(correo, Mensajes.CORREO_USUARIO_VACIO);
        ValidadorTexto.validarCorreoValido(correo, Mensajes.PATRON_CORREO_INVALIDO);
        ValidadorNumero.validarNumeroEntre(correo.length(), 10, 100, "");

        this.correo = correo;
    }

    private void setClave(String clave) {
        ValidadorTexto.validarObligatorio(clave, Mensajes.CONTRASENA_VACIA);
        ValidadorTexto.validarClaveValida(clave, Mensajes.PATRON_CONTRASENA_INVALIDO);
        ValidadorNumero.validarNumeroEntre(clave.length(), 8, 20, "");

        this.clave = clave;
    }

    private void setTipoUsuario(TipoUsuario tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    private void setEstaActivo(Boolean estaActivo) {
        this.estaActivo = estaActivo;
    }
}