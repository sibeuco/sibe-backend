package co.edu.uco.sibe.infraestructura.adaptador.repositorio.comando;

import co.edu.uco.sibe.dominio.puerto.comando.TipoIdentificacionRepositorioComando;
import co.edu.uco.sibe.infraestructura.adaptador.mapeador.TipoIdentificacionMapeador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public class TipoIdentificacionRepositorioComandoImplementacion implements TipoIdentificacionRepositorioComando {

    @Autowired
    TipoIdentificacionDAO tipoIdentificacionDAO;

    @Autowired
    TipoIdentificacionMapeador tipoIdentificacionMapeador;

    @Override
    public UUID agregarNuevoTipoIdentificacion(TipoIdentificacion tipoIdentificacion) {
        var entidad = this.tipoIdentificacionMapeador.construirEntidad(tipoIdentificacion);

        return this.tipoIdentificacionDAO.save(entidad).getIdentificador();
    }

}
