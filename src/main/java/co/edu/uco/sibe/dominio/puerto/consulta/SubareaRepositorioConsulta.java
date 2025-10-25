package co.edu.uco.sibe.dominio.puerto.consulta;

import co.edu.uco.sibe.dominio.dto.SubareaDTO;
import co.edu.uco.sibe.dominio.modelo.Subarea;

import java.util.List;
import java.util.UUID;

public interface SubareaRepositorioConsulta {
    List<SubareaDTO> consultarDTOs();

    List<Subarea> consultarTodos();

    Subarea consultarPorIdentificador(UUID identificador);

    boolean hayDatos();
}