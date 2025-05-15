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
        setIdentificador(UtilUUID.obtenerValorDefecto());
        setNombre(UtilTexto.getInstance().obtenerValorDefecto());
    }

    private PublicoInteres(UUID identificador, String nombre){
        setIdentificador(identificador);
        setNombre(nombre);
    }

    public static PublicoInteres obtenerValorDefecto(){
        return new PublicoInteres();
    }

    public static PublicoInteres obtenerValorDefecto(final PublicoInteres publicoInteres){
        return UtilObjeto.getInstance().obtenerValorDefecto(publicoInteres, obtenerValorDefecto());
    }

    public static PublicoInteres construir(UUID identificador, String nombre){
        return new PublicoInteres(identificador, nombre);
    }

    public void setIdentificador(UUID identificador) {
        this.identificador = UtilUUID.obtenerValorDefecto(identificador);
    }

    public void setNombre(String nombre) {
        this.nombre = UtilTexto.getInstance().quitarEspaciosBlancoInicioFin(nombre);
    }
}
