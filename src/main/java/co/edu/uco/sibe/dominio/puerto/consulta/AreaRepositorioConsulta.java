package co.edu.uco.sibe.dominio.puerto.consulta;

import java.util.List;
import java.util.UUID;

public interface AreaRepositorioConsulta {

    AreaDTO consultarAreaPorIdentificador(UUID identificador);

    List<AreaDTO> consultarAreas();

}
