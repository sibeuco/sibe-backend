package co.edu.uco.sibe.aplicacion.comando.manejador;

import co.edu.uco.sibe.aplicacion.comando.UsuarioComando;
import co.edu.uco.sibe.aplicacion.comando.fabrica.PersonaFabrica;
import co.edu.uco.sibe.aplicacion.comando.fabrica.UsuarioFabrica;
import co.edu.uco.sibe.aplicacion.transversal.ComandoRespuesta;
import co.edu.uco.sibe.aplicacion.transversal.manejador.ManejadorComandoRespuesta;
import co.edu.uco.sibe.dominio.enums.TipoArea;
import co.edu.uco.sibe.dominio.usecase.comando.AgregarNuevoUsuarioUseCase;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@AllArgsConstructor
public class AgregarNuevoUsuarioManejador implements ManejadorComandoRespuesta<UsuarioComando, ComandoRespuesta<UUID>> {
    private final UsuarioFabrica usuarioFabrica;
    private final PersonaFabrica personaFabrica;
    private final AgregarNuevoUsuarioUseCase agregarNuevoUsuarioUseCase;

    @Override
    public ComandoRespuesta<UUID> ejecutar(UsuarioComando comando) {
        return new ComandoRespuesta<>(this.agregarNuevoUsuarioUseCase.ejecutar(
                this.usuarioFabrica.construir(comando),
                this.personaFabrica.construir(comando),
                UUID.fromString(comando.getArea().getArea()),
                TipoArea.valueOf(comando.getArea().getTipoArea())
        ));
    }

}
