package co.edu.uco.sibe.infraestructura.adaptador.mapeador;

import co.edu.uco.sibe.dominio.modelo.Indicador;
import co.edu.uco.sibe.infraestructura.adaptador.entidad.IndicadorEntidad;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class IndicadorMapeador {
    private final IndicadorTipoIndicadorMapeador indicadorTipoIndicadorMapeador;
    private final IndicadorTemporalidadMapeador indicadorTemporalidadMapeador;
    private final IndicadorProyectoMapeador indicadorProyectoMapeador;
    private final IndicadorPublicoInteresMapeador indicadorPublicoInteresMapeador;

    public IndicadorEntidad construirEntidad(Indicador indicador) {
        return new IndicadorEntidad(
                indicador.getIdentificador(),
                indicador.getNombre(),
                this.indicadorTipoIndicadorMapeador.construirEntidad(indicador.getTipoIndicador()),
                this.indicadorTemporalidadMapeador.construirEntidad(indicador.getTemporalidad()),
                this.indicadorProyectoMapeador.construirEntidad(indicador.getProyecto()),
                this.indicadorPublicoInteresMapeador.construirEntidad(indicador.getPublicoInteres())
        );
    }

    public Indicador construriModelo(IndicadorEntidad indicador) {
        return Indicador.construir(
                indicador.getIdentificador(),
                indicador.getNombre(),
                indicadorTipoIndicadorMapeador.construirModelo(indicador.getTipoIndicador()),
                this.indicadorTemporalidadMapeador.construirModelo(indicador.getTemporalidad()),
                this.indicadorProyectoMapeador.construirModelo(indicador.getProyecto()),
                this.indicadorPublicoInteresMapeador.construirModelo(indicador.getPublicoInteres())
        );
    }
}