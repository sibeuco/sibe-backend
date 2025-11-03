package co.edu.uco.sibe.aplicacion.consulta;

import co.edu.uco.sibe.aplicacion.transversal.manejador.ManejadorRespuesta;
import co.edu.uco.sibe.dominio.dto.DireccionDTO;
import co.edu.uco.sibe.dominio.puerto.consulta.DireccionRepositorioConsulta;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
@AllArgsConstructor
public class ConsultarDireccionesManejador implements ManejadorRespuesta<List<DireccionDTO>> {
    private final DireccionRepositorioConsulta direccionRepositorioConsulta;

    @Override
    public List<DireccionDTO> ejecutar() {
        return this.direccionRepositorioConsulta.consultarDTOs();
    }
}