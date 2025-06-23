package co.edu.uco.sibe.infraestructura.adaptador.repositorio.comando;

import co.edu.uco.sibe.dominio.modelo.Persona;
import co.edu.uco.sibe.dominio.modelo.Usuario;
import co.edu.uco.sibe.dominio.puerto.comando.PersonaRepositorioComando;
import co.edu.uco.sibe.dominio.transversal.utilitarios.UtilObjeto;
import co.edu.uco.sibe.infraestructura.adaptador.dao.PersonaDAO;
import co.edu.uco.sibe.infraestructura.adaptador.dao.UsuarioDAO;
import co.edu.uco.sibe.infraestructura.adaptador.mapeador.PersonaMapeador;
import co.edu.uco.sibe.infraestructura.adaptador.mapeador.UsuarioMapeador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
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
    public UUID agregarNuevoUsuario(Usuario usuario, Persona persona, String contrasenaEncriptada) {
        var entidadUsuario = this.usuarioMapeador.construirEntidad(usuario, contrasenaEncriptada);
        var entidadPersona = this.personaMapeador.construirEntidad(persona);

        this.personaDAO.save(entidadPersona);

        return this.usuarioDAO.save(entidadUsuario).getIdentificador();
    }

    @Override
    public UUID modificarPersona(Persona persona, UUID identificador) {
        UUID tipoIdentificacionPersona = persona.getTipoIdentificacion().getIdentificador();

        this.personaDAO.modificarPersona(tipoIdentificacionPersona, persona.getDocumento(),
                persona.getPrimerNombre(), persona.getSegundoNombre(), persona.getPrimerApellido(), persona.getSegundoApellido(), persona.getCorreo(), identificador);

        return identificador;

    }

    @Override
    public UUID modificarUsuario(Usuario usuario, UUID identificador) {
        UUID tipoUsuarioIdentificador = usuario.getTipoUsuario().getIdentificador();

        this.usuarioDAO.modificarUsuario(tipoUsuarioIdentificador, usuario.getCorreo(), identificador);

        return identificador;
    }

    @Override
    public UUID modificarContrasena(String nuevaContrasena, UUID identificador) {
        var usuarioEntidad = this.usuarioDAO.consultarUsuarioPorIdentificador(identificador);

        assert !UtilObjeto.getInstance().esNulo(usuarioEntidad);
        this.usuarioMapeador.construirModificarContrasenaEntidad(usuarioEntidad, nuevaContrasena);

        return this.usuarioDAO.save(usuarioEntidad).getIdentificador();
    }

    @Override
    public void eliminarUsuario(UUID identificador) {
        var usuario = usuarioDAO.findById(identificador).orElse(null);

        assert usuario != null;
        var persona = personaDAO.consultarPersonaPorCorreo(usuario.getCorreo());
        UUID identificadorPersona = persona.getIdentificador();

        personaDAO.deleteById(identificadorPersona);
        usuarioDAO.deleteById(identificador);

    }
}
