package co.edu.uco.sibe.dominio.transversal.utilitarios;

import java.util.UUID;

public class UtilUUID {

    private static final String UUID_DEFECTO_TEXTO = "00000000-0000-0000-0000-000000000000";

    private UtilUUID() {
        super();
    }

    public static UUID convertirAUUID(final String uuidComoTexto) {
        return UUID.fromString(ValidadorTexto.obtenerValorPorDefecto(uuidComoTexto, UUID_DEFECTO_TEXTO));
    }

    public static UUID obtenerValorDefecto(final UUID valorOriginal, final UUID valorDefecto) {
        return ValidadorObjeto.obtenerValorPorDefecto(valorOriginal, valorDefecto);
    }

    public static UUID obtenerValorDefecto() {
        return convertirAUUID(obtenerValorDefectoComoTexto());
    }

    public static UUID obtenerValorDefecto(final UUID valor) {
        return obtenerValorDefecto(valor, obtenerValorDefecto());
    }

    public static String obtenerValorDefectoComoTexto() {
        return UUID_DEFECTO_TEXTO;
    }

    public static UUID generarNuevoUUID() {
        return UUID.randomUUID();
    }

    public static String generarNuevoUUIDComoTexto() {
        return generarNuevoUUID().toString();
    }

    public static boolean esValorDefecto(final UUID valor) {
        return obtenerValorDefecto(valor, obtenerValorDefecto()).equals(obtenerValorDefecto());
    }

    public static boolean esValorDefecto(final String uuidComoTexto) {
        return obtenerValorDefecto(convertirAUUID(uuidComoTexto), obtenerValorDefecto()).equals(obtenerValorDefecto());
    }

}
