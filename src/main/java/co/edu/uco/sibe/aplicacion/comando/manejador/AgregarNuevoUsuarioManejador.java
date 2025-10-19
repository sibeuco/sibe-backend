package co.edu.uco.sibe.aplicacion.comando.manejador;

import co.edu.uco.sibe.aplicacion.comando.UsuarioComando;
import co.edu.uco.sibe.aplicacion.comando.fabrica.PersonaFabrica;
import co.edu.uco.sibe.aplicacion.comando.fabrica.UsuarioFabrica;
import co.edu.uco.sibe.aplicacion.transversal.ComandoRespuesta;
import co.edu.uco.sibe.aplicacion.transversal.manejador.ManejadorComandoRespuesta;
import co.edu.uco.sibe.dominio.enums.TipoArea;
import co.edu.uco.sibe.dominio.regla.TipoOperacion;
import co.edu.uco.sibe.dominio.regla.fabrica.MotoresFabrica;
import co.edu.uco.sibe.dominio.transversal.utilitarios.UtilUUID;
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
        var usuario = this.usuarioFabrica.construir(comando);

        MotoresFabrica.MOTOR_USUARIO.ejecutar(usuario, TipoOperacion.CREAR);

        var persona = this.personaFabrica.construir(comando);

        MotoresFabrica.MOTOR_IDENTIFICACION.ejecutar(persona.getIdentificacion(), TipoOperacion.CREAR);

        MotoresFabrica.MOTOR_PERSONA.ejecutar(persona, TipoOperacion.CREAR);

        var area = UtilUUID.textoAUUID(comando.getArea().getArea());
        var tipoArea = TipoArea.valueOf(comando.getArea().getTipoArea());

        return new ComandoRespuesta<>(this.agregarNuevoUsuarioUseCase.ejecutar(
                usuario,
                persona,
                area,
                tipoArea
        ));
    }
}