package co.edu.uco.sibe.dominio.usecase.consulta;

import co.edu.uco.sibe.dominio.puerto.consulta.TipoAreaRepositorioConsulta;

import java.util.List;

public class ConsultarTiposAreaUseCase {

    private final TipoAreaRepositorioConsulta tipoAreaRepositorioConsulta;

    public ConsultarTiposAreaUseCase(TipoAreaRepositorioConsulta tipoAreaRepositorioConsulta) {
        this.tipoAreaRepositorioConsulta = tipoAreaRepositorioConsulta;
    }

    public List<TipoAreaDTO> ejecutar(){
        return tipoAreaRepositorioConsulta.consultarTiposArea();

    }

}
