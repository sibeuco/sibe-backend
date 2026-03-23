package co.edu.uco.sibe.aplicacion.consulta;

import co.edu.uco.sibe.aplicacion.transversal.manejador.ManejadorComandoRespuesta;
import co.edu.uco.sibe.dominio.dto.MiembroDTO;
import co.edu.uco.sibe.dominio.dto.ParticipanteDTO;
import co.edu.uco.sibe.dominio.dto.RespuestaPaginada;
import co.edu.uco.sibe.dominio.dto.SolicitudPaginacion;
import co.edu.uco.sibe.dominio.usecase.consulta.ConsultarParticipantesPorEjecucionActividadUseCase;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.UUID;

@Component
@AllArgsConstructor
public class ConsultarParticipantesPorEjecucionActividadManejador implements ManejadorComandoRespuesta<UUID, List<ParticipanteDTO>> {
    private final ConsultarParticipantesPorEjecucionActividadUseCase consultarParticipantesPorEjecucionActividadUseCase;

    @Override
    public List<ParticipanteDTO> ejecutar(UUID comando) {
        return consultarParticipantesPorEjecucionActividadUseCase.ejecutar(comando);
    }

    public RespuestaPaginada<ParticipanteDTO> ejecutar(UUID comando, SolicitudPaginacion solicitud) {
        return consultarParticipantesPorEjecucionActividadUseCase.ejecutar(comando, solicitud);
    }
}
