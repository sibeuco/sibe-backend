package co.edu.uco.sibe.dominio.dto;

import co.edu.uco.sibe.dominio.transversal.utilitarios.UtilObjeto;
import co.edu.uco.sibe.dominio.transversal.utilitarios.UtilTexto;
import co.edu.uco.sibe.dominio.transversal.utilitarios.UtilUUID;

import java.util.UUID;
import lombok.Getter;

@Getter
public class TemporalidadDTO {
    private UUID identificador;
    private String nombre;

    public TemporalidadDTO(){
        setIdentificador(UtilUUID.obtenerValorDefecto());
        setNombre(UtilTexto.getInstance().obtenerValorDefecto());
    }

    private TemporalidadDTO(UUID identificador, String nombre){
        setIdentificador(identificador);
        setNombre(nombre);
    }

    public static TemporalidadDTO obtenerValorDefecto(){
        return new TemporalidadDTO();
    }

    public static TemporalidadDTO obtenerValorDefecto(final TemporalidadDTO temporalidad){
        return UtilObjeto.getInstance().obtenerValorDefecto(temporalidad, obtenerValorDefecto());
    }

    public static TemporalidadDTO construir(UUID identificador, String nombre){
        return new TemporalidadDTO(identificador, nombre);
    }

    public void setIdentificador(UUID identificador) {
        this.identificador = UtilUUID.obtenerValorDefecto(identificador);
    }

    public void setNombre(String nombre) {
        this.nombre = UtilTexto.getInstance().quitarEspaciosBlancoInicioFin(nombre);
    }
}
