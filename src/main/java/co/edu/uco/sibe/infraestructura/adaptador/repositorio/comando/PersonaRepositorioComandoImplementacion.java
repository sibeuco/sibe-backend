package co.edu.uco.sibe.infraestructura.adaptador.repositorio.comando;

import co.edu.uco.sibe.dominio.modelo.Persona;
import co.edu.uco.sibe.dominio.modelo.Usuario;
import co.edu.uco.sibe.dominio.puerto.comando.PersonaRepositorioComando;
import co.edu.uco.sibe.dominio.transversal.utilitarios.ValidadorObjeto;
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
    private PersonaDAO personaDAO;

    @Autowired
    private PersonaMapeador personaMapeador;

    @Autowired
    private UsuarioDAO usuarioDAO;

    @Autowired
    private UsuarioMapeador usuarioMapeador;

    @Override
    public UUID agregarNuevoUsuario(Usuario usuario, Persona persona, String claveEncriptada) {
        var entidadUsuario = this.usuarioMapeador.construirEntidad(usuario, claveEncriptada);
        var entidadPersona = this.personaMapeador.construirEntidad(persona);

        this.personaDAO.save(entidadPersona);

        return this.usuarioDAO.save(entidadUsuario).getIdentificador();
    }

    @Override
    public UUID modificarUsuario(Usuario usuario, Persona persona) {
        var personaEntidad = this.personaDAO.findById(persona.getIdentificador()).orElse(null);
        var usuarioEntidad = this.usuarioDAO.findById(usuario.getIdentificador()).orElse(null);

        assert !ValidadorObjeto.esNulo(personaEntidad);
        this.personaMapeador.modificarEntidad(personaEntidad, persona);

        assert !ValidadorObjeto.esNulo(usuarioEntidad);
        this.usuarioMapeador.modificarEntidad(usuarioEntidad, usuario);

        this.personaDAO.save(personaEntidad);

        return this.usuarioDAO.save(usuarioEntidad).getIdentificador();
    }

    @Override
    public UUID modificarClave(String nuevaContrasena, UUID identificador) {
        var usuarioEntidad = this.usuarioDAO.findById(identificador).orElse(null);

        assert !ValidadorObjeto.esNulo(usuarioEntidad);
        this.usuarioMapeador.construirModificarContrasenaEntidad(usuarioEntidad, nuevaContrasena);

        return this.usuarioDAO.save(usuarioEntidad).getIdentificador();

    }

    @Override
    public void eliminarUsuario(UUID identificador) {
        var personaEntidad = personaDAO.findById(identificador).orElse(null);

        assert !ValidadorObjeto.esNulo(personaEntidad);
        var usuarioEntidad = usuarioDAO.findByCorreo(personaEntidad.getCorreo());

        assert !ValidadorObjeto.esNulo(usuarioEntidad);
        usuarioEntidad.setEstaActivo(false);

        this.usuarioDAO.save(usuarioEntidad);
    }
}