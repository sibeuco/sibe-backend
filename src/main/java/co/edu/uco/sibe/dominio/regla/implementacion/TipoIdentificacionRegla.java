package co.edu.uco.sibe.dominio.regla.implementacion;

import co.edu.uco.sibe.dominio.modelo.TipoIdentificacion;
import co.edu.uco.sibe.dominio.regla.Regla;
import co.edu.uco.sibe.dominio.transversal.utilitarios.ValidadorNumero;
import co.edu.uco.sibe.dominio.transversal.utilitarios.ValidadorObjeto;
import co.edu.uco.sibe.dominio.transversal.utilitarios.ValidadorTexto;

import java.util.UUID;

import static co.edu.uco.sibe.dominio.transversal.utilitarios.UtilMensaje.*;

public final class TipoIdentificacionRegla implements Regla<TipoIdentificacion> {
    private static final TipoIdentificacionRegla INSTANCIA = new TipoIdentificacionRegla();

    private TipoIdentificacionRegla() {
        super();
    }

    public static TipoIdentificacionRegla obtenerInstancia() {
        return INSTANCIA;
    }

    @Override
    public void validarIdentificador(UUID identificador) {
        ValidadorObjeto.validarObligatorio(identificador, IDENTIFICADOR_TIPO_IDENTIFICACION_NULO);
    }

    @Override
    public void validarCampos(TipoIdentificacion modelo) {
        validarigla(modelo.getSigla());
        validarDescripcion(modelo.getDescripcion());
    }

    private void validarigla(String sigla) {
        ValidadorTexto.validarObligatorio(sigla, CAMPO_OBLIGATORIO);
        ValidadorTexto.validarTextoValido(sigla, PATRON_SIGLA_TIPO_IDENTIFICACION_INVALIDO);
        ValidadorNumero.validarNumeroEntre(sigla.length(), 1, 6, LONGITUD_SIGLA_TIPO_IDENTIFICACION_INVALIDA);
    }

    private void validarDescripcion(String descripcion) {
        ValidadorTexto.validarObligatorio(descripcion, CAMPO_OBLIGATORIO);
        ValidadorTexto.validarTextoValido(descripcion, PATRON_DESCIPCION_TIPO_IDENTIFICACION_INVALIDO);
        ValidadorNumero.validarNumeroEntre(descripcion.length(), 1, 30, LONGITUD_DESCRIPCION_TIPO_IDENTIFICACION_INVALIDA);
    }
}