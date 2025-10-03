package co.edu.uco.sibe.dominio.modelo;

import co.edu.uco.sibe.dominio.transversal.utilitarios.Mensajes;
import co.edu.uco.sibe.dominio.transversal.utilitarios.ValidadorNumero;
import co.edu.uco.sibe.dominio.transversal.utilitarios.ValidadorTexto;

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
        ValidadorTexto.validarObligatorio(nombres, Mensajes.PRIMER_NOMBRE_PERSONA_VACIO);
        ValidadorTexto.validarTextoValido(nombres, Mensajes.PATRON_NOMBRE_PERSONA_INVALIDO);
        ValidadorNumero.validarNumeroEntre(nombres.length(), 1, 50, Mensajes.LONGITUD_NOMBRE_PERSONA_INVALIDA);

        this.nombres = nombres;
    }

    private void setApellidos(String apellidos) {
        ValidadorTexto.validarObligatorio(nombres, Mensajes.PRIMER_APELLIDO_PERSONA_VACIO);
        ValidadorTexto.validarTextoValido(nombres, Mensajes.PATRON_APELLIDO_PERSONA_INVALIDO);
        ValidadorNumero.validarNumeroEntre(nombres.length(), 1, 50, Mensajes.LONGITUD_APELLIDO_PERSONA_INVALIDA);

        this.apellidos = apellidos;
    }

    private void setCorreo(String correo) {
        ValidadorTexto.validarObligatorio(nombres, Mensajes.CORREO_USUARIO_VACIO);
        ValidadorTexto.validarCorreoValido(nombres, Mensajes.PATRON_CORREO_INVALIDO);
        ValidadorNumero.validarNumeroEntre(nombres.length(), 10, 100, Mensajes.LONGITUD_CORREO_PERSONA_INVALIDA);

        this.correo = correo;
    }

    private void setIdentificacion(Identificacion identificacion) {
        this.identificacion = identificacion;
    }
}