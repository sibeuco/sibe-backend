package co.edu.uco.sibe.dominio.transversal.utilitarios;

import java.util.Collection;

public class ValidadorObjeto {
    private ValidadorObjeto() { }

    public static <T> void validarObligatorio(T objeto, String mensaje) {
        if (esNulo(objeto)) {
            throw new IllegalArgumentException(mensaje);
        }
    }

    public static <T extends Collection<?>> void validarColeccionNoVacia(T coleccion, String mensaje) {
        if (esNulo(coleccion) || coleccion.isEmpty()) {
            throw new IllegalArgumentException(mensaje);
        }
    }

    public static <T> boolean esNulo(T objeto) {
        return objeto == null;
    }

    public static <T> T obtenerValorPorDefecto(T objeto, T valorPorDefecto) {
        return esNulo(objeto) ? valorPorDefecto : objeto;
    }
}