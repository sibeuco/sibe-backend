package co.edu.uco.sibe.dominio.usecase.consulta;

import co.edu.uco.sibe.dominio.dto.EstadisticaMesDTO;
import co.edu.uco.sibe.dominio.dto.FiltroEstadisticaDTO;
import co.edu.uco.sibe.dominio.puerto.consulta.ActividadRepositorioConsulta;
import lombok.AllArgsConstructor;
import java.util.List;

@AllArgsConstructor
public class ConsultarEstadisticasParticipantesPorMesUseCase {
    private final ActividadRepositorioConsulta actividadRepositorioConsulta;

    public List<EstadisticaMesDTO> ejecutar(FiltroEstadisticaDTO filtro) {
        return actividadRepositorioConsulta.consultarEstadisticasParticipantesPorMes(filtro);
    }
}