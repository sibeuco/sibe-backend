package co.edu.uco.sibe.dominio.regla.implementacion;

import co.edu.uco.sibe.dominio.modelo.TipoIndicador;
import co.edu.uco.sibe.dominio.regla.Regla;
import co.edu.uco.sibe.dominio.transversal.utilitarios.UtilMensaje;
import co.edu.uco.sibe.dominio.transversal.utilitarios.ValidadorNumero;
import co.edu.uco.sibe.dominio.transversal.utilitarios.ValidadorObjeto;
import co.edu.uco.sibe.dominio.transversal.utilitarios.ValidadorTexto;
import java.util.UUID;

public final class TipoIndicadorRegla implements Regla<TipoIndicador> {
    private static final TipoIndicadorRegla INSTANCIA = new TipoIndicadorRegla();

    private TipoIndicadorRegla() {
        super();
    }

    public static TipoIndicadorRegla obtenerInstancia() {
        return INSTANCIA;
    }

    @Override
    public void validarIdentificador(UUID identificador) {
        ValidadorObjeto.validarObligatorio(identificador, UtilMensaje.IDENTIFICADOR_TIPO_INDICADOR_NULO);
    }

    @Override
    public void validarCampos(TipoIndicador modelo) {
        validarNaturalezaIndicador(modelo.getNaturaleza());
        validarTipologiaIndicador(modelo.getTipologia());
    }

    private void validarNaturalezaIndicador(String naturalezaIndicador) {
        ValidadorTexto.validarObligatorio(naturalezaIndicador, UtilMensaje.NATURALEZA_TIPO_INDICADOR_OBLIGATORIA);
        ValidadorTexto.validarTextoValido(naturalezaIndicador, UtilMensaje.NATURALEZA_TIPO_INDICADOR_INVALIDA);
        ValidadorNumero.validarNumeroEntre(naturalezaIndicador.length(), 5, 20, UtilMensaje.LONGITUD_NATURALEZA_TIPO_INDICADOR_INVALIDA);
    }

    private void validarTipologiaIndicador(String tipologiaIndicador) {
        ValidadorTexto.validarObligatorio(tipologiaIndicador, UtilMensaje.TIPOLOGIA_TIPO_INDICADOR_OBLIGATORIA);
        ValidadorTexto.validarTextoValido(tipologiaIndicador, UtilMensaje.TIPOLOGIA_TIPO_INDICADOR_INVALIDA);
        ValidadorNumero.validarNumeroEntre(tipologiaIndicador.length(), 5, 15, UtilMensaje.LONGITUD_TIPOLOGIA_TIPO_INDICADOR_INVALIDA);
    }
}