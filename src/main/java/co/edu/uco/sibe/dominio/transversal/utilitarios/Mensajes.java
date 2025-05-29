package co.edu.uco.sibe.dominio.transversal.utilitarios;

import java.util.UUID;

public class Mensajes {
    public static final String CAMPO_OBLIGATORIO = "El campo no puede estar vacío.";
    public static final String OCURRIO_UN_ERROR = "Ocurrió un error inesperado, por favor contactar al administrador del sistema.";
    public static final String NO_SE_ENCONTRARON_PERSONAS = "No se encontraron personas registradas.";
    public static final String DOCUMENTO_PERSONA_VACIO = "El documento no puede estar vacío.";
    public static final String DOCUMENTO_EXISTENTE = "Ya existe un usuario con el documento ingresado.";
    public static final String PRIMER_NOMBRE_PERSONA_VACIO = "El primer nombre no puede estar vacío.";
    public static final String PRIMER_APELLIDO_PERSONA_VACIO = "El primer apellido no puede estar vacío.";
    public static final String PATRON_DOCUMENTO_PERSONA_INVALIDO = "El documento debe contener solo números y tener entre 5 y 12 dígitos.";
    public static final String PATRON_NOMBRE_PERSONA_INVALIDO = "El nombre solo debe contener letras y espacios.";
    public static final String PATRON_APELLIDO_PERSONA_INVALIDO = "El apellido solo debe contener letras y espacios.";
    public static final String LONGITUD_NOMBRE_PERSONA_INVALIDA = "El nombre debe contener entre 1 y 20 caracteres.";
    public static final String LONGITUD_SEGUNDO_NOMBRE_PERSONA_INVALIDA = "El nombre debe contener máximo 20 caracteres";
    public static final String LONGITUD_APELLIDO_PERSONA_INVALIDA = "El apellido debe contener entre 1 y 20 caracteres.";
    public static final String LONGITUD_SEGUNDO_APELLIDO_PERSONA_INVALIDA = "El apellido debe contener máximo 20 caracteres.";
    public static final String CORREO_EXISTENTE = "Ya existe un usuario con el correo ingresado.";
    public static final String CORREO_USUARIO_VACIO = "El correo electrónico no puede estar vacío.";
    public static final String NO_SE_ECONTRARON_USUARIOS = "No se encontraron usuarios registrados.";
    public static final String PATRON_CORREO_INVALIDO = "El formato del correo electrónico no es válido.";
    public static final String CONTRASENA_VACIA = "La contraseña no puede estar vacía.";
    public static final String PATRON_CONTRASENA_INVALIDO = "La contraseña debe tener entre 8 y 20 caracteres, incluyendo al menos una letra mayúscula, una minúscula y un número.";
    public static final String TIPO_USUARIO_NULO = "Debe seleccionar un tipo de usuario.";
    public static final String AREA_USUARIO_NULA = "Debe asignar un área o dirección al usuario.";
    public static final String NOMBRE_TIPO_USUARIO_VACIO = "El nombre del tipo usuario no puede estar vacío.";
    public static final String LONGITUD_NOMBRE_TIPO_USUARIO = "El nombre del tipo usuario debe contener entre 1 y 30 caracteres.";
    public static final String PATRON_NOMBRE_TIPO_USUARIO_INVALIDO = "El nombre del tipo usuario solo debe contener letras y espacios";
    public static final String PATRON_SIGLA_TIPO_IDENTIFICACION_INVALIDO = "La sigla del tipo identificacion solo debe contener letras y espacios";
    public static final String LONGITUD_SIGLA_TIPO_IDENTIFICACION_INVALIDA = "El campo sigla debe contener entre 1 y 5 caracteres.";
    public static final String PATRON_DESCIPCION_TIPO_IDENTIFICACION_INVALIDO = "La descripción del tipo identificacion solo debe contener letras y espacios.";
    public static final String LONGITUD_DESCRIPCION_TIPO_IDENTIFICACION_INVALIDA = "El campo de la descripción debe contener entre 1 y 40 caracteres.";
    public static final String PATRON_NOMBRE_TIPO_AREA_INVALIDO = "El nombre del tipo de area solo puede contener letras y espacios";
    public static final String LONGITUD_NOMBRE_TIPO_AREA_INVALIDA = "El nombre del tipo area solo debe contener entre 1 y 25 caracteres.";
    public static final String PATRON_NOMBRE_AREA_INVALIDO = "El nombre del area solo puede contener letras y espacios.";
    public static final String LONGITUD_NOMBRE_AREA_INVALIDA = "El nombre del area debe contener entre 1 y 50 caracteres.";
    public static final String NO_SE_ENCONTRARON_AREAS = "No se encontraron areas registradas.";
    private static final String NO_EXISTE_USUARIO_CON_IDENTIFICADOR = "No existe un usuario con el identificador ";
    private static final String NO_EXISTE_USUARIO_CON_CORREO = "No existe un usuario con el correo ";
    private static final String NO_EXISTE_PERSONA_CON_IDENTIFICADOR = "No existe un persona con el identificador ";
    private static final String NO_EXISTE_PERSONA_CON_DOCUMENTO = "No existe un persona con el documento ";
    private static final String NO_EXISTE_AREA_CON_IDENTIFICADOR = "No existe un área con el identificador ";
    private static final String NO_EXISTE_TIPO_AREA_CON_IDENTIFICADOR = "No existe un tipo área con el identificador ";
    private static final String NO_EXISTE_TIPO_IDENTIFICACION_CON_IDENTIFICADOR = "No existe un tipo identificacion con el identificador ";
    private static final String NO_EXISTE_TIPO_USUARIO_CON_IDENTIFICADOR = "No existe un tipo usuario con el identificador ";

    private Mensajes() {
    }

    public static String obtenerNoExisteUsuarioConId(UUID identificador) {
        return NO_EXISTE_USUARIO_CON_IDENTIFICADOR + identificador;
    }

    public static String obtenerNoExisteUsuarioConCorreo(String correo) {
        return NO_EXISTE_USUARIO_CON_CORREO + correo;
    }

    public static String obtenerNoExistePersonaConId(UUID identificador) {
        return NO_EXISTE_PERSONA_CON_IDENTIFICADOR + identificador;
    }

    public static String obtenerNoExistePersonaConDocumento(String documento) {
        return NO_EXISTE_PERSONA_CON_DOCUMENTO + documento;
    }

    public static String obtenerNoExisteAreaConId(UUID identificador) {
        return NO_EXISTE_AREA_CON_IDENTIFICADOR + identificador;
    }

    public static String obtenerNoExisteTipoAreaConId(UUID identificador) {
        return NO_EXISTE_TIPO_AREA_CON_IDENTIFICADOR + identificador;
    }

    public static String obtenerNoExisteTipoIdentificacionConId(UUID identificador) {
        return NO_EXISTE_TIPO_IDENTIFICACION_CON_IDENTIFICADOR + identificador;
    }

    public static String obtenerNoExisteTipoUsuarioConId(UUID identificador) {
        return NO_EXISTE_TIPO_USUARIO_CON_IDENTIFICADOR + identificador;
    }

}
