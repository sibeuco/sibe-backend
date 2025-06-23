package co.edu.uco.sibe.infraestructura.adaptador.repositorio.consulta;

import co.edu.uco.sibe.dominio.dto.PersonaDTO;
import co.edu.uco.sibe.dominio.dto.UsuarioDTO;
import co.edu.uco.sibe.dominio.puerto.consulta.PersonaRepositorioConsulta;
import co.edu.uco.sibe.dominio.transversal.utilitarios.UtilObjeto;
import co.edu.uco.sibe.infraestructura.adaptador.dao.PersonaDAO;
import co.edu.uco.sibe.infraestructura.adaptador.dao.UsuarioDAO;
import co.edu.uco.sibe.infraestructura.adaptador.mapeador.PersonaMapeador;
import co.edu.uco.sibe.infraestructura.adaptador.mapeador.UsuarioMapeador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

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

    @Override
    public PersonaDTO consultarPersonaPorIdentificador(UUID identificador) {
        var entidad = this.personaDAO.consultarPersonaPorIdentificador(identificador);

        if (UtilObjeto.getInstance().esNulo(entidad)){
            return null;
        }
        return this.personaMapeador.construirDTO(entidad);
    }

    @Override
    public PersonaDTO consultarPersonaPorDocumento(String documento) {
        var entidad = this.personaDAO.consultarPersonaPorDocumento(documento);

        if (UtilObjeto.getInstance().esNulo(entidad)){
            return null;
        }
        return this.personaMapeador.construirDTO(entidad);
    }

    @Override
    public PersonaDTO consultarPersonaPorCorreo(String correo) {
        var entidad = this.personaDAO.consultarPersonaPorCorreo(correo);

        if (UtilObjeto.getInstance().esNulo(entidad)){
            return null;
        }
        return this.personaMapeador.construirDTO(entidad);
    }

    @Override
    public UsuarioDTO consultarUsuarioPorIdentificador(UUID identificador) {
        var entidad = this.usuarioDAO.consultarUsuarioPorIdentificador(identificador);

        if (UtilObjeto.getInstance().esNulo(entidad)){
            return null;
        }
        return this.usuarioMapeador.construirDTO(entidad);
    }

    @Override
    public UsuarioDTO consultarUsuarioPorCorreo(String correo) {
        var entidad = this.usuarioDAO.consultarUsuarioPorCorreo(correo);

        if (UtilObjeto.getInstance().esNulo(entidad)){
            return null;
        }
        return this.usuarioMapeador.construirDTO(entidad);
    }

    @Override
    public List<PersonaDTO> consultarPersonas() {
        var entidades = this.personaDAO.findAll();

        return  this.personaMapeador.construirDTOs(entidades);
    }

    @Override
    public List<UsuarioDTO> consultarUsuarios() {
        var entidades = this.usuarioDAO.findAll();

        return this.usuarioMapeador.construirDTOs(entidades);
    }
}
