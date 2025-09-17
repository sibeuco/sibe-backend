package co.edu.uco.sibe.dominio.usecase.consulta;

import co.edu.uco.sibe.dominio.dto.UsuarioDTO;
import co.edu.uco.sibe.dominio.puerto.consulta.PersonaRepositorioConsulta;
import co.edu.uco.sibe.dominio.transversal.excepcion.ValorInvalidoExcepcion;
import co.edu.uco.sibe.dominio.transversal.utilitarios.Mensajes;
import co.edu.uco.sibe.dominio.transversal.utilitarios.ValidadorObjeto;

import java.util.UUID;

public class ConsultarUsuarioPorIdentificadorUseCase {

    private final PersonaRepositorioConsulta personaRepositorioConsulta;

    public ConsultarUsuarioPorIdentificadorUseCase(PersonaRepositorioConsulta personaRepositorioConsulta) {
        this.personaRepositorioConsulta = personaRepositorioConsulta;
    }

    public UsuarioDTO ejecutar(UUID identificador){
        validarSiNoExisteUsuarioConId(identificador);

        return personaRepositorioConsulta.consultarUsuarioPorIdentificador(identificador);

    }

    private void validarSiNoExisteUsuarioConId(UUID identificador) {
        if (ValidadorObjeto.getInstance().esNulo(this.personaRepositorioConsulta.consultarUsuarioPorIdentificador(identificador))) {
            throw new ValorInvalidoExcepcion(Mensajes.obtenerNoExisteUsuarioConId(identificador));
        }
    }

}
