package co.edu.uco.sibe.dominio.dto;

import co.edu.uco.sibe.dominio.transversal.utilitarios.ValidadorObjeto;
import co.edu.uco.sibe.dominio.transversal.utilitarios.ValidadorTexto;
import co.edu.uco.sibe.dominio.transversal.utilitarios.UtilUUID;

import java.util.UUID;
import lombok.Getter;

@Getter
public class EstadoActividadDTO {
    private UUID identificador;
    private String nombre;

    public EstadoActividadDTO(){
        setIdentificador(UtilUUID.obtenerValorDefecto());
        setNombre(ValidadorTexto.getInstance().obtenerValorDefecto());
    }

    public EstadoActividadDTO(UUID identificador, String nombre){
        setIdentificador(identificador);
        setNombre(nombre);
    }

    public static EstadoActividadDTO obtenerValorDefecto(){
        return new EstadoActividadDTO();
    }

    public static EstadoActividadDTO obtenerValorDefecto(final EstadoActividadDTO estadoActividad){
        return ValidadorObjeto.getInstance().obtenerValorDefecto(estadoActividad, obtenerValorDefecto());
    }

    public static EstadoActividadDTO construir(UUID identificador, String nombre){
        return new EstadoActividadDTO(identificador, nombre);
    }

    public void setIdentificador(UUID identifiacador) {
        this.identificador = UtilUUID.obtenerValorDefecto(identificador);
    }

    public void setNombre(String nombre) {
        this.nombre = ValidadorTexto.getInstance().quitarEspaciosBlancoInicioFin(nombre);
    }
}
