package co.edu.uco.sibe.dominio.modelo;

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
        this.documento = UtilTexto.getInstance().quitarEspaciosBlancoInicioFin(documento);
    }

    public void setPrimerNombre(String primerNombre) {
        this.primerNombre = UtilTexto.getInstance().quitarEspaciosBlancoInicioFin(primerNombre);
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = UtilTexto.getInstance().quitarEspaciosBlancoInicioFin(primerApellido);
    }

    public void setSegundoNombre(String segundoNombre) {
        this.segundoNombre = UtilTexto.getInstance().quitarEspaciosBlancoInicioFin(segundoNombre);
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = UtilTexto.getInstance().quitarEspaciosBlancoInicioFin(segundoApellido);
    }
}
