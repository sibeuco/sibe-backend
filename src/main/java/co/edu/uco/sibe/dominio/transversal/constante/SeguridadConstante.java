package co.edu.uco.sibe.dominio.transversal.constante;

import static co.edu.uco.sibe.dominio.transversal.constante.MensajeConstante.NO_SE_PUEDE_INSTANCIAR_UNA_CLASE_UTILITARIA;

public final class SeguridadConstante {
    public static final String JWT_KEY = "jxgEQeXHuPq8VdbyYFNkANdudQ53YUn4";
    public static final String JWT_HEADER = "Authorization";
    public static final String AUTHENTICATION_SCHEME_BASIC = "Basic";
    public static final String JWT_TOKEN = "JWT Token";
    public static final String APP_NAME = "Login";
    public static final String EMAIL_PARAMETER = "email";
    public static final String ID_PARAMETER = "id";
    public static final String AUTHORITIES_PARAMETER = "authorities";
    public static final String LOCAL_FRONT_URL = "http://localhost:4200";

    private SeguridadConstante() {
        throw new UnsupportedOperationException(NO_SE_PUEDE_INSTANCIAR_UNA_CLASE_UTILITARIA);
    }
}