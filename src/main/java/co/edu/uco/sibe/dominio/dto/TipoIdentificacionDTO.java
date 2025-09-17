package co.edu.uco.sibe.dominio.dto;

import co.edu.uco.sibe.dominio.transversal.utilitarios.ValidadorObjeto;
import co.edu.uco.sibe.dominio.transversal.utilitarios.ValidadorTexto;
import co.edu.uco.sibe.dominio.transversal.utilitarios.UtilUUID;

import java.util.UUID;
import lombok.Getter;

@Getter
public class TipoIdentificacionDTO {
    private UUID identificador;
    private String sigla;
    private String descripcion;

    public TipoIdentificacionDTO(){
        setIdentificador(UtilUUID.obtenerValorDefecto());
        setSigla(ValidadorTexto.getInstance().obtenerValorDefecto());
        setDescripcion(ValidadorTexto.getInstance().obtenerValorDefecto());
    }

    public TipoIdentificacionDTO(UUID identificador, String sigla, String descripcion){
        setIdentificador(identificador);
        setSigla(sigla);
        setDescripcion(descripcion);
    }

    public static TipoIdentificacionDTO obtenerValorDefecto(){
        return new TipoIdentificacionDTO();
    }

    public static TipoIdentificacionDTO obtenerValorDefecto(final TipoIdentificacionDTO tipoIdentificacion){
        return ValidadorObjeto.getInstance().obtenerValorDefecto(tipoIdentificacion, obtenerValorDefecto());
    }

    public static TipoIdentificacionDTO construir(UUID identificador, String sigla, String descripcion){
        return new TipoIdentificacionDTO(identificador, sigla, descripcion);
    }

    private void setIdentificador(UUID identificador) {
        this.identificador = UtilUUID.obtenerValorDefecto(identificador);
    }

    private void setSigla(String sigla) {
        this.sigla = ValidadorTexto.getInstance().quitarEspaciosBlancoInicioFin(sigla);
    }

    private void setDescripcion(String descripcion) {
        this.descripcion = ValidadorTexto.getInstance().quitarEspaciosBlancoInicioFin(descripcion);
    }
}
