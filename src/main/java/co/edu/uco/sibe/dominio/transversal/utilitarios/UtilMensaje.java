package co.edu.uco.sibe.dominio.transversal.utilitarios;

import java.util.UUID;

public final class UtilMensaje {
    public static final String DETALLE_ACCION_OBLIGATORIO = "El detalle de la acción es obligatorio.";
    public static final String DETALLE_ACCION_INVALIDO = "El detalle proporcionado para la acción es inválido.";
    public static final String LONGITUD_DETALLE_ACCION_INVALIDA = "El detalle de la acción debe tener entre 10 y 500 caracteres.";
    public static final String OBJETIVO_ACCION_OBLIGATORIO = "El objetivo de la acción es obligatorio.";
    public static final String OBJETIVO_ACCION_INVALIDO = "El objetivo proporcionado para la acción es inválido.";
    public static final String LONGITUD_OBJETIVO_ACCION_INVALIDA = "El objetivo de la acción debe tener entre 10 y 500 caracteres.";

    public static final String NOMBRE_ACTIVIDAD_OBLIGATORIO = "El nombre de la actividad es obligatorio.";
    public static final String NOMBRE_ACTIVIDAD_INVALIDO = "El nombre proporcionado para la actividad es inválido.";
    public static final String LONGITUD_NOMBRE_ACTIVIDAD_INVALIDA = "El nombre de la actividad debe tener entre 10 y 200 caracteres.";
    public static final String OBJETIVO_ACTIVIDAD_OBLIGATORIO = "El objetivo de la actividad es obligatorio.";
    public static final String OBJETIVO_ACTIVIDAD_INVALIDO = "El objetivo proporcionado para la actividad es inválido.";
    public static final String LONGITUD_OBJETIVO_ACTIVIDAD_INVALIDA = "El objetivo de la actividad debe tener entre 10 y 500 caracteres.";
    public static final String SEMESTRE_ACTIVIDAD_OBLIGATORIO = "El semestre de la actividad es obligatorio.";
    public static final String SEMESTRE_ACTIVIDAD_INVALIDO = "El semestre proporcionado para la actividad es inválido.";
    public static final String LONGITUD_SEMESTRE_ACTIVIDAD_INVALIDA = "El semestre de la actividad debe tener 6 caracteres.";
    public static final String RUTA_INSUMOS_ACTIVIDAD_OBLIGATORIA = "La ruta de los insumos de la actividad es obligatoria.";
    public static final String RUTA_INSUMOS_ACTIVIDAD_INVALIDA = "La ruta de los insumos proporcionada para la actividad es inválida.";
    public static final String LONGITUD_RUTA_INSUMOS_ACTIVIDAD_INVALIDA = "La ruta de los insumos de la actividad debe tener entre 10 y 3000 caracteres.";

    public static final String NOMBRE_AREA_OBLIGATORIO = "El nombre del área es obligatorio.";
    public static final String NOMBRE_AREA_INVALIDO = "El nombre proporcionado para el área es inválido.";
    public static final String LONGITUD_NOMBRE_AREA_INVALIDA = "El nombre del área debe tener entre 8 y 70 caracteres.";

    public static final String CODIGO_CENTRO_COSTOS_OBLIGATORIO = "El código del centro de costos es obligatorio.";
    public static final String CODIGO_CENTRO_COSTOS_INVALIDO = "El código proporcionado para el centro de costos es inválido.";
    public static final String LONGITUD_CODIGO_CENTRO_COSTOS_INVALIDA = "El código del centro de costos debe tener entre 4 y 6 caracteres.";
    public static final String DESCRIPCION_CENTRO_COSTOS_OBLIGATORIA = "La descripción del centro de costos es obligatoria.";
    public static final String DESCRIPCION_CENTRO_COSTOS_INVALIDA = "La descripción proporcionada para el centro de costos es inválida.";
    public static final String LONGITUD_DESCRIPCION_CENTRO_COSTOS_INVALIDA = "La descripción del centro de costos debe tener entre 10 y 100 caracteres.";

