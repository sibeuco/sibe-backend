package co.edu.uco.sibe.dominio.modelo;

import java.util.UUID;

import co.edu.uco.sibe.dominio.transversal.utilitarios.UtilObjeto;
import co.edu.uco.sibe.dominio.transversal.utilitarios.UtilTexto;
import co.edu.uco.sibe.dominio.transversal.utilitarios.UtilUUID;
import lombok.Getter;

@Getter
public class Temporalidad {
    private UUID identificador;
    private String nombre;

    public Temporalidad(){
        this.identificador = UtilUUID.obtenerValorDefecto();
        setNombre(UtilTexto.getInstance().obtenerValorDefecto());
    }

    private Temporalidad(String nombre){
        setIdentificador();
        setNombre(nombre);
    }

    public static Temporalidad obtenerValorDefecto(){
        return new Temporalidad();
    }

    public static Temporalidad obtenerValorDefecto(final Temporalidad temporalidad){
        return UtilObjeto.getInstance().obtenerValorDefecto(temporalidad, obtenerValorDefecto());
    }

    public static Temporalidad construir(String nombre){
        return new Temporalidad(nombre);
    }

    public void setIdentificador() {
        this.identificador = UtilUUID.generarNuevoUUID();
    }

    public void setNombre(String nombre) {
        this.nombre = UtilTexto.getInstance().quitarEspaciosBlancoInicioFin(nombre);
    }
}
