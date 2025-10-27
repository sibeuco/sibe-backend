package co.edu.uco.sibe.infraestructura.adaptador.repositorio.comando;

import co.edu.uco.sibe.dominio.modelo.Empleado;
import co.edu.uco.sibe.dominio.puerto.comando.EmpleadoRepositorioComando;
import co.edu.uco.sibe.infraestructura.adaptador.dao.EmpleadoDAO;
import co.edu.uco.sibe.infraestructura.adaptador.mapeador.EmpleadoMapeador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.UUID;

@Repository
public class EmpleadoRepositorioComandoImplementacion implements EmpleadoRepositorioComando {
    @Autowired
    private EmpleadoDAO empleadoDAO;

    @Autowired
    private EmpleadoMapeador empleadoMapeador;

    @Override
    public UUID guardar(Empleado empleado) {
        var entidad = empleadoMapeador.construirEntidad(empleado);

        return this.empleadoDAO.save(entidad).getIdentificador();
    }

    @Override
    public UUID modificar(Empleado empleado, UUID identificador) {
        var entidad = empleadoDAO.findById(identificador).orElse(null);

        empleadoMapeador.modificarEntidad(entidad, empleado);

        return this.empleadoDAO.save(entidad).getIdentificador();
    }
}
