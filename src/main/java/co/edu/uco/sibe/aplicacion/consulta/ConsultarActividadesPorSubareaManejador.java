package co.edu.uco.sibe.aplicacion.consulta;

import co.edu.uco.sibe.aplicacion.transversal.manejador.ManejadorComandoRespuesta;
import co.edu.uco.sibe.dominio.dto.ActividadDTO;
import co.edu.uco.sibe.dominio.dto.RespuestaPaginada;
import co.edu.uco.sibe.dominio.dto.SolicitudPaginacion;
import co.edu.uco.sibe.dominio.usecase.consulta.ConsultarActividadesPorSubareaUseCase;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
@AllArgsConstructor
public class ConsultarActividadesPorSubareaManejador implements ManejadorComandoRespuesta<String, List<ActividadDTO>> {
    private final ConsultarActividadesPorSubareaUseCase consultarActividadesPorSubareaUseCase;

    @Override
    public List<ActividadDTO> ejecutar(String comando) {
        return consultarActividadesPorSubareaUseCase.ejecutar(comando);
    }

    public RespuestaPaginada<ActividadDTO> ejecutar(String comando, SolicitudPaginacion solicitud) {
        return consultarActividadesPorSubareaUseCase.ejecutar(comando, solicitud);
    }
}