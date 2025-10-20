package co.edu.uco.sibe.infraestructura.adaptador.repositorio.comando;

import co.edu.uco.sibe.dominio.modelo.Direccion;
import co.edu.uco.sibe.dominio.puerto.comando.DireccionRepositorioComando;
import co.edu.uco.sibe.infraestructura.adaptador.dao.DireccionDAO;
import co.edu.uco.sibe.infraestructura.adaptador.mapeador.DireccionMapeador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.UUID;

@Repository
public class DireccionRepositorioComandoImplementacion implements DireccionRepositorioComando {
    @Autowired
    private DireccionDAO direccionDAO;

    @Autowired
    private DireccionMapeador direccionMapeador;

    @Override
    public UUID guardar(Direccion direccion) {
        var entidad = direccionMapeador.construirEntidad(direccion);

        return this.direccionDAO.save(entidad).getIdentificador();
    }
}