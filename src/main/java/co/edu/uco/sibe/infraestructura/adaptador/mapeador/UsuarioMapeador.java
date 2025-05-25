package co.edu.uco.sibe.infraestructura.adaptador.mapeador;

import co.edu.uco.sibe.dominio.dto.UsuarioDTO;
import co.edu.uco.sibe.dominio.modelo.Usuario;
import co.edu.uco.sibe.infraestructura.adaptador.entidad.UsuarioEntidad;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UsuarioMapeador {
    private final TipoUsuarioMapeador tipoUsuarioMapeador;
    private final AreaMapeador areaMapeador;
    private final PersonaMapeador personaMapeador;

    public UsuarioMapeador(TipoUsuarioMapeador tipoUsuarioMapeador, AreaMapeador areaMapeador, PersonaMapeador personaMapeador){
        this.tipoUsuarioMapeador = tipoUsuarioMapeador;
        this.areaMapeador = areaMapeador;
        this.personaMapeador = personaMapeador;
    }

    public UsuarioDTO construirDTO(UsuarioEntidad usuario){
        return new UsuarioDTO(usuario.getIdentificador(), usuario.getCorreo(), this.tipoUsuarioMapeador.construirDTO(usuario.getTipoUsuario()), usuario.isEstaActivo(), this.areaMapeador.construirDTO(usuario.getArea()), this.personaMapeador.construirDTO(usuario.getPersona()));
    }

    public UsuarioEntidad construirEntidad(Usuario usuario){
        return new UsuarioEntidad(usuario.getIdentificador(), usuario.getCorreo(), usuario.getContrasena(), this.tipoUsuarioMapeador.construirEntidad(usuario.getTipoUsuario()), usuario.isEstaActivo(), this.areaMapeador.construirEntidad(usuario.getArea()), this.personaMapeador.construirEntidad(usuario.getPersona()));
    }

    public List<UsuarioDTO> construirDTOs(List<UsuarioEntidad> usuarios){
        return usuarios.stream().map(this::construirDTO).toList();
    }

}
