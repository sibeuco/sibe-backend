package co.edu.uco.sibe.dominio.puerto.consulta;

import co.edu.uco.sibe.dominio.dto.TipoAreaDTO;

import java.util.List;
import java.util.UUID;

public interface TipoAreaRepositorioConsulta {

    TipoAreaDTO consultarTipoAreaPorIdentificador(UUID identificador);

    List<TipoAreaDTO> consultarTiposArea();

}
