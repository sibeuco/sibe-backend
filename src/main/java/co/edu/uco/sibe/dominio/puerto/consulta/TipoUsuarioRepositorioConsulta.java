package co.edu.uco.sibe.dominio.puerto.consulta;

import co.edu.uco.sibe.dominio.dto.TipoUsuarioDTO;
import co.edu.uco.sibe.dominio.modelo.TipoUsuario;
import java.util.List;
import java.util.UUID;

public interface TipoUsuarioRepositorioConsulta {
    List<TipoUsuarioDTO> consultarTiposUsuarioDTO();

    TipoUsuario consultarTiposUsuario(UUID identificador);
}