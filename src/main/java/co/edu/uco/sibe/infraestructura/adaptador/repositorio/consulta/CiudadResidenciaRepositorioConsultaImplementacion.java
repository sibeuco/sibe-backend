package co.edu.uco.sibe.infraestructura.adaptador.repositorio.consulta;

import co.edu.uco.sibe.dominio.modelo.CiudadResidencia;
import co.edu.uco.sibe.dominio.puerto.consulta.CiudadResidenciaRepositorioConsulta;
import co.edu.uco.sibe.dominio.transversal.utilitarios.ValidadorObjeto;
import co.edu.uco.sibe.infraestructura.adaptador.dao.CiudadResidenciaDAO;
import co.edu.uco.sibe.infraestructura.adaptador.mapeador.CiudadResidenciaMapeador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public class CiudadResidenciaRepositorioConsultaImplementacion implements CiudadResidenciaRepositorioConsulta {
    @Autowired
    private CiudadResidenciaDAO ciudadResidenciaDAO;

    @Autowired
    private CiudadResidenciaMapeador ciudadResidenciaMapeador;

    @Override
    public CiudadResidencia consultarPorIdentificador(UUID identificador) {
        var entidad = this.ciudadResidenciaDAO.findById(identificador).orElse(null);

        if(ValidadorObjeto.esNulo(entidad)) {
            return null;
        }

        return this.ciudadResidenciaMapeador.construirModelo(entidad);
    }

    @Override
    public CiudadResidencia consultarPorDescripcion(String descripcion) {
        var entidad = this.ciudadResidenciaDAO.findByDescripcion(descripcion);

        if(ValidadorObjeto.esNulo(entidad)) {
            return null;
        }

        return this.ciudadResidenciaMapeador.construirModelo(entidad);
    }
}
