package co.edu.uco.sibe.aplicacion.consulta;

import co.edu.uco.sibe.aplicacion.transversal.manejador.ManejadorRespuesta;
import co.edu.uco.sibe.dominio.dto.TipoUsuarioDTO;
import co.edu.uco.sibe.dominio.usecase.consulta.ConsultarTiposUsuarioUseCase;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class ConsultarTiposUsuarioManejador implements ManejadorRespuesta<List<TipoUsuarioDTO>> {
    private final ConsultarTiposUsuarioUseCase consultarTiposUsuarioUseCase;

    @Override
    public List<TipoUsuarioDTO> ejecutar() {
        return this.consultarTiposUsuarioUseCase.ejecutar();
    }
}
