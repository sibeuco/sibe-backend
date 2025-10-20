package co.edu.uco.sibe.infraestructura.adaptador.repositorio.comando;

import co.edu.uco.sibe.dominio.modelo.Area;
import co.edu.uco.sibe.dominio.puerto.comando.AreaRepositorioComando;
import co.edu.uco.sibe.infraestructura.adaptador.dao.AreaDAO;
import co.edu.uco.sibe.infraestructura.adaptador.mapeador.AreaMapeador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.UUID;

@Repository
public class AreaRepositorioComandoImplementacion implements AreaRepositorioComando {
    @Autowired
    private AreaDAO areaDAO;

    @Autowired
    private AreaMapeador areaMapeador;

    @Override
    public UUID guardar(Area area) {
        var entidad = areaMapeador.construirEntidad(area);

        return this.areaDAO.save(entidad).getIdentificador();
    }
}