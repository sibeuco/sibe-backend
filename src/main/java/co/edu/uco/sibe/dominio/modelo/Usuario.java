package co.edu.uco.sibe.dominio.modelo;

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
        this.correo = correo;
    }

    private void setClave(String clave) {
        this.clave = clave;
    }

    private void setTipoUsuario(TipoUsuario tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    private void setEstaActivo(Boolean estaActivo) {
        this.estaActivo = estaActivo;
    }
}