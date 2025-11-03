package co.edu.uco.sibe.dominio.regla.implementacion;

import co.edu.uco.sibe.dominio.modelo.RelacionLaboral;
import co.edu.uco.sibe.dominio.regla.Regla;
import co.edu.uco.sibe.dominio.transversal.utilitarios.ValidadorNumero;
import co.edu.uco.sibe.dominio.transversal.utilitarios.ValidadorObjeto;
import co.edu.uco.sibe.dominio.transversal.utilitarios.ValidadorTexto;
import java.util.UUID;
import static co.edu.uco.sibe.dominio.transversal.utilitarios.UtilMensaje.*;

public final class RelacionLaboralRegla implements Regla<RelacionLaboral> {
    private static final RelacionLaboralRegla INSTANCIA = new RelacionLaboralRegla();

    private RelacionLaboralRegla() {
        super();
    }

    public static RelacionLaboralRegla obtenerInstancia() {
        return INSTANCIA;
    }

    @Override
    public void validarIdentificador(UUID identificador) {
        ValidadorObjeto.validarObligatorio(identificador, IDENTIFICADOR_RELACION_LABORAL_NULO);
    }

    @Override
    public void validarCampos(RelacionLaboral modelo) {
        validarCodigo(modelo.getCodigo());
        validarDescripcion(modelo.getDescripcion());
    }

    private void validarCodigo(String codigo) {
        ValidadorTexto.validarObligatorio(codigo, CODIGO_RELACION_OBLIGATORIO);
        ValidadorTexto.validarTextoAlfanumericoValido(codigo, CODIGO_RELACION_INVALIDO);
        ValidadorNumero.validarNumeroEntre(codigo.length(), 2, 4, LONGITUD_CODIGO_RELACION_INVALIDA);
    }

    private void validarDescripcion(String descripcion) {
        ValidadorTexto.validarObligatorio(descripcion, DESCRIPCION_RELACION_LABORAL_OBLIGATORIA);
        ValidadorTexto.validarTextoValido(descripcion, DESCRIPCION_RELACION_LABORAL_INVALIDA);
        ValidadorNumero.validarNumeroEntre(descripcion.length(), 5, 20, LONGITUD_DESCRIPCION_RELACION_LABORAL_INVALIDA);
    }
}