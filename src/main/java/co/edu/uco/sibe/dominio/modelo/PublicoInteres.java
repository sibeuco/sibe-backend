package co.edu.uco.sibe.dominio.modelo;

import java.util.UUID;

import co.edu.uco.sibe.dominio.transversal.utilitarios.UtilObjeto;
import co.edu.uco.sibe.dominio.transversal.utilitarios.UtilTexto;
import co.edu.uco.sibe.dominio.transversal.utilitarios.UtilUUID;
import lombok.Getter;

@Getter
public class PublicoInteres {
    private UUID identificador;
    private String nombre;

    public PublicoInteres(){
        this.identificador = UtilUUID.obtenerValorDefecto();
        setNombre(UtilTexto.getInstance().obtenerValorDefecto());
    }

    private PublicoInteres(String nombre){
        setIdentificador();
        setNombre(nombre);
    }

    public static PublicoInteres obtenerValorDefecto(){
        return new PublicoInteres();
    }

    public static PublicoInteres obtenerValorDefecto(final PublicoInteres publicoInteres){
        return UtilObjeto.getInstance().obtenerValorDefecto(publicoInteres, obtenerValorDefecto());
    }

    public static PublicoInteres construir(String nombre){
        return new PublicoInteres(nombre);
    }

    public void setIdentificador() {
        this.identificador = UtilUUID.generarNuevoUUID();
    }

    public void setNombre(String nombre) {
        this.nombre = UtilTexto.getInstance().quitarEspaciosBlancoInicioFin(nombre);
    }
}
