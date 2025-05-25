package co.edu.uco.sibe.infraestructura.adaptador.repositorio.comando;

import co.edu.uco.sibe.dominio.modelo.Persona;
import co.edu.uco.sibe.dominio.modelo.Usuario;
import co.edu.uco.sibe.dominio.puerto.comando.PersonaRepositorioComando;
import co.edu.uco.sibe.infraestructura.adaptador.dao.PersonaDAO;
import co.edu.uco.sibe.infraestructura.adaptador.dao.UsuarioDAO;
import co.edu.uco.sibe.infraestructura.adaptador.mapeador.PersonaMapeador;
import co.edu.uco.sibe.infraestructura.adaptador.mapeador.UsuarioMapeador;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.UUID;

public class PersonaRepositorioComandoImplementacion implements PersonaRepositorioComando {

    @Autowired
    PersonaDAO personaDAO;

    @Autowired
    PersonaMapeador personaMapeador;

    @Autowired
    UsuarioDAO usuarioDAO;

    @Autowired
    UsuarioMapeador usuarioMapeador;

    @Override
    public UUID agregarNuevoUsuario(Usuario usuario) {
        var entidadPersona = this.personaMapeador.construirEntidad(usuario.getPersona());
        this.personaDAO.save(entidadPersona);
        var entidadUsuario = this.usuarioMapeador.construirEntidad(usuario);

        entidadUsuario.setPersona(entidadPersona);

        return this.usuarioDAO.save(entidadUsuario).getIdentificador();
    }

    @Override
    public UUID modificarPersona(Persona persona, UUID identificador) {
        UUID tipoIdentificacionPersona = persona.getTipoIdentificacion().getIdentificador();

        this.personaDAO.modificarPersona(tipoIdentificacionPersona, persona.getDocumento(),
                persona.getPrimerNombre(), persona.getSegundoNombre(), persona.getPrimerApellido(), persona.getSegundoApellido(), identificador);

        return identificador;

    }

    @Override
    public UUID modificarUsuario(Usuario usuario, UUID identificador) {
        UUID tipoUsuarioIdentificador = usuario.getTipoUsuario().getIdentificador();
        UUID areaODireccionIdentificador = usuario.getArea().getIdentificador();

        this.usuarioDAO.modificarUsuario(tipoUsuarioIdentificador, areaODireccionIdentificador, identificador);

        return identificador;
    }

    @Override
    public UUID modificarContrasena(String nuevaContrasena, UUID identificador) {
        usuarioDAO.cambiarContrasena(nuevaContrasena, identificador);
        return identificador;
    }

    @Override
    public void eliminarUsuario(UUID identificador) {
        var usuario = usuarioDAO.findById(identificador).orElse(null);

        assert usuario != null;
        UUID identificadorPersona = usuario.getPersona().getIdentificador();

        personaDAO.deleteById(identificadorPersona);
        usuarioDAO.deleteById(identificador);

    }
}
