package co.edu.uco.sibe.dominio.usecase.consulta;

import co.edu.uco.sibe.dominio.dto.TipoUsuarioDTO;
import co.edu.uco.sibe.dominio.modelo.TipoUsuario;
import co.edu.uco.sibe.dominio.puerto.consulta.TipoUsuarioRepositorioConsulta;

import java.util.List;

public class ConsultarTiposUsuarioUseCase {

    private final TipoUsuarioRepositorioConsulta tipoUsuarioRepositorioConsulta;

    public ConsultarTiposUsuarioUseCase(TipoUsuarioRepositorioConsulta tipoUsuarioRepositorioConsulta) {
        this.tipoUsuarioRepositorioConsulta = tipoUsuarioRepositorioConsulta;
    }

    public List<TipoUsuarioDTO> ejecutar(){
        return tipoUsuarioRepositorioConsulta.consultarTiposUsuarioDTO();

    }

}
