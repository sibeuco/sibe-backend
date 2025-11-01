package co.edu.uco.sibe.infraestructura.adaptador.repositorio.consulta;

import co.edu.uco.sibe.dominio.dto.TipoIndicadorDTO;
import co.edu.uco.sibe.dominio.modelo.TipoIndicador;
import co.edu.uco.sibe.dominio.puerto.consulta.TipoIndicadorRepositorioConsulta;
import co.edu.uco.sibe.dominio.transversal.utilitarios.ValidadorNumero;
import co.edu.uco.sibe.infraestructura.adaptador.dao.TipoIndicadorDAO;
import co.edu.uco.sibe.infraestructura.adaptador.mapeador.TipoIndicadorMapeador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.UUID;

import static co.edu.uco.sibe.dominio.transversal.constante.NumeroConstante.CERO;
import static co.edu.uco.sibe.dominio.transversal.utilitarios.ValidadorObjeto.esNulo;

@Repository
public class TipoIndicadorRepositorioConsultaImplementacion implements TipoIndicadorRepositorioConsulta {
    @Autowired
    private TipoIndicadorDAO tipoIndicadorDAO;

    @Autowired
    private TipoIndicadorMapeador tipoIndicadorMapeador;

    @Override
    public List<TipoIndicadorDTO> consultarDTOs() {
        var entidades = tipoIndicadorDAO.findAll();

        return this.tipoIndicadorMapeador.construirDTOs(entidades);
    }

    @Override
    public TipoIndicador consultarPorIdentificador(UUID identificador) {
        var entidad = tipoIndicadorDAO.findById(identificador).orElse(null);

        if(esNulo(entidad)) {
            return null;
        }

        return this.tipoIndicadorMapeador.construirModelo(entidad);
    }

    @Override
    public TipoIndicador consultarPorNaturaleza(String naturaleza) {
        var entidad = tipoIndicadorDAO.findByNaturaleza(naturaleza);

        if(esNulo(entidad)) {
            return null;
        }

        return this.tipoIndicadorMapeador.construirModelo(entidad);
    }

    @Override
    public TipoIndicador consultarPorTipologia(String tipologia) {
        var entidad = tipoIndicadorDAO.findByTipologia(tipologia);

        if(esNulo(entidad)) {
            return null;
        }

        return this.tipoIndicadorMapeador.construirModelo(entidad);
    }

    @Override
    public Boolean hayDatos() {
        var cantidad = tipoIndicadorDAO.count();

        return ValidadorNumero.esNumeroMayor(cantidad, CERO);
    }
}
