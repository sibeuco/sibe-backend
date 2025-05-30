package co.edu.uco.sibe.aplicacion.consulta;

import co.edu.uco.sibe.aplicacion.transversal.manejador.ManejadorParametroRespuesta;
import co.edu.uco.sibe.dominio.dto.AreaDTO;
import co.edu.uco.sibe.dominio.usecase.consulta.ConsultarAreaPorIdentificadorUseCase;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@AllArgsConstructor
public class ConsultarAreaPorIdentificadorManejador implements ManejadorParametroRespuesta<UUID, AreaDTO> {
    private final ConsultarAreaPorIdentificadorUseCase consultarAreaPorIdentificadorUseCase;
    @Override
    public AreaDTO ejecutar(UUID parametro) {
        return this.consultarAreaPorIdentificadorUseCase.ejecutar(parametro);
    }
}
