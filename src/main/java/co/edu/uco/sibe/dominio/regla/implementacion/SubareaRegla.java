package co.edu.uco.sibe.dominio.regla.implementacion;

import co.edu.uco.sibe.dominio.modelo.Subarea;
import co.edu.uco.sibe.dominio.regla.Regla;
import co.edu.uco.sibe.dominio.transversal.utilitarios.Mensajes;
import co.edu.uco.sibe.dominio.transversal.utilitarios.ValidadorNumero;
import co.edu.uco.sibe.dominio.transversal.utilitarios.ValidadorObjeto;
import co.edu.uco.sibe.dominio.transversal.utilitarios.ValidadorTexto;
import java.util.UUID;

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
        ValidadorObjeto.validarObligatorio(identificador, Mensajes.IDENTIFICADOR_SUBAREA_NULO);
    }

    @Override
    public void validarCampos(Subarea modelo) {
        validarNombre(modelo.getNombre());
    }

    private void validarNombre(String nombre) {
        ValidadorTexto.validarObligatorio(nombre, Mensajes.NOMBRE_SUB_AREA_OBLIGATORIO);
        ValidadorTexto.validarTextoValido(nombre, Mensajes.NOMBRE_SUB_AREA_INVALIDO);
        ValidadorNumero.validarNumeroEntre(nombre.length(), 10, 70, Mensajes.LONGITUD_NOMBRE_SUB_AREA_INVALIDA);
    }
}