package co.edu.uco.sibe.dominio.modelo;

import lombok.Getter;
import java.util.List;
import java.util.UUID;

@Getter
public class Proyecto {
    private UUID identificador;
    private String numeroProyecto;
    private String nombre;
    private String objetivo;
    private List<Accion> acciones;

    public Proyecto(UUID identificador, String numeroProyecto, String nombre, String objetivo, List<Accion> acciones) {
        this.identificador = identificador;
        this.numeroProyecto = numeroProyecto;
        this.nombre = nombre;
        this.objetivo = objetivo;
        this.acciones = acciones;
    }

    public static Proyecto construir(UUID identificador, String numeroProyecto, String nombre, String objetivo, List<Accion> acciones) {
        return new Proyecto(identificador, numeroProyecto, nombre, objetivo, acciones);
    }
}