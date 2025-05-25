package co.edu.uco.sibe.infraestructura.adaptador.mapeador;

import co.edu.uco.sibe.dominio.dto.AreaDTO;
import co.edu.uco.sibe.dominio.modelo.Area;
import co.edu.uco.sibe.infraestructura.adaptador.entidad.AreaEntidad;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AreaMapeador {
    private final TipoAreaMapeador tipoAreaMapeador;
    private final AreaMapeador areaPadre;

    public AreaMapeador(TipoAreaMapeador tipoAreaMapeador, AreaMapeador areaPadre){
        this.tipoAreaMapeador = tipoAreaMapeador;
        this.areaPadre = areaPadre;
    }

    public AreaDTO construirDTO(AreaEntidad area){
        return new AreaDTO(area.getIdentificador(), area.getNombreArea(), this.tipoAreaMapeador.construirDTO(area.getTipoArea()), this.areaPadre.construirDTO(area.getAreaPadre()));
    }

    public AreaEntidad construirEntidad(Area area){
        return new AreaEntidad(area.getIdentificador(), area.getNombreArea(), this.tipoAreaMapeador.construirEntidad(area.getTipoArea()), this.areaPadre.construirEntidad(area.getAreaPadre()));
    }

    public List<AreaDTO> construirDTOs(List<AreaEntidad> areas){
        return areas.stream().map(this::construirDTO).toList();
    }

}
