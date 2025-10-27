package co.edu.uco.sibe.infraestructura.adaptador.repositorio.consulta;

import co.edu.uco.sibe.dominio.modelo.CentroCostos;
import co.edu.uco.sibe.dominio.puerto.consulta.CentroCostosRepositorioConsulta;
import co.edu.uco.sibe.dominio.transversal.utilitarios.ValidadorObjeto;
import co.edu.uco.sibe.infraestructura.adaptador.dao.CentroCostosDAO;
import co.edu.uco.sibe.infraestructura.adaptador.mapeador.CentroCostosMapeador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.UUID;

@Repository
public class CentroCostosRepositorioConsultaImplementacion implements CentroCostosRepositorioConsulta {
    @Autowired
    private CentroCostosDAO centroCostosDAO;

    @Autowired
    private CentroCostosMapeador centroCostosMapeador;

    @Override
    public CentroCostos consultarPorIdentificador(UUID identificador) {
        var entidad = this.centroCostosDAO.findById(identificador).orElse(null);

        if(ValidadorObjeto.esNulo(entidad)) {
            return null;
        }

        return this.centroCostosMapeador.construirModelo(entidad);
    }

    @Override
    public CentroCostos consultarPorCodigo(String codigo) {
        var entidad = this.centroCostosDAO.findByCodigo(codigo);

        if(ValidadorObjeto.esNulo(entidad)) {
            return null;
        }

        return this.centroCostosMapeador.construirModelo(entidad);
    }
}