    public static final String DESCRIPCION_CIUDAD_RESIDENCIA_OBLIGATORIA = "La descripción de la ciudad de residencia es obligatoria.";
    public static final String DESCRIPCION_CIUDAD_RESIDENCIA_INVALIDA = "La descripción proporcionada para la ciudad de residencia es inválida.";
    public static final String LONGITUD_DESCRIPCION_CIUDAD_RESIDENCIA_INVALIDA = "La descripción de la ciudad de residencia debe tener entre 3 y 30 caracteres.";

    public static final String NOMBRE_DIRECCION_OBLIGATORIO = "El nombre de la Dirección es obligatorio.";
    public static final String NOMBRE_DIRECCION_INVALIDO = "El nombre proporcionado para la Dirección es inválido.";
    public static final String LONGITUD_NOMBRE_DIRECCION_INVALIDA = "El nombre de la Dirección debe tener entre 10 y 70 caracteres.";

    public static final String NOMBRE_ESTADO_ACTIVIDAD_OBLIGATORIO = "El nombre del estado de la actividad es obligatorio.";
    public static final String NOMBRE_ESTADO_ACTIVIDAD_INVALIDO = "El nombre proporcionado para el estado de la actividad es inválido.";
    public static final String LONGITUD_NOMBRE_ESTADO_ACTIVIDAD_INVALIDA = "El nombre del estado de la actividad debe tener entre 5 y 15 caracteres.";

    public static final String NACIONALIDAD_ESTUDIANTE_OBLIGATORIA = "La nacionalidad del estudiante es obligatoria.";
    public static final String NACIONALIDAD_ESTUDIANTE_INVALIDA = "La nacionalidad proporcionada para el estudiante es inválida.";
    public static final String LONGITUD_NACIONALIDAD_ESTUDIANTE_INVALIDA = "La nacionalidad del estudiante debe tener entre 4 y 50 caracteres.";
    public static final String ESTADO_CIVIL_ESTUDIANTE_OBLIGATORIO = "El estado civil del estudiante es obligatorio.";
    public static final String ESTADO_CIVIL_ESTUDIANTE_INVALIDO = "El estado civil proporcionado para el estudiante es inválido.";
    public static final String LONGITUD_ESTADO_CIVIL_ESTUDIANTE_INVALIDA = "El estado civil del estudiante debe tener entre 5 y 15 caracteres.";
    public static final String CORREO_PERSONAL_ESTUDIANTE_OBLIGATORIO = "El correo personal del estudiante es obligatorio.";
    public static final String CORREO_PERSONAL_ESTUDIANTE_INVALIDO = "El correo personal proporcionado para el estudiante es inválido.";
    public static final String LONGITUD_CORREO_PERSONAL_ESTUDIANTE_INVALIDA = "El correo personal del estudiante debe tener entre 10 y 100 caracteres.";
    public static final String CORREO_INSTITUCIONAL_ESTUDIANTE_OBLIGATORIO = "El correo institucional del estudiante es obligatorio.";
    public static final String CORREO_INSTITUCIONAL_ESTUDIANTE_INVALIDO = "El correo institucional proporcionado para el estudiante es inválido.";
    public static final String LONGITUD_CORREO_INSTITUCIONAL_ESTUDIANTE_INVALIDA = "El correo institucional del estudiante debe tener entre 10 y 100 caracteres.";
    public static final String PROGRAMA_ACADEMICO_ESTUDIANTE_OBLIGATORIO = "El programa académico del estudiante es obligatorio.";
    public static final String PROGRAMA_ACADEMICO_ESTUDIANTE_INVALIDO = "El programa académico proporcionado para el estudiante es inválido.";
    public static final String LONGITUD_PROGRAMA_ACADEMICO_ESTUDIANTE_INVALIDA = "El programa académico del estudiante debe tener entre 5 y 100 caracteres.";
    public static final String FACULTAD_ESTUDIANTE_OBLIGATORIA = "La facultad del estudiante es obligatoria.";
    public static final String FACULTAD_ESTUDIANTE_INVALIDA = "La facultad proporcionada para el estudiante es inválida.";
    public static final String LONGITUD_FACULTAD_ESTUDIANTE_INVALIDA = "La facultad del estudiante debe tener entre 5 y 50 caracteres.";
    public static final String ANNO_INGRESO_ESTUDIANTE_INVALIDO = "El año de ingreso del estudiante debe ser mayor o igual al año 2000.";
    public static final String CREDITOS_APROBADOS_ESTUDIANTE_INVALIDOS = "El número de créditos aprobados del estudiante debe ser mayor o igual a 0.";
    public static final String PROMEDIO_GENERAL_ESTUDIANTE_INVALIDO = "El promedio general del estudiante debe ser mayor o igual a 0.0.";
    public static final String ESTADO_ACADEMICO_ESTUDIANTE_OBLIGATORIO = "El estado académico del estudiante es obligatorio.";
    public static final String ESTADO_ACADEMICO_ESTUDIANTE_INVALIDO = "El estado académico proporcionado para el estudiante es inválido.";
    public static final String LONGITUD_ESTADO_ACADEMICO_ESTUDIANTE_INVALIDA = "El estado académico del estudiante debe tener entre 6 y 10 caracteres.";
    public static final String MODALIDAD_ESTUDIO_ESTUDIANTE_OBLIGATORIA = "La modalidad de estudio del estudiante es obligatoria.";
    public static final String MODALIDAD_ESTUDIO_ESTUDIANTE_INVALIDA = "La modalidad de estudio proporcionada para el estudiante es inválida.";
    public static final String LONGITUD_MODALIDAD_ESTUDIO_ESTUDIANTE_INVALIDA = "La modalidad de estudio del estudiante debe tener entre 5 y 50 caracteres.";
    public static final String TIEMPO_LLEGADA_ESTUDIANTE_INVALIDO = "El tiempo de llegada del estudiante debe ser mayor o igual a un 1 minuto.";
    public static final String MEDIO_TRANSPORTE_ESTUDIANTE_INVALIDO = "El medio de transporte proporcionado para el estudiante es inválido.";
    public static final String LONGITUD_MEDIO_TRANSPORTE_ESTUDIANTE_INVALIDA = "El medio de transporte del estudiante debe tener entre 5 y 30 caracteres.";
    public static final String SEMESTRE_ACTUAL_ESTUDIANTE_OBLIGATORIO = "El semestre del estudiante es obligatorio.";
    public static final String SEMESTRE_ACTUAL_ESTUDIANTE_INVALIDO = "El semestre proporcionado para el estudiante es inválido.";
    public static final String LONGITUD_SEMESTRE_ACTUAL_ESTUDIANTE_INVALIDA = "El semestre del estudiante debe tener 5 caracteres.";

