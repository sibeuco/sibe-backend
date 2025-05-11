package co.edu.uco.sibe.dominio.transversal.utilitarios;

public class UtilTexto {

    private static UtilTexto instancia = new UtilTexto();
    public final static String VACIO = "";

    private UtilTexto() {
    }

    public static UtilTexto getInstance() {
        return instancia;
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

}
