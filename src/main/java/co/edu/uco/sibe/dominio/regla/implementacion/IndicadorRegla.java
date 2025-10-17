package co.edu.uco.sibe.dominio.regla.implementacion;

import co.edu.uco.sibe.dominio.modelo.Indicador;
import co.edu.uco.sibe.dominio.regla.Regla;
import co.edu.uco.sibe.dominio.transversal.utilitarios.UtilMensaje;
import co.edu.uco.sibe.dominio.transversal.utilitarios.ValidadorNumero;
import co.edu.uco.sibe.dominio.transversal.utilitarios.ValidadorObjeto;
import co.edu.uco.sibe.dominio.transversal.utilitarios.ValidadorTexto;
import java.util.UUID;

public final class IndicadorRegla implements Regla<Indicador> {
    private static final IndicadorRegla INSTANCIA = new IndicadorRegla();

    private IndicadorRegla() {
        super();
    }

    public static IndicadorRegla obtenerInstancia() {
        return INSTANCIA;
    }

    @Override
    public void validarIdentificador(UUID identificador) {
        ValidadorObjeto.validarObligatorio(identificador, UtilMensaje.IDENTIFICADOR_INDICADOR_NULO);
    }

    @Override
    public void validarCampos(Indicador modelo) {
        validarNombre(modelo.getNombre());
    }

    private void validarNombre(String nombre) {
        ValidadorTexto.validarObligatorio(nombre, UtilMensaje.NOMBRE_INDICADOR_OBLIGATORIO);
        ValidadorTexto.validarTextoAlfanumericoValido(nombre, UtilMensaje.NOMBRE_INDICADOR_INVALIDO);
        ValidadorNumero.validarNumeroEntre(nombre.length(), 10, 100, UtilMensaje.LONGITUD_NOMBRE_INDICADOR_INVALIDA);
    }
}