package co.edu.uco.sibe.dominio.regla.implementacion;

import co.edu.uco.sibe.dominio.modelo.EstadoActividad;
import co.edu.uco.sibe.dominio.regla.Regla;
import co.edu.uco.sibe.dominio.transversal.utilitarios.ValidadorNumero;
import co.edu.uco.sibe.dominio.transversal.utilitarios.ValidadorObjeto;
import co.edu.uco.sibe.dominio.transversal.utilitarios.ValidadorTexto;
import java.util.UUID;
import static co.edu.uco.sibe.dominio.transversal.utilitarios.UtilMensaje.*;

public final class EstadoActividadRegla implements Regla<EstadoActividad> {
    private static final EstadoActividadRegla INSTANCIA = new EstadoActividadRegla();

    private EstadoActividadRegla() {
        super();
    }

    public static EstadoActividadRegla obtenerInstancia() {
        return INSTANCIA;
    }

    @Override
    public void validarIdentificador(UUID identificador) {
        ValidadorObjeto.validarObligatorio(identificador, IDENTIFICADOR_ESTADO_ACTIVIDAD_NULO);
    }

    @Override
    public void validarCampos(EstadoActividad modelo) {
        validarNombre(modelo.getNombre());
    }

    private void validarNombre(String nombre) {
        ValidadorTexto.validarObligatorio(nombre, NOMBRE_ESTADO_ACTIVIDAD_OBLIGATORIO);
        ValidadorTexto.validarTextoValido(nombre, NOMBRE_ESTADO_ACTIVIDAD_INVALIDO);
        ValidadorNumero.validarNumeroEntre(nombre.length(), 5, 15, LONGITUD_NOMBRE_ESTADO_ACTIVIDAD_INVALIDA);
    }
}