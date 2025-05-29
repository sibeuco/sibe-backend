package co.edu.uco.sibe.dominio.usecase.consulta;

import co.edu.uco.sibe.dominio.dto.PersonaDTO;
import co.edu.uco.sibe.dominio.puerto.consulta.PersonaRepositorioConsulta;
import co.edu.uco.sibe.dominio.transversal.excepcion.ValorInvalidoExcepcion;
import co.edu.uco.sibe.dominio.transversal.utilitarios.Mensajes;

import java.util.List;

public class ConsultarPersonasUseCase {

    private final PersonaRepositorioConsulta personaRepositorioConsulta;


    public ConsultarPersonasUseCase(PersonaRepositorioConsulta personaRepositorioConsulta) {
        this.personaRepositorioConsulta = personaRepositorioConsulta;
    }

    public List<PersonaDTO> ejecutar(){

        List<PersonaDTO> personas = personaRepositorioConsulta.consultarPersonas();

        if (personas.isEmpty()) {
            throw new ValorInvalidoExcepcion(Mensajes.NO_SE_ENCONTRARON_PERSONAS);
        }

        return personas;

    }

}
