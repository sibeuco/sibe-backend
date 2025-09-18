package co.edu.uco.sibe.dominio.puerto.consulta;

import java.util.List;
import java.util.UUID;

public interface TipoUsuarioRepositorioConsulta {

    TipoUsuarioDTO consultarTipoUsuarioPorIdentificador(UUID identificador);

    List<TipoUsuarioDTO> consultarTiposUsuario();

}
