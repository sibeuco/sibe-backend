package co.edu.uco.sibe.aplicacion.comando.manejador;

import co.edu.uco.sibe.aplicacion.comando.UsuarioModificacionComando;
import co.edu.uco.sibe.aplicacion.comando.fabrica.PersonaFabrica;
import co.edu.uco.sibe.aplicacion.comando.fabrica.UsuarioFabrica;
import co.edu.uco.sibe.aplicacion.transversal.ComandoRespuesta;
import co.edu.uco.sibe.aplicacion.transversal.manejador.ManejadorComandoParametroRespuesta;
import co.edu.uco.sibe.dominio.enums.TipoArea;
import co.edu.uco.sibe.dominio.usecase.comando.ModificarUsuarioUseCase;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@AllArgsConstructor
public class ModificarUsuarioManejador implements ManejadorComandoParametroRespuesta<UsuarioModificacionComando, UUID, ComandoRespuesta<UUID>> {
    private final UsuarioFabrica usuarioFabrica;
    private final PersonaFabrica personaFabrica;
    private final ModificarUsuarioUseCase modificarUsuarioUseCase;

    @Override
    public ComandoRespuesta<UUID> ejecutar(UsuarioModificacionComando comando, UUID parametro) {
        return new ComandoRespuesta<>(
                this.modificarUsuarioUseCase.ejecutar(
                        this.usuarioFabrica.construirActualizar(comando, parametro),
                        this.personaFabrica.construirActualizar(comando, parametro),
                        UUID.fromString(comando.getArea().getArea()),
                        TipoArea.valueOf(comando.getArea().getTipoArea()),
                        parametro
                )
        );
    }
}
