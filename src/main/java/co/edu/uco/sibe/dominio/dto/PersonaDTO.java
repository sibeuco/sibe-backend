package co.edu.uco.sibe.dominio.dto;

import co.edu.uco.sibe.dominio.transversal.utilitarios.ValidadorObjeto;
import co.edu.uco.sibe.dominio.transversal.utilitarios.ValidadorTexto;
import co.edu.uco.sibe.dominio.transversal.utilitarios.UtilUUID;
import lombok.Getter;

import java.util.UUID;

@Getter
public class PersonaDTO {
    private UUID identificador;
    private TipoIdentificacionDTO tipoIdentificacion;
    private String documento;
    private String primerNombre;
    private String segundoNombre;
    private String primerApellido;
    private String segundoApellido;
    private String correo;

    public PersonaDTO(){
        setIdentificador(UtilUUID.obtenerValorDefecto());
        setTipoIdentificacion(TipoIdentificacionDTO.obtenerValorDefecto());
        setDocumento(ValidadorTexto.getInstance().obtenerValorDefecto());
        setPrimerNombre(ValidadorTexto.getInstance().obtenerValorDefecto());
        setSegundoNombre(ValidadorTexto.getInstance().obtenerValorDefecto());
        setPrimerApellido(ValidadorTexto.getInstance().obtenerValorDefecto());
        setSegundoApellido(ValidadorTexto.getInstance().obtenerValorDefecto());
        setCorreo(ValidadorTexto.getInstance().obtenerValorDefecto());
    }

    public PersonaDTO(UUID identificador, TipoIdentificacionDTO tipoIdentificacion, String documento, String primerNombre, String segundoNombre, String primerApellido, String segundoApellido, String correo) {
        setIdentificador(identificador);
        setTipoIdentificacion(tipoIdentificacion);
        setDocumento(documento);
        setPrimerNombre(primerNombre);
        setSegundoNombre(segundoNombre);
        setPrimerApellido(primerApellido);
        setSegundoApellido(segundoApellido);
        setCorreo(correo);
    }

    public static PersonaDTO obtenerValorDefecto(){
        return new PersonaDTO();
    }

    public static PersonaDTO obtenerValorDefecto(final PersonaDTO persona){
        return ValidadorObjeto.getInstance().obtenerValorDefecto(persona, obtenerValorDefecto());
    }

    public static PersonaDTO construir(UUID identificador, TipoIdentificacionDTO tipoIdentificacion, String documento, String primerNombre, String segundoNombre, String primerApellido, String segundoApellido, String correo){
        return new PersonaDTO(identificador, tipoIdentificacion, documento, primerNombre, segundoNombre, primerApellido, segundoApellido, correo);
    }

    private void setIdentificador(UUID identificador) {
        this.identificador = UtilUUID.obtenerValorDefecto(identificador);
    }

    private void setTipoIdentificacion(TipoIdentificacionDTO tipoIdentificacion) {
        this.tipoIdentificacion = TipoIdentificacionDTO.obtenerValorDefecto(tipoIdentificacion);
    }

    private void setDocumento(String documento) {
        this.documento = ValidadorTexto.getInstance().quitarEspaciosBlancoInicioFin(documento);
    }

    private void setPrimerNombre(String primerNombre) {
        this.primerNombre = ValidadorTexto.getInstance().quitarEspaciosBlancoInicioFin(primerNombre);
    }

    private void setPrimerApellido(String primerApellido) {
        this.primerApellido = ValidadorTexto.getInstance().quitarEspaciosBlancoInicioFin(primerApellido);
    }

    private void setSegundoNombre(String segundoNombre) {
        this.segundoNombre = ValidadorTexto.getInstance().quitarEspaciosBlancoInicioFin(segundoNombre);
    }

    private void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = ValidadorTexto.getInstance().quitarEspaciosBlancoInicioFin(segundoApellido);
    }

    public void setCorreo(String correo) {
        this.correo = ValidadorTexto.getInstance().quitarEspaciosBlancoInicioFin(correo);
    }
}
