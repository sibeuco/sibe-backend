package co.edu.uco.sibe.infraestructura.adaptador.repositorio.consulta;

import co.edu.uco.sibe.dominio.modelo.RelacionLaboral;
import co.edu.uco.sibe.dominio.puerto.consulta.RelacionLaboralRepositorioConsulta;
import co.edu.uco.sibe.dominio.transversal.utilitarios.ValidadorObjeto;
import co.edu.uco.sibe.infraestructura.adaptador.dao.RelacionLaboralDAO;
import co.edu.uco.sibe.infraestructura.adaptador.mapeador.RelacionLaboralMapeador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.UUID;

@Repository
public class RelacionLaboralRepositorioConsultaImplementacion implements RelacionLaboralRepositorioConsulta {
    @Autowired
    private RelacionLaboralDAO relacionLaboralDAO;

    @Autowired
    private RelacionLaboralMapeador relacionLaboralMapeador;

    @Override
    public RelacionLaboral consultarPorIdentificador(UUID identificador) {
        var entidad = this.relacionLaboralDAO.findById(identificador).orElse(null);

        if(ValidadorObjeto.esNulo(entidad)) {
            return null;
        }

        return this.relacionLaboralMapeador.construirModelo(entidad);
    }

    @Override
    public RelacionLaboral consultarPorCodigo(String codigo) {
        var entidad = this.relacionLaboralDAO.findByCodigo(codigo);

        if(ValidadorObjeto.esNulo(entidad)) {
            return null;
        }

        return this.relacionLaboralMapeador.construirModelo(entidad);
    }
}
