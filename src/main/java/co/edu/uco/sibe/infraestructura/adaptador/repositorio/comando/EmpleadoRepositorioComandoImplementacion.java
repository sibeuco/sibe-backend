package co.edu.uco.sibe.infraestructura.adaptador.repositorio.comando;

import co.edu.uco.sibe.dominio.modelo.Empleado;
import co.edu.uco.sibe.dominio.puerto.comando.EmpleadoRepositorioComando;
import co.edu.uco.sibe.infraestructura.adaptador.dao.CentroCostosDAO;
import co.edu.uco.sibe.infraestructura.adaptador.dao.CiudadResidenciaDAO;
import co.edu.uco.sibe.infraestructura.adaptador.dao.EmpleadoDAO;
import co.edu.uco.sibe.infraestructura.adaptador.dao.RelacionLaboralDAO;
import co.edu.uco.sibe.infraestructura.adaptador.mapeador.EmpleadoMapeador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.UUID;

import static co.edu.uco.sibe.dominio.transversal.utilitarios.ValidadorObjeto.esNulo;

@Repository
public class EmpleadoRepositorioComandoImplementacion implements EmpleadoRepositorioComando {
    @Autowired
    private EmpleadoDAO empleadoDAO;

    @Autowired
    private CiudadResidenciaDAO ciudadResidenciaDAO;

    @Autowired
    private RelacionLaboralDAO relacionLaboralDAO;

    @Autowired
    private CentroCostosDAO centroCostosDAO;

    @Autowired
    private EmpleadoMapeador empleadoMapeador;

    @Override
    public UUID guardar(Empleado empleado) {
        var entidad = empleadoMapeador.construirEntidad(empleado);

        if (esNulo(this.ciudadResidenciaDAO.findById(entidad.getCiudadResidencia().getCiudadResidencia().getIdentificador()).orElse(null))) {
            this.ciudadResidenciaDAO.save(entidad.getCiudadResidencia().getCiudadResidencia());
        }

        if (esNulo(this.relacionLaboralDAO.findById(entidad.getRelacionLaboral().getRelacionLaboral().getIdentificador()).orElse(null))) {
            this.relacionLaboralDAO.save(entidad.getRelacionLaboral().getRelacionLaboral());
        }

        if (esNulo(this.centroCostosDAO.findById(entidad.getCentroCostos().getCentroCostos().getIdentificador()).orElse(null))) {
            this.centroCostosDAO.save(entidad.getCentroCostos().getCentroCostos());
        }

        return this.empleadoDAO.save(entidad).getIdentificador();
    }

    @Override
    public UUID modificar(Empleado empleado, UUID identificador) {
        var entidad = empleadoDAO.findById(identificador).orElse(null);

        assert !esNulo(entidad);
        empleadoMapeador.modificarEntidad(entidad, empleado);

        return this.empleadoDAO.save(entidad).getIdentificador();
    }
}
