package co.edu.uco.sibe.dominio.dto;

import co.edu.uco.sibe.dominio.transversal.utilitarios.UtilTexto;
import co.edu.uco.sibe.dominio.transversal.utilitarios.UtilUUID;

import java.util.UUID;
import lombok.Getter;

@Getter
public class AccionDTO {
    private UUID identificador;
    private String detalle;
    private String objetivo;
    private ProyectoDTO proyecto;

    public AccionDTO(UUID identificador, String detalle, String objetivo, ProyectoDTO proyecto) {
        setIdentificador(identificador);
        setDetalle(detalle);
        setObjetivo(objetivo);
        setProyecto(proyecto);
    }

    public static AccionDTO construir(UUID identificador, String detalle, String objetivo, ProyectoDTO proyecto){
        return new AccionDTO(identificador, detalle, objetivo, proyecto);
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

    public void setProyecto(ProyectoDTO proyecto) {
        this.proyecto = ProyectoDTO.obtenerValorDefecto(proyecto);
    }
}
