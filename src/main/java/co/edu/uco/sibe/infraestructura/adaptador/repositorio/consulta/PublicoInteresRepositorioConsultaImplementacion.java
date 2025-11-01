package co.edu.uco.sibe.infraestructura.adaptador.repositorio.consulta;

import co.edu.uco.sibe.dominio.dto.PublicoInteresDTO;
import co.edu.uco.sibe.dominio.modelo.PublicoInteres;
import co.edu.uco.sibe.dominio.puerto.consulta.PublicoInteresRepositorioConsulta;
import co.edu.uco.sibe.infraestructura.adaptador.dao.PublicoInteresDAO;
import co.edu.uco.sibe.infraestructura.adaptador.mapeador.PublicoInteresMapeador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.UUID;
import static co.edu.uco.sibe.dominio.transversal.constante.NumeroConstante.CERO;
import static co.edu.uco.sibe.dominio.transversal.utilitarios.ValidadorNumero.esNumeroMayor;
import static co.edu.uco.sibe.dominio.transversal.utilitarios.ValidadorObjeto.esNulo;

@Repository
public class PublicoInteresRepositorioConsultaImplementacion implements PublicoInteresRepositorioConsulta {
    @Autowired
    private PublicoInteresDAO publicoInteresDAO;

    @Autowired
    private PublicoInteresMapeador publicoInteresMapeador;

    @Override
    public List<PublicoInteresDTO> consultarDTOs() {
        var entidades = publicoInteresDAO.findAll();

        return publicoInteresMapeador.construirDTOs(entidades);
    }

    @Override
    public PublicoInteres consultarPorIdentificador(UUID identificador) {
        var entidad = this.publicoInteresDAO.findById(identificador).orElse(null);

        if(esNulo(entidad)) {
            return null;
        }

        return this.publicoInteresMapeador.construriModelo(entidad);
    }

    @Override
    public PublicoInteres consultarPorNombre(String nombre) {
        var entidad = this.publicoInteresDAO.findByNombre(nombre);

        if(esNulo(entidad)) {
            return null;
        }

        return this.publicoInteresMapeador.construriModelo(entidad);
    }

    @Override
    public boolean hayDatos() {
        var cantidad = publicoInteresDAO.count();

        return esNumeroMayor(cantidad, CERO);
    }
}