package co.edu.uco.sibe.dominio.transversal.utilitarios;

public class UtilNumero {

    private static final UtilNumero instancia = new UtilNumero();
    public static final int CERO = 0;

    private UtilNumero() {}

    public static UtilNumero getInstance() {
        return instancia;
    }

    public boolean esNulo(final Integer valor) {
        return valor == null;
    }

    public int obtenerValorDefecto(final Integer valorOriginal, final int valorDefecto) {
        return (valorOriginal != null) ? valorOriginal : valorDefecto;
    }

    public int obtenerValorDefecto(final Integer valor) {
        return obtenerValorDefecto(valor, CERO);
    }

    public int obtenerValorDefecto() {
        return CERO;
    }

}
