package co.edu.uco.sibe.infraestructura.adaptador.repositorio.consulta;

import co.edu.uco.sibe.dominio.dto.TipoUsuarioDTO;
import co.edu.uco.sibe.dominio.puerto.consulta.TipoUsuarioRepositorioConsulta;
import co.edu.uco.sibe.dominio.transversal.utilitarios.ValidadorObjeto;
import co.edu.uco.sibe.infraestructura.adaptador.dao.TipoUsuarioDAO;
import co.edu.uco.sibe.infraestructura.adaptador.mapeador.TipoUsuarioMapeador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public class TipoUsuarioRepositorioConsultaImplementacion implements TipoUsuarioRepositorioConsulta {

    @Autowired
    TipoUsuarioDAO tipoUsuarioDAO;

    @Autowired
    TipoUsuarioMapeador tipoUsuarioMapeador;

    @Override
    public TipoUsuarioDTO consultarTipoUsuarioPorIdentificador(UUID identificador) {
        var entidad = this.tipoUsuarioDAO.consultarTipoUsuarioPorIdentificador(identificador);
        if (ValidadorObjeto.getInstance().esNulo(entidad)){
            return null;
        }
        return this.tipoUsuarioMapeador.construirDTO(entidad);
    }

    @Override
    public List<TipoUsuarioDTO> consultarTiposUsuario() {
        var entidades = this.tipoUsuarioDAO.findAll();

        return this.tipoUsuarioMapeador.construirDTOs(entidades);
    }
}
