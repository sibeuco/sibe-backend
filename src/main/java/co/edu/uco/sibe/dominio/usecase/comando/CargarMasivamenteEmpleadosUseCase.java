package co.edu.uco.sibe.dominio.usecase.comando;

import co.edu.uco.sibe.dominio.modelo.Empleado;
import co.edu.uco.sibe.dominio.puerto.comando.EmpleadoRepositorioComando;
import co.edu.uco.sibe.dominio.puerto.consulta.EmpleadoRepositorioConsulta;
import co.edu.uco.sibe.dominio.transversal.utilitarios.ValidadorObjeto;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class CargarMasivamenteEmpleadosUseCase {
    private final EmpleadoRepositorioComando empleadoRepositorioComando;
    private final EmpleadoRepositorioConsulta empleadoRepositorioConsulta;

    public CargarMasivamenteEmpleadosUseCase(EmpleadoRepositorioComando empleadoRepositorioComando, EmpleadoRepositorioConsulta empleadoRepositorioConsulta) {
        this.empleadoRepositorioComando = empleadoRepositorioComando;
        this.empleadoRepositorioConsulta = empleadoRepositorioConsulta;
    }

    public List<UUID> ejecutar(List<Empleado> empleados) {
        var identificadores = new ArrayList<UUID>();

        empleados.forEach(empleado -> {
            var empleadoActual = this.empleadoRepositorioConsulta.consultarPorIdentificacion(empleado.getNumeroIdentificacion());

            if (ValidadorObjeto.esNulo(empleadoActual)) {
                identificadores.add(this.empleadoRepositorioComando.guardar(empleado));
            } else {
                identificadores.add(this.empleadoRepositorioComando.modificar(empleado, empleadoActual.getIdentificador()));
            }
        });

        return identificadores;
    }
}