package co.edu.uco.sibe.dominio.transversal.utilitarios;

import co.edu.uco.sibe.dominio.transversal.constante.TextoConstante;

public class ValidadorTexto {
    public final static String VACIO = "";
    private static final String PATRON_LETRAS_Y_ESPACIOS = "^[a-zA-ZáéíóúÁÉÍÓÚÄëËïÏöÖüÜñÑ ]*$";
    private static final String PATRON_ALFANUMERICO = "^[a-zA-ZáéíóúäÄëËïÏöÖüÜÁÉÍÓÚñÑ .\\-_+*/#$!=,;()\"%':?@0-9]*$";
    private static final String PATRON_CORREO = "(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])";
    private static final String PATRON_CLAVE = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9]).{8,20}$";

    private ValidadorTexto() { }

    public static String aplicarTrim(String cadena) {
        return obtenerValorPorDefecto(cadena.trim());
    }

    public static String obtenerValorPorDefecto(String cadena) {
        return ValidadorObjeto.obtenerValorPorDefecto(cadena, TextoConstante.VACIO);
    }

    public boolean esCadenaLetrasYEspacios(String valor) {
        return cadenaAceptaPatron(valor, PATRON_LETRAS_Y_ESPACIOS);
    }

    public boolean esCadenaEsAlfanumerica(String valor) {
        return cadenaAceptaPatron(valor, PATRON_ALFANUMERICO);
    }

    public boolean esCadenaCorreo(String valor) {
        return cadenaAceptaPatron(valor, PATRON_CORREO);
    }

    public boolean esCadenaClave(String valor) {
        return cadenaAceptaPatron(valor, PATRON_CLAVE);
    }

    public static boolean cadenaAceptaPatron(String cadena, String patron) {
        return aplicarTrim(cadena).matches(patron);
    }
}
