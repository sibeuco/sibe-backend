package co.edu.uco.sibe.dominio.puerto.consulta;

import co.edu.uco.sibe.dominio.dto.TipoIdentificacionDTO;

import java.util.List;
import java.util.UUID;

public interface TipoIdentificacionRepositorioConsulta {

    TipoIdentificacionDTO consultarTipoIdentificacionPorIdentificador(UUID identificador);

    List<TipoIdentificacionDTO> consultarTiposIdentificacion();

}
