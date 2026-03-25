package co.edu.uco.sibe.aplicacion.consulta;

import co.edu.uco.sibe.aplicacion.transversal.manejador.ManejadorRespuesta;
import co.edu.uco.sibe.dominio.dto.IndicadorDTO;
import co.edu.uco.sibe.dominio.puerto.consulta.IndicadorRepositorioConsulta;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
@AllArgsConstructor
public class ConsultarIndicadoresManejador  implements ManejadorRespuesta<List<IndicadorDTO>> {
    private final IndicadorRepositorioConsulta indicadorRepositorioConsulta;

    @Override
    public List<IndicadorDTO> ejecutar() {
        return this.indicadorRepositorioConsulta.consultarDTOs();
    }
}