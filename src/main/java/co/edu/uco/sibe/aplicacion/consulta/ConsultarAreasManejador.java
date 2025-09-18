package co.edu.uco.sibe.aplicacion.consulta;

import co.edu.uco.sibe.aplicacion.transversal.manejador.ManejadorRespuesta;
import co.edu.uco.sibe.dominio.usecase.consulta.ConsultarAreasUseCase;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class ConsultarAreasManejador implements ManejadorRespuesta<List<AreaDTO>> {
    private final ConsultarAreasUseCase consultarAreasUseCase;

    @Override
    public List<AreaDTO> ejecutar() {
        return this.consultarAreasUseCase.ejecutar();
    }
}