    public static final String NOMBRE_INDICADOR_OBLIGATORIO = "El nombre del indicador es obligatorio.";
    public static final String NOMBRE_INDICADOR_INVALIDO = "El nombre proporcionado para el indicador es inválido.";
    public static final String LONGITUD_NOMBRE_INDICADOR_INVALIDA = "El nombre del indicador debe tener entre 10 y 100 caracteres.";

    public static final String ID_CARNET_OBLIGATORIO = "El ID de carnet es obligatorio.";
    public static final String ID_CARNET_INVALIDO = "El ID de carnet proporcionado es inválido.";
    public static final String LONGITUD_ID_CARNET_INVALIDA = "El ID del carnet debe tener entre 1 y 20 caracteres.";
    public static final String SEXO_OBLIGATORIO = "El campo sexo es obligatorio.";
    public static final String SEXO_INVALIDO = "El sexo proporcionado es inválido.";
    public static final String LONGITUD_SEXO_INVALIDA = "El sexo solo debe tener 1 carácter.";

    public static final String NOMBRE_COMPLETO_MIEMBRO_OBLIGATORIO = "El nombre completo del miembro es obligatorio.";
    public static final String NOMBRE_COMPLETO_MIEMBRO_INVALIDO = "El nombre proporcionado para el miembro es inválido.";
    public static final String LONGITUD_NOMBRE_COMPLETO_MIEMBRO_INVALIDA = "El nombre completo del miembro debe tener entre 5 y 100 caracteres.";
    public static final String NUMERO_IDENTIFICACION_MIEMBRO_OBLIGATORIO = "El número de identificación del miembro es obligatorio.";
    public static final String NUMERO_IDENTIFICACION_MIEMBRO_INVALIDO = "El número de identificación proporcionado para el miembro es inválido.";
    public static final String LONGITUD_NUMERO_IDENTIFICACION_MIEMBRO_INVALIDA = "El número de identificación del miembro debe tener entre 6 y 12 caracteres.";
    public static final String LONGITUD_NUMERO_IDENTIFICACION__INVALIDA = "El número de identificación debe tener entre 6 y 12 caracteres.";

