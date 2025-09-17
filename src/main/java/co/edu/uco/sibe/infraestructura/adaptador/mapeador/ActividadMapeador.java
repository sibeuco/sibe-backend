package co.edu.uco.sibe.infraestructura.adaptador.mapeador;

import co.edu.uco.sibe.dominio.dto.ActividadDTO;
import co.edu.uco.sibe.infraestructura.adaptador.entidad.ActividadEntidad;
import org.springframework.stereotype.Component;

@Component
public class ActividadMapeador {
    private final UsuarioMapeador colaboradorMapeador;
    private final UsuarioMapeador creadorMapeador;
    private final IndicadorMapeador indicadorMapeador;
    private final EstadoActividadMapeador estadoActividadMapeador;
    private final AreaMapeador areaMapeador;

    public ActividadMapeador(UsuarioMapeador colaboradorMapeador, UsuarioMapeador creadorMapeador, IndicadorMapeador indicadorMapeador, EstadoActividadMapeador estadoActividadMapeador, AreaMapeador areaMapeador){
        this.colaboradorMapeador = colaboradorMapeador;
        this.creadorMapeador = creadorMapeador;
        this.indicadorMapeador = indicadorMapeador;
        this.estadoActividadMapeador = estadoActividadMapeador;
        this.areaMapeador = areaMapeador;
    }

    public ActividadDTO construirDTO(ActividadEntidad actividad){
        return new ActividadDTO(actividad.getIdentificador(), actividad.getNombreCapacitacionOEvento(), actividad.getObjetivo(), this.colaboradorMapeador.construirDTO(actividad.getColaborador()), this.creadorMapeador.construirDTO(actividad.getCreador()), this.indicadorMapeador.construirDTO(actividad.getIndicador()), actividad.getFechaCreacion(), actividad.getFechaProgramada(), actividad.getFechaRealizacion(), actividad.getHoraInicio(), actividad.getHoraFin(), this.estadoActividadMapeador.construirDTO(actividad.getEstadoActividad()), this.areaMapeador.construirDTO(actividad.getArea()), actividad.getRutaInsumos());
    }

    public ActividadEntidad construirEntidad(Actividad actividad){
        return new ActividadEntidad(actividad.getIdentificador(), actividad.getNombreCapacitacionOEvento(), actividad.getObjetivo(), this.colaboradorMapeador.construirEntidad(actividad.getColaborador(), ""), this.creadorMapeador.construirEntidad(actividad.getCreador(), ""), this.indicadorMapeador.construirEntidad(actividad.getIndicador()), actividad.getFechaCreacion(), actividad.getFechaProgramada(), actividad.getFechaRealizacion(), actividad.getHoraInicio(), actividad.getHoraFin(), this.estadoActividadMapeador.construirEntidad(actividad.getEstadoActividad()), this.areaMapeador.construirEntidad(actividad.getArea()), actividad.getRutaInsumos());
    }

}
