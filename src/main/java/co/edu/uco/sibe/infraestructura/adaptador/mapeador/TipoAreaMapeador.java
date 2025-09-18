package co.edu.uco.sibe.infraestructura.adaptador.mapeador;

import co.edu.uco.sibe.infraestructura.adaptador.entidad.TipoAreaEntidad;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TipoAreaMapeador {

    public TipoAreaDTO construirDTO(TipoAreaEntidad tipoArea){
        return new TipoAreaDTO(tipoArea.getIdentificador(), tipoArea.getNombre(), tipoArea.isGestionable(), tipoArea.getNivel());
    }

    public TipoAreaEntidad construirEntidad(TipoArea tipoArea){
        return new TipoAreaEntidad(tipoArea.getIdentificador(), tipoArea.getNombre(), tipoArea.isGestionable(), tipoArea.getNivel());
    }

    public List<TipoAreaDTO> construirDTOs(List<TipoAreaEntidad> tiposArea){
        return tiposArea.stream().map(new TipoAreaMapeador()::construirDTO).toList();
    }

}
