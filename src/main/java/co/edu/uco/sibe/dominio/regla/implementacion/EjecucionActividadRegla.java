package co.edu.uco.sibe.dominio.regla.implementacion;

import co.edu.uco.sibe.dominio.modelo.EjecucionActividad;
import co.edu.uco.sibe.dominio.regla.Regla;
import co.edu.uco.sibe.dominio.transversal.utilitarios.UtilMensaje;
import co.edu.uco.sibe.dominio.transversal.utilitarios.ValidadorObjeto;
import java.util.UUID;

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
        ValidadorObjeto.validarObligatorio(identificador, UtilMensaje.IDENTIFICADOR_EJECUCION_ACTIVIDAD_NULO);
    }

    @Override
    public void validarCampos(EjecucionActividad modelo) {
        throw new IllegalStateException(UtilMensaje.NO_HAY_CAMPOS_POR_VALIDAR);
    }
}
