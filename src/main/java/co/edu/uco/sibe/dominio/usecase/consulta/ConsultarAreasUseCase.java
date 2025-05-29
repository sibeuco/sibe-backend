package co.edu.uco.sibe.dominio.usecase.consulta;

import co.edu.uco.sibe.dominio.dto.AreaDTO;
import co.edu.uco.sibe.dominio.puerto.consulta.AreaRepositorioConsulta;
import co.edu.uco.sibe.dominio.transversal.excepcion.ValorInvalidoExcepcion;
import co.edu.uco.sibe.dominio.transversal.utilitarios.Mensajes;

import java.util.List;

public class ConsultarAreasUseCase {

    private final AreaRepositorioConsulta areaRepositorioConsulta;

    public ConsultarAreasUseCase(AreaRepositorioConsulta areaRepositorioConsulta) {
        this.areaRepositorioConsulta = areaRepositorioConsulta;
    }

    public List<AreaDTO> ejecutar(){

        List<AreaDTO> areas = areaRepositorioConsulta.consultarAreas();

        if (areas.isEmpty()) {
            throw new ValorInvalidoExcepcion(Mensajes.NO_SE_ENCONTRARON_AREAS);
        }

        return areas;

    }
}
