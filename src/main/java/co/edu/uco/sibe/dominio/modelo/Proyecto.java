package co.edu.uco.sibe.dominio.modelo;

import co.edu.uco.sibe.dominio.transversal.utilitarios.UtilTexto;
import co.edu.uco.sibe.dominio.transversal.utilitarios.UtilUUID;
import lombok.Getter;

import java.util.UUID;

@Getter
public class Proyecto {
    private UUID identificador;
    private String numeroProyecto;
    private String nombre;
    private String objetivo;

    private Proyecto(String numeroProyecto, String nombre, String objetivo){
        setIdentificador();
        setNumeroProyecto(numeroProyecto);
        setNombre(nombre);
        setObjetivo(objetivo);
    }

    public static Proyecto construir(String numeroProyecto, String nombre, String objetivo){
        return new Proyecto(numeroProyecto, nombre, objetivo);
    }

    public void setIdentificador() {
        this.identificador = UtilUUID.generarNuevoUUID();
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
