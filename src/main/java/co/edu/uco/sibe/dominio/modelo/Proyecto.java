package co.edu.uco.sibe.dominio.modelo;

import co.edu.uco.sibe.dominio.transversal.utilitarios.UtilObjeto;
import co.edu.uco.sibe.dominio.transversal.utilitarios.UtilTexto;
import co.edu.uco.sibe.dominio.transversal.utilitarios.UtilUUID;

import java.util.UUID;

public class Proyecto {
    private UUID identificador;
    private String numeroProyecto;
    private String nombre;
    private String objetivo;

    private Proyecto(UUID identificador, String numeroProyecto, String nombre, String objetivo){
        setIdentificador(identificador);
        setNumeroProyecto(numeroProyecto);
        setNombre(nombre);
        setObjetivo(objetivo);
    }

    public static Proyecto construir(UUID identificador, String numeroProyecto, String nombre, String objetivo){
        return new Proyecto(identificador, numeroProyecto, nombre, objetivo);
    }

    public void setIdentificador(UUID identificador) {
        this.identificador = UtilUUID.obtenerValorDefecto(identificador);
    }

    public void setNumeroProyecto(String numeroProyecto) {
        this.numeroProyecto = UtilTexto.getInstance().quitarEspaciosBlancoInicioFin(numeroProyecto);
    }

    public void setNombre(String nombre) {
        this.nombre = UtilTexto.getInstance().quitarEspaciosBlancoInicioFin(nombre);
    }

    public void setObjetivo(String objetivo) {
        this.objetivo = UtilTexto.getInstance().quitarEspaciosBlancoInicioFin(objetivo);
    }
}
