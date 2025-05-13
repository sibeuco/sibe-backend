package co.edu.uco.sibe.dominio.dto;

import co.edu.uco.sibe.dominio.modelo.TipoIdentificacion;
import co.edu.uco.sibe.dominio.transversal.utilitarios.UtilObjeto;
import co.edu.uco.sibe.dominio.transversal.utilitarios.UtilTexto;
import co.edu.uco.sibe.dominio.transversal.utilitarios.UtilUUID;

import java.util.UUID;
import lombok.Getter;

@Getter
public class PersonaDTO {
    private UUID identificador;
    private TipoIdentificacion tipoIdentificacion;
    private String documento;
    private String primerNombre;
    private String segundoNombre;
    private String primerApellido;
    private String segundoApellido;

    public PersonaDTO(){
        setIdentificador(UtilUUID.obtenerValorDefecto());
        setTipoIdentificacion(TipoIdentificacion.obtenerValorDefecto());
        setDocumento(UtilTexto.getInstance().obtenerValorDefecto());
        setPrimerNombre(UtilTexto.getInstance().obtenerValorDefecto());
        setSegundoNombre(UtilTexto.getInstance().obtenerValorDefecto());
        setPrimerApellido(UtilTexto.getInstance().obtenerValorDefecto());
        setSegundoApellido(UtilTexto.getInstance().obtenerValorDefecto());
    }

    private PersonaDTO(UUID identificador, TipoIdentificacion tipoIdentificacion, String documento, String primerNombre, String segundoNombre, String primerApellido, String segundoApellido) {
        setIdentificador(identificador);
        setTipoIdentificacion(tipoIdentificacion);
        setDocumento(documento);
        setPrimerNombre(primerNombre);
        setSegundoNombre(segundoNombre);
        setPrimerApellido(primerApellido);
        setSegundoApellido(segundoApellido);
    }

    public static PersonaDTO obtenerValorDefecto(){
        return new PersonaDTO();
    }

    public static PersonaDTO obtenerValorDefecto(final PersonaDTO persona){
        return UtilObjeto.getInstance().obtenerValorDefecto(persona, obtenerValorDefecto());
    }

    public static PersonaDTO construir(UUID identificador, TipoIdentificacion tipoIdentificacion, String documento, String primerNombre, String segundoNombre, String primerApellido, String segundoApellido){
        return new PersonaDTO(identificador, tipoIdentificacion, documento, primerNombre, segundoNombre, primerApellido, segundoApellido);
    }

    private void setIdentificador(UUID identificador) {
        this.identificador = UtilUUID.obtenerValorDefecto(identificador);
    }

    private void setTipoIdentificacion(TipoIdentificacion tipoIdentificacion) {
        this.tipoIdentificacion = TipoIdentificacion.obtenerValorDefecto(tipoIdentificacion);
    }

    private void setDocumento(String documento) {
        this.documento = UtilTexto.getInstance().quitarEspaciosBlancoInicioFin(documento);
    }

    private void setPrimerNombre(String primerNombre) {
        this.primerNombre = UtilTexto.getInstance().quitarEspaciosBlancoInicioFin(primerNombre);
    }

    private void setPrimerApellido(String primerApellido) {
        this.primerApellido = UtilTexto.getInstance().quitarEspaciosBlancoInicioFin(primerApellido);
    }

    private void setSegundoNombre(String segundoNombre) {
        this.segundoNombre = UtilTexto.getInstance().quitarEspaciosBlancoInicioFin(segundoNombre);
    }

    private void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = UtilTexto.getInstance().quitarEspaciosBlancoInicioFin(segundoApellido);
    }
}
