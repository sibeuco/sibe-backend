package co.edu.uco.sibe.dominio.usecase.comando;

import co.edu.uco.sibe.dominio.puerto.comando.PersonaRepositorioComando;
import co.edu.uco.sibe.dominio.puerto.consulta.PersonaRepositorioConsulta;
import co.edu.uco.sibe.dominio.transversal.excepcion.ValorInvalidoExcepcion;
import java.util.UUID;
import static co.edu.uco.sibe.dominio.transversal.constante.MensajesErrorConstante.NO_EXISTE_USUARIO_CON_IDENTIFICADOR;
import static co.edu.uco.sibe.dominio.transversal.constante.MensajesSistemaConstante.obtenerMensajeConParametro;
import static co.edu.uco.sibe.dominio.transversal.utilitarios.ValidadorObjeto.esNulo;

public class EliminarUsuarioUseCase {

    private final PersonaRepositorioComando personaRepositorioComando;
    private final  PersonaRepositorioConsulta personaRepositorioConsulta;

    public EliminarUsuarioUseCase(PersonaRepositorioComando personaRepositorioComando, PersonaRepositorioConsulta personaRepositorioConsulta) {
        this.personaRepositorioComando = personaRepositorioComando;
        this.personaRepositorioConsulta = personaRepositorioConsulta;
    }

    public UUID ejecutar(UUID identificador){
        validarSiNoExisteUsuarioConId(identificador);

        this.personaRepositorioComando.eliminarUsuario(identificador);

        return identificador;
    }

    private void validarSiNoExisteUsuarioConId(UUID identificador) {
        if (esNulo(this.personaRepositorioConsulta.consultarPersonaPorIdentificador(identificador))) {
            throw new ValorInvalidoExcepcion(obtenerMensajeConParametro(NO_EXISTE_USUARIO_CON_IDENTIFICADOR, identificador));
        }
    }
}