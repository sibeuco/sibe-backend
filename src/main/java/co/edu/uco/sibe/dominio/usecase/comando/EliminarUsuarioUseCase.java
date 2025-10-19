package co.edu.uco.sibe.dominio.usecase.comando;

import co.edu.uco.sibe.dominio.puerto.comando.PersonaRepositorioComando;
import co.edu.uco.sibe.dominio.puerto.consulta.PersonaRepositorioConsulta;
import co.edu.uco.sibe.dominio.transversal.excepcion.ValorInvalidoExcepcion;
import co.edu.uco.sibe.dominio.transversal.utilitarios.Mensajes;
import co.edu.uco.sibe.dominio.transversal.utilitarios.ValidadorObjeto;
import java.util.UUID;

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
        if (ValidadorObjeto.esNulo(this.personaRepositorioConsulta.consultarPersonaPorIdentificador(identificador))) {
            throw new ValorInvalidoExcepcion(Mensajes.obtenerNoExisteUsuarioConId(identificador));
        }
    }
}