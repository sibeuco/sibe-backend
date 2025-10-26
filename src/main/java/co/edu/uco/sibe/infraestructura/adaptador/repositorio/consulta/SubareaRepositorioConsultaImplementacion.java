package co.edu.uco.sibe.infraestructura.adaptador.repositorio.consulta;

import co.edu.uco.sibe.dominio.dto.SubareaDTO;
import co.edu.uco.sibe.dominio.modelo.Subarea;
import co.edu.uco.sibe.dominio.puerto.consulta.SubareaRepositorioConsulta;
import co.edu.uco.sibe.dominio.transversal.utilitarios.ValidadorNumero;
import co.edu.uco.sibe.dominio.transversal.utilitarios.ValidadorObjeto;
import co.edu.uco.sibe.infraestructura.adaptador.dao.SubareaDAO;
import co.edu.uco.sibe.infraestructura.adaptador.mapeador.SubareaMapeador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

import static co.edu.uco.sibe.dominio.transversal.constante.NumeroConstante.CERO;

@Repository
public class SubareaRepositorioConsultaImplementacion implements SubareaRepositorioConsulta {
    @Autowired
    private SubareaDAO subareaDAO;

    @Autowired
    private SubareaMapeador subareaMapeador;

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

        if(ValidadorObjeto.esNulo(entidad)) {
            return null;
        }

        return this.subareaMapeador.construirModelo(entidad);
    }

    @Override
    public boolean hayDatos() {
        var cantidad = subareaDAO.count();

        return ValidadorNumero.esNumeroMayor(cantidad, CERO);
    }
}