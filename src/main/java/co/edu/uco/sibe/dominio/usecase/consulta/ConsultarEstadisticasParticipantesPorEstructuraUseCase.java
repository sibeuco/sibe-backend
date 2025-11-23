package co.edu.uco.sibe.dominio.usecase.consulta;

import co.edu.uco.sibe.dominio.dto.EstadisticaDTO;
import co.edu.uco.sibe.dominio.dto.FiltroEstadisticaDTO;
import co.edu.uco.sibe.dominio.puerto.consulta.ActividadRepositorioConsulta;
import lombok.AllArgsConstructor;
import java.util.List;

@AllArgsConstructor
public class ConsultarEstadisticasParticipantesPorEstructuraUseCase {
    private final ActividadRepositorioConsulta actividadRepositorioConsulta;

    public List<EstadisticaDTO> ejecutar(FiltroEstadisticaDTO filtro) {
        return actividadRepositorioConsulta.consultarEstadisticasParticipantesPorEstructura(filtro);
    }
}