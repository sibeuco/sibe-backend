package co.edu.uco.sibe.dominio.usecase.consulta;

import co.edu.uco.sibe.dominio.dto.PersonaDTO;
import co.edu.uco.sibe.dominio.dto.UsuarioDTO;
import co.edu.uco.sibe.dominio.puerto.consulta.PersonaRepositorioConsulta;
import co.edu.uco.sibe.dominio.transversal.excepcion.ValorInvalidoExcepcion;
import co.edu.uco.sibe.dominio.transversal.utilitarios.Mensajes;
import co.edu.uco.sibe.dominio.transversal.utilitarios.UtilObjeto;

import java.util.UUID;

public class ConsultarPersonaPorDocumentoUseCase {

    private final PersonaRepositorioConsulta personaRepositorioConsulta;

    public ConsultarPersonaPorDocumentoUseCase(PersonaRepositorioConsulta personaRepositorioConsulta) {
        this.personaRepositorioConsulta = personaRepositorioConsulta;
    }

    public PersonaDTO ejecutar(String documento){
        validarSiNoExistePersonaConDocumento(documento);

        return personaRepositorioConsulta.consultarPersonaPorDocumento(documento);

    }

    private void validarSiNoExistePersonaConDocumento(String documento) {
        if (UtilObjeto.getInstance().esNulo(this.personaRepositorioConsulta.consultarPersonaPorDocumento(documento))) {
            throw new ValorInvalidoExcepcion(Mensajes.obtenerNoExistePersonaConDocumento(documento));
        }
    }
}
