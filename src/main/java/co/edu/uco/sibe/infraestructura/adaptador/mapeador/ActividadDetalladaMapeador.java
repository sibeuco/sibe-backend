package co.edu.uco.sibe.infraestructura.adaptador.mapeador;

import co.edu.uco.sibe.dominio.dto.ActividadDetalladaDTO;
import co.edu.uco.sibe.infraestructura.adaptador.dao.EjecucionActividadDAO;
import co.edu.uco.sibe.infraestructura.adaptador.entidad.ActividadEntidad;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
@AllArgsConstructor
public class ActividadDetalladaMapeador {

    private final IndicadorMapeador indicadorMapeador;
    private final EjecucionActividadDAO ejecucionActividadDAO;
    private final EjecucionActividadDetalladaMapeador ejecucionActividadDetalladaMapeador;

    public ActividadDetalladaDTO construirDTO(ActividadEntidad entidad) {
        var ejecucionesEntidad = ejecucionActividadDAO.findByActividadIdentificador(entidad.getIdentificador());
        var ejecucionesDTO = ejecucionActividadDetalladaMapeador.construirDTOs(ejecucionesEntidad);

        return new ActividadDetalladaDTO(
                entidad.getIdentificador().toString(),
                entidad.getNombre(),
                entidad.getObjetivo(),
                entidad.getSemestre(),
                indicadorMapeador.construirDTO(entidad.getIndicador()),
                entidad.getColaborador().toString(),
                ejecucionesDTO
        );
    }

    public List<ActividadDetalladaDTO> construirDTOs(List<ActividadEntidad> entidades) {
        return entidades.stream().map(this::construirDTO).toList();
    }
}