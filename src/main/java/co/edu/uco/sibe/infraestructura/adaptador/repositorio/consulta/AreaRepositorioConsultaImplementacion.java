package co.edu.uco.sibe.infraestructura.adaptador.repositorio.consulta;

import co.edu.uco.sibe.dominio.puerto.consulta.AreaRepositorioConsulta;
import co.edu.uco.sibe.dominio.transversal.utilitarios.ValidadorObjeto;
import co.edu.uco.sibe.infraestructura.adaptador.mapeador.AreaMapeador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public class AreaRepositorioConsultaImplementacion implements AreaRepositorioConsulta {

    @Autowired
    AreaDAO areaDAO;

    @Autowired
    AreaMapeador areaMapeador;

    @Override
    public AreaDTO consultarAreaPorIdentificador(UUID identificador) {
        var entidad = this.areaDAO.consultarAreaPorIdentificador(identificador);

        if (ValidadorObjeto.getInstance().esNulo(entidad)){
            return null;
        }
        return this.areaMapeador.construirDTO(entidad);

    }

    @Override
    public List<AreaDTO> consultarAreas() {
        var entidades = this.areaDAO.findAll();

        return this.areaMapeador.construirDTOs(entidades);
    }
}
