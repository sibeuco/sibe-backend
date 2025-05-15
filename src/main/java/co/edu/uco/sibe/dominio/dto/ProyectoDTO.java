package co.edu.uco.sibe.dominio.dto;

import co.edu.uco.sibe.dominio.transversal.utilitarios.UtilObjeto;
import co.edu.uco.sibe.dominio.transversal.utilitarios.UtilTexto;
import co.edu.uco.sibe.dominio.transversal.utilitarios.UtilUUID;

import java.util.UUID;
import lombok.Getter;

@Getter
public class ProyectoDTO {
    private UUID identificador;
    private String numeroProyecto;
    private String nombre;
    private String objetivo;

    public ProyectoDTO(){
        setIdentificador(UtilUUID.obtenerValorDefecto());
        setNumeroProyecto(UtilTexto.getInstance().obtenerValorDefecto());
        setNombre(UtilTexto.getInstance().obtenerValorDefecto());
        setObjetivo(UtilTexto.getInstance().obtenerValorDefecto());
    }

    private ProyectoDTO(UUID identificador, String numeroProyecto, String nombre, String objetivo){
        setIdentificador(identificador);
        setNumeroProyecto(numeroProyecto);
        setNombre(nombre);
        setObjetivo(objetivo);
    }

    public static ProyectoDTO obtenerValorDefecto(){
        return new ProyectoDTO();
    }

    public static ProyectoDTO obtenerValorDefecto(final ProyectoDTO proyecto){
        return UtilObjeto.getInstance().obtenerValorDefecto(proyecto, obtenerValorDefecto());
    }

    public static ProyectoDTO construir(UUID identificador, String numeroProyecto, String nombre, String objetivo){
        return new ProyectoDTO(identificador, numeroProyecto, nombre, objetivo);
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
