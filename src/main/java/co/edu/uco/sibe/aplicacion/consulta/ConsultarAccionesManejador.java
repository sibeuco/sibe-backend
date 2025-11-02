package co.edu.uco.sibe.aplicacion.consulta;

import co.edu.uco.sibe.aplicacion.transversal.manejador.ManejadorRespuesta;
import co.edu.uco.sibe.dominio.dto.AccionDTO;
import co.edu.uco.sibe.dominio.puerto.consulta.AccionRepositorioConsulta;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class ConsultarAccionesManejador implements ManejadorRespuesta<List<AccionDTO>> {
    private final AccionRepositorioConsulta accionRepositorioConsulta;

    @Override
    public List<AccionDTO> ejecutar() {
        return this.accionRepositorioConsulta.consultarDTOs();
    }
}