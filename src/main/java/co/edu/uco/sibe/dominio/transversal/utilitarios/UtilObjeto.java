package co.edu.uco.sibe.dominio.transversal.utilitarios;

public class UtilObjeto {

    private static UtilObjeto instancia;

    private UtilObjeto() {

    }

    public static synchronized UtilObjeto getInstance() {
        if (instancia == null) {
            instancia = new UtilObjeto();
        }
        return instancia;
    }

    public <O> boolean esNulo(final O objeto) {
        return objeto == null;
    }

    public <O> O obtenerValorDefecto(final O valorOriginal, final O valorDefecto) {
        return esNulo(valorOriginal) ? valorDefecto : valorOriginal;
    }
}
