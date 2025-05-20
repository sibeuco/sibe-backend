package co.edu.uco.sibe.infraestructura.adaptador.mapeador;

import co.edu.uco.sibe.dominio.dto.TipoIdentificacionDTO;
import co.edu.uco.sibe.dominio.modelo.TipoIdentificacion;
import co.edu.uco.sibe.infraestructura.adaptador.entidad.TipoIdentificacionEntidad;
import org.springframework.stereotype.Component;

@Component
public class TipoIdentificacionMapeador {

    public TipoIdentificacionDTO construirDTO(TipoIdentificacionEntidad tipoIdentificacion){
        return new TipoIdentificacionDTO(tipoIdentificacion.getIdentificador(), tipoIdentificacion.getSigla(), tipoIdentificacion.getDescripcion());
    }

    public TipoIdentificacionEntidad construirEntidad(TipoIdentificacion tipoIdentificacion){
        return new TipoIdentificacionEntidad(tipoIdentificacion.getIdentificador(), tipoIdentificacion.getSigla(), tipoIdentificacion.getDescripcion());
    }
}
