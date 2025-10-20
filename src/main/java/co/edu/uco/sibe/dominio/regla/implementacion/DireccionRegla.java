package co.edu.uco.sibe.dominio.regla.implementacion;

import co.edu.uco.sibe.dominio.modelo.Direccion;
import co.edu.uco.sibe.dominio.regla.Regla;
import co.edu.uco.sibe.dominio.transversal.utilitarios.UtilMensaje;
import co.edu.uco.sibe.dominio.transversal.utilitarios.ValidadorNumero;
import co.edu.uco.sibe.dominio.transversal.utilitarios.ValidadorObjeto;
import co.edu.uco.sibe.dominio.transversal.utilitarios.ValidadorTexto;

import java.util.UUID;

public final class DireccionRegla implements Regla<Direccion> {
    private static final DireccionRegla INSTANCIA = new DireccionRegla();

    private DireccionRegla() {
        super();
    }

    public static DireccionRegla obtenerInstancia() {
        return INSTANCIA;
    }

    @Override
    public void validarIdentificador(UUID identificador) {
        ValidadorObjeto.validarObligatorio(identificador, UtilMensaje.IDENTIFICADOR_DIRECCION_NULO);
    }

    @Override
    public void validarCampos(Direccion modelo) {
        validarNombre(modelo.getNombre());
    }

    private void validarNombre(String nombre) {
        ValidadorTexto.validarObligatorio(nombre, UtilMensaje.NOMBRE_DIRECCION_OBLIGATORIO);
        ValidadorTexto.validarTextoValido(nombre, UtilMensaje.NOMBRE_DIRECCION_INVALIDO);
        ValidadorNumero.validarNumeroEntre(nombre.length(), 10, 70, UtilMensaje.LONGITUD_NOMBRE_DIRECCION_INVALIDA);
    }
}