package co.edu.uco.sibe.dominio.usecase.consulta;

import co.edu.uco.sibe.dominio.dto.PersonaDTO;
import co.edu.uco.sibe.dominio.puerto.consulta.PersonaRepositorioConsulta;
import co.edu.uco.sibe.dominio.transversal.excepcion.ValorInvalidoExcepcion;
import co.edu.uco.sibe.dominio.transversal.utilitarios.Mensajes;
import co.edu.uco.sibe.dominio.transversal.utilitarios.ValidadorObjeto;

import java.util.UUID;

public class ConsultarPersonaPorIdentificadorUseCase {

    private final PersonaRepositorioConsulta personaRepositorioConsulta;

    public ConsultarPersonaPorIdentificadorUseCase(PersonaRepositorioConsulta personaRepositorioConsulta) {
        this.personaRepositorioConsulta = personaRepositorioConsulta;
    }

    public PersonaDTO ejecutar(UUID identificador){
        validarSiNoExistePersonaConId(identificador);

        return this.personaRepositorioConsulta.consultarPersonaPorIdentificador(identificador);

    }

    private void validarSiNoExistePersonaConId(UUID identificador) {
        if (ValidadorObjeto.getInstance().esNulo(this.personaRepositorioConsulta.consultarPersonaPorIdentificador(identificador))) {
            throw new ValorInvalidoExcepcion(Mensajes.obtenerNoExistePersonaConId(identificador));
        }
    }

}
