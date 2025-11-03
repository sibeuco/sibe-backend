package co.edu.uco.sibe.dominio.usecase.consulta;

import co.edu.uco.sibe.dominio.dto.PersonaDTO;
import co.edu.uco.sibe.dominio.puerto.consulta.PersonaRepositorioConsulta;
import co.edu.uco.sibe.dominio.transversal.excepcion.ValorInvalidoExcepcion;
import static co.edu.uco.sibe.dominio.transversal.utilitarios.UtilMensaje.obtenerNoExistePersonaConCorreo;
import static co.edu.uco.sibe.dominio.transversal.utilitarios.ValidadorObjeto.esNulo;

public class ConsultarPersonaPorCorreoUseCase {
    private final PersonaRepositorioConsulta personaRepositorioConsulta;

    public ConsultarPersonaPorCorreoUseCase(PersonaRepositorioConsulta personaRepositorioConsulta) {
        this.personaRepositorioConsulta = personaRepositorioConsulta;
    }

    public PersonaDTO ejecutar(String correo){
        validarSiNoExistePersonaConCorreo(correo);

        return personaRepositorioConsulta.consultarPersonaPorCorreoDTO(correo);

    }

    private void validarSiNoExistePersonaConCorreo(String correo) {
        if (esNulo(this.personaRepositorioConsulta.consultarPersonaPorCorreo(correo))) {
            throw new ValorInvalidoExcepcion(obtenerNoExistePersonaConCorreo(correo));
        }
    }
}