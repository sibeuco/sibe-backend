package co.edu.uco.sibe.dominio.regla.implementacion;

import co.edu.uco.sibe.dominio.modelo.Empleado;
import co.edu.uco.sibe.dominio.regla.Regla;
import co.edu.uco.sibe.dominio.transversal.utilitarios.Mensajes;
import co.edu.uco.sibe.dominio.transversal.utilitarios.ValidadorNumero;
import co.edu.uco.sibe.dominio.transversal.utilitarios.ValidadorObjeto;
import co.edu.uco.sibe.dominio.transversal.utilitarios.ValidadorTexto;

import java.util.UUID;

public class ExternoRegla implements Regla<Empleado> {
    @Override
    public void validarIdentificador(UUID identificador) {
        ValidadorObjeto.validarObligatorio(identificador, "");
    }

    @Override
    public void validarCampos(Empleado modelo) {
        validarNombreCompleto(modelo.getNombreCompleto());
        validarNumeroIdentificacion(modelo.getNumeroIdentificacion());
    }

    private void validarNombreCompleto(String nombreCompleto) {
        ValidadorTexto.validarObligatorio(nombreCompleto, Mensajes.NOMBRE_COMPLETO_MIEMBRO_OBLIGATORIO);
        ValidadorTexto.validarTextoValido(nombreCompleto, Mensajes.NOMBRE_COMPLETO_MIEMBRO_INVALIDO);
        ValidadorNumero.validarNumeroEntre(nombreCompleto.length(), 5, 100, Mensajes.LONGITUD_NOMBRE_COMPLETO_MIEMBRO_INVALIDA);
    }

    private void validarNumeroIdentificacion(String numeroIdentificacion) {
        ValidadorTexto.validarObligatorio(numeroIdentificacion, Mensajes.NUMERO_IDENTIFICACION_MIEMBRO_OBLIGATORIO);
        ValidadorTexto.validarNumeroIdentificacionValido(numeroIdentificacion, Mensajes.NUMERO_IDENTIFICACION_MIEMBRO_INVALIDO);
        ValidadorNumero.validarNumeroEntre(numeroIdentificacion.length(), 6, 12, Mensajes.LONGITUD_NUMERO_IDENTIFICACION_MIEMBRO_INVALIDA);
    }
}