package co.edu.uco.sibe.infraestructura.adaptador.repositorio.comando;

import co.edu.uco.sibe.dominio.puerto.comando.TipoAreaRepositorioComando;
import co.edu.uco.sibe.infraestructura.adaptador.dao.TipoAreaDAO;
import co.edu.uco.sibe.infraestructura.adaptador.mapeador.TipoAreaMapeador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public class TipoAreaRepositorioComandoImplementacion implements TipoAreaRepositorioComando {

    @Autowired
    TipoAreaDAO tipoAreaDAO;

    @Autowired
    TipoAreaMapeador tipoAreaMapeador;

    @Override
    public UUID agregarNuevoTipoArea(TipoArea tipoArea) {
        var entidad = this.tipoAreaMapeador.construirEntidad(tipoArea);

        return this.tipoAreaDAO.save(entidad).getIdentificador();
    }

}
