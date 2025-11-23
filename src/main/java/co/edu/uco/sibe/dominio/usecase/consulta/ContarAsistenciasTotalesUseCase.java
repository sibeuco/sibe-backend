package co.edu.uco.sibe.dominio.usecase.consulta;

import co.edu.uco.sibe.dominio.dto.FiltroEstadisticaDTO;
import co.edu.uco.sibe.dominio.puerto.consulta.ActividadRepositorioConsulta;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ContarAsistenciasTotalesUseCase {
    private final ActividadRepositorioConsulta actividadRepositorioConsulta;

    public Long ejecutar(FiltroEstadisticaDTO filtro) {
        return actividadRepositorioConsulta.contarAsistenciasTotales(filtro);
    }
}