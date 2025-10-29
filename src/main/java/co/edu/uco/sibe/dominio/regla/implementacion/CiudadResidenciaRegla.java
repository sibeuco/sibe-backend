package co.edu.uco.sibe.dominio.regla.implementacion;

import co.edu.uco.sibe.dominio.modelo.CiudadResidencia;
import co.edu.uco.sibe.dominio.regla.Regla;
import co.edu.uco.sibe.dominio.transversal.utilitarios.ValidadorNumero;
import co.edu.uco.sibe.dominio.transversal.utilitarios.ValidadorObjeto;
import co.edu.uco.sibe.dominio.transversal.utilitarios.ValidadorTexto;

import java.util.UUID;

import static co.edu.uco.sibe.dominio.transversal.utilitarios.UtilMensaje.*;

public final class CiudadResidenciaRegla implements Regla<CiudadResidencia> {
    private static final CiudadResidenciaRegla INSTANCIA = new CiudadResidenciaRegla();

    private CiudadResidenciaRegla() {
        super();
    }

    public static CiudadResidenciaRegla obtenerInstancia() {
        return INSTANCIA;
    }

    @Override
    public void validarIdentificador(UUID identificador) {
        ValidadorObjeto.validarObligatorio(identificador, IDENTIFICADOR_CIUDAD_RESIDENCIA_NULO);
    }

    @Override
    public void validarCampos(CiudadResidencia modelo) {
        validarDescripcion(modelo.getDescripcion());
    }

    private void validarDescripcion(String descripcion) {
        ValidadorTexto.validarObligatorio(descripcion, DESCRIPCION_CIUDAD_RESIDENCIA_OBLIGATORIA);
        ValidadorTexto.validarTextoAlfanumericoValido(descripcion, DESCRIPCION_CIUDAD_RESIDENCIA_INVALIDA);
        ValidadorNumero.validarNumeroEntre(descripcion.length(), 3, 30, LONGITUD_DESCRIPCION_CIUDAD_RESIDENCIA_INVALIDA);
    }
}