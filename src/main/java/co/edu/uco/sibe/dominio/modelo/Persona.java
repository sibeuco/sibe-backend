package co.edu.uco.sibe.dominio.modelo;

import co.edu.uco.sibe.dominio.transversal.utilitarios.Mensajes;
import co.edu.uco.sibe.dominio.transversal.utilitarios.UtilObjeto;
import co.edu.uco.sibe.dominio.transversal.utilitarios.UtilTexto;
import co.edu.uco.sibe.dominio.transversal.utilitarios.UtilUUID;

import java.util.UUID;
import lombok.Getter;

@Getter
public class Persona {
    private UUID identificador;
    private TipoIdentificacion tipoIdentificacion;
    private String documento;
    private String primerNombre;
    private String segundoNombre;
    private String primerApellido;
    private String segundoApellido;

    public Persona(){
        setIdentificador(UtilUUID.obtenerValorDefecto());
        setTipoIdentificacion(TipoIdentificacion.obtenerValorDefecto());
        setDocumento(UtilTexto.getInstance().obtenerValorDefecto());
        setPrimerNombre(UtilTexto.getInstance().obtenerValorDefecto());
        setSegundoNombre(UtilTexto.getInstance().obtenerValorDefecto());
        setPrimerApellido(UtilTexto.getInstance().obtenerValorDefecto());
        setSegundoApellido(UtilTexto.getInstance().obtenerValorDefecto());
    }

    private Persona(UUID identificador, TipoIdentificacion tipoIdentificacion, String documento, String primerNombre, String segundoNombre, String primerApellido, String segundoApellido) {
        setIdentificador(identificador);
        setTipoIdentificacion(tipoIdentificacion);
        setDocumento(documento);
        setPrimerNombre(primerNombre);
        setSegundoNombre(segundoNombre);
        setPrimerApellido(primerApellido);
        setSegundoApellido(segundoApellido);
    }

    public static Persona obtenerValorDefecto(){
        return new Persona();
    }

    public static Persona obtenerValorDefecto(final Persona persona){
        return UtilObjeto.getInstance().obtenerValorDefecto(persona, obtenerValorDefecto());
    }

    public static Persona construir(UUID identificador, TipoIdentificacion tipoIdentificacion, String documento, String primerNombre, String segundoNombre, String primerApellido, String segundoApellido){
        return new Persona(identificador, tipoIdentificacion, documento, primerNombre, segundoNombre, primerApellido, segundoApellido);
    }

    public void setIdentificador(UUID identificador) {
        this.identificador = UtilUUID.obtenerValorDefecto(identificador);
    }

    public void setTipoIdentificacion(TipoIdentificacion tipoIdentificacion) {
        this.tipoIdentificacion = TipoIdentificacion.obtenerValorDefecto(tipoIdentificacion);
    }

    public void setDocumento(String documento) {
        UtilTexto.getInstance().validarObligatorio(documento, Mensajes.DOCUMENTO_PERSONA_VACIO);
        UtilTexto.getInstance().validarPatronDocumentoEsValido(documento, Mensajes.PATRON_DOCUMENTO_PERSONA_INVALIDO);
        this.documento = UtilTexto.getInstance().quitarEspaciosBlancoInicioFin(documento);
    }

    public void setPrimerNombre(String primerNombre) {
        UtilTexto.getInstance().validarObligatorio(primerNombre, Mensajes.PRIMER_NOMBRE_PERSONA_VACIO);
        UtilTexto.getInstance().validarPatronTextoEsValido(primerNombre, Mensajes.PATRON_NOMBRE_PERSONA_INVALIDO);
        UtilTexto.getInstance().validarLongitud(primerNombre, 1, 20, Mensajes.LONGITUD_NOMBRE_PERSONA_INVALIDA);
        this.primerNombre = UtilTexto.getInstance().quitarEspaciosBlancoInicioFin(primerNombre);
    }

    public void setPrimerApellido(String primerApellido) {
        UtilTexto.getInstance().validarObligatorio(primerApellido, Mensajes.PRIMER_APELLIDO_PERSONA_VACIO);
        UtilTexto.getInstance().validarPatronTextoEsValido(primerApellido, Mensajes.PATRON_APELLIDO_PERSONA_INVALIDO);
        UtilTexto.getInstance().validarLongitud(primerApellido, 1, 20, Mensajes.LONGITUD_APELLIDO_PERSONA_INVALIDA);
        this.primerApellido = UtilTexto.getInstance().quitarEspaciosBlancoInicioFin(primerApellido);
    }

    public void setSegundoNombre(String segundoNombre) {
        UtilTexto.getInstance().validarPatronTextoEsValido(segundoNombre, Mensajes.PATRON_NOMBRE_PERSONA_INVALIDO);
        UtilTexto.getInstance().validarLongitudNoObligatorio(segundoNombre, 20, Mensajes.LONGITUD_SEGUNDO_NOMBRE_PERSONA_INVALIDA);
        this.segundoNombre = UtilTexto.getInstance().quitarEspaciosBlancoInicioFin(segundoNombre);
    }

    public void setSegundoApellido(String segundoApellido) {
        UtilTexto.getInstance().validarPatronTextoEsValido(segundoApellido, Mensajes.PATRON_APELLIDO_PERSONA_INVALIDO);
        UtilTexto.getInstance().validarLongitudNoObligatorio(segundoApellido, 20, Mensajes.LONGITUD_SEGUNDO_APELLIDO_PERSONA_INVALIDA);
        this.segundoApellido = UtilTexto.getInstance().quitarEspaciosBlancoInicioFin(segundoApellido);
    }
}
