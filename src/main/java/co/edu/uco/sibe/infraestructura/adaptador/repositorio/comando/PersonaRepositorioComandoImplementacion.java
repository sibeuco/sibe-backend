package co.edu.uco.sibe.infraestructura.adaptador.repositorio.comando;

import co.edu.uco.sibe.dominio.modelo.Persona;
import co.edu.uco.sibe.dominio.modelo.Usuario;
import co.edu.uco.sibe.dominio.puerto.comando.PersonaRepositorioComando;
import co.edu.uco.sibe.dominio.transversal.utilitarios.ValidadorObjeto;
import co.edu.uco.sibe.infraestructura.adaptador.dao.PersonaDAO;
import co.edu.uco.sibe.infraestructura.adaptador.dao.PeticionRecuperacionClaveDAO;
import co.edu.uco.sibe.infraestructura.adaptador.dao.UsuarioDAO;
import co.edu.uco.sibe.infraestructura.adaptador.mapeador.PersonaMapeador;
import co.edu.uco.sibe.infraestructura.adaptador.mapeador.PeticionRecuperacionClaveMapeador;
import co.edu.uco.sibe.infraestructura.adaptador.mapeador.UsuarioMapeador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
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

    @Autowired
    PeticionRecuperacionClaveDAO peticionRecuperacionClaveDAO;

    @Autowired
    PeticionRecuperacionClaveMapeador peticionRecuperacionClaveMapeador;

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

    @Override
    public UUID crearPeticionRecuperacionClave(String codigoCifrado, String correo, LocalDateTime fecha) {
        var entidad = this.peticionRecuperacionClaveDAO.findByCorreo(correo);

        if (ValidadorObjeto.esNulo(entidad)) {
            entidad = this.peticionRecuperacionClaveMapeador.construirEntidad(codigoCifrado, correo, fecha);
        } else {
            this.peticionRecuperacionClaveMapeador.actualizarEntidad(entidad, codigoCifrado, fecha);
        }

        return this.peticionRecuperacionClaveDAO.save(entidad).getId();
    }

    @Override
    public void eliminarPeticionRecuperacionClaveConCorreo(String correo) {
        var entidad = this.peticionRecuperacionClaveDAO.findByCorreo(correo);

        assert !ValidadorObjeto.esNulo(entidad);
        this.peticionRecuperacionClaveDAO.deleteById(entidad.getId());
    }

    @Override
    public UUID modificarClaveConCorreo(String claveCifrada, String correo) {
        var entidad = this.usuarioDAO.findByCorreo(correo);

        assert !ValidadorObjeto.esNulo(entidad);
        this.usuarioMapeador.construirModificarContrasenaEntidad(entidad, claveCifrada);

        return this.usuarioDAO.save(entidad).getIdentificador();
    }
}