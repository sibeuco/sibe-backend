package co.edu.uco.sibe.dominio.regla.implementacion;

import co.edu.uco.sibe.dominio.modelo.Temporalidad;
import co.edu.uco.sibe.dominio.regla.Regla;
import co.edu.uco.sibe.dominio.transversal.utilitarios.ValidadorNumero;
import co.edu.uco.sibe.dominio.transversal.utilitarios.ValidadorObjeto;
import co.edu.uco.sibe.dominio.transversal.utilitarios.ValidadorTexto;

import java.util.UUID;

import static co.edu.uco.sibe.dominio.transversal.utilitarios.UtilMensaje.*;

public final class TemporalidadRegla implements Regla<Temporalidad> {
    private static final TemporalidadRegla INSTANCIA = new TemporalidadRegla();

    private TemporalidadRegla() {
        super();
    }

    public static TemporalidadRegla obtenerInstancia() {
        return INSTANCIA;
    }

    @Override
    public void validarIdentificador(UUID identificador) {
        ValidadorObjeto.validarObligatorio(identificador, IDENTIFICADOR_TEMPORALIDAD_NULO);
    }

    @Override
    public void validarCampos(Temporalidad modelo) {
        validarNombre(modelo.getNombre());
    }

    private void validarNombre(String nombre) {
        ValidadorTexto.validarObligatorio(nombre, NOMBRE_TEMPORALIDAD_OBLIGATORIO);
        ValidadorTexto.validarTextoValido(nombre, NOMBRE_TEMPORALIDAD_INVALIDO);
        ValidadorNumero.validarNumeroEntre(nombre.length(), 5, 30, LONGITUD_NOMBRE_TEMPORALIDAD_INVALIDA);
    }
}