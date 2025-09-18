package co.edu.uco.sibe.dominio.modelo;

import co.edu.uco.sibe.dominio.transversal.utilitarios.ValidadorNumero;
import co.edu.uco.sibe.dominio.transversal.utilitarios.ValidadorTexto;

import java.util.UUID;

public class Accion {
    private UUID identificador;
    private String detalle;
    private String objetivo;

    private Accion(UUID identificador, String detalle, String objetivo) {
        setIdentificador(identificador);
        setDetalle(detalle);
        setObjetivo(objetivo);
    }

    public static Accion construir(UUID identificador, String detalle, String objetivo) {
        return new Accion(identificador, detalle, objetivo);
    }

    public UUID getIdentificador() {
        return identificador;
    }

    public String getDetalle() {
        return detalle;
    }

    public String getObjetivo() {
        return objetivo;
    }

    private void setIdentificador(UUID identificador) {
        this.identificador = identificador;
    }

    private void setDetalle(String detalle) {
        ValidadorTexto.validarObligatorio(detalle, "");
        ValidadorTexto.validarTextoValido(detalle, "");
        ValidadorNumero.validarNumeroEntre(detalle.length(), 1, 30, "");

        this.detalle = detalle;
    }

    private void setObjetivo(String objetivo) {
        ValidadorTexto.validarObligatorio(objetivo, "");
        ValidadorTexto.validarTextoValido(objetivo, "");
        ValidadorNumero.validarNumeroEntre(objetivo.length(), 1, 30, "");

        this.objetivo = objetivo;
    }
}