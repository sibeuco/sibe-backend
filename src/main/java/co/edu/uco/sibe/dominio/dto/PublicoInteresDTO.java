package co.edu.uco.sibe.dominio.dto;

import co.edu.uco.sibe.dominio.transversal.utilitarios.UtilObjeto;
import co.edu.uco.sibe.dominio.transversal.utilitarios.UtilTexto;
import co.edu.uco.sibe.dominio.transversal.utilitarios.UtilUUID;

import java.util.UUID;
import lombok.Getter;

@Getter
public class PublicoInteresDTO {
    private UUID identificador;
    private String nombre;

    public PublicoInteresDTO(){
        setIdentificador(UtilUUID.obtenerValorDefecto());
        setNombre(UtilTexto.getInstance().obtenerValorDefecto());
    }

    private PublicoInteresDTO(UUID identificador, String nombre){
        setIdentificador(identificador);
        setNombre(nombre);
    }

    public static PublicoInteresDTO obtenerValorDefecto(){
        return new PublicoInteresDTO();
    }

    public static PublicoInteresDTO obtenerValorDefecto(final PublicoInteresDTO publicoInteres){
        return UtilObjeto.getInstance().obtenerValorDefecto(publicoInteres, obtenerValorDefecto());
    }

    public static PublicoInteresDTO construir(UUID identificador, String nombre){
        return new PublicoInteresDTO(identificador, nombre);
    }

    public void setIdentificador(UUID identificador) {
        this.identificador = UtilUUID.obtenerValorDefecto(identificador);
    }

    public void setNombre(String nombre) {
        this.nombre = UtilTexto.getInstance().quitarEspaciosBlancoInicioFin(nombre);
    }
}
