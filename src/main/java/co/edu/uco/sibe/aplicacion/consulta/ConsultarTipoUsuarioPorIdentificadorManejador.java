package co.edu.uco.sibe.aplicacion.consulta;

import co.edu.uco.sibe.aplicacion.transversal.manejador.ManejadorParametroRespuesta;
import co.edu.uco.sibe.dominio.dto.TipoUsuarioDTO;
import co.edu.uco.sibe.dominio.usecase.consulta.ConsultarTipoUsuarioPorIdentificadorUseCase;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@AllArgsConstructor
public class ConsultarTipoUsuarioPorIdentificadorManejador implements ManejadorParametroRespuesta<UUID, TipoUsuarioDTO> {
    private final ConsultarTipoUsuarioPorIdentificadorUseCase consultarTipoUsuarioPorIdentificadorUseCase;
    @Override
    public TipoUsuarioDTO ejecutar(UUID parametro) {
        return this.consultarTipoUsuarioPorIdentificadorUseCase.ejecutar(parametro);
    }
}
