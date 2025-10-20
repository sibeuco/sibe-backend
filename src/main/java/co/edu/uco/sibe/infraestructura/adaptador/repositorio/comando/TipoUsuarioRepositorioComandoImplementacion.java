package co.edu.uco.sibe.infraestructura.adaptador.repositorio.comando;

import co.edu.uco.sibe.dominio.modelo.TipoUsuario;
import co.edu.uco.sibe.dominio.puerto.comando.TipoUsuarioRepositorioComando;
import co.edu.uco.sibe.infraestructura.adaptador.dao.TipoUsuarioDAO;
import co.edu.uco.sibe.infraestructura.adaptador.mapeador.TipoUsuarioMapeador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.UUID;

@Repository
public class TipoUsuarioRepositorioComandoImplementacion implements TipoUsuarioRepositorioComando {
    @Autowired
    TipoUsuarioDAO tipoUsuarioDAO;

    @Autowired
    TipoUsuarioMapeador tipoUsuarioMapeador;

    @Override
    public UUID guardar(TipoUsuario tipoUsuario) {
        var entidad = tipoUsuarioMapeador.construirEntidad(tipoUsuario);

        return tipoUsuarioDAO.save(entidad).getIdentificador();
    }
}