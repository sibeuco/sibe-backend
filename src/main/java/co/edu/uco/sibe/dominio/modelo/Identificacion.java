package co.edu.uco.sibe.dominio.modelo;

import co.edu.uco.sibe.dominio.transversal.utilitarios.Mensajes;
import co.edu.uco.sibe.dominio.transversal.utilitarios.ValidadorNumero;
import co.edu.uco.sibe.dominio.transversal.utilitarios.ValidadorTexto;

import java.util.UUID;

public class Identificacion {
    private UUID identificador;
    private String numeroIdentificacion;
    private TipoIdentificacion tipoIdentificacion;

    private Identificacion(UUID identificador, String numeroIdentificacion, TipoIdentificacion tipoIdentificacion) {
        setIdentificador(identificador);
        setNumeroIdentificacion(numeroIdentificacion);
        setTipoIdentificacion(tipoIdentificacion);
    }

    public static Identificacion construir(UUID identificador, String numeroIdentificacion, TipoIdentificacion tipoIdentificacion) {
        return new Identificacion(identificador, numeroIdentificacion, tipoIdentificacion);
    }

    public UUID getIdentificador() {
        return identificador;
    }

    public String getNumeroIdentificacion() {
        return numeroIdentificacion;
    }

    public TipoIdentificacion getTipoIdentificacion() {
        return tipoIdentificacion;
    }

    private void setIdentificador(UUID identificador) {
        this.identificador = identificador;
    }

    private void setNumeroIdentificacion(String numeroIdentificacion) {
        ValidadorTexto.validarObligatorio(numeroIdentificacion, Mensajes.DOCUMENTO_PERSONA_VACIO);
        ValidadorTexto.validarNumeroIdentificacionValido(numeroIdentificacion, Mensajes.PATRON_DOCUMENTO_PERSONA_INVALIDO);
        ValidadorNumero.validarNumeroEntre(numeroIdentificacion.length(), 1, 10, "");

        this.numeroIdentificacion = numeroIdentificacion;
    }

    private void setTipoIdentificacion(TipoIdentificacion tipoIdentificacion) {
        this.tipoIdentificacion = tipoIdentificacion;
    }
}