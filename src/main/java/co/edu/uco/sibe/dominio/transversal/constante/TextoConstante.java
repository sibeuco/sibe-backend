package co.edu.uco.sibe.dominio.transversal.constante;

public final class TextoConstante {
    public static final String VACIO = "";
    public static final String UNDERSCORE = "_";
    public static final String COLON = ":";
    public static final String COMMA = ",";
    public static final String ASTERISK = "*";

    public static final String SIGLA_CC = "CC";
    public static final String DESCRIPCION_CC = "Cédula de Ciudadanía";
    public static final String SIGLA_TI = "TI";
    public static final String DESCRIPCION_TI = "Tarjeta de Identidad";
    public static final String SIGLA_CE = "CE";
    public static final String DESCRIPCION_CE = "Cédula de Extranjería";

    public static final String NOMBRE_AREA_BIENESTAR = "Bienestar";
    public static final String NOMBRE_AREA_EVANGELIZACION = "Evangelización";
    public static final String NOMBRE_AREA_HOGAR_JUVENIL = "Hogar Juvenil Santa María";
    public static final String NOMBRE_AREA_SERVICIO_USUARIO = "Servicio y atención al usuario";
    public static final String NOMBRE_SUB_AREA_DEPORTERS = "Deportes";
    public static final String NOMBRE_SUB_AREA_CANCHA = "Cancha sintética";
    public static final String NOMBRE_SUB_AREA_EXTENSION = "Extensión cultural";
    public static final String NOMBRE_SUB_AREA_BANDA = "Banda Sinfónica";
    public static final String NOMBRE_SUB_AREA_GIMNASIO = "Gimnasio";
    public static final String NOMBRE_SUB_AREA_UNIDAD_SALUD = "Unidad de Salud";
    public static final String NOMBRE_SUB_AREA_ACOMPANAMIENTO = "Acompañamiento psicosocial";
    public static final String NOMBRE_SUB_AREA_TRABAJO_SOCIAL = "Trabajo social";
    public static final String NOMBRE_DIRECCION_BIENESTAR_EVANGELIZACION = "Dirección de Bienestar y Evangelización";

    public static final String NUMERO_ID_ADMIN = "1111111111";
    public static final String NOMBRE_ADMIN = "Administrador";
    public static final String APELLIDO_ADMIN = "UCO";
    public static final String EMAIL_ADMIN = "administrador@uco.net.co";
    public static final String CLAVE_ADMIN = "Administrador123";

    public static final String PENDIENTE = "Pendiente";
    public static final String EN_CURSO = "En curso";
    public static final String FINALIZADA = "Finalizada";

    public static final String TEMPORALIDAD_DIARIA = "Diaria";
    public static final String TEMPORALIDAD_SEMANAL = "Semanal";
    public static final String TEMPORALIDAD_MENSUAL = "Mensual";
    public static final String TEMPORALIDAD_TRIMESTRAL = "Trimestral";
    public static final String TEMPORALIDAD_ANUAL = "Anual";

    public static final String USER_API = "/usuarios";
    public static final String LOGIN_API = "/login";

    public static final String USUARIO_IDENTIFICADOR = "/usuario/{identificador}";
    public static final String IDENTIFICADOR = "identificador";
    public static final String TIPOS_IDENTIFICACION = "/tipos_identificacion";
    public static final String TIPOS_USUARIO = "/tipos_usuario";
    public static final String USUARIO_ID_IDENTIFICADOR = "/usuario/id/{identificador}";
    public static final String USUARIO_CORREO_CORREO = "/usuario/correo/{correo}";
    public static final String ADMINISTRADOR_DIRECCION = "ADMINISTRADOR_DIRECCION";
    public static final String DESCRIPCION_ADMINISTRADOR_DIRECCION = "Administrador de dirección";
    public static final String ADMINISTRADOR_AREA = "ADMINISTRADOR_AREA";
    public static final String DESCRIPCION_ADMINISTRADOR_AREA = "Administrador de Area";
    public static final String COLABORADOR = "COLABORADOR";
    public static final String DESCRIPCION_COLABORADOR = "Colaborador";

    public static final String ADMIN_CREATE_AUTHORITY = "ADMINISTRADOR_DIRECCION_CREATE";
    public static final String ADMIN_GET_AUTHORITY = "ADMINISTRAD_DIRECCION_READ";
    public static final String ADMIN_UPDATE_AUTHORITY = "ADMINISTRADOR_DIRECCION_UPDATE";
    public static final String ADMIN_DELETE_AUTHORITY = "ADMINISTRADOR_DIRECCION_DELETE";

    public static final String USER_GET_AUTHORITY = "COLABORADOR_READ";
    public static final String USER_UPDATE_AUTHORITY = "COLABORADOR_UPDATE";

    public static final String CREATE_AUTHORITY = "CREATE";
    public static final String READ_AUTHORITY = "READ";
    public static final String UPDATE_AUTHORITY = "UPDATE";
    public static final String DELETE_AUTHORITY = "DELETE";

    public static final String HAS_ADMIN_CREATE_AUTHORITY = "hasAuthority('" + ADMIN_CREATE_AUTHORITY + "')";
    public static final String HAS_ADMIN_GET_AUTHORITY = "hasAuthority('" + ADMIN_GET_AUTHORITY + "')";
    public static final String HAS_ADMIN_UPDATE_AUTHORITY = "hasAuthority('" + ADMIN_UPDATE_AUTHORITY + "')";
    public static final String HAS_ADMIN_DELETE_AUTHORITY = "hasAuthority('" + ADMIN_DELETE_AUTHORITY + "')";

    public static final String HAS_USER_GET_AUTHORITY = "hasAuthority('" + USER_GET_AUTHORITY + "')";
    public static final String HAS_USER_UPDATE_AUTHORITY = "hasAuthority('" + USER_UPDATE_AUTHORITY + "')";

    public static final String HAS_USER_OR_ADMIN_GET_AUTHORITY = HAS_USER_GET_AUTHORITY + " or " + HAS_ADMIN_GET_AUTHORITY;
    public static final String HAS_USER_OR_ADMIN_UPDATE_AUTHORITY = HAS_USER_UPDATE_AUTHORITY + " or " + HAS_ADMIN_UPDATE_AUTHORITY;

    public static final String USERNAME = "username";
    public static final String AUTHORITIES = "authorities";

    public static final String NO_VERIFICADO = "unchecked";
    public static final String TEST_CASE = "test";

    private TextoConstante() {
        super();
    }
}
