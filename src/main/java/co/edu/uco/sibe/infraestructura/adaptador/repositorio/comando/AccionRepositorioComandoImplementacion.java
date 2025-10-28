package co.edu.uco.sibe.infraestructura.adaptador.repositorio.comando;

import co.edu.uco.sibe.dominio.modelo.Accion;
import co.edu.uco.sibe.dominio.puerto.comando.AccionRepositorioComando;
import co.edu.uco.sibe.infraestructura.adaptador.dao.AccionDAO;
import co.edu.uco.sibe.infraestructura.adaptador.mapeador.AccionMapeador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.UUID;
import static co.edu.uco.sibe.dominio.transversal.utilitarios.ValidadorObjeto.esNulo;

@Repository
public class AccionRepositorioComandoImplementacion implements AccionRepositorioComando {
    @Autowired
    private AccionDAO accionDAO;

    @Autowired
    private AccionMapeador accionMapeador;

    @Override
    public UUID guardar(Accion accion) {
        var entidad = accionMapeador.construirEntidad(accion);

        return this.accionDAO.save(entidad).getIdentificador();
    }

    @Override
    public UUID modificar(Accion accion, UUID identificador) {
        var entidad = accionDAO.findById(identificador).orElse(null);

        assert !esNulo(entidad);
        accionMapeador.actualizarEntidad(entidad, accion);

        return this.accionDAO.save(entidad).getIdentificador();
    }
}