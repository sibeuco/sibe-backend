package co.edu.uco.sibe.dominio.regla.implementacion;

import co.edu.uco.sibe.dominio.modelo.Accion;
import co.edu.uco.sibe.dominio.regla.Regla;
import co.edu.uco.sibe.dominio.transversal.utilitarios.ValidadorNumero;
import co.edu.uco.sibe.dominio.transversal.utilitarios.ValidadorObjeto;
import co.edu.uco.sibe.dominio.transversal.utilitarios.ValidadorTexto;
import java.util.UUID;
import static co.edu.uco.sibe.dominio.transversal.utilitarios.UtilMensaje.*;

public final class AccionRegla implements Regla<Accion> {
    private static final AccionRegla INSTANCIA = new AccionRegla();

    private AccionRegla() {
        super();
    }

    public static AccionRegla obtenerInstancia() {
        return INSTANCIA;
    }

    @Override
    public void validarIdentificador(UUID identificador) {
        ValidadorObjeto.validarObligatorio(identificador, IDENTIFICADOR_ACCION_NULO);
    }

    @Override
    public void validarCampos(Accion modelo) {
        validarDetalle(modelo.getDetalle());
        validarObjetivo(modelo.getObjetivo());
    }

    private void validarDetalle(String detalle) {
        ValidadorTexto.validarObligatorio(detalle, DETALLE_ACCION_OBLIGATORIO);
        ValidadorTexto.validarTextoAlfanumericoValido(detalle, DETALLE_ACCION_INVALIDO);
        ValidadorNumero.validarNumeroEntre(detalle.length(), 10, 500, LONGITUD_DETALLE_ACCION_INVALIDA);
    }

    private void validarObjetivo(String objetivo) {
        ValidadorTexto.validarObligatorio(objetivo, OBJETIVO_ACCION_OBLIGATORIO);
        ValidadorTexto.validarTextoAlfanumericoValido(objetivo, OBJETIVO_ACCION_INVALIDO);
        ValidadorNumero.validarNumeroEntre(objetivo.length(), 10, 500, LONGITUD_OBJETIVO_ACCION_INVALIDA);
    }
}