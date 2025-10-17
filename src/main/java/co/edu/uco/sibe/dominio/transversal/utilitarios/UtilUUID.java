package co.edu.uco.sibe.dominio.transversal.utilitarios;

import java.util.UUID;

public final class UtilUUID {
    private static final String UUID_DEFECTO_TEXTO = "00000000-0000-0000-0000-000000000000";

    private UtilUUID() {
        super();
    }

    public static UUID textoAUUID(final String texto) {
        return UUID.fromString(ValidadorObjeto.obtenerValorPorDefecto(texto, UUID_DEFECTO_TEXTO));
    }

    public static UUID obtenerValorDefecto() {
        return textoAUUID(UUID_DEFECTO_TEXTO);
    }

    public static UUID generarNuevoUUID() {
        return UUID.randomUUID();
    }
}