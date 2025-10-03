package co.edu.uco.sibe.dominio.modelo;

import co.edu.uco.sibe.dominio.transversal.utilitarios.Mensajes;
import co.edu.uco.sibe.dominio.transversal.utilitarios.ValidadorNumero;
import co.edu.uco.sibe.dominio.transversal.utilitarios.ValidadorTexto;

import java.util.UUID;

public class Miembro {
    private UUID identificador;
    private String nombreCompleto;
    private String numeroIdentificacion;

    protected Miembro(UUID identificador, String nombreCompleto, String numeroIdentificacion) {
        setIdentificador(identificador);
        setNombreCompleto(nombreCompleto);
        setNumeroIdentificacion(numeroIdentificacion);
    }

    public static Miembro construir(UUID identificador, String nombreCompleto, String numeroIdentificacion) {
        return new Miembro(identificador, nombreCompleto, numeroIdentificacion);
    }

    public UUID getIdentificador() {
        return identificador;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public String getNumeroIdentificacion() {
        return numeroIdentificacion;
    }

    private void setIdentificador(UUID identificador) {
        this.identificador = identificador;
    }

    private void setNombreCompleto(String nombreCompleto) {
        ValidadorTexto.validarObligatorio(nombreCompleto, Mensajes.NOMBRE_COMPLETO_MIEMBRO_OBLIGATORIO);
        ValidadorTexto.validarTextoValido(nombreCompleto, Mensajes.NOMBRE_COMPLETO_MIEMBRO_INVALIDO);
        ValidadorNumero.validarNumeroEntre(nombreCompleto.length(), 5, 100, Mensajes.LONGITUD_NOMBRE_COMPLETO_MIEMBRO_INVALIDA);

        this.nombreCompleto = nombreCompleto;
    }

    private void setNumeroIdentificacion(String numeroIdentificacion) {
        ValidadorTexto.validarObligatorio(numeroIdentificacion, Mensajes.NUMERO_IDENTIFICACION_MIEMBRO_OBLIGATORIO);
        ValidadorTexto.validarNumeroIdentificacionValido(numeroIdentificacion, Mensajes.NUMERO_IDENTIFICACION_MIEMBRO_INVALIDO);
        ValidadorNumero.validarNumeroEntre(numeroIdentificacion.length(), 6, 12, Mensajes.LONGITUD_NUMERO_IDENTIFICACION_MIEMBRO_INVALIDA);

        this.numeroIdentificacion = numeroIdentificacion;
    }
}