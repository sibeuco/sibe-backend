package co.edu.uco.sibe.infraestructura.adaptador.mapeador;

import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Component
public class AreaMapeador {
    private final TipoAreaMapeador tipoAreaMapeador;

    public AreaMapeador(TipoAreaMapeador tipoAreaMapeador){
        this.tipoAreaMapeador = tipoAreaMapeador;
    }

    public AreaDTO construirDTO(AreaEntidad area){
        return construirDTO(area, new HashSet<>());
    }

    private AreaDTO construirDTO(AreaEntidad area, Set<UUID> visitados){
        if(area == null) return null;

        if(!visitados.add(area.getIdentificador())){
            return null;
        }

        AreaDTO areaPadreDTO = construirDTO(area.getAreaPadre(), visitados);

        return new AreaDTO(area.getIdentificador(), area.getNombreArea(), this.tipoAreaMapeador.construirDTO(area.getTipoArea()), areaPadreDTO);
    }

    public AreaEntidad construirEntidad(Area area) {
        return construirEntidad(area, new HashSet<>());
    }

    private AreaEntidad construirEntidad(Area area, Set<UUID> visitados) {
        if (area == null) return null;
        if (!visitados.add(area.getIdentificador())) {
            return null;
        }
        AreaEntidad padreEntidad = construirEntidad(area.getAreaPadre(), visitados);
        return new AreaEntidad(
                area.getIdentificador(),
                area.getNombreArea(),
                tipoAreaMapeador.construirEntidad(area.getTipoArea()),
                padreEntidad
        );
    }


    public List<AreaDTO> construirDTOs(List<AreaEntidad> areas){
        return areas.stream().map(this::construirDTO).toList();
    }

}
