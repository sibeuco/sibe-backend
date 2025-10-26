package co.edu.uco.sibe.dominio.regla.implementacion;

import co.edu.uco.sibe.dominio.modelo.Proyecto;
import co.edu.uco.sibe.dominio.regla.Regla;
import co.edu.uco.sibe.dominio.transversal.utilitarios.ValidadorNumero;
import co.edu.uco.sibe.dominio.transversal.utilitarios.ValidadorObjeto;
import co.edu.uco.sibe.dominio.transversal.utilitarios.ValidadorTexto;

import java.util.UUID;

import static co.edu.uco.sibe.dominio.transversal.utilitarios.UtilMensaje.*;

public final class ProyectoRegla implements Regla<Proyecto> {
    private static final ProyectoRegla INSTANCIA = new ProyectoRegla();

    private ProyectoRegla() {
        super();
    }

    public static ProyectoRegla obtenerInstancia() {
        return INSTANCIA;
    }

    @Override
    public void validarIdentificador(UUID identificador) {
        ValidadorObjeto.validarObligatorio(identificador, IDENTIFICADOR_PROYECTO_NULO);
    }

    @Override
    public void validarCampos(Proyecto modelo) {
        validarNumeroProyecto(modelo.getNumeroProyecto());
        validarNombre(modelo.getNombre());
        validarObjetivo(modelo.getObjetivo());
    }

    private void validarNumeroProyecto(String numeroProyecto) {
        ValidadorTexto.validarObligatorio(numeroProyecto, NUMERO_PROYECTO_OBLIGATORIO);
        ValidadorTexto.validarTextoValido(numeroProyecto, NUMERO_PROYECTO_INVALIDO);
        ValidadorNumero.validarNumeroEntre(numeroProyecto.length(), 1, 12, LONGITUD_NUMERO_PROYECTO_INVALIDA);
    }

    private void validarNombre(String nombre) {
        ValidadorTexto.validarObligatorio(nombre, NOMBRE_PROYECTO_OBLIGATORIO);
        ValidadorTexto.validarTextoValido(nombre, NOMBRE_PROYECTO_INVALIDO);
        ValidadorNumero.validarNumeroEntre(nombre.length(), 10, 100, LONGITUD_NOMBRE_PROYECTO_INVALIDA);
    }

    private void validarObjetivo(String objetivo) {
        ValidadorTexto.validarObligatorio(objetivo, OBJETIVO_PROYECTO_OBLIGATORIO);
        ValidadorTexto.validarTextoValido(objetivo, OBJETIVO_PROYECTO_INVALIDO);
        ValidadorNumero.validarNumeroEntre(objetivo.length(), 10, 500, LONGITUD_OBJETIVO_PROYECTO_INVALIDA);
    }
}