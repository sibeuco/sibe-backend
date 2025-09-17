package co.edu.uco.sibe.infraestructura.adaptador.mapeador;

import co.edu.uco.sibe.dominio.dto.IndicadorDTO;
import co.edu.uco.sibe.infraestructura.adaptador.entidad.IndicadorEntidad;
import org.springframework.stereotype.Component;

@Component
public class IndicadorMapeador {
    private final TipoIndicadorMapeador tipoIndicadorMapeador;
    private final TemporalidadMapeador temporalidadMapeador;
    private final ProyectoMapeador proyectoMapeador;
    private final PublicoInteresMapeador publicoInteresMapeador;

    public IndicadorMapeador(TipoIndicadorMapeador tipoIndicadorMapeador, TemporalidadMapeador temporalidadMapeador, ProyectoMapeador proyectoMapeador, PublicoInteresMapeador publicoInteresMapeador){
       this.tipoIndicadorMapeador = tipoIndicadorMapeador;
       this.temporalidadMapeador = temporalidadMapeador;
       this.proyectoMapeador = proyectoMapeador;
       this.publicoInteresMapeador = publicoInteresMapeador;
    }

    public IndicadorDTO construirDTO(IndicadorEntidad indicador){
        return new IndicadorDTO(indicador.getIdentificador(), indicador.getNombre(), this.tipoIndicadorMapeador.construirDTO(indicador.getTipoIndicador()), this.temporalidadMapeador.construirDTO(indicador.getTemporalidad()), this.proyectoMapeador.construirDTO(indicador.getProyecto()), this.publicoInteresMapeador.construirDTO(indicador.getPublicoInteres()));
    }

    public IndicadorEntidad construirEntidad(Indicador indicador){
        return new IndicadorEntidad(indicador.getIdentificador(), indicador.getNombre(), this.tipoIndicadorMapeador.construirEntidad(indicador.getTipoIndicador()), this.temporalidadMapeador.construirEntidad(indicador.getTemporalidad()), this.proyectoMapeador.construirEntidad(indicador.getProyecto()), this.publicoInteresMapeador.construirEntidad(indicador.getPublicoInteres()));
    }

}
