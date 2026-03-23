package co.edu.uco.sibe.aplicacion.consulta;

import co.edu.uco.sibe.aplicacion.transversal.manejador.ManejadorRespuesta;
import co.edu.uco.sibe.dominio.dto.RespuestaPaginada;
import co.edu.uco.sibe.dominio.dto.SolicitudPaginacion;
import co.edu.uco.sibe.dominio.dto.UsuarioDTO;
import co.edu.uco.sibe.dominio.usecase.consulta.ConsultarUsuariosUseCase;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
@AllArgsConstructor
public class ConsultarUsuariosManejador implements ManejadorRespuesta<List<UsuarioDTO>> {
    private final ConsultarUsuariosUseCase consultarUsuariosUseCase;

    @Override
    public List<UsuarioDTO> ejecutar() {
        return this.consultarUsuariosUseCase.ejecutar();
    }

    public RespuestaPaginada<UsuarioDTO> ejecutar(SolicitudPaginacion solicitud, String tipoUsuario, String excluirTipoUsuario) {
        return this.consultarUsuariosUseCase.ejecutar(solicitud, tipoUsuario, excluirTipoUsuario);
    }
}