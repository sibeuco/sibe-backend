package co.edu.uco.sibe.aplicacion.comando.fabrica;

import co.edu.uco.sibe.aplicacion.comando.DatosEstudianteComando;
import co.edu.uco.sibe.dominio.modelo.Estudiante;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Component
@AllArgsConstructor
public class EstudianteFabrica {
    private final CiudadResidenciaFabrica ciudadResidenciaFabrica;

    public Estudiante construir(DatosEstudianteComando estudianteComando) {
        return Estudiante.construir(
                UUID.randomUUID(),
                estudianteComando.getNombreCompleto(),
                estudianteComando.getNumeroIdentificacion(),
                ciudadResidenciaFabrica.construir(estudianteComando.getMunicipioResidencia()),
                estudianteComando.getIdLecturaCarnetUniversitario(),
                estudianteComando.getSexo(),
                LocalDate.parse(estudianteComando.getFechaNacimiento()),
                estudianteComando.getNacionalidad(),
                estudianteComando.getEstadoCivil(),
                estudianteComando.getCorreoPersonal(),
                estudianteComando.getCorreoInstitucional(),
                estudianteComando.getProgramaAcademico(),
                estudianteComando.getFacultad(),
                Integer.parseInt(estudianteComando.getAnnoIngreso()),
                estudianteComando.getSemestreActual(),
                Integer.parseInt(estudianteComando.getCreditosAprobados()),
                Float.parseFloat(estudianteComando.getPromedioGeneral()),
                estudianteComando.getEstadoAcademico(),
                estudianteComando.getModalidad(),
                Integer.parseInt(estudianteComando.getTiempoLlegadaUniversidad()),
                estudianteComando.getMedioDeTransporte()
                );
    }

    public List<Estudiante> construirTodos(List<DatosEstudianteComando> estudiantesComando) {
        return estudiantesComando.stream().map(this::construir).toList();
    }
}
