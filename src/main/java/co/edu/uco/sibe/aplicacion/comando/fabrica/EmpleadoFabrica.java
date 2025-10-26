package co.edu.uco.sibe.aplicacion.comando.fabrica;

import co.edu.uco.sibe.aplicacion.comando.DatosEmpleadoComando;
import co.edu.uco.sibe.dominio.modelo.Empleado;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.UUID;

@Component
@AllArgsConstructor
public class EmpleadoFabrica {
    private final CiudadResidenciaFabrica ciudadResidenciaFabrica;
    private final RelacionLaboralFabrica relacionLaboralFabrica;
    private final CentroCostosFabrica centroCostosFabrica;

    public Empleado construir(DatosEmpleadoComando empleadoComando) {
        return Empleado.construir(
                UUID.randomUUID(),
                empleadoComando.getNombre(),
                empleadoComando.getIdentificacion(),
                ciudadResidenciaFabrica.construir(empleadoComando.getCiudadDeResidencia()),
                empleadoComando.getIdCarnet(),
                empleadoComando.getGenero(),
                relacionLaboralFabrica.construir(empleadoComando.getCodigoClasificacion(), empleadoComando.getGrupoRelacionLaboral()),
                centroCostosFabrica.construir(empleadoComando.getCodigoCentroCostos(), empleadoComando.getCentroCostos())
        );
    }

    public List<Empleado> construirTodos(List<DatosEmpleadoComando> empleadoComando) {
        return empleadoComando.stream().map(this::construir).toList();
    }
}
