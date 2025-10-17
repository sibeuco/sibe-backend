package co.edu.uco.sibe.dominio.regla.implementacion;

import co.edu.uco.sibe.dominio.modelo.Externo;
import co.edu.uco.sibe.dominio.regla.Regla;
import co.edu.uco.sibe.dominio.transversal.utilitarios.UtilMensaje;
import co.edu.uco.sibe.dominio.transversal.utilitarios.ValidadorNumero;
import co.edu.uco.sibe.dominio.transversal.utilitarios.ValidadorObjeto;
import co.edu.uco.sibe.dominio.transversal.utilitarios.ValidadorTexto;

import java.util.UUID;

public class ExternoRegla implements Regla<Externo> {
    private static final ExternoRegla INSTANCIA = new ExternoRegla();

    private ExternoRegla() {
        super();
    }

    public static ExternoRegla obtenerInstancia() {
        return INSTANCIA;
    }

    @Override
    public void validarIdentificador(UUID identificador) {
        ValidadorObjeto.validarObligatorio(identificador, UtilMensaje.IDENTIFICADOR_EXTERNO_NULO);
    }

    @Override
    public void validarCampos(Externo modelo) {
        validarNombreCompleto(modelo.getNombreCompleto());
        validarNumeroIdentificacion(modelo.getNumeroIdentificacion());
    }

    private void validarNombreCompleto(String nombreCompleto) {
        ValidadorTexto.validarObligatorio(nombreCompleto, UtilMensaje.NOMBRE_COMPLETO_MIEMBRO_OBLIGATORIO);
        ValidadorTexto.validarTextoValido(nombreCompleto, UtilMensaje.NOMBRE_COMPLETO_MIEMBRO_INVALIDO);
        ValidadorNumero.validarNumeroEntre(nombreCompleto.length(), 5, 100, UtilMensaje.LONGITUD_NOMBRE_COMPLETO_MIEMBRO_INVALIDA);
    }

    private void validarNumeroIdentificacion(String numeroIdentificacion) {
        ValidadorTexto.validarObligatorio(numeroIdentificacion, UtilMensaje.NUMERO_IDENTIFICACION_MIEMBRO_OBLIGATORIO);
        ValidadorTexto.validarNumeroIdentificacionValido(numeroIdentificacion, UtilMensaje.NUMERO_IDENTIFICACION_MIEMBRO_INVALIDO);
        ValidadorNumero.validarNumeroEntre(numeroIdentificacion.length(), 6, 12, UtilMensaje.LONGITUD_NUMERO_IDENTIFICACION_MIEMBRO_INVALIDA);
    }
}