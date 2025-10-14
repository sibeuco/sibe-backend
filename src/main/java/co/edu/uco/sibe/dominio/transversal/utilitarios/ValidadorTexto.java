package co.edu.uco.sibe.dominio.transversal.utilitarios;

import co.edu.uco.sibe.dominio.transversal.constante.TextoConstante;
import co.edu.uco.sibe.dominio.transversal.excepcion.PatronExcepcion;
import co.edu.uco.sibe.dominio.transversal.excepcion.ValorObligatorioExcepcion;

public class ValidadorTexto {
    private static final String PATRON_LETRAS_Y_ESPACIOS = "^[a-zA-ZáéíóúÁÉÍÓÚÄëËïÏöÖüÜñÑ ]*$";
    private static final String PATRON_ALFANUMERICO = "^[a-zA-ZáéíóúäÄëËïÏöÖüÜÁÉÍÓÚñÑ .\\-_+*/#$!=,;()\"%':?@0-9]*$";
    private static final String PATRON_CORREO = "(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])";
    private static final String PATRON_CLAVE = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9]).{8,20}$";
    private static final String PATRON_NUMERO_IDENTIFICACION = "^([0-9]{5,12})";

    private ValidadorTexto() { }

    public static String aplicarTrim(String cadena) {
        return obtenerValorPorDefecto(cadena.trim());
    }

    public static void validarObligatorio(String valor, String mensaje) {
        if (estaCadenaVacia(valor)) {
            throw new ValorObligatorioExcepcion(mensaje);
        }
    }

    public static void validarTextoAlfanumericoValido(String valor, String mensaje) {
        if (!esCadenaAlfanumerica(valor)) {
            throw new PatronExcepcion(mensaje);
        }
    }

    public static void validarTextoValido(String valor, String mensaje) {
        if (!esCadenaLetrasYEspacios(valor)) {
            throw new PatronExcepcion(mensaje);
        }
    }

    public static void validarCorreoValido(String valor, String mensaje) {
        if (!esCadenaCorreo(valor)) {
            throw new PatronExcepcion(mensaje);
        }
    }

    public static void validarNumeroIdentificacionValido(String valor, String mensaje) {
        if (!esCadenaNumeroIdentificacion(valor)) {
            throw new PatronExcepcion(mensaje);
        }
    }

    public static void validarClaveValida(String valor, String mensaje) {
        if (!esCadenaClave(valor)) {
            throw new PatronExcepcion(mensaje);
        }
    }

    public static boolean estaCadenaVacia(String valor) {
        return esNula(valor) || TextoConstante.VACIO.equals(quitarEspaciosBlancoInicioFin(valor));
    }

    private static String quitarEspaciosBlancoInicioFin(final String valor) {
        return obtenerValorPorDefecto(valor).trim();
    }

    public static boolean esNula(final String valor) {
        return ValidadorObjeto.esNulo(valor);
    }

    public static String obtenerValorPorDefecto(String cadena) {
        return ValidadorObjeto.obtenerValorPorDefecto(cadena, TextoConstante.VACIO);
    }

    private static boolean esCadenaLetrasYEspacios(String valor) {
        return cadenaAceptaPatron(valor, PATRON_LETRAS_Y_ESPACIOS);
    }

    private static boolean esCadenaAlfanumerica(String valor) {
        return cadenaAceptaPatron(valor, PATRON_ALFANUMERICO);
    }

    private static boolean esCadenaNumeroIdentificacion(String valor) {
        return cadenaAceptaPatron(valor, PATRON_NUMERO_IDENTIFICACION);
    }

    public static boolean esCadenaCorreo(String valor) {
        return cadenaAceptaPatron(valor, PATRON_CORREO);
    }

    public static boolean esCadenaClave(String valor) {
        return cadenaAceptaPatron(valor, PATRON_CLAVE);
    }

    public static boolean cadenaAceptaPatron(String cadena, String patron) {
        return aplicarTrim(cadena).matches(patron);
    }
}