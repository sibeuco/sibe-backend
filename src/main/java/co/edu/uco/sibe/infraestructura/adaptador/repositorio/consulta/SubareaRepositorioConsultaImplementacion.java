package co.edu.uco.sibe.infraestructura.adaptador.repositorio.consulta;

import co.edu.uco.sibe.dominio.dto.SubareaDTO;
import co.edu.uco.sibe.dominio.dto.SubareaDetalladaDTO;
import co.edu.uco.sibe.dominio.modelo.Actividad;
import co.edu.uco.sibe.dominio.modelo.Subarea;
import co.edu.uco.sibe.dominio.puerto.consulta.SubareaRepositorioConsulta;
import co.edu.uco.sibe.dominio.transversal.utilitarios.ValidadorNumero;
import co.edu.uco.sibe.dominio.transversal.utilitarios.ValidadorObjeto;
import co.edu.uco.sibe.infraestructura.adaptador.dao.SubareaDAO;
import co.edu.uco.sibe.infraestructura.adaptador.mapeador.SubareaDetalladaMapeador;
import co.edu.uco.sibe.infraestructura.adaptador.mapeador.SubareaMapeador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

import static co.edu.uco.sibe.dominio.transversal.constante.NumeroConstante.CERO;
import static co.edu.uco.sibe.dominio.transversal.utilitarios.ValidadorObjeto.esNulo;

@Repository
public class SubareaRepositorioConsultaImplementacion implements SubareaRepositorioConsulta {
    @Autowired
    private SubareaDAO subareaDAO;

    @Autowired
    private SubareaMapeador subareaMapeador;

    @Autowired
    private SubareaDetalladaMapeador subareaDetalladaMapeador;

    @Override
    public List<SubareaDTO> consultarDTOs() {
        var entidades = this.subareaDAO.findAll();
        return this.subareaMapeador.construirDTOs(entidades);
    }

    @Override
    public List<Subarea> consultarTodos() {
        var entidades = this.subareaDAO.findAll();
        return this.subareaMapeador.construirModelos(entidades);
    }

    @Override
    public Subarea consultarPorIdentificador(UUID identificador) {
        var entidad = this.subareaDAO.findById(identificador).orElse(null);

        if(esNulo(entidad)) {
            return null;
        }

        return this.subareaMapeador.construirModelo(entidad);
    }

    @Override
    public boolean hayDatos() {
        var cantidad = subareaDAO.count();
        return ValidadorNumero.esNumeroMayor(cantidad, CERO);
    }

    @Override
    public Subarea consultarPorNombre(String nombre) {
        var entidad = this.subareaDAO.findByNombre(nombre);

        if(esNulo(entidad)) {
            return null;
        }

        return this.subareaMapeador.construirModelo(entidad);
    }

    @Override
    public Subarea consultarPorActividad(Actividad actividad) {
        var entidad = this.subareaDAO.findByActividades_Identificador(actividad.getIdentificador());
        if(esNulo(entidad)) {
            return null;
        }
        return this.subareaMapeador.construirModelo(entidad);
    }

    @Override
    public SubareaDetalladaDTO consultarDetallePorIdentificador(UUID identificador) {
        var entidad = this.subareaDAO.findById(identificador).orElse(null);
        if(esNulo(entidad)) {
            return null;
        }
        return this.subareaDetalladaMapeador.construirDTO(entidad);
    }
}