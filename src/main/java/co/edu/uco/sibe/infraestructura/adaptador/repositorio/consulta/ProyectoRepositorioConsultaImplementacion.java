package co.edu.uco.sibe.infraestructura.adaptador.repositorio.consulta;

import co.edu.uco.sibe.dominio.dto.ProyectoDTO;
import co.edu.uco.sibe.dominio.modelo.Proyecto;
import co.edu.uco.sibe.dominio.puerto.consulta.ProyectoRepositorioConsulta;
import co.edu.uco.sibe.dominio.transversal.utilitarios.ValidadorObjeto;
import co.edu.uco.sibe.infraestructura.adaptador.dao.ProyectoDAO;
import co.edu.uco.sibe.infraestructura.adaptador.mapeador.ProyectoMapeador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.UUID;

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

    @Override
    public Proyecto consultarPorIdentificador(UUID identificador) {
        var entidad = this.proyectoDAO.findById(identificador).orElse(null);

        if(ValidadorObjeto.esNulo(entidad)){
            return null;
        }

        return this.proyectoMapeador.construriModelo(entidad);
    }

    @Override
    public Proyecto consultarPorNumeroProyecto(String numeroProyecto) {
        var entidad = this.proyectoDAO.findByNumeroProyecto(numeroProyecto);

        if(ValidadorObjeto.esNulo(entidad)){
            return null;
        }

        return this.proyectoMapeador.construriModelo(entidad);
    }
}