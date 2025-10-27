package co.edu.uco.sibe.infraestructura.adaptador.repositorio.comando;

import co.edu.uco.sibe.dominio.modelo.Proyecto;
import co.edu.uco.sibe.dominio.puerto.comando.ProyectoRepositorioComando;
import co.edu.uco.sibe.infraestructura.adaptador.dao.ProyectoDAO;
import co.edu.uco.sibe.infraestructura.adaptador.mapeador.ProyectoMapeador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.UUID;

@Repository
public class ProyectoRepositorioComandoImplementacion implements ProyectoRepositorioComando {
    @Autowired
    private ProyectoDAO proyectoDAO;

    @Autowired
    private ProyectoMapeador proyectoMapeador;

    @Override
    public UUID guardar(Proyecto proyecto) {
        var entidad = proyectoMapeador.construirEntidad(proyecto);

        return this.proyectoDAO.save(entidad).getIdentificador();
    }
}
