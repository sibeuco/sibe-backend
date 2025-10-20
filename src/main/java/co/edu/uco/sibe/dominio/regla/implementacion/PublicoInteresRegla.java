package co.edu.uco.sibe.dominio.regla.implementacion;

import co.edu.uco.sibe.dominio.modelo.PublicoInteres;
import co.edu.uco.sibe.dominio.regla.Regla;
import co.edu.uco.sibe.dominio.transversal.utilitarios.UtilMensaje;
import co.edu.uco.sibe.dominio.transversal.utilitarios.ValidadorNumero;
import co.edu.uco.sibe.dominio.transversal.utilitarios.ValidadorObjeto;
import co.edu.uco.sibe.dominio.transversal.utilitarios.ValidadorTexto;
import java.util.UUID;

public final class PublicoInteresRegla implements Regla<PublicoInteres> {
    private static final PublicoInteresRegla INSTANCIA = new PublicoInteresRegla();

    private PublicoInteresRegla() {
        super();
    }

    public static PublicoInteresRegla obtenerInstancia() {
        return INSTANCIA;
    }

    @Override
    public void validarIdentificador(UUID identificador) {
        ValidadorObjeto.validarObligatorio(identificador, UtilMensaje.IDENTIFICADOR_PUBLICO_INTERES_NULO);
    }

    @Override
    public void validarCampos(PublicoInteres modelo) {
        validarNombre(modelo.getNombre());
    }

    private void validarNombre(String nombre) {
        ValidadorTexto.validarObligatorio(nombre, UtilMensaje.NOMBRE_PUBLICO_OBLIGATORIO);
        ValidadorTexto.validarTextoValido(nombre, UtilMensaje.NOMBRE_PUBLICO_INVALIDO);
        ValidadorNumero.validarNumeroEntre(nombre.length(), 5, 50, UtilMensaje.LONGITUD_NOMBRE_PUBLICO_INVALIDA);
    }
}