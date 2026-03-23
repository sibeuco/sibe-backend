package co.edu.uco.sibe.aplicacion.consulta;

import co.edu.uco.sibe.aplicacion.transversal.manejador.ManejadorComandoRespuesta;
import co.edu.uco.sibe.dominio.dto.ActividadDTO;
import co.edu.uco.sibe.dominio.dto.RespuestaPaginada;
import co.edu.uco.sibe.dominio.dto.SolicitudPaginacion;
import co.edu.uco.sibe.dominio.usecase.consulta.ConsultarActividadesPorAreaUseCase;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
@AllArgsConstructor
public class ConsultarActividadesPorAreaManejador implements ManejadorComandoRespuesta<String, List<ActividadDTO>> {
    private final ConsultarActividadesPorAreaUseCase consultarActividadesPorAreaUseCase;

    @Override
    public List<ActividadDTO> ejecutar(String comando) {
        return consultarActividadesPorAreaUseCase.ejecutar(comando);
    }

    public RespuestaPaginada<ActividadDTO> ejecutar(String comando, SolicitudPaginacion solicitud) {
        return consultarActividadesPorAreaUseCase.ejecutar(comando, solicitud);
    }
}