package co.edu.uco.sibe.infraestructura.adaptador.repositorio.consulta;

import co.edu.uco.sibe.dominio.dto.DireccionDTO;
import co.edu.uco.sibe.dominio.dto.ProyectoDTO;
import co.edu.uco.sibe.dominio.puerto.consulta.ProyectoRepositorioConsulta;
import co.edu.uco.sibe.infraestructura.adaptador.dao.ProyectoDAO;
import co.edu.uco.sibe.infraestructura.adaptador.mapeador.ProyectoMapeador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProyectoRepositorioConsultaImplementacion implements ProyectoRepositorioConsulta {
    @Autowired
    private ProyectoDAO proyectoDAO;

    @Autowired
    private ProyectoMapeador proyectoMapeador;

    @Override
    public List<ProyectoDTO> consultarDTOs() {
        var entidades = this.proyectoDAO.findAll();

        return this.proyectoMapeador.construirDTOs(entidades);
    }
}
