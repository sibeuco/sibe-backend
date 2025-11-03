package co.edu.uco.sibe.infraestructura.adaptador.repositorio.consulta;

import co.edu.uco.sibe.dominio.dto.IndicadorDTO;
import co.edu.uco.sibe.dominio.modelo.Indicador;
import co.edu.uco.sibe.dominio.puerto.consulta.IndicadorRepositorioConsulta;
import co.edu.uco.sibe.infraestructura.adaptador.dao.IndicadorDAO;
import co.edu.uco.sibe.infraestructura.adaptador.mapeador.IndicadorMapeador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.UUID;
import static co.edu.uco.sibe.dominio.transversal.utilitarios.ValidadorObjeto.esNulo;

@Repository
public class IndicadorRepositorioConsultaImplementacion implements IndicadorRepositorioConsulta {
    @Autowired
    private IndicadorDAO indicadorDAO;

    @Autowired
    private IndicadorMapeador indicadorMapeador;

    @Override
    public List<IndicadorDTO> consultarDTOs() {
        var entidades = indicadorDAO.findAll();

        return this.indicadorMapeador.construirDTOs(entidades);
    }

    @Override
    public Indicador consultarPorIdentificador(UUID identificador) {
        var entidad = this.indicadorDAO.findById(identificador).orElse(null);

        if(esNulo(entidad)) {
            return null;
        }

        return this.indicadorMapeador.construriModelo(entidad);
    }

    @Override
    public Indicador consultarPorNombre(String nombre) {
        var entidad = this.indicadorDAO.findByNombre(nombre);

        if(esNulo(entidad)) {
            return null;
        }

        return this.indicadorMapeador.construriModelo(entidad);
    }
}