package co.edu.uco.sibe.aplicacion.comando.manejador;

import co.edu.uco.sibe.aplicacion.comando.PersonaComando;
import co.edu.uco.sibe.aplicacion.comando.fabrica.PersonaFabrica;
import co.edu.uco.sibe.aplicacion.transversal.ComandoRespuesta;
import co.edu.uco.sibe.aplicacion.transversal.manejador.ManejadorComandoParametroRespuesta;
import co.edu.uco.sibe.dominio.usecase.comando.ModificarPersonaUseCase;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@AllArgsConstructor
public class ModificarPersonaManejador implements ManejadorComandoParametroRespuesta<PersonaComando, UUID, ComandoRespuesta<UUID>> {
    private final PersonaFabrica personaFabrica;
    private final ModificarPersonaUseCase modificarPersonaUseCase;

    @Override
    public ComandoRespuesta<UUID> ejecutar(PersonaComando comando, UUID parametro) {
        return new ComandoRespuesta<>(this.modificarPersonaUseCase.ejecutar(this.personaFabrica.construirActualizar(comando, parametro), parametro));
    }
}
