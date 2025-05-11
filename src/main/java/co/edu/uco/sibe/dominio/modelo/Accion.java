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

    private Accion(UUID identificador, String detalle, String objetivo, Proyecto proyecto) {
        setIdentificador(identificador);
        setDetalle(detalle);
        setObjetivo(objetivo);
        this.proyecto = proyecto;
    }

    public static Accion construir(UUID identificador, String detalle, String objetivo, Proyecto proyecto){
        return new Accion(identificador, detalle, objetivo, proyecto);
    }

    public void setIdentificador(UUID identificador) {
        this.identificador = UtilUUID.obtenerValorDefecto(identificador);
    }

    public void setDetalle(String detalle) {
        this.detalle = UtilTexto.getInstance().quitarEspaciosBlancoInicioFin(detalle);
    }

    public void setObjetivo(String objetivo) {
        this.objetivo = UtilTexto.getInstance().quitarEspaciosBlancoInicioFin(objetivo);
    }

}
