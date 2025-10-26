package co.edu.uco.sibe.dominio.transversal.constante;

import co.edu.uco.sibe.infraestructura.adaptador.entidad.PublicoInteresEntidad;

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
    public static final String DIRECCION = "/direcciones";
    public static final String AREA = "/areas";
    public static final String SUBAREA = "/subareas";

    public static final String ADMIN_CREATE_AUTHORITY = "ADMINISTRADOR_DIRECCION_CREATE";
    public static final String ADMIN_GET_AUTHORITY = "ADMINISTRADOR_DIRECCION_READ";
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

    public static final String TABLA_ACCION = "accion";
    public static final String CAMPO_IDENTIFICADOR = "identificador";
    public static final String CAMPO_DETALLE = "detalle";
    public static final String CAMPO_OBJETIVO = "objetivo";
    public static final String TABLA_ACTIVIDAD = "actividad";
    public static final String CAMPO_NOMBRE = "nombre";
    public static final String CAMPO_SEMESTRE = "semestre";
    public static final String CAMPO_RUTA_INSUMOS = "ruta_insumos";
    public static final String CAMPO_INDICADOR = "indicador";
    public static final String CAMPO_COLABORADOR = "colaborador";
    public static final String CAMPO_CREADOR = "creador";
    public static final String TABLA_AREA = "area";
    public static final String CAMPO_AREA = "area";
    public static final String CAMPO_ACTIVIDAD = "actividad";
    public static final String AREA_ACTIVIDAD = "area_actividad";
    public static final String TABLA_CENTRO_COSTOS = "centro_costos";
    public static final String TABLA_CIUDAD_RESIDENCIA = "ciudad_residencia";
    public static final String TABLA_DIRECCION = "direccion";
    public static final String CAMPO_DIRECCION = "direccion";
    public static final String DIRECCION_ACTIVIDAD = "direccion_actividad";
    public static final String TABLA_EJECUCION_ACTIVIDAD = "ejecucion_actividad";
    public static final String CAMPO_FECHA_PROGRAMADA = "fecha_programada";
    public static final String CAMPO_FECHA_REALIZACION = "fecha_realizacion";
    public static final String CAMPO_HORA_INICIO = "hora_inicio";
    public static final String CAMPO_HORA_FIN = "hora_fin";
    public static final String CAMPO_EJECUCION_ACTIVIDAD = "ejecucion_actividad";
    public static final String CAMPO_ACTIVIDAD_ID = "actividad_id";
    public static final String TABLA_EJECUCION_ACTIVIDAD_ESTADO_ACTIVIDAD = "ejecucion_actividad_estado_actividad";
    public static final String CAMPO_ESTADO_ACTIVIDAD = "estado_actividad";
    public static final String EMPLEADO_CENTRO_COSTOS = "empleado_centro_costos";
    public static final String TABLA_EMPLEADO = "empleado";
    public static final String CAMPO_CENTRO_COSTOS = "centro_costos";
    public static final String CAMPO_RELACION_LABORAL = "relacion_laboral";
    public static final String TABLA_EMPLEADO_RELACION_LABORAL = "empleado_relacion_laboral";
    public static final String TABLA_ESTADO_ACTIVIDAD = "estado_actividad";
    public static final String TABLA_USUARIO_TIPO_USUARIO = "usuario_tipo_usuario";
    public static final String TIPO_USUARIO = "tipo_usuario";
    public static final String USUARIO_ORGANIZACION = "usuario_organizacion";
    public static final String USUARIO = "usuario";
    public static final String SUB_AREA = "subarea";
    public static final String ESTA_ACTIVO = "esta_activo";
    public static final String TIPO_INDICADOR = "tipo_indicador";
    public static final String NATURALEZA = "naturaleza";
    public static final String TIPOLOGIA = "tipologia";
    public static final String TIPO_IDENTIFICACION = "tipo_identificacion";
    public static final String TEMPORALIDAD = "temporalidad";
    public static final String SUB_AREA_ACTIVIDAD = "subarea_actividad";
    public static final String RELACION_LABORAL = "relacion_laboral";
    public static final String REGISTRO_ASISTENCIA = "registro_asistencia";
    public static final String PARTICIPANTE = "participante";
    public static final String PUBLICO_INTERES = "publico_interes";
    public static final String PROYECTO = "proyecto";
    public static final String NUMERO_PROYECTO = "numero_proyecto";
    public static final String PROYECTO_ACCION = "proyecto_accion";
    public static final String ACCION = "accion";
    public static final String PETICION_RECUPERACION_CLAVE = "peticion_recuperacion_clave";
    public static final String PERSONA = "persona";
    public static final String IDENTIFICACION = "identificacion";
    public static final String PARTICIPANTE_INTERNO = "participante_interno";
    public static final String CIUDAD_RESIDENCIA = "ciudad_residencia";
    public static final String ID_CARNET = "id_carnet";
    public static final String SEXO = "sexo";
    public static final String PARTICIPANTE_EXTERNO = "participante_externo";
    public static final String MIEMBRO = "miembro";
    public static final String PARTICIPANTE_EMPLEADO = "participante_empleado";
    public static final String PARTICIPANTE_ESTUDIANTE = "participante_estudiante";
    public static final String ESTADO_CIVIL = "estado_civil";
    public static final String PROGRAMA_ACADEMICO = "programa_academico";
    public static final String FACULTAD = "facultad";
    public static final String ANNO_INGRESO = "anno_ingreso";
    public static final String SEMESTRE_ACTUAL = "semestre_actual";
    public static final String CREDITOS_APROBADOS = "creditos_aprobados";
    public static final String PROMEDIO_GENERAL = "promedio_general";
    public static final String ESTADO_ACADEMICO = "estado_academico";
    public static final String MODALIDAD_ESTUDIO = "modalidad_estudio";
    public static final String TIEMPO_LLEGADA_UNIVERSIDAD = "tiempo_llegada_universidad";
    public static final String MEDIO_TRANSPORTE = "medio_transporte";
    public static final String NOMBRE_COMPLETO = "nombre_completo";
    public static final String NUMERO_IDENTIFICACION = "numero_identificacion";
    public static final String INTERNO = "interno";
    public static final String INTERNO_CIUDAD_RESIDENCIA = "interno_ciudad_residencia";
    public static final String INDICADOR_TIPO_INDICADOR = "indicador_tipo_indicador";
    public static final String INDICADOR_TEMPORALIDAD = "indicador_temporalidad";
    public static final String INDICADOR_PUBLICO_INTERES = "indicador_publico_interes";
    public static final String INDICADOR_PROYECTO = "indicador_proyecto";
    public static final String EXTERNO = "externo";
    public static final String IDENTIFICACION_TIPO_IDENTIFICACION = "identificacion_tipo_identificacion";
    public static final String ESTUDIANTE = "estudiante";
    public static final String FECHA_NACIMIENTO = "fecha_nacimiento";
    public static final String NACIONALIDAD = "nacionalidad";
    public static final String CORREO_PERSONAL = "correo_personal";
    public static final String CORREO_INSTITUCIONAL = "correo_institucional";

    private TextoConstante() {
        super();
    }
}
