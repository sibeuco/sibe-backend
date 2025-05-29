package co.edu.uco.sibe.dominio.usecase.consulta;

import co.edu.uco.sibe.dominio.dto.TipoIdentificacionDTO;
import co.edu.uco.sibe.dominio.puerto.consulta.TipoIdentificacionRepositorioConsulta;

import java.util.List;

public class ConsultarTiposIdentificacionUseCase {

    private final TipoIdentificacionRepositorioConsulta tipoIdentificacionRepositorioConsulta;

    public ConsultarTiposIdentificacionUseCase(TipoIdentificacionRepositorioConsulta tipoIdentificacionRepositorioConsulta) {
        this.tipoIdentificacionRepositorioConsulta = tipoIdentificacionRepositorioConsulta;
    }

    public List<TipoIdentificacionDTO> ejecutar(){
        return tipoIdentificacionRepositorioConsulta.consultarTiposIdentificacion();

    }

}
