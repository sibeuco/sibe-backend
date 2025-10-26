package co.edu.uco.sibe.infraestructura.adaptador.repositorio.consulta;

import co.edu.uco.sibe.dominio.dto.AccionDTO;
import co.edu.uco.sibe.dominio.modelo.Accion;
import co.edu.uco.sibe.dominio.puerto.consulta.AccionRepositorioConsulta;
import co.edu.uco.sibe.dominio.transversal.utilitarios.ValidadorObjeto;
import co.edu.uco.sibe.infraestructura.adaptador.dao.AccionDAO;
import co.edu.uco.sibe.infraestructura.adaptador.mapeador.AccionMapeador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public class AccionRepositorioConsultaImplementacion implements AccionRepositorioConsulta {
    @Autowired
    private AccionDAO accionDAO;

    @Autowired
    private AccionMapeador accionMapeador;

    @Override
    public List<AccionDTO> consultarDTOs() {
        var entidades = this.accionDAO.findAll();

        return this.accionMapeador.construirDTOs(entidades);
    }

    @Override
    public Accion consultarPorIdentificador(UUID identificador) {
        var entidad = this.accionDAO.findById(identificador).orElse(null);

        if(ValidadorObjeto.esNulo(entidad)){
            return null;
        }

        return this.accionMapeador.construriModelo(entidad);
    }

    @Override
    public List<Accion> consultarTodos() {
        var entidades = this.accionDAO.findAll();

        return this.accionMapeador.construirModelos(entidades);
    }
}
