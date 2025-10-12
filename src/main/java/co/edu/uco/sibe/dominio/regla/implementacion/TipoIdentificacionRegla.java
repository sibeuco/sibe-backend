package co.edu.uco.sibe.dominio.regla.implementacion;

import co.edu.uco.sibe.dominio.modelo.TipoIdentificacion;
import co.edu.uco.sibe.dominio.regla.Regla;
import co.edu.uco.sibe.dominio.transversal.utilitarios.Mensajes;
import co.edu.uco.sibe.dominio.transversal.utilitarios.ValidadorNumero;
import co.edu.uco.sibe.dominio.transversal.utilitarios.ValidadorObjeto;
import co.edu.uco.sibe.dominio.transversal.utilitarios.ValidadorTexto;

import java.util.UUID;

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
        ValidadorObjeto.validarObligatorio(identificador, "");
    }

    @Override
    public void validarCampos(TipoIdentificacion modelo) {
        validarigla(modelo.getSigla());
        validarDescripcion(modelo.getDescripcion());
    }

    private void validarigla(String sigla) {
        ValidadorTexto.validarObligatorio(sigla, Mensajes.CAMPO_OBLIGATORIO);
        ValidadorTexto.validarTextoValido(sigla, Mensajes.PATRON_SIGLA_TIPO_IDENTIFICACION_INVALIDO);
        ValidadorNumero.validarNumeroEntre(sigla.length(), 1, 6, Mensajes.LONGITUD_SIGLA_TIPO_IDENTIFICACION_INVALIDA);
    }

    private void validarDescripcion(String descripcion) {
        ValidadorTexto.validarObligatorio(descripcion, Mensajes.CAMPO_OBLIGATORIO);
        ValidadorTexto.validarTextoValido(descripcion, Mensajes.PATRON_DESCIPCION_TIPO_IDENTIFICACION_INVALIDO);
        ValidadorNumero.validarNumeroEntre(descripcion.length(), 1, 30, Mensajes.LONGITUD_DESCRIPCION_TIPO_IDENTIFICACION_INVALIDA);
    }
}