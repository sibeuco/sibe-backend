package co.edu.uco.sibe.dominio.modelo;

import co.edu.uco.sibe.dominio.transversal.utilitarios.UtilTexto;
import co.edu.uco.sibe.dominio.transversal.utilitarios.UtilUUID;

import java.util.UUID;
import lombok.Getter;

@Getter
public class Accion {
    private UUID identificador;
    private String detalle;
    private String objetivo;
    private Proyecto proyecto;

    private Accion(String detalle, String objetivo, Proyecto proyecto) {
        setIdentificador();
        setDetalle(detalle);
        setObjetivo(objetivo);
        setProyecto(proyecto);
    }

    public static Accion construir(String detalle, String objetivo, Proyecto proyecto){
        return new Accion(detalle, objetivo, proyecto);
    }

    public void setIdentificador() {
        this.identificador = UtilUUID.generarNuevoUUID();
    }

    public void setDetalle(String detalle) {
        this.detalle = UtilTexto.getInstance().quitarEspaciosBlancoInicioFin(detalle);
    }

    public void setObjetivo(String objetivo) {
        this.objetivo = UtilTexto.getInstance().quitarEspaciosBlancoInicioFin(objetivo);
    }

    public void setProyecto(Proyecto proyecto) {
        this.proyecto = proyecto;
    }
}
