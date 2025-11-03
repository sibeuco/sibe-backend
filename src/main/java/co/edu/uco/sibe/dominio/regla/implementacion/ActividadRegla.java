package co.edu.uco.sibe.dominio.regla.implementacion;

import co.edu.uco.sibe.dominio.modelo.Actividad;
import co.edu.uco.sibe.dominio.regla.Regla;
import co.edu.uco.sibe.dominio.transversal.utilitarios.ValidadorNumero;
import co.edu.uco.sibe.dominio.transversal.utilitarios.ValidadorObjeto;
import co.edu.uco.sibe.dominio.transversal.utilitarios.ValidadorTexto;
import java.util.UUID;
import static co.edu.uco.sibe.dominio.transversal.utilitarios.UtilMensaje.*;

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
        ValidadorObjeto.validarObligatorio(identificador, IDENTIFICADOR_ACTIVIDAD_NULO);
    }

    @Override
    public void validarCampos(Actividad modelo) {
        validarNombre(modelo.getNombre());
        validarObjetivo(modelo.getObjetivo());
        validarSemestre(modelo.getSemestre());
        validarRutaInsumos(modelo.getRutaInsumos());
    }

    private void validarNombre(String nombre) {
        ValidadorTexto.validarObligatorio(nombre, NOMBRE_ACTIVIDAD_OBLIGATORIO);
        ValidadorTexto.validarTextoAlfanumericoValido(nombre, NOMBRE_ACTIVIDAD_INVALIDO);
        ValidadorNumero.validarNumeroEntre(nombre.length(), 10, 200, LONGITUD_NOMBRE_ACTIVIDAD_INVALIDA);
    }

    private void validarObjetivo(String objetivo) {
        ValidadorTexto.validarObligatorio(objetivo, OBJETIVO_ACTIVIDAD_OBLIGATORIO);
        ValidadorTexto.validarTextoAlfanumericoValido(objetivo, OBJETIVO_ACTIVIDAD_INVALIDO);
        ValidadorNumero.validarNumeroEntre(objetivo.length(), 10, 500, LONGITUD_OBJETIVO_ACTIVIDAD_INVALIDA);
    }

    private void validarSemestre(String semestre) {
        ValidadorTexto.validarObligatorio(semestre, SEMESTRE_ACTIVIDAD_OBLIGATORIO);
        ValidadorTexto.validarTextoAlfanumericoValido(semestre, SEMESTRE_ACTIVIDAD_INVALIDO);
        ValidadorNumero.validarNumeroEntre(semestre.length(), 6, 6, LONGITUD_SEMESTRE_ACTIVIDAD_INVALIDA);
    }

    private void validarRutaInsumos(String rutaInsumos) {
        ValidadorTexto.validarObligatorio(rutaInsumos, RUTA_INSUMOS_ACTIVIDAD_OBLIGATORIA);
        ValidadorTexto.validarTextoAlfanumericoValido(rutaInsumos, RUTA_INSUMOS_ACTIVIDAD_INVALIDA);
        ValidadorNumero.validarNumeroEntre(rutaInsumos.length(), 10, 3000, LONGITUD_RUTA_INSUMOS_ACTIVIDAD_INVALIDA);
    }
}