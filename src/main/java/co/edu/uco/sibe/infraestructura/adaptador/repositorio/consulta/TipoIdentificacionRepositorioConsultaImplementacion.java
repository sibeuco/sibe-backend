package co.edu.uco.sibe.infraestructura.adaptador.repositorio.consulta;

import co.edu.uco.sibe.dominio.puerto.consulta.TipoIdentificacionRepositorioConsulta;
import co.edu.uco.sibe.dominio.transversal.utilitarios.ValidadorObjeto;
import co.edu.uco.sibe.infraestructura.adaptador.mapeador.TipoIdentificacionMapeador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public class TipoIdentificacionRepositorioConsultaImplementacion implements TipoIdentificacionRepositorioConsulta {

    @Autowired
    TipoIdentificacionDAO tipoIdentificacionDAO;

    @Autowired
    TipoIdentificacionMapeador tipoIdentificacionMapeador;

    @Override
    public TipoIdentificacionDTO consultarTipoIdentificacionPorIdentificador(UUID identificador) {
        var entidad = this.tipoIdentificacionDAO.consultarTipoIdentificacionPorIdentificador(identificador);
        if (ValidadorObjeto.getInstance().esNulo(entidad)){
            return null;
        }

        return this.tipoIdentificacionMapeador.construirDTO(entidad);
    }

    @Override
    public List<TipoIdentificacionDTO> consultarTiposIdentificacionDTO() {
        var entidades = this.tipoIdentificacionDAO.findAll();

        return this.tipoIdentificacionMapeador.construirDTOs(entidades);
    }
}
