package co.edu.uco.sibe.dominio.modelo;

import java.util.UUID;

import co.edu.uco.sibe.dominio.transversal.utilitarios.UtilObjeto;
import co.edu.uco.sibe.dominio.transversal.utilitarios.UtilTexto;
import co.edu.uco.sibe.dominio.transversal.utilitarios.UtilUUID;
import lombok.Getter;

@Getter
public class Vinculo {
    private UUID identificador;
    private String nombre;

    public Vinculo(){
        this.identificador = UtilUUID.obtenerValorDefecto();
        setNombre(UtilTexto.getInstance().obtenerValorDefecto());
    }

    private Vinculo(String nombre){
        setIdentificador();
        setNombre(nombre);
    }

    public static Vinculo obtenerValorDefecto(){
        return new Vinculo();
    }

    public static Vinculo obtenerValorDefecto(final Vinculo vinculo){
        return UtilObjeto.getInstance().obtenerValorDefecto(vinculo, obtenerValorDefecto());
    }

    public static Vinculo construir(UUID identificador, String nombre){
        return new Vinculo(nombre);
    }

    public void setIdentificador() {
        this.identificador = UtilUUID.generarNuevoUUID();
    }

    public void setNombre(String nombre) {
        this.nombre = UtilTexto.getInstance().quitarEspaciosBlancoInicioFin(nombre);
    }
}
