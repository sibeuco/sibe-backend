package co.edu.uco.sibe.dominio.modelo;

import lombok.Getter;

import java.util.UUID;

@Getter
public class Usuario {
    private UUID identificador;
    private String correo;
    private String clave;
    private TipoUsuario tipoUsuario;
    private Boolean estaActivo;

    private Usuario(UUID identificador, String correo, String clave, TipoUsuario tipoUsuario, Boolean estaActivo) {
        this.identificador = identificador;
        this.correo = correo;
        this.clave = clave;
        this.tipoUsuario = tipoUsuario;
        this.estaActivo = estaActivo;
    }

    public static Usuario construir(UUID identificador, String correo, String clave, TipoUsuario tipoUsuario, Boolean estaActivo) {
        return new Usuario(identificador, correo, clave, tipoUsuario, estaActivo);
    }
}