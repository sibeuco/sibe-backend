package co.edu.uco.sibe.aplicacion.consulta;

import co.edu.uco.sibe.aplicacion.transversal.manejador.ManejadorParametroRespuesta;
import co.edu.uco.sibe.dominio.usecase.consulta.ConsultarTipoIdentificacionPorIdentificadorUseCase;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@AllArgsConstructor
public class ConsultarTipoIdentificacionPorIdentificadorManejador implements ManejadorParametroRespuesta<UUID, TipoIdentificacionDTO> {
    private final ConsultarTipoIdentificacionPorIdentificadorUseCase consultarTipoIdentificacionPorIdentificadorUseCase;

    @Override
    public TipoIdentificacionDTO ejecutar(UUID parametro) {
        return this.consultarTipoIdentificacionPorIdentificadorUseCase.ejecutar(parametro);
    }
}
