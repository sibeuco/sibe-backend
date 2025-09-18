package co.edu.uco.sibe.aplicacion.consulta;

import co.edu.uco.sibe.aplicacion.transversal.manejador.ManejadorRespuesta;
import co.edu.uco.sibe.dominio.usecase.consulta.ConsultarPersonasUseCase;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class ConsultarPersonasManejador implements ManejadorRespuesta<List<PersonaDTO>> {
    private final ConsultarPersonasUseCase consultarPersonasUseCase;

    @Override
    public List<PersonaDTO> ejecutar() {
        return this.consultarPersonasUseCase.ejecutar();
    }
}
