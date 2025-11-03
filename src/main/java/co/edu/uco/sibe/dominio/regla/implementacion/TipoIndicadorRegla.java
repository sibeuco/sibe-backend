package co.edu.uco.sibe.dominio.regla.implementacion;

import co.edu.uco.sibe.dominio.modelo.TipoIndicador;
import co.edu.uco.sibe.dominio.regla.Regla;
import co.edu.uco.sibe.dominio.transversal.utilitarios.ValidadorNumero;
import co.edu.uco.sibe.dominio.transversal.utilitarios.ValidadorObjeto;
import co.edu.uco.sibe.dominio.transversal.utilitarios.ValidadorTexto;
import java.util.UUID;
import static co.edu.uco.sibe.dominio.transversal.utilitarios.UtilMensaje.*;

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
        ValidadorObjeto.validarObligatorio(identificador, IDENTIFICADOR_TIPO_INDICADOR_NULO);
    }

    @Override
    public void validarCampos(TipoIndicador modelo) {
        validarNaturalezaIndicador(modelo.getNaturaleza());
        validarTipologiaIndicador(modelo.getTipologia());
    }

    private void validarNaturalezaIndicador(String naturalezaIndicador) {
        ValidadorTexto.validarObligatorio(naturalezaIndicador, NATURALEZA_TIPO_INDICADOR_OBLIGATORIA);
        ValidadorTexto.validarTextoValido(naturalezaIndicador, NATURALEZA_TIPO_INDICADOR_INVALIDA);
        ValidadorNumero.validarNumeroEntre(naturalezaIndicador.length(), 5, 20, LONGITUD_NATURALEZA_TIPO_INDICADOR_INVALIDA);
    }

    private void validarTipologiaIndicador(String tipologiaIndicador) {
        ValidadorTexto.validarObligatorio(tipologiaIndicador, TIPOLOGIA_TIPO_INDICADOR_OBLIGATORIA);
        ValidadorTexto.validarTextoValido(tipologiaIndicador, TIPOLOGIA_TIPO_INDICADOR_INVALIDA);
        ValidadorNumero.validarNumeroEntre(tipologiaIndicador.length(), 5, 15, LONGITUD_TIPOLOGIA_TIPO_INDICADOR_INVALIDA);
    }
}