    public static final String ESTADO_CIVIL_PARTICIPANTE_ESTUDIANTE_OBLIGATORIO = "El estado civil del participante estudiante es obligatorio.";
    public static final String ESTADO_CIVIL_PARTICIPANTE_ESTUDIANTE_INVALIDO = "El estado civil proporcionado para el participante estudiante es inválido.";
    public static final String LONGITUD_ESTADO_CIVIL_PARTICIPANTE_ESTUDIANTE_INVALIDA = "El estado civil del participante estudiante debe tener entre 5 y 15 caracteres.";
    public static final String PROGRAMA_PARTICIPANTE_ESTUDIANTE_OBLIGATORIO = "El programa académico del participante estudiante es obligatorio.";
    public static final String PROGRAMA_PARTICIPANTE_ESTUDIANTE_INVALIDO = "El programa académico proporcionado para el participante estudiante es inválido.";
    public static final String LONGITUD_PROGRAMA_PARTICIPANTE_ESTUDIANTE_INVALIDA = "El programa académico del participante estudiante debe tener entre 5 y 100 caracteres.";
    public static final String FACULTAD_PARTICPANTE_ESTUDIANTE_OBLIGATORIA = "La facultad del particpante estudiante es obligatoria.";
    public static final String FACULTAD_PARTICIPANTE_ESTUDIANTE_INVALIDA = "La facultad proporcionada para el participante estudiante es inválida.";
    public static final String LONGITUD_FACULTAD_PARTICIPANTE_ESTUDIANTE_INVALIDA = "La facultad del participante estudiante debe tener entre 5 y 50 caracteres.";
    public static final String ANNO_INGRESO_PARTICIPANTE_ESTUDIANTE_INVALIDO = "El año de ingreso del participante estudiante debe ser mayor o igual al año 2000.";
    public static final String SEMESTRE_PARTICIPANTE_ESTUDIANTE_OBLIGATORIO = "El semestre del participante estudiante es obligatorio.";
    public static final String SEMESTRE_PARTICIPANTE_ESTUDIANTE_INVALIDO = "El semestre proporcionado para el participante estudiante es inválido.";
    public static final String LONGITUD_SEMESTRE_PARTICIPANTE_ESTUDIANTE_INVALIDA = "El semestre del participante estudiante debe tener 5 caracteres.";
    public static final String CREDITOS_APROBADOS_PARTICIPANTE_ESTUDIANTE_INVALIDOS = "El número de créditos aprobados del participante estudiante debe ser mayor o igual a 0.";
    public static final String PROMEDIO_GENERAL_PARTICIPANTE_ESTUDIANTE_INVALIDO = "El promedio general del estudiante debe ser mayor o igual a 0.0.";
    public static final String ESTADO_ACADEMICO_PARTICIPANTE_ESTUDIANTE_OBLIGATORIO = "El estado académico del participante estudiante es obligatorio.";
    public static final String ESTADO_ACADEMICO_PARTICIPANTE_ESTUDIANTE_INVALIDO = "El estado académico proporcionado para el participante estudiante es inválido.";
    public static final String LONGITUD_ESTADO_ACADEMICO_PARTICIPANTE_ESTUDIANTE_INVALIDA = "El estado académico del participante estudiante debe tener entre 6 y 10 caracteres.";
    public static final String MODALIDAD_ESTUDIO_PARTICIPANTE_ESTUDIANTE_OBLIGATORIA = "La modalidad de estudio del participante estudiante es obligatoria.";
    public static final String MODALIDAD_ESTUDIO_PARTICIPANTE_ESTUDIANTE_INVALIDA = "La modalidad de estudio proporcionada para el participante estudiante es inválida.";
    public static final String LONGITUD_MODALIDAD_ESTUDIO_PARTICIPANTE_ESTUDIANTE_INVALIDA = "La modalidad de estudio del participante estudiante debe tener entre 5 y 50 caracteres.";
    public static final String TIEMPO_LLEGADA_PARTICIPANTE_ESTUDIANTE_INVALIDO = "El tiempo de llegada del participante estudiante debe ser mayor o igual a un 1 minuto.";
    public static final String MEDIO_TRANSPORTE_PARTICIPANTE_ESTUDIANTE_INVALIDO = "El medio de transporte proporcionado para el participante estudiante es inválido.";
    public static final String LONGITUD_MEDIO_TRANSPORTE_PARTICIPANTE_ESTUDIANTE_INVALIDA = "El medio de transporte del participante estudiante debe tener entre 5 y 30 caracteres.";

    public static final String ID_CARNET_INTERNO_OBLIGATORIO = "El ID de carnet del participante interno es obligatorio.";
    public static final String ID_CARNET_INTERNO_INVALIDO = "El ID de carnet proporcionado para el participante interno es inválido.";
    public static final String LONGITUD_ID_CARNET_INTERNO_INVALIDA = "El ID del carnet del participante interno debe tener entre 1 y 20 caracteres.";
    public static final String SEXO_PARTICIPANTE_INTERNO_OBLIGATORIO = "El campo sexo del participante interno es obligatorio.";
    public static final String SEXO_PARTICIPANTE_INTERNO_INVALIDO = "El sexo proporcionado para el participante interno es inválido.";
    public static final String LONGITUD_SEXO_PARTICIPANTE_INTERNO_INVALIDA = "El sexo del participante interno solo debe tener 1 carácter.";

    public static final String LONGITUD_CORREO_PERSONA_INVALIDA = "El correo de la persona debe tener entre 10 y 100 caracteres.";

    public static final String NUMERO_PROYECTO_OBLIGATORIO = "El número de proyecto es obligatorio.";
    public static final String NUMERO_PROYECTO_INVALIDO = "El número de proyecto es inválido.";
    public static final String LONGITUD_NUMERO_PROYECTO_INVALIDA = "El número de proyecto solo debe tener entre 1 y 12 caracteres.";
    public static final String NOMBRE_PROYECTO_OBLIGATORIO = "El nombre del proyecto es obligatorio.";
    public static final String NOMBRE_PROYECTO_INVALIDO = "El nombre proporcionado para el proyecto es inválido.";
    public static final String LONGITUD_NOMBRE_PROYECTO_INVALIDA = "El nombre del proyecto debe tener entre 10 y 100 caracteres.";
    public static final String OBJETIVO_PROYECTO_OBLIGATORIO = "El objetivo del proyecto es obligatorio.";
    public static final String OBJETIVO_PROYECTO_INVALIDO = "El objetivo proporcionado para el proyecto es inválido.";
    public static final String LONGITUD_OBJETIVO_PROYECTO_INVALIDA = "El objetico del proyecto debe tener entre 10 y 500 caracteres.";

    public static final String NOMBRE_PUBLICO_OBLIGATORIO = "El nombre del público objetivo es obligatorio.";
    public static final String NOMBRE_PUBLICO_INVALIDO = "El nombre proporcionado para el público objetivo es inválido.";
    public static final String LONGITUD_NOMBRE_PUBLICO_INVALIDA = "El nombre del público objetivo debe tener entre 5 y 50 caracteres.";

    public static final String CODIGO_RELACION_OBLIGATORIO = "El código de la relación laboral es obligatorio.";
    public static final String CODIGO_RELACION_INVALIDO = "El código proporcionado de la relación laboral es inválido.";
    public static final String LONGITUD_CODIGO_RELACION_INVALIDA = "El código de la relación laboral debe tener entre 2 y 4 caracteres.";
    public static final String DESCRIPCION_RELACION_LABORAL_OBLIGATORIA = "La descripción de la relación laboral es obligatoria.";
    public static final String DESCRIPCION_RELACION_LABORAL_INVALIDA = "La descripción proporcionada para la relación laboral es inválida.";
    public static final String LONGITUD_DESCRIPCION_RELACION_LABORAL_INVALIDA = "La descripción de la relación laboral debe tener entre 5 y 20 caracteres.";

    public static final String NOMBRE_SUB_AREA_OBLIGATORIO = "El nombre de la sub área es obligatorio.";
    public static final String NOMBRE_SUB_AREA_INVALIDO = "El nombre proporcionado para la sub área es inválido.";
    public static final String LONGITUD_NOMBRE_SUB_AREA_INVALIDA = "El nombre de la sub área debe tener entre 8 y 70 caracteres.";

    public static final String NOMBRE_TEMPORALIDAD_OBLIGATORIO = "El nombre de la temporalidad es obligatorio.";
    public static final String NOMBRE_TEMPORALIDAD_INVALIDO = "El nombre proporcionado para la temporalidad es inválido.";
    public static final String LONGITUD_NOMBRE_TEMPORALIDAD_INVALIDA = "El nombre de la temporalidad debe tener entre 5 y 30 caracteres.";

    public static final String NATURALEZA_TIPO_INDICADOR_OBLIGATORIA = "La naturaleza del tipo indicador es obligatoria.";
    public static final String NATURALEZA_TIPO_INDICADOR_INVALIDA = "La naturaleza proporcionada para el tipo indicador es inválida.";
    public static final String LONGITUD_NATURALEZA_TIPO_INDICADOR_INVALIDA = "La naturaleza del tipo indicador debe tener entre 5 y 20 caracteres.";
    public static final String TIPOLOGIA_TIPO_INDICADOR_OBLIGATORIA = "La tipología del tipo indicador es obligatoria.";
    public static final String TIPOLOGIA_TIPO_INDICADOR_INVALIDA = "La tipología proporcionada para el tipo indicador es inválida.";
    public static final String LONGITUD_TIPOLOGIA_TIPO_INDICADOR_INVALIDA = "La tipología del tipo indicador debe tener entre 5 y 15 caracteres.";

    public static final String LONGITUD_CORREO_USUARIO_INVALIDA = "El correo del usuario debe tener entre 10 y 100 caracteres.";
    public static final String LONGITUD_CLAVE_USUARIO_INVALIDA = "La clave del usuario debe tener entre 8 y 20 caracteres.";

