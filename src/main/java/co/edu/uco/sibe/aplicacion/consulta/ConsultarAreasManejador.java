package co.edu.uco.sibe.aplicacion.consulta;

import co.edu.uco.sibe.aplicacion.transversal.manejador.ManejadorRespuesta;
import co.edu.uco.sibe.dominio.dto.AreaDTO;
import co.edu.uco.sibe.dominio.puerto.consulta.AreaRepositorioConsulta;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
@AllArgsConstructor
public class ConsultarAreasManejador implements ManejadorRespuesta<List<AreaDTO>> {
    private final AreaRepositorioConsulta areaRepositorioConsulta;

    @Override
    public List<AreaDTO> ejecutar() {
        return this.areaRepositorioConsulta.consultarDTOs();
    }
}