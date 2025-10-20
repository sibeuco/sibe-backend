package co.edu.uco.sibe.dominio.puerto.consulta;

import co.edu.uco.sibe.dominio.modelo.Subarea;
import java.util.List;
import java.util.UUID;

public interface SubareaRepositorioConsulta {
    List<Subarea> consultarTodos();

    Subarea consultarPorIdentificador(UUID identificador);

    boolean hayDatos();
}