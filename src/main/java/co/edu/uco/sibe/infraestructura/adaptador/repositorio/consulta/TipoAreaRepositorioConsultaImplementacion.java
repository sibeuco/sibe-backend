package co.edu.uco.sibe.infraestructura.adaptador.repositorio.consulta;

import co.edu.uco.sibe.dominio.puerto.consulta.TipoAreaRepositorioConsulta;
import co.edu.uco.sibe.dominio.transversal.utilitarios.ValidadorObjeto;
import co.edu.uco.sibe.infraestructura.adaptador.mapeador.TipoAreaMapeador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public class TipoAreaRepositorioConsultaImplementacion implements TipoAreaRepositorioConsulta {

    @Autowired
    TipoAreaDAO tipoAreaDAO;

    @Autowired
    TipoAreaMapeador tipoAreaMapeador;

    @Override
    public TipoAreaDTO consultarTipoAreaPorIdentificador(UUID identificador) {
        var entidad = this.tipoAreaDAO.consultarTipoAreaPorIdentificador(identificador);
        if (ValidadorObjeto.getInstance().esNulo(entidad)){
            return null;
        }
        return this.tipoAreaMapeador.construirDTO(entidad);
    }

    @Override
    public List<TipoAreaDTO> consultarTiposArea() {
        var entidades = this.tipoAreaDAO.findAll();

        return this.tipoAreaMapeador.construirDTOs(entidades);
    }
}
