package co.edu.uco.sibe.dominio.dto;

import co.edu.uco.sibe.dominio.transversal.utilitarios.UtilObjeto;
import co.edu.uco.sibe.dominio.transversal.utilitarios.UtilTexto;
import co.edu.uco.sibe.dominio.transversal.utilitarios.UtilUUID;

import java.util.UUID;
import lombok.Getter;

@Getter
public class VinculoDTO {

    private UUID identificador;
    private String nombre;

    public VinculoDTO(){
        setIdentificador(UtilUUID.obtenerValorDefecto());
        setNombre(UtilTexto.getInstance().obtenerValorDefecto());
    }

    private VinculoDTO(UUID identificador, String nombre){
        setIdentificador(identificador);
        setNombre(nombre);
    }

    public static VinculoDTO obtenerValorDefecto(){
        return new VinculoDTO();
    }

    public static VinculoDTO obtenerValorDefecto(final VinculoDTO vinculo){
        return UtilObjeto.getInstance().obtenerValorDefecto(vinculo, obtenerValorDefecto());
    }

    public static VinculoDTO construir(UUID identificador, String nombre){
        return new VinculoDTO(identificador, nombre);
    }

    private void setIdentificador(UUID identificador) {
        this.identificador = UtilUUID.obtenerValorDefecto(identificador);
    }

    private void setNombre(String nombre) {
        this.nombre = UtilTexto.getInstance().quitarEspaciosBlancoInicioFin(nombre);
    }
}
