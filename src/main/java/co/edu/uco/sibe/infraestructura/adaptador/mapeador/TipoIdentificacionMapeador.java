package co.edu.uco.sibe.infraestructura.adaptador.mapeador;

import co.edu.uco.sibe.dominio.dto.TipoIdentificacionDTO;
import co.edu.uco.sibe.dominio.modelo.TipoIdentificacion;
import co.edu.uco.sibe.infraestructura.adaptador.entidad.TipoIdentificacionEntidad;
import co.edu.uco.sibe.infraestructura.adaptador.entidad.TipoUsuarioEntidad;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TipoIdentificacionMapeador {

    public TipoIdentificacionDTO construirDTO(TipoIdentificacionEntidad tipoIdentificacion){
        return new TipoIdentificacionDTO(tipoIdentificacion.getIdentificador(), tipoIdentificacion.getSigla(), tipoIdentificacion.getDescripcion());
    }

    public TipoIdentificacionEntidad construirEntidad(TipoIdentificacion tipoIdentificacion){
        return new TipoIdentificacionEntidad(tipoIdentificacion.getIdentificador(), tipoIdentificacion.getSigla(), tipoIdentificacion.getDescripcion());
    }

    public TipoIdentificacion construirDominio(TipoIdentificacionDTO tipoIdentificacionDTO) {
        return TipoIdentificacion.construir(tipoIdentificacionDTO.getIdentificador(), tipoIdentificacionDTO.getSigla(), tipoIdentificacionDTO.getDescripcion());
    }

    public List<TipoIdentificacionDTO> construirDTOs(List<TipoIdentificacionEntidad> tiposIdentificacion){
        return tiposIdentificacion.stream().map(new TipoIdentificacionMapeador()::construirDTO).toList();
    }
}
