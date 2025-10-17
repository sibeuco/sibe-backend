package co.edu.uco.sibe.dominio.regla.implementacion;

import co.edu.uco.sibe.dominio.modelo.Identificacion;
import co.edu.uco.sibe.dominio.regla.Regla;
import co.edu.uco.sibe.dominio.transversal.utilitarios.UtilMensaje;
import co.edu.uco.sibe.dominio.transversal.utilitarios.ValidadorNumero;
import co.edu.uco.sibe.dominio.transversal.utilitarios.ValidadorObjeto;
import co.edu.uco.sibe.dominio.transversal.utilitarios.ValidadorTexto;

import java.util.UUID;

public final class IdentificacionRegla implements Regla<Identificacion> {
    private static final IdentificacionRegla INSTANCIA = new IdentificacionRegla();

    private IdentificacionRegla() {
        super();
    }

    public static IdentificacionRegla obtenerInstancia() {
        return INSTANCIA;
    }

    @Override
    public void validarIdentificador(UUID identificador) {
        ValidadorObjeto.validarObligatorio(identificador, UtilMensaje.IDENTIFICADOR_IDENTIFICACION_NULO);
    }

    @Override
    public void validarCampos(Identificacion modelo) {
        validarNumeroIdentificacion(modelo.getNumeroIdentificacion());
    }

    private void validarNumeroIdentificacion(String numeroIdentificacion) {
        ValidadorTexto.validarObligatorio(numeroIdentificacion, UtilMensaje.DOCUMENTO_PERSONA_VACIO);
        ValidadorTexto.validarNumeroIdentificacionValido(numeroIdentificacion, UtilMensaje.PATRON_DOCUMENTO_PERSONA_INVALIDO);
        ValidadorNumero.validarNumeroEntre(numeroIdentificacion.length(), 5, 12, "");
    }
}
