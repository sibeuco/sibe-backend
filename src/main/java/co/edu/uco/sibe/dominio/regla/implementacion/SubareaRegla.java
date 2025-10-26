package co.edu.uco.sibe.dominio.regla.implementacion;

import co.edu.uco.sibe.dominio.modelo.Subarea;
import co.edu.uco.sibe.dominio.regla.Regla;
import co.edu.uco.sibe.dominio.transversal.utilitarios.ValidadorNumero;
import co.edu.uco.sibe.dominio.transversal.utilitarios.ValidadorObjeto;
import co.edu.uco.sibe.dominio.transversal.utilitarios.ValidadorTexto;

import java.util.UUID;

import static co.edu.uco.sibe.dominio.transversal.utilitarios.UtilMensaje.*;

public final class SubareaRegla implements Regla<Subarea> {
    private static final SubareaRegla INSTANCIA = new SubareaRegla();

    private SubareaRegla() {
        super();
    }

    public static SubareaRegla obtenerInstancia() {
        return INSTANCIA;
    }

    @Override
    public void validarIdentificador(UUID identificador) {
        ValidadorObjeto.validarObligatorio(identificador, IDENTIFICADOR_SUBAREA_NULO);
    }

    @Override
    public void validarCampos(Subarea modelo) {
        validarNombre(modelo.getNombre());
    }

    private void validarNombre(String nombre) {
        ValidadorTexto.validarObligatorio(nombre, NOMBRE_SUB_AREA_OBLIGATORIO);
        ValidadorTexto.validarTextoValido(nombre, NOMBRE_SUB_AREA_INVALIDO);
        ValidadorNumero.validarNumeroEntre(nombre.length(), 8, 70, LONGITUD_NOMBRE_SUB_AREA_INVALIDA);
    }
}