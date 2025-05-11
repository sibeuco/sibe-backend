package co.edu.uco.sibe.dominio.modelo;

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

    private Persona(UUID identificador, TipoIdentificacion tipoIdentificacion, String documento, String primerNombre, String segundoNombre, String primerApellido, String segundoApellido) {
        setIdentificador(identificador);
        this.tipoIdentificacion = tipoIdentificacion;
        setDocumento(documento);
        setPrimerNombre(primerNombre);
        setSegundoNombre(segundoNombre);
        setPrimerApellido(primerApellido);
        setSegundoApellido(segundoApellido);
    }

    public static Persona construir(UUID identificador, TipoIdentificacion tipoIdentificacion, String documento, String primerNombre, String segundoNombre, String primerApellido, String segundoApellido){
        return new Persona(identificador, tipoIdentificacion, documento, primerNombre, segundoNombre, primerApellido, segundoApellido);
    }

    public void setIdentificador(UUID identificador) {
        this.identificador = UtilUUID.obtenerValorDefecto(identificador);
    }

    public void setDocumento(String documento) {
        this.documento = documento;
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
