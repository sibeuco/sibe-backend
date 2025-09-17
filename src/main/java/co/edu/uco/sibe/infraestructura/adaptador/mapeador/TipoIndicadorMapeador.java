package co.edu.uco.sibe.infraestructura.adaptador.mapeador;

import co.edu.uco.sibe.dominio.dto.TipoIndicadorDTO;
import co.edu.uco.sibe.infraestructura.adaptador.entidad.TipoIndicadorEntidad;
import org.springframework.stereotype.Component;

@Component
public class TipoIndicadorMapeador {

    public TipoIndicadorDTO construirDTO(TipoIndicadorEntidad tipoIndicador){
        return new TipoIndicadorDTO(tipoIndicador.getIdentificador(), tipoIndicador.getNaturalezaIndicador(), tipoIndicador.getTipologiaIndicador());
    }

    public TipoIndicadorEntidad construirEntidad(TipoIndicador tipoIndicador){
        return new TipoIndicadorEntidad(tipoIndicador.getIdentificador(), tipoIndicador.getNaturalezaIndicador(), tipoIndicador.getTipologiaIndicador());
    }

}
