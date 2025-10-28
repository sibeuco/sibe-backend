package co.edu.uco.sibe.dominio.usecase.comando;

import co.edu.uco.sibe.dominio.modelo.Estudiante;
import co.edu.uco.sibe.dominio.puerto.comando.EstudianteRepositorioComando;
import co.edu.uco.sibe.dominio.puerto.consulta.EstudianteRepositorioConsulta;
import co.edu.uco.sibe.dominio.regla.TipoOperacion;
import co.edu.uco.sibe.dominio.regla.fabrica.MotoresFabrica;
import co.edu.uco.sibe.dominio.transversal.utilitarios.ValidadorObjeto;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static co.edu.uco.sibe.dominio.transversal.utilitarios.ValidadorObjeto.esNulo;

public class CargarMasivamenteEstudiantesUseCase {
    private final EstudianteRepositorioComando estudianteRepositorioComando;
    private final EstudianteRepositorioConsulta estudianteRepositorioConsulta;

    public CargarMasivamenteEstudiantesUseCase(EstudianteRepositorioComando estudianteRepositorioComando, EstudianteRepositorioConsulta estudianteRepositorioConsulta) {
        this.estudianteRepositorioComando = estudianteRepositorioComando;
        this.estudianteRepositorioConsulta = estudianteRepositorioConsulta;
    }

    public UUID ejecutar(Estudiante estudiante) {
        MotoresFabrica.MOTOR_CIUDAD_RESIDENCIA.ejecutar(estudiante.getCiudadResidencia(), TipoOperacion.CREAR);
        MotoresFabrica.MOTOR_ESTUDIANTE.ejecutar(estudiante, TipoOperacion.CREAR);

        var estudianteActual = this.estudianteRepositorioConsulta.consultarPorIdentificacion(estudiante.getNumeroIdentificacion());

        if (!esNulo(estudianteActual)) {
            return this.estudianteRepositorioComando.modificar(estudiante, estudianteActual.getIdentificador());
        }

        return this.estudianteRepositorioComando.guardar(estudiante);
    }
}