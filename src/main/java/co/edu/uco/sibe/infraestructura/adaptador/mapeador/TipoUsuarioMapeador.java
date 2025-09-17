package co.edu.uco.sibe.infraestructura.adaptador.mapeador;

import co.edu.uco.sibe.dominio.dto.TipoUsuarioDTO;
import co.edu.uco.sibe.infraestructura.adaptador.entidad.TipoUsuarioEntidad;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TipoUsuarioMapeador {

    public TipoUsuarioDTO construirDTO(TipoUsuarioEntidad tipoUsuario){
        return new TipoUsuarioDTO(tipoUsuario.getIdentificador(), tipoUsuario.getNombre(), tipoUsuario.isCrear(), tipoUsuario.isModificar(), tipoUsuario.isEliminar(), tipoUsuario.isConsultar());
    }

    public TipoUsuarioEntidad construirEntidad(TipoUsuario tipoUsuario){
        return new TipoUsuarioEntidad(tipoUsuario.getIdentificador(), tipoUsuario.getNombre(), tipoUsuario.isCrear(), tipoUsuario.isModificar(), tipoUsuario.isEliminar(), tipoUsuario.isConsultar());
    }

    public List<TipoUsuarioDTO> construirDTOs(List<TipoUsuarioEntidad> tiposUsuario){
        return tiposUsuario.stream().map(new TipoUsuarioMapeador()::construirDTO).toList();
    }

}
