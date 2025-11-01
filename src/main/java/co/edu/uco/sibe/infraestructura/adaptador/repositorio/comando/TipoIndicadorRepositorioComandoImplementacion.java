package co.edu.uco.sibe.infraestructura.adaptador.repositorio.comando;

import co.edu.uco.sibe.dominio.modelo.TipoIndicador;
import co.edu.uco.sibe.dominio.puerto.comando.TipoIndicadorRepositorioComando;
import co.edu.uco.sibe.infraestructura.adaptador.dao.TipoIndicadorDAO;
import co.edu.uco.sibe.infraestructura.adaptador.mapeador.TipoIndicadorMapeador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.UUID;

@Repository
public class TipoIndicadorRepositorioComandoImplementacion implements TipoIndicadorRepositorioComando {
    @Autowired
    private TipoIndicadorDAO tipoIndicadorDAO;

    @Autowired
    private TipoIndicadorMapeador tipoIndicadorMapeador;

    @Override
    public UUID guardar(TipoIndicador tipoIndicador) {
        var entidad = tipoIndicadorMapeador.construirEntidad(tipoIndicador);

        return tipoIndicadorDAO.save(entidad).getIdentificador();
    }
}