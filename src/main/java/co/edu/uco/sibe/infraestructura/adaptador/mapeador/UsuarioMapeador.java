package co.edu.uco.sibe.infraestructura.adaptador.mapeador;

import co.edu.uco.sibe.dominio.dto.UsuarioDTO;
import co.edu.uco.sibe.dominio.modelo.Usuario;
import co.edu.uco.sibe.dominio.transversal.utilitarios.UtilUUID;
import co.edu.uco.sibe.infraestructura.adaptador.dao.PersonaDAO;
import co.edu.uco.sibe.infraestructura.adaptador.dao.UsuarioTipoUsuarioDAO;
import co.edu.uco.sibe.infraestructura.adaptador.entidad.UsuarioEntidad;
import co.edu.uco.sibe.infraestructura.adaptador.entidad.UsuarioTipoUsuarioEntidad;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.UUID;

@Component
@AllArgsConstructor
public class UsuarioMapeador {
    private final TipoUsuarioMapeador tipoUsuarioMapeador;
    private final IdentificacionMapeador identificacionMapeador;
    private final PersonaDAO personaDAO;
    private final UsuarioTipoUsuarioDAO usuarioTipoUsuarioDAO;

    public UsuarioDTO construirDTO(UsuarioEntidad usuario){
        var personaEntidad = personaDAO.findByCorreo(usuario.getCorreo());
        var identificacionDTO = identificacionMapeador.construirDTO(personaEntidad.getIdentificacion());
        var tipoUsuarioDTO = tipoUsuarioMapeador.construirDTO(usuario.getRol().getTipoUsuario());

        return new UsuarioDTO(usuario.getIdentificador(), personaEntidad.getNombres(), personaEntidad.getApellidos(), personaEntidad.getCorreo(), identificacionDTO, tipoUsuarioDTO, usuario.isEstaActivo());
    }

    public UsuarioEntidad construirEntidad(Usuario usuario, String contrasena){
        var tipoUsuarioEntidad = tipoUsuarioMapeador.construirEntidad(usuario.getTipoUsuario());
        var usuarioTipoUsuarioEntidad = new UsuarioTipoUsuarioEntidad(
                generarNuevoUUIDIdentificacionTipoIdentificacion(),
                tipoUsuarioEntidad
        );

        return new UsuarioEntidad(usuario.getIdentificador(), usuario.getCorreo(), usuario.getClave(), usuario.isEstaActivo(), usuarioTipoUsuarioEntidad);
    }

    public UUID generarNuevoUUIDIdentificacionTipoIdentificacion() {
        UUID nuevoUUID;

        do {
            nuevoUUID = UtilUUID.generarNuevoUUID();
        } while (usuarioTipoUsuarioDAO.findById(nuevoUUID).orElse(null) != null);

        return nuevoUUID;
    }

    public List<UsuarioDTO> construirDTOs(List<UsuarioEntidad> usuarios){
        return usuarios.stream().map(this::construirDTO).toList();
    }

    public void construirModificarContrasenaEntidad(UsuarioEntidad usuario, String contrasena){
        usuario.setClave(contrasena);
    }

    public void modificarEntidad(UsuarioEntidad usuarioEntidad, Usuario usuario) {
        usuarioEntidad.setCorreo(usuario.getCorreo());
        usuarioEntidad.setEstaActivo(usuarioEntidad.isEstaActivo());

        this.tipoUsuarioMapeador.modificarEntidad(usuarioEntidad.getRol(), usuario.getTipoUsuario());
    }

    public Usuario construirModelo(UsuarioEntidad entidad) {
        var tipoUsuario = tipoUsuarioMapeador.construirModelo(entidad.getRol().getTipoUsuario());

        return Usuario.construir(entidad.getIdentificador(), entidad.getCorreo(), entidad.getClave(), tipoUsuario, entidad.isEstaActivo());
    }
}