package co.edu.uco.sibe.dominio.modelo;

import java.util.UUID;

import co.edu.uco.sibe.dominio.transversal.utilitarios.UtilObjeto;
import co.edu.uco.sibe.dominio.transversal.utilitarios.UtilTexto;
import co.edu.uco.sibe.dominio.transversal.utilitarios.UtilUUID;
import lombok.Getter;

@Getter
public class EstadoActividad {
    private UUID identificador;
    private String nombre;

    public EstadoActividad(){
        this.identificador = UtilUUID.obtenerValorDefecto();
        setNombre(UtilTexto.getInstance().obtenerValorDefecto());
    }

    private EstadoActividad(String nombre){
        setIdentificador();
        setNombre(nombre);
    }

    public static EstadoActividad obtenerValorDefecto(){
        return new EstadoActividad();
    }

    public static EstadoActividad obtenerValorDefecto(final EstadoActividad estadoActividad){
        return UtilObjeto.getInstance().obtenerValorDefecto(estadoActividad, obtenerValorDefecto());
    }

    public static EstadoActividad construir(String nombre){
        return new EstadoActividad(nombre);
    }

    public void setIdentificador() {
        this.identificador = UtilUUID.generarNuevoUUID();
    }

    public void setNombre(String nombre) {
        this.nombre = UtilTexto.getInstance().quitarEspaciosBlancoInicioFin(nombre);
    }
}
