package co.edu.uco.sibe.dominio.modelo;

import lombok.Getter;

import java.util.UUID;

@Getter
public class Persona {
    private UUID identificador;
    private String nombres;
    private String apellidos;
    private String correo;
    private Identificacion identificacion;

    private Persona(UUID identificador, String nombres, String correo, String apellidos, Identificacion identificacion) {
        this.identificador = identificador;
        this.nombres = nombres;
        this.correo = correo;
        this.apellidos = apellidos;
        this.identificacion = identificacion;
    }

    public static Persona construir(UUID identificador, String nombres, String apellidos, String correo, Identificacion identificacion) {
        return new Persona(identificador, nombres, apellidos, correo, identificacion);
    }
}