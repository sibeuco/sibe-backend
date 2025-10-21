package co.edu.uco.sibe.dominio.regla.implementacion;

import co.edu.uco.sibe.dominio.modelo.Area;
import co.edu.uco.sibe.dominio.regla.Regla;
import co.edu.uco.sibe.dominio.transversal.utilitarios.ValidadorNumero;
import co.edu.uco.sibe.dominio.transversal.utilitarios.ValidadorObjeto;
import co.edu.uco.sibe.dominio.transversal.utilitarios.ValidadorTexto;

import java.util.UUID;

import static co.edu.uco.sibe.dominio.transversal.utilitarios.UtilMensaje.*;

public final class AreaRegla implements Regla<Area> {
    private static final AreaRegla INSTANCIA = new AreaRegla();

    private AreaRegla() {
        super();
    }

    public static AreaRegla obtenerInstancia() {
        return INSTANCIA;
    }

    @Override
    public void validarIdentificador(UUID identificador) {
        ValidadorObjeto.validarObligatorio(identificador, IDENTIFICADOR_AREA_NULO);
    }

    @Override
    public void validarCampos(Area modelo) {
        validarNombre(modelo.getNombre());
    }

    private void validarNombre(String nombre) {
        ValidadorTexto.validarObligatorio(nombre, NOMBRE_AREA_OBLIGATORIO);
        ValidadorTexto.validarTextoValido(nombre, NOMBRE_AREA_INVALIDO);
        ValidadorNumero.validarNumeroEntre(nombre.length(), 8, 70, LONGITUD_NOMBRE_AREA_INVALIDA);
    }
}