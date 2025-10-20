package co.edu.uco.sibe.infraestructura.adaptador.repositorio.comando;

import co.edu.uco.sibe.dominio.modelo.Temporalidad;
import co.edu.uco.sibe.dominio.puerto.comando.TemporalidadRepositorioComando;
import co.edu.uco.sibe.infraestructura.adaptador.dao.TemporalidadDAO;
import co.edu.uco.sibe.infraestructura.adaptador.mapeador.TemporalidadMapeador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.UUID;

@Repository
public class TemporalidadRepositorioComandoImplementacion implements TemporalidadRepositorioComando {
    @Autowired
    private TemporalidadDAO temporalidadDAO;

    @Autowired
    private TemporalidadMapeador temporalidadMapeador;

    @Override
    public UUID guardar(Temporalidad temporalidad) {
        var entidad = temporalidadMapeador.construirEntidad(temporalidad);

        return this.temporalidadDAO.save(entidad).getIdentificador();
    }
}