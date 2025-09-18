package co.edu.uco.sibe.dominio.usecase.consulta;

import co.edu.uco.sibe.dominio.puerto.consulta.PersonaRepositorioConsulta;
import co.edu.uco.sibe.dominio.transversal.excepcion.ValorInvalidoExcepcion;
import co.edu.uco.sibe.dominio.transversal.utilitarios.Mensajes;
import co.edu.uco.sibe.dominio.transversal.utilitarios.ValidadorObjeto;

public class ConsultarPersonaPorCorreoUseCase {
    private final PersonaRepositorioConsulta personaRepositorioConsulta;

    public ConsultarPersonaPorCorreoUseCase(PersonaRepositorioConsulta personaRepositorioConsulta) {
        this.personaRepositorioConsulta = personaRepositorioConsulta;
    }

    public PersonaDTO ejecutar(String correo){
        validarSiNoExistePersonaConCorreo(correo);

        return personaRepositorioConsulta.consultarPersonaPorCorreo(correo);

    }

    private void validarSiNoExistePersonaConCorreo(String correo) {
        if (ValidadorObjeto.getInstance().esNulo(this.personaRepositorioConsulta.consultarPersonaPorCorreo(correo))) {
            throw new ValorInvalidoExcepcion(Mensajes.obtenerNoExistePersonaConCorreo(correo));
        }
    }
}
