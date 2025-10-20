package co.edu.uco.sibe.dominio.regla.implementacion;

import co.edu.uco.sibe.dominio.modelo.Actividad;
import co.edu.uco.sibe.dominio.regla.Regla;
import co.edu.uco.sibe.dominio.transversal.utilitarios.UtilMensaje;
import co.edu.uco.sibe.dominio.transversal.utilitarios.ValidadorNumero;
import co.edu.uco.sibe.dominio.transversal.utilitarios.ValidadorObjeto;
import co.edu.uco.sibe.dominio.transversal.utilitarios.ValidadorTexto;

import java.util.UUID;

public final class ActividadRegla implements Regla<Actividad> {
    private static final ActividadRegla INSTANCIA = new ActividadRegla();

    private ActividadRegla() {
        super();
    }

    public static ActividadRegla obtenerInstancia() {
        return INSTANCIA;
    }

    @Override
    public void validarIdentificador(UUID identificador) {
        ValidadorObjeto.validarObligatorio(identificador, UtilMensaje.IDENTIFICADOR_ACTIVIDAD_NULO);
    }

    @Override
    public void validarCampos(Actividad modelo) {
        validarNombre(modelo.getNombre());
        validarObjetivo(modelo.getObjetivo());
        validarSemestre(modelo.getSemestre());
        validarRutaInsumos(modelo.getRutaInsumos());
    }

    private void validarNombre(String nombre) {
        ValidadorTexto.validarObligatorio(nombre, UtilMensaje.NOMBRE_ACTIVIDAD_OBLIGATORIO);
        ValidadorTexto.validarTextoValido(nombre, UtilMensaje.NOMBRE_ACTIVIDAD_INVALIDO);
        ValidadorNumero.validarNumeroEntre(nombre.length(), 10, 200, UtilMensaje.LONGITUD_NOMBRE_ACTIVIDAD_INVALIDA);
    }

    private void validarObjetivo(String objetivo) {
        ValidadorTexto.validarObligatorio(objetivo, UtilMensaje.OBJETIVO_ACTIVIDAD_OBLIGATORIO);
        ValidadorTexto.validarTextoValido(objetivo, UtilMensaje.OBJETIVO_ACTIVIDAD_INVALIDO);
        ValidadorNumero.validarNumeroEntre(objetivo.length(), 10, 500, UtilMensaje.LONGITUD_OBJETIVO_ACTIVIDAD_INVALIDA);
    }

    private void validarSemestre(String semestre) {
        ValidadorTexto.validarObligatorio(semestre, UtilMensaje.SEMESTRE_ACTIVIDAD_OBLIGATORIO);
        ValidadorTexto.validarTextoValido(semestre, UtilMensaje.SEMESTRE_ACTIVIDAD_INVALIDO);
        ValidadorNumero.validarNumeroEntre(semestre.length(), 6, 6, UtilMensaje.LONGITUD_SEMESTRE_ACTIVIDAD_INVALIDA);
    }

    private void validarRutaInsumos(String rutaInsumos) {
        ValidadorTexto.validarObligatorio(rutaInsumos, UtilMensaje.RUTA_INSUMOS_ACTIVIDAD_OBLIGATORIA);
        ValidadorTexto.validarTextoValido(rutaInsumos, UtilMensaje.RUTA_INSUMOS_ACTIVIDAD_INVALIDA);
        ValidadorNumero.validarNumeroEntre(rutaInsumos.length(), 10, 3000, UtilMensaje.LONGITUD_RUTA_INSUMOS_ACTIVIDAD_INVALIDA);
    }
}