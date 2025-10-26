package co.edu.uco.sibe.dominio.regla.implementacion;

import co.edu.uco.sibe.dominio.modelo.EjecucionActividad;
import co.edu.uco.sibe.dominio.regla.Regla;
import co.edu.uco.sibe.dominio.transversal.utilitarios.ValidadorObjeto;

import java.util.UUID;

import static co.edu.uco.sibe.dominio.transversal.utilitarios.UtilMensaje.IDENTIFICADOR_EJECUCION_ACTIVIDAD_NULO;
import static co.edu.uco.sibe.dominio.transversal.utilitarios.UtilMensaje.NO_HAY_CAMPOS_POR_VALIDAR;

public class EjecucionActividadRegla implements Regla<EjecucionActividad> {
    private static final EjecucionActividadRegla INSTANCIA = new EjecucionActividadRegla();

    private EjecucionActividadRegla() {
        super();
    }

    public static EjecucionActividadRegla obtenerInstancia() {
        return INSTANCIA;
    }

    @Override
    public void validarIdentificador(UUID identificador) {
        ValidadorObjeto.validarObligatorio(identificador, IDENTIFICADOR_EJECUCION_ACTIVIDAD_NULO);
    }

    @Override
    public void validarCampos(EjecucionActividad modelo) {
        throw new IllegalStateException(NO_HAY_CAMPOS_POR_VALIDAR);
    }
}
