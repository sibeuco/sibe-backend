package co.edu.uco.sibe.dominio.transversal.constante;

public class TextoConstante {
    public static final String UNDERSCORE = "_";
    public static final String COLON = ":";
    public static final String COMMA = ",";
    public static final String ASTERISK = "*";
    public static final String USER_API = "/usuarios";
    public static final String LOGIN_API = "/login";
    public static final String USER_UPDATE_AUTHORITY = "COLABORADOR_UPDATE";
    public static final String USER_GET_AUTHORITY = "COLABORADOR_READ";
    public static final String ADMIN_DELETE_AUTHORITY = "ADMINISTRADOR_DIRECCION_DELETE";
    public static final String ADMIN_UPDATE_AUTHORITY = "ADMINISTRADOR_DIRECCION_UPDATE";
    public static final String ADMIN_GET_AUTHORITY = "ADMINISTRADOR_DIRECCION_READ";
    public static final String VACIO = "";
    public static final String NO_VERIFICADO = "unchecked";
    private static final String ADMIN_CREATE_AUTHORITY = "ADMINISTRADOR_DIRECCION_CREATE";
    public static final String READ_AUTHORITY = "READ";
    public static final String CREATE_AUTHORITY = "CREATE";
    public static final String UPDATE_AUTHORITY = "UPDATE";
    public static final String DELETE_AUTHORITY = "DELETE";
    public static final String HAS_USER_UPDATE_AUTHORITY = "hasAuthority('" + USER_UPDATE_AUTHORITY + "')";
    public static final String HAS_USER_GET_AUTHORITY = "hasAuthority('" + USER_GET_AUTHORITY + "')";
    public static final String HAS_ADMIN_DELETE_AUTHORITY = "hasAuthority('" + ADMIN_DELETE_AUTHORITY + "')";
    public static final String HAS_ADMIN_UPDATE_AUTHORITY = "hasAuthority('" + ADMIN_UPDATE_AUTHORITY + "')";
    public static final String HAS_ADMIN_GET_AUTHORITY = "hasAuthority('" + ADMIN_GET_AUTHORITY + "')";
    public static final String HAS_ADMIN_CREATE_AUTHORITY = "hasAuthority('" + ADMIN_CREATE_AUTHORITY + "')";
    public static final String HAS_USER_OR_ADMIN_UPDATE_AUTHORITY = HAS_USER_UPDATE_AUTHORITY + " or " + HAS_ADMIN_UPDATE_AUTHORITY;
    public static final String HAS_USER_OR_ADMIN_GET_AUTHORITY = HAS_USER_GET_AUTHORITY + " or " + HAS_ADMIN_GET_AUTHORITY;
    public static final String TEST_CASE = "test";
    public static final String USERNAME = "username";
    public static final String AUTHORITIES = "authorities";

    private TextoConstante(){}
}
