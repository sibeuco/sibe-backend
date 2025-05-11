package co.edu.uco.sibe.dominio.modelo;

import java.util.UUID;

public class Usuario {
    private UUID identificador;
    private String correo;
    private String contrasena;
    private TipoUsuario tipoUsuario;
    private boolean estaActivo;
    private Area area;
    private Persona persona;
}
