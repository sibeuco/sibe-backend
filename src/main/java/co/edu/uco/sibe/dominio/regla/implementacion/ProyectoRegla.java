package co.edu.uco.sibe.dominio.regla.implementacion;

import co.edu.uco.sibe.dominio.modelo.Proyecto;
import co.edu.uco.sibe.dominio.regla.Regla;
import co.edu.uco.sibe.dominio.transversal.utilitarios.Mensajes;
import co.edu.uco.sibe.dominio.transversal.utilitarios.ValidadorNumero;
import co.edu.uco.sibe.dominio.transversal.utilitarios.ValidadorObjeto;
import co.edu.uco.sibe.dominio.transversal.utilitarios.ValidadorTexto;
import java.util.UUID;

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
        ValidadorObjeto.validarObligatorio(identificador, Mensajes.IDENTIFICADOR_PROYECTO_NULO);
    }

    @Override
    public void validarCampos(Proyecto modelo) {
        validarNumeroProyecto(modelo.getNumeroProyecto());
        validarNombre(modelo.getNombre());
        validarObjetivo(modelo.getObjetivo());
    }

    private void validarNumeroProyecto(String numeroProyecto) {
        ValidadorTexto.validarObligatorio(numeroProyecto, Mensajes.NUMERO_PROYECTO_OBLIGATORIO);
        ValidadorTexto.validarTextoValido(numeroProyecto, Mensajes.NUMERO_PROYECTO_INVALIDO);
        ValidadorNumero.validarNumeroEntre(numeroProyecto.length(), 1, 12, Mensajes.LONGITUD_NUMERO_PROYECTO_INVALIDA);
    }

    private void validarNombre(String nombre) {
        ValidadorTexto.validarObligatorio(nombre, Mensajes.NOMBRE_PROYECTO_OBLIGATORIO);
        ValidadorTexto.validarTextoValido(nombre, Mensajes.NOMBRE_PROYECTO_INVALIDO);
        ValidadorNumero.validarNumeroEntre(nombre.length(), 10, 100, Mensajes.LONGITUD_NOMBRE_PROYECTO_INVALIDA);
    }

    private void validarObjetivo(String objetivo) {
        ValidadorTexto.validarObligatorio(objetivo, Mensajes.OBJETIVO_PROYECTO_OBLIGATORIO);
        ValidadorTexto.validarTextoValido(objetivo, Mensajes.OBJETIVO_PROYECTO_INVALIDO);
        ValidadorNumero.validarNumeroEntre(objetivo.length(), 10, 500, Mensajes.LONGITUD_OBJETIVO_PROYECTO_INVALIDA);
    }
}