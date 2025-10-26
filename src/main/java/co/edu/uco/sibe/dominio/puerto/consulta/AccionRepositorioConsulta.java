package co.edu.uco.sibe.dominio.puerto.consulta;

import co.edu.uco.sibe.dominio.dto.AccionDTO;
import co.edu.uco.sibe.dominio.modelo.Accion;

import java.util.List;
import java.util.UUID;

public interface AccionRepositorioConsulta {
    List<AccionDTO> consultarDTOs();

    Accion consultarPorIdentificador(UUID identificador);

    List<Accion> consultarTodos();

}
