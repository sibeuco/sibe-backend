package co.edu.uco.sibe.aplicacion.consulta;

import co.edu.uco.sibe.aplicacion.transversal.manejador.ManejadorRespuesta;
import co.edu.uco.sibe.dominio.dto.ProyectoDTO;
import co.edu.uco.sibe.dominio.dto.RespuestaPaginada;
import co.edu.uco.sibe.dominio.dto.SolicitudPaginacion;
import co.edu.uco.sibe.dominio.puerto.consulta.ProyectoRepositorioConsulta;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
@AllArgsConstructor
public class ConsultarProyectosManejador implements ManejadorRespuesta<List<ProyectoDTO>> {
    private final ProyectoRepositorioConsulta proyectoRepositorioConsulta;

    @Override
    public List<ProyectoDTO> ejecutar() {
        return this.proyectoRepositorioConsulta.consultarDTOs();
    }

    public RespuestaPaginada<ProyectoDTO> ejecutar(SolicitudPaginacion solicitud) {
        return this.proyectoRepositorioConsulta.consultarDTOsPaginado(solicitud);
    }
}