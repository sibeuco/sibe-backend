package co.edu.uco.sibe.infraestructura.adaptador.repositorio.consulta;

import co.edu.uco.sibe.dominio.modelo.Empleado;
import co.edu.uco.sibe.dominio.puerto.consulta.EmpleadoRepositorioConsulta;
import co.edu.uco.sibe.dominio.transversal.utilitarios.ValidadorObjeto;
import co.edu.uco.sibe.infraestructura.adaptador.dao.EmpleadoDAO;
import co.edu.uco.sibe.infraestructura.adaptador.mapeador.EmpleadoMapeador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.UUID;

@Repository
public class EmpleadoRepositorioConsultaImplementacion implements EmpleadoRepositorioConsulta {
    @Autowired
    private EmpleadoDAO empleadoDAO;

    @Autowired
    private EmpleadoMapeador empleadoMapeador;

    @Override
    public Empleado consultarPorIdentificador(UUID identificador) {
        var entidad = this.empleadoDAO.findById(identificador).orElse(null);

        if(ValidadorObjeto.esNulo(entidad)) {
            return null;
        }

        return this.empleadoMapeador.construirModelo(entidad);
    }

    @Override
    public Empleado consultarPorIdentificacion(String identificacion) {
        var entidad = this.empleadoDAO.findByNumeroIdentificacion(identificacion);

        if(ValidadorObjeto.esNulo(entidad)) {
            return null;
        }

        return this.empleadoMapeador.construirModelo(entidad);
    }
}
