package co.edu.uco.sibe.dominio.puerto.consulta;

import co.edu.uco.sibe.dominio.dto.AreaDTO;

import java.util.List;
import java.util.UUID;

public interface AreaRepositorioConsulta {

    List<AreaDTO> consultarAreas();

}
