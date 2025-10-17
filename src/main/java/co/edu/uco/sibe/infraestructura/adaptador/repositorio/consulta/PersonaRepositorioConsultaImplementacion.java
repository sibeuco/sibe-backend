package co.edu.uco.sibe.infraestructura.adaptador.repositorio.consulta;

import co.edu.uco.sibe.dominio.dto.PersonaDTO;
import co.edu.uco.sibe.dominio.dto.UsuarioDTO;
import co.edu.uco.sibe.dominio.modelo.Persona;
import co.edu.uco.sibe.dominio.modelo.Usuario;
import co.edu.uco.sibe.dominio.puerto.consulta.PersonaRepositorioConsulta;
import co.edu.uco.sibe.dominio.transversal.utilitarios.ValidadorObjeto;
import co.edu.uco.sibe.infraestructura.adaptador.dao.IdentificacionDAO;
import co.edu.uco.sibe.infraestructura.adaptador.dao.PersonaDAO;
import co.edu.uco.sibe.infraestructura.adaptador.dao.UsuarioDAO;
import co.edu.uco.sibe.infraestructura.adaptador.entidad.UsuarioEntidad;
import co.edu.uco.sibe.infraestructura.adaptador.mapeador.PersonaMapeador;
import co.edu.uco.sibe.infraestructura.adaptador.mapeador.UsuarioMapeador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Repository
public class PersonaRepositorioConsultaImplementacion implements PersonaRepositorioConsulta {
    @Autowired
    PersonaDAO personaDAO;

    @Autowired
    PersonaMapeador personaMapeador;

    @Autowired
    UsuarioDAO usuarioDAO;

    @Autowired
    UsuarioMapeador usuarioMapeador;

    @Autowired
    IdentificacionDAO identificacionDAO;

    @Override
    public Persona consultarPersonaPorIdentificador(UUID identificador) {
        var entidad = this.personaDAO.findById(identificador).orElse(null);

        if (ValidadorObjeto.esNulo(entidad)){
            return null;
        }

        var usuarioEntidad = this.usuarioDAO.findByCorreo(entidad.getCorreo());

        if(!usuarioEntidad.isEstaActivo()) {
            return null;
        }

        return this.personaMapeador.construirModelo(entidad);
    }

    @Override
    public PersonaDTO consultarPersonaPorCorreoDTO(String correo) {
        var entidad = this.personaDAO.findByCorreo(correo);

        if (ValidadorObjeto.esNulo(entidad)){
            return null;
        }

        var usuarioEntidad = this.usuarioDAO.findByCorreo(correo);

        if(!usuarioEntidad.isEstaActivo()) {
            return null;
        }

        return this.personaMapeador.construirDTO(entidad);
    }

    @Override
    public Persona consultarPersonaPorCorreo(String correo) {
        var entidad = this.personaDAO.findByCorreo(correo);

        if (ValidadorObjeto.esNulo(entidad)){
            return null;
        }

        var usuarioEntidad = this.usuarioDAO.findByCorreo(correo);

        if(!usuarioEntidad.isEstaActivo()) {
            return null;
        }

        return this.personaMapeador.construirModelo(entidad);
    }

    @Override
    public Persona consultarPersonaPorDocumento(String documento) {
        var identificacionEntidad = this.identificacionDAO.findByNumeroIdentificacion(documento);
        var entidad = this.personaDAO.findByIdentificacion(identificacionEntidad);

        if (ValidadorObjeto.esNulo(entidad)){
            return null;
        }

        var usuarioEntidad = this.usuarioDAO.findByCorreo(entidad.getCorreo());

        if(!usuarioEntidad.isEstaActivo()) {
            return null;
        }

        return this.personaMapeador.construirModelo(entidad);
    }

    @Override
    public UsuarioDTO consultarUsuarioPorIdentificadorDTO(UUID identificador) {
        var entidad = this.usuarioDAO.findById(identificador).orElse(null);

        if (ValidadorObjeto.esNulo(entidad)){
            return null;
        }

        var usuarioEntidad = this.usuarioDAO.findByCorreo(entidad.getCorreo());

        if(!usuarioEntidad.isEstaActivo()) {
            return null;
        }

        return this.usuarioMapeador.construirDTO(entidad);
    }

    @Override
    public Usuario consultarUsuarioPorIdentificador(UUID identificador) {
        var entidad = this.usuarioDAO.findById(identificador).orElse(null);

        if (ValidadorObjeto.esNulo(entidad) || !entidad.isEstaActivo()){
            return null;
        }

        return this.usuarioMapeador.construirModelo(entidad);
    }

    @Override
    public UsuarioDTO consultarUsuarioPorCorreoDTO(String correo) {
        var entidad = this.usuarioDAO.findByCorreo(correo);

        if (ValidadorObjeto.esNulo(entidad) || !entidad.isEstaActivo()){
            return null;
        }

        return this.usuarioMapeador.construirDTO(entidad);
    }

    @Override
    public Usuario consultarUsuarioPorCorreo(String correo) {
        var entidad = this.usuarioDAO.findByCorreo(correo);

        if (ValidadorObjeto.esNulo(entidad) || !entidad.isEstaActivo()){
            return null;
        }

        return this.usuarioMapeador.construirModelo(entidad);
    }

    @Override
    public List<UsuarioDTO> consultarUsuariosDTO() {
        var entidades = this.usuarioDAO.findAll().stream().filter(UsuarioEntidad::isEstaActivo).toList();

        return this.usuarioMapeador.construirDTOs(entidades);
    }
}