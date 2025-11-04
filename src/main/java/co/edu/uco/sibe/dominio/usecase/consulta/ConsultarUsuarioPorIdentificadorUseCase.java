package co.edu.uco.sibe.dominio.usecase.consulta;

import co.edu.uco.sibe.dominio.dto.UsuarioDTO;
import co.edu.uco.sibe.dominio.puerto.consulta.PersonaRepositorioConsulta;
import co.edu.uco.sibe.dominio.transversal.excepcion.ValorInvalidoExcepcion;
import java.util.UUID;
import static co.edu.uco.sibe.dominio.transversal.constante.MensajeConstante.NO_EXISTE_USUARIO_CON_IDENTIFICADOR;
import static co.edu.uco.sibe.dominio.transversal.constante.MensajeConstante.obtenerMensajeConParametro;
import static co.edu.uco.sibe.dominio.transversal.utilitarios.ValidadorObjeto.esNulo;

public class ConsultarUsuarioPorIdentificadorUseCase {
    private final PersonaRepositorioConsulta personaRepositorioConsulta;

    public ConsultarUsuarioPorIdentificadorUseCase(PersonaRepositorioConsulta personaRepositorioConsulta) {
        this.personaRepositorioConsulta = personaRepositorioConsulta;
    }

    public UsuarioDTO ejecutar(UUID identificador){
        validarSiNoExisteUsuarioConId(identificador);

        return personaRepositorioConsulta.consultarUsuarioPorIdentificadorDTO(identificador);

    }

    private void validarSiNoExisteUsuarioConId(UUID identificador) {
        if (esNulo(this.personaRepositorioConsulta.consultarUsuarioPorIdentificador(identificador))) {
            throw new ValorInvalidoExcepcion(obtenerMensajeConParametro(NO_EXISTE_USUARIO_CON_IDENTIFICADOR, identificador));
        }
    }
}