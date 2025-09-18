package co.edu.uco.sibe.aplicacion.consulta;

import co.edu.uco.sibe.aplicacion.transversal.manejador.ManejadorParametroRespuesta;
import co.edu.uco.sibe.dominio.usecase.consulta.ConsultarPersonaPorIdentificadorUseCase;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@AllArgsConstructor
public class ConsultarPersonaPorIdentificadorManejador implements ManejadorParametroRespuesta<UUID, PersonaDTO> {
    private final ConsultarPersonaPorIdentificadorUseCase consultarPersonaPorIdentificadorUseCase;
    @Override
    public PersonaDTO ejecutar(UUID parametro) {
        return this.consultarPersonaPorIdentificadorUseCase.ejecutar(parametro);
    }
}
