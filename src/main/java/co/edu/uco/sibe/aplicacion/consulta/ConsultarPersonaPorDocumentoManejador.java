package co.edu.uco.sibe.aplicacion.consulta;

import co.edu.uco.sibe.aplicacion.transversal.manejador.ManejadorParametroRespuesta;
import co.edu.uco.sibe.dominio.dto.PersonaDTO;
import co.edu.uco.sibe.dominio.usecase.consulta.ConsultarPersonaPorDocumentoUseCase;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ConsultarPersonaPorDocumentoManejador implements ManejadorParametroRespuesta<String, PersonaDTO> {
    private final ConsultarPersonaPorDocumentoUseCase consultarPersonaPorDocumentoUseCase;
    @Override
    public PersonaDTO ejecutar(String parametro) {
        return this.consultarPersonaPorDocumentoUseCase.ejecutar(parametro);
    }
}