    public static final String CAMPO_OBLIGATORIO = "El campo no puede estar vacío.";
    public static final String OCURRIO_UN_ERROR = "Ocurrió un error inesperado, por favor contactar al administrador del sistema.";
    public static final String DOCUMENTO_PERSONA_VACIO = "El documento no puede estar vacío.";
    public static final String PRIMER_NOMBRE_PERSONA_VACIO = "El primer nombre no puede estar vacío.";
    public static final String PRIMER_APELLIDO_PERSONA_VACIO = "El primer apellido no puede estar vacío.";
    public static final String PATRON_DOCUMENTO_PERSONA_INVALIDO = "El documento debe contener solo números y tener entre 5 y 12 dígitos.";
    public static final String PATRON_NOMBRE_PERSONA_INVALIDO = "El nombre solo debe contener letras y espacios.";
    public static final String PATRON_APELLIDO_PERSONA_INVALIDO = "El apellido solo debe contener letras y espacios.";
    public static final String LONGITUD_NOMBRE_PERSONA_INVALIDA = "El nombre debe contener entre 1 y 20 caracteres.";
    public static final String LONGITUD_APELLIDO_PERSONA_INVALIDA = "El apellido debe contener entre 1 y 20 caracteres.";
    public static final String CORREO_EXISTENTE = "Ya existe un usuario con el correo ingresado.";
    public static final String CORREO_USUARIO_VACIO = "El correo electrónico no puede estar vacío.";
    public static final String NO_SE_ECONTRARON_USUARIOS = "No se encontraron usuarios registrados.";
    public static final String NO_SE_ECONTRARON_DIRECCIONES = "No se encontraron direcciones.";
    public static final String PATRON_CORREO_INVALIDO = "El formato del correo electrónico no es válido.";
    public static final String CONTRASENA_VACIA = "La contraseña no puede estar vacía.";
    public static final String PATRON_CONTRASENA_INVALIDO = "La contraseña debe tener entre 8 y 20 caracteres, incluyendo al menos una letra mayúscula, una minúscula y un número.";
    public static final String NOMBRE_TIPO_USUARIO_VACIO = "El nombre del tipo usuario no puede estar vacío.";
    public static final String LONGITUD_NOMBRE_TIPO_USUARIO = "El nombre del tipo usuario debe contener entre 1 y 30 caracteres.";
    public static final String PATRON_SIGLA_TIPO_IDENTIFICACION_INVALIDO = "La sigla del tipo identificacion solo debe contener letras y espacios";
    public static final String LONGITUD_SIGLA_TIPO_IDENTIFICACION_INVALIDA = "El campo sigla debe contener entre 1 y 5 caracteres.";
    public static final String PATRON_DESCIPCION_TIPO_IDENTIFICACION_INVALIDO = "La descripción del tipo identificacion solo debe contener letras y espacios.";
    public static final String LONGITUD_DESCRIPCION_TIPO_IDENTIFICACION_INVALIDA = "El campo de la descripción debe contener entre 1 y 40 caracteres.";
    public static final String IDENTIFICADOR_USUARIO_NULO = "El identificiador de un usuario no puede ser nulo";
    public static final String NO_HAY_CAMPOS_POR_VALIDAR = "No hay campos por validar para este modelo de dominio";
    public static final String IDENTIFICADOR_TIPO_USUARIO_NULO = "El identificador del tipo usuario no puede ser nulo.";
    public static final String IDENTIFICADOR_TIPO_INDICADOR_NULO = "El identificador del tipo indicador no puede ser nulo.";
    public static final String IDENTIFICADOR_TIPO_IDENTIFICACION_NULO = "El identificador del tipo identificacion no puede ser nulo.";
    public static final String IDENTIFICADOR_TEMPORALIDAD_NULO = "El identificador de la temporalidad no puede ser nulo.";
    public static final String IDENTIFICADOR_SUBAREA_NULO = "El identificador de la sub área no puede ser nulo.";
    public static final String IDENTIFICADOR_RELACION_LABORAL_NULO = "El identificador de la relación laboral no puede ser nulo.";
    public static final String IDENTIFICADOR_PUBLICO_INTERES_NULO = "El identificador del público interés no puede ser nulo.";
    public static final String IDENTIFICADOR_PROYECTO_NULO = "El identificador del proyecto no puede ser nulo.";
    public static final String IDENTIFICADOR_PERSONA_NULO = "El identificador de la persona no puede ser nulo.";
    public static final String IDENTIFICADOR_PARTICIPANTE_EMPLEADO_NULO = "El identificador del participante empleado no puede ser nulo.";
    public static final String IDENTIFICADOR_PARTICIPANTE_EXTERNO_NULO = "El identificador del participante externo no puede ser nulo.";
    public static final String IDENTIFICADOR_PARTICIPANTE_ESTUDIANTE_NULO = "El identificador del participante estudiante no puede ser nulo.";
    public static final String IDENTIFICADOR_INDICADOR_NULO = "El identificador del indicador no puede ser nulo.";
    public static final String IDENTIFICADOR_IDENTIFICACION_NULO = "El identificador de la identificación no puede ser nulo.";
    public static final String IDENTIFICADOR_ESTUDIANTE_NULO = "El identificador del estudiante no puede ser nulo.";
    public static final String IDENTIFICADOR_ESTADO_ACTIVIDAD_NULO = "El identificador del estado actividad no puede ser nulo.";
    public static final String IDENTIFICADOR_DIRECCION_NULO = "El identificador de la dirección no puede ser nulo.";
    public static final String IDENTIFICADOR_CIUDAD_RESIDENCIA_NULO = "El identificador de la ciudad de residencia no puede ser nulo.";
    public static final String IDENTIFICADOR_CENTRO_COSTOS_NULO = "El identificador del centro de costos no puede ser nulo.";
    public static final String IDENTIFICADOR_AREA_NULO = "El identificador del área no puede ser nulo.";
    public static final String IDENTIFICADOR_ACTIVIDAD_NULO = "El identificador de la actividad no puede ser nulo.";
    public static final String IDENTIFICADOR_ACCION_NULO = "El identificador de la acción no puede ser nulo.";
    public static final String IDENTIFICADOR_EJECUCION_ACTIVIDAD_NULO = "El identificador de la ejecución de la actividad no puede ser nulo.";
    public static final String IDENTIFICADOR_EMPLEADO_NULO = "El identificador del empleado no puede ser nulo.";
    public static final String IDENTIFICADOR_EXTERNO_NULO = "El identificador del externo no puede ser nulo.";
    public static final String IDENTIFICADOR_REGISTRO_ASISTENCIA_NULO = "El identificador del registro de asistencia no puede ser nulo.";
    public static final String IDENTIFICADOR_USUARIO_ORGANIZACION_NULO = "El identificador del usuario organizaicón no puede ser nulo.";
    public static final String DOCUMENTO_EXISTENTE = "Ya existe un usuario con el número de identificación suministrado.";
    public static final String EL_CODIGO_PARA_RECUPERAR_CLAVE_YA_NO_ES_VALIDO = "El codigo para recuperar la clave es invalido.";
    public static final String EL_CODIGO_PARA_RECUPERAR_CLAVE_ES_INCORRECTO = "El codigo para recuperar la clave es incorrecto";
    private static final String NO_EXISTE_USUARIO_CON_IDENTIFICADOR = "No existe un usuario con el identificador ";
    private static final String NO_EXISTE_USUARIO_CON_CORREO = "No existe un usuario con el correo ";
    private static final String NO_EXISTE_PERSONA_CON_CORREO = "No existe un persona con el correo ";
    private static final String NO_EXISTE_PERSONA_CON_IDENTIFICADOR = "No existe un persona con el identificador ";
    public static final String VALIDANDO_AUTENTICACION = "La autenticación está siendo validada.";
    public static final String TOKEN_RECIBIDO_INVALIDO = "El token recibido es inválido.";
    public static final String ERROR_DECODIFICANDO_TOKEN_AUTENTICACION_BASICA = "Error al decodificar el token de autenticación básica.";
    public static final String USUARIO_O_CLAVE_INCORRECTO = "El usuario o la contraseña no son validos.";
    public static final String ERROR_AL_ENVIAR_CORREO = "Error al enviar el correo";
    public static final String ERROR_INESPERADO_EN_EL_SERVICIO_DE_ENVIAR_CORREO = "Error inesperado en el servicio de correo";
    public static final String LA_CLAVE_NUEVA_NO_PUEDE_SER_IGUAL_A_LA_ANTIGUA = "La clave nueva no puede ser igual a la antigua.";
    public static final String LA_CLAVE_ANTIGUA_ES_INCORRECTA = "La clave antigua es incorrecta.";


    private UtilMensaje() {
        super();
    }

    public static String obtenerNoExisteUsuarioConId(UUID identificador) {
        return NO_EXISTE_USUARIO_CON_IDENTIFICADOR + identificador;
    }

    public static String obtenerNoExistePersonaConCorreo(String correo) {
        return NO_EXISTE_PERSONA_CON_CORREO + correo;
    }

    public static String obtenerNoExisteUsuarioConCorreo(String correo) {
        return NO_EXISTE_USUARIO_CON_CORREO + correo;
    }

    public static String obtenerNoExistePersonaConId(UUID identificador) {
        return NO_EXISTE_PERSONA_CON_IDENTIFICADOR + identificador;
    }

    public static String getUserWasSuccessfullyAuthenticatedAndHasTheRoles(String name, String role) {
        return "Usuario " + name + " fue autenticado exitosamente y tiene el rol de: " + role;
    }

    public static String consultarPorNombre(String nombre) {
        return "No existe direccion con el nombre: " + nombre;
    }

    public static String consultarPorSigla(String sigla) {
        return "No existe tipo identificacion con la sigla: " + sigla;
    }

    public static String consultarPorCodigo(String codigo) {
        return "No existe tipo usuario con el codigo: " + codigo;
    }
}