package co.edu.uco.sibe.dominio.usecase.consulta;

import co.edu.uco.sibe.dominio.dto.EstadisticaDTO;
import co.edu.uco.sibe.dominio.dto.FiltroEstadisticaDTO;
import co.edu.uco.sibe.dominio.puerto.consulta.ActividadRepositorioConsulta;
import co.edu.uco.sibe.dominio.service.AutorizacionContextoOrganizacionalServicio;
import lombok.AllArgsConstructor;
import java.util.List;

@AllArgsConstructor
public class ConsultarEstadisticasParticipantesPorEstructuraUseCase {
    private final ActividadRepositorioConsulta actividadRepositorioConsulta;
    private final AutorizacionContextoOrganizacionalServicio autorizacionServicio;

    public List<EstadisticaDTO> ejecutar(FiltroEstadisticaDTO filtro) {
        if (filtro.getIdArea() != null)
            autorizacionServicio.validarAccesoAArea(filtro.getIdArea());
        return actividadRepositorioConsulta.consultarEstadisticasParticipantesPorEstructura(filtro);
    }
}