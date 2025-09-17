package co.edu.uco.sibe.dominio.modelo;

import java.util.UUID;

public class Persona {
    private UUID identificador;
    private String nombres;
    private String apellidos;
    private String correo;
    private Identificacion identificacion;

    private Persona(UUID identificador, String nombres, String apellidos, String correo, Identificacion identificacion) {
        setIdentificador(identificador);
        setNombres(nombres);
        setApellidos(apellidos);
        setCorreo(correo);
        setIdentificacion(identificacion);
    }

    public static Persona construir(UUID identificador, String nombres, String apellidos, String correo, Identificacion identificacion) {
        return new Persona(identificador, nombres, apellidos, correo, identificacion);
    }

    public UUID getIdentificador() {
        return identificador;
    }

    public String getNombres() {
        return nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getCorreo() {
        return correo;
    }

    public Identificacion getIdentificacion() {
        return identificacion;
    }

    private void setIdentificador(UUID identificador) {
        this.identificador = identificador;
    }

    private void setNombres(String nombres) {
        this.nombres = nombres;
    }

    private void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    private void setCorreo(String correo) {
        this.correo = correo;
    }

    private void setIdentificacion(Identificacion identificacion) {
        this.identificacion = identificacion;
    }
}