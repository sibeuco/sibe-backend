package co.edu.uco.sibe.dominio.transversal.utilitarios;

import co.edu.uco.sibe.dominio.transversal.excepcion.PatronExcepcion;
import co.edu.uco.sibe.dominio.transversal.excepcion.ValorObligatorioExcepcion;

public class UtilTexto {

    private static UtilTexto instancia = new UtilTexto();
    public final static String VACIO = "";
    private static final String LETRAS_Y_ESPACIOS = "^[a-zA-ZáéíóúÁÉÍÓÚÄëËïÏöÖüÜñÑ ]*$";
    private static final String ALFANUMERICO = "^[a-zA-ZáéíóúäÄëËïÏöÖüÜÁÉÍÓÚñÑ .\\-_+*/#$!=,;()\"%':?@0-9]*$";
    private static final String DOCUMENTO = "^([0-9]{5,12})";
    private static final String CORREO = "(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])";
    public static final String PATRON_CONTRASENA = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9]).{8,20}$";
    private static final String URL = "^(ftp|http|https):\\/\\/[^ \"]+$";

    private UtilTexto() {
    }

    public static UtilTexto getInstance() {
        return instancia;
    }

    public void validarObligatorio(String valor, String mensaje) {
        if (cadenaEstaVacia(valor)) {
            throw new ValorObligatorioExcepcion(mensaje);
        }
    }

    public void validarPatronAlfanumericoEsValido(String valor, String mensaje) {
        if (!cadenaEsAlfanumerica(valor)) {
            throw new PatronExcepcion(mensaje);
        }
    }

    public void validarPatronTextoEsValido(String valor, String mensaje) {
        if (!cadenaLetrasYEspacios(valor)) {
            throw new PatronExcepcion(mensaje);
        }
    }

    public void validarCorreoEsValido(String valor, String mensaje) {
        if (!cadenaCorreo(valor)) {
            throw new PatronExcepcion(mensaje);
        }
    }

    public void validarContrasenaEsValida(String valor, String mensaje) {
        if (!cadenaContrasena(valor)) {
            throw new PatronExcepcion(mensaje);
        }
    }

    public void validarPatronDocumentoEsValido(String valor, String mensaje) {
        if (!cadenaDocumento(valor)) {
            throw new PatronExcepcion(mensaje);
        }
    }

    public void validarPatronURLEsValido(String valor, String mensaje) {
        if (!cadenaURL(valor)) {
            throw new PatronExcepcion(mensaje);
        }
    }

    public boolean cadenaEstaVacia(String valor) {
        return esNula(valor) || "".equals(quitarEspaciosBlancoInicioFin(valor));
    }

    public boolean esNula(final String valor) {
        return UtilObjeto.getInstance().esNulo(valor);
    }

    public String obtenerValorDefecto(final String valorOriginal, final String valorDefecto) {
        return UtilObjeto.getInstance().obtenerValorDefecto(valorOriginal, valorDefecto);
    }

    public String obtenerValorDefecto(final String valor) {
        return obtenerValorDefecto(valor, VACIO);
    }

    public String obtenerValorDefecto() {
        return VACIO;
    }

    public String quitarEspaciosBlancoInicioFin(final String valor) {
        return obtenerValorDefecto(valor).trim();
    }

    public boolean cadenaAceptaElPatron(String valor, String pattern) {
        return quitarEspaciosBlancoInicioFin(valor).matches(pattern);
    }

    public boolean cadenaLetrasYEspacios(String valor) {
        return cadenaAceptaElPatron(valor, LETRAS_Y_ESPACIOS);
    }

    public boolean cadenaEsAlfanumerica(String valor) {
        return cadenaAceptaElPatron(valor, ALFANUMERICO);
    }

    public boolean cadenaCorreo(String valor) {
        return cadenaAceptaElPatron(valor, CORREO);
    }

    public boolean cadenaContrasena(String valor) {
        return cadenaAceptaElPatron(valor, PATRON_CONTRASENA);
    }

    public boolean cadenaDocumento(String valor) {
        return cadenaAceptaElPatron(valor, DOCUMENTO);
    }

    public boolean cadenaURL(String valor) {
        return cadenaAceptaElPatron(valor, URL);
    }

}
