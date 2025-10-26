package co.edu.uco.sibe.dominio.puerto.consulta;

import co.edu.uco.sibe.dominio.dto.AreaDTO;
import co.edu.uco.sibe.dominio.modelo.Area;
import java.util.List;
import java.util.UUID;

public interface AreaRepositorioConsulta {
    List<AreaDTO> consultarDTOs();

    List<Area> consultarTodos();

    Area consultarPorIdentificador(UUID identificador);

    boolean hayDatos();
}