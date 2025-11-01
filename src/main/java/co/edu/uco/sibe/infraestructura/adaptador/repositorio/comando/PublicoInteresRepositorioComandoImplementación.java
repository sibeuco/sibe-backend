package co.edu.uco.sibe.infraestructura.adaptador.repositorio.comando;

import co.edu.uco.sibe.dominio.modelo.PublicoInteres;
import co.edu.uco.sibe.dominio.puerto.comando.PublicoInteresRepositorioComando;
import co.edu.uco.sibe.infraestructura.adaptador.dao.PublicoInteresDAO;
import co.edu.uco.sibe.infraestructura.adaptador.mapeador.PublicoInteresMapeador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.UUID;

@Repository
public class PublicoInteresRepositorioComandoImplementación implements PublicoInteresRepositorioComando {
    @Autowired
    private PublicoInteresDAO publicoInteresDAO;

    @Autowired
    private PublicoInteresMapeador publicoInteresMapeador;

    @Override
    public UUID guardar(PublicoInteres publicoInteres) {
        var entidad = publicoInteresMapeador.construirEntidad(publicoInteres);

        return this.publicoInteresDAO.save(entidad).getIdentificador();
    }
}