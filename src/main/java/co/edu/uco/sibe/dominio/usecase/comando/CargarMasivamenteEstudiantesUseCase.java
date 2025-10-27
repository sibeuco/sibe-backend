package co.edu.uco.sibe.dominio.usecase.comando;

import co.edu.uco.sibe.dominio.modelo.Estudiante;
import co.edu.uco.sibe.dominio.puerto.comando.EstudianteRepositorioComando;
import co.edu.uco.sibe.dominio.puerto.consulta.EstudianteRepositorioConsulta;
import co.edu.uco.sibe.dominio.transversal.utilitarios.ValidadorObjeto;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class CargarMasivamenteEstudiantesUseCase {
    private final EstudianteRepositorioComando estudianteRepositorioComando;
    private final EstudianteRepositorioConsulta estudianteRepositorioConsulta;

    public CargarMasivamenteEstudiantesUseCase(EstudianteRepositorioComando estudianteRepositorioComando, EstudianteRepositorioConsulta estudianteRepositorioConsulta) {
        this.estudianteRepositorioComando = estudianteRepositorioComando;
        this.estudianteRepositorioConsulta = estudianteRepositorioConsulta;
    }

    public List<UUID> ejecutar(List<Estudiante> estudiantes) {
        var identificadores = new ArrayList<UUID>();

        estudiantes.forEach(estudiante -> {
            var estudianteActual = this.estudianteRepositorioConsulta.consultarPorIdentificacion(estudiante.getNumeroIdentificacion());

            if (ValidadorObjeto.esNulo(estudianteActual)) {
                identificadores.add(this.estudianteRepositorioComando.guardar(estudiante));
            } else {
                identificadores.add(this.estudianteRepositorioComando.modificar(estudiante, estudianteActual.getIdentificador()));
            }

        });

        return identificadores;
    }
}