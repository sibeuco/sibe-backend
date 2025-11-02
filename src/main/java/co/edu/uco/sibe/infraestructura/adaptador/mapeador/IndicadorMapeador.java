package co.edu.uco.sibe.infraestructura.adaptador.mapeador;

import co.edu.uco.sibe.dominio.dto.IndicadorDTO;
import co.edu.uco.sibe.dominio.modelo.Indicador;
import co.edu.uco.sibe.infraestructura.adaptador.entidad.IndicadorEntidad;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

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
                this.indicadorPublicoInteresMapeador.construirEntidades(indicador.getPublicosInteres())
        );
    }

    public Indicador construriModelo(IndicadorEntidad indicador) {
        return Indicador.construir(
                indicador.getIdentificador(),
                indicador.getNombre(),
                indicadorTipoIndicadorMapeador.construirModelo(indicador.getTipoIndicador()),
                this.indicadorTemporalidadMapeador.construirModelo(indicador.getTemporalidad()),
                this.indicadorProyectoMapeador.construirModelo(indicador.getProyecto()),
                this.indicadorPublicoInteresMapeador.construirModelos(indicador.getPublicoInteres())
        );
    }

    public void actualizarEntidad(IndicadorEntidad entidad, Indicador indicador) {
        entidad.setNombre(indicador.getNombre());
        this.indicadorTipoIndicadorMapeador.actualizarEntidad(entidad.getTipoIndicador(), indicador.getTipoIndicador());
        this.indicadorTemporalidadMapeador.actualizarEntidad(entidad.getTemporalidad(), indicador.getTemporalidad());
        this.indicadorProyectoMapeador.actualizarEntidad(entidad.getProyecto(), indicador.getProyecto());
        this.indicadorPublicoInteresMapeador.actualizarEntidades(entidad.getPublicoInteres(), indicador.getPublicosInteres());
    }

    public IndicadorDTO construirDTO(IndicadorEntidad indicador) {
        return new IndicadorDTO(
                indicador.getIdentificador(),
                indicador.getNombre(),
                this.indicadorTipoIndicadorMapeador.construirDTO(indicador.getTipoIndicador()),
                this.indicadorTemporalidadMapeador.construirDTO(indicador.getTemporalidad()),
                this.indicadorProyectoMapeador.construirDTO(indicador.getProyecto()),
                this.indicadorPublicoInteresMapeador.construirDTOs(indicador.getPublicoInteres())
        );
    }

    public List<IndicadorDTO> construirDTOs(List<IndicadorEntidad> entidades) {
        return entidades.stream().map(this::construirDTO).toList();
    }
}