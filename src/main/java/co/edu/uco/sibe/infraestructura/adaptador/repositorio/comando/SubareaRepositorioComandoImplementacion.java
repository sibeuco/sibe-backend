package co.edu.uco.sibe.infraestructura.adaptador.repositorio.comando;

import co.edu.uco.sibe.dominio.modelo.Subarea;
import co.edu.uco.sibe.dominio.puerto.comando.SubareaRepositorioComando;
import co.edu.uco.sibe.infraestructura.adaptador.dao.SubareaDAO;
import co.edu.uco.sibe.infraestructura.adaptador.mapeador.SubareaMapeador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.UUID;

@Repository
public class SubareaRepositorioComandoImplementacion implements SubareaRepositorioComando {
    @Autowired
    private SubareaDAO subareaDAO;

    @Autowired
    private SubareaMapeador subareaMapeador;

    @Override
    public UUID guardar(Subarea subarea) {
        var entidad = subareaMapeador.construirEntidad(subarea);

        return this.subareaDAO.save(entidad).getIdentificador();
    }
}