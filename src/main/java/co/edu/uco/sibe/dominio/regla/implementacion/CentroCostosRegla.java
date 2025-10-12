package co.edu.uco.sibe.dominio.regla.implementacion;

import co.edu.uco.sibe.dominio.modelo.CentroCostos;
import co.edu.uco.sibe.dominio.regla.Regla;
import co.edu.uco.sibe.dominio.transversal.utilitarios.Mensajes;
import co.edu.uco.sibe.dominio.transversal.utilitarios.ValidadorNumero;
import co.edu.uco.sibe.dominio.transversal.utilitarios.ValidadorObjeto;
import co.edu.uco.sibe.dominio.transversal.utilitarios.ValidadorTexto;

import java.util.UUID;

public final class CentroCostosRegla implements Regla<CentroCostos> {
    private static final CentroCostosRegla INSTANCIA = new CentroCostosRegla();

    private CentroCostosRegla() {
        super();
    }

    public static CentroCostosRegla obtenerInstancia() {
        return INSTANCIA;
    }

    @Override
    public void validarIdentificador(UUID identificador) {
        ValidadorObjeto.validarObligatorio(identificador, Mensajes.IDENTIFICADOR_CENTRO_COSTOS_NULO);
    }

    @Override
    public void validarCampos(CentroCostos modelo) {

    }

    private void validarCodigo(String codigo) {
        ValidadorTexto.validarObligatorio(codigo, Mensajes.CODIGO_CENTRO_COSTOS_OBLIGATORIO);
        ValidadorTexto.validarTextoValido(codigo, Mensajes.CODIGO_CENTRO_COSTOS_INVALIDO);
        ValidadorNumero.validarNumeroEntre(codigo.length(), 4, 6, Mensajes.LONGITUD_CODIGO_CENTRO_COSTOS_INVALIDA);
    }

    private void validarDescripcion(String descripcion) {
        ValidadorTexto.validarObligatorio(descripcion, Mensajes.DESCRIPCION_CENTRO_COSTOS_OBLIGATORIA);
        ValidadorTexto.validarTextoValido(descripcion, Mensajes.DESCRIPCION_CENTRO_COSTOS_INVALIDA);
        ValidadorNumero.validarNumeroEntre(descripcion.length(), 10, 100, Mensajes.LONGITUD_DESCRIPCION_CENTRO_COSTOS_INVALIDA);
    }
}