package co.edu.uco.sibe.dominio.regla.implementacion;

import co.edu.uco.sibe.dominio.modelo.RelacionLaboral;
import co.edu.uco.sibe.dominio.regla.Regla;
import co.edu.uco.sibe.dominio.transversal.utilitarios.Mensajes;
import co.edu.uco.sibe.dominio.transversal.utilitarios.ValidadorNumero;
import co.edu.uco.sibe.dominio.transversal.utilitarios.ValidadorObjeto;
import co.edu.uco.sibe.dominio.transversal.utilitarios.ValidadorTexto;
import java.util.UUID;

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
        ValidadorObjeto.validarObligatorio(identificador, "");
    }

    @Override
    public void validarCampos(RelacionLaboral modelo) {
        validarCodigo(modelo.getCodigo());
        validarDescripcion(modelo.getDescripcion());
    }

    private void validarCodigo(String codigo) {
        ValidadorTexto.validarObligatorio(codigo, Mensajes.CODIGO_RELACION_OBLIGATORIO);
        ValidadorTexto.validarTextoValido(codigo, Mensajes.CODIGO_RELACION_INVALIDO);
        ValidadorNumero.validarNumeroEntre(codigo.length(), 2, 4, Mensajes.LONGITUD_CODIGO_RELACION_INVALIDA);
    }

    private void validarDescripcion(String descripcion) {
        ValidadorTexto.validarObligatorio(descripcion, Mensajes.DESCRIPCION_RELACION_LABORAL_OBLIGATORIA);
        ValidadorTexto.validarTextoValido(descripcion, Mensajes.DESCRIPCION_RELACION_LABORAL_INVALIDA);
        ValidadorNumero.validarNumeroEntre(descripcion.length(), 5, 20, Mensajes.LONGITUD_DESCRIPCION_RELACION_LABORAL_INVALIDA);
    }
}