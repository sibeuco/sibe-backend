package co.edu.uco.sibe.infraestructura.adaptador.mapeador;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UsuarioMapeador {
    private final TipoUsuarioMapeador tipoUsuarioMapeador;

    public UsuarioMapeador(TipoUsuarioMapeador tipoUsuarioMapeador){
        this.tipoUsuarioMapeador = tipoUsuarioMapeador;
    }

    public UsuarioDTO construirDTO(UsuarioEntidad usuario){
        return new UsuarioDTO(usuario.getIdentificador(), usuario.getCorreo(), this.tipoUsuarioMapeador.construirDTO(usuario.getTipoUsuario()), usuario.isEstaActivo());
    }

    public UsuarioEntidad construirEntidad(Usuario usuario, String contrasena){
        return new UsuarioEntidad(usuario.getIdentificador(), usuario.getCorreo(), contrasena, this.tipoUsuarioMapeador.construirEntidad(usuario.getTipoUsuario()), usuario.isEstaActivo());
    }

    public List<UsuarioDTO> construirDTOs(List<UsuarioEntidad> usuarios){
        return usuarios.stream().map(this::construirDTO).toList();
    }

    public void construirModificarContrasenaEntidad(UsuarioEntidad usuario, String contrasena){
        usuario.setContrasena(contrasena);
    }

}
