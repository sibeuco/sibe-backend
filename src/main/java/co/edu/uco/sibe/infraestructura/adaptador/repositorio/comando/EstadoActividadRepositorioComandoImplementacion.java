package co.edu.uco.sibe.infraestructura.adaptador.repositorio.comando;

import co.edu.uco.sibe.dominio.modelo.EstadoActividad;
import co.edu.uco.sibe.dominio.puerto.comando.EstadoActividadRepositorioComando;
import co.edu.uco.sibe.infraestructura.adaptador.dao.EstadoActividadDAO;
import co.edu.uco.sibe.infraestructura.adaptador.mapeador.EstadoActividadMapeador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.UUID;

@Repository
public class EstadoActividadRepositorioComandoImplementacion implements EstadoActividadRepositorioComando {
    @Autowired
    private EstadoActividadDAO estadoActividadDAO;

    @Autowired
    private EstadoActividadMapeador estadoActividadMapeador;

    @Override
    public UUID guardar(EstadoActividad estadoActividad) {
        var entidad = this.estadoActividadMapeador.construirEntidad(estadoActividad);

        return this.estadoActividadDAO.save(entidad).getIdentificador();
    }
}