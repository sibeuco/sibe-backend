package co.edu.uco.sibe.dominio.usecase.consulta;

import co.edu.uco.sibe.dominio.dto.MiembroDTO;
import co.edu.uco.sibe.dominio.dto.ParticipanteDTO;
import co.edu.uco.sibe.dominio.puerto.consulta.ActividadRepositorioConsulta;
import co.edu.uco.sibe.dominio.transversal.excepcion.ValorInvalidoExcepcion;
import java.util.List;
import java.util.UUID;
import static co.edu.uco.sibe.dominio.transversal.constante.MensajesErrorConstante.EJECUCION_ACTIVIDAD_NO_ENCONTRADA_CON_ID;
import static co.edu.uco.sibe.dominio.transversal.constante.MensajesSistemaConstante.obtenerMensajeConParametro;
import static co.edu.uco.sibe.dominio.transversal.utilitarios.ValidadorObjeto.esNulo;

public class ConsultarParticipantesPorEjecucionActividadUseCase {
    private final ActividadRepositorioConsulta actividadRepositorioConsulta;

    public ConsultarParticipantesPorEjecucionActividadUseCase(ActividadRepositorioConsulta actividadRepositorioConsulta) {
        this.actividadRepositorioConsulta = actividadRepositorioConsulta;
    }

    public List<ParticipanteDTO> ejecutar(UUID identificador) {
        validarSiExisteEjecucionActividad(identificador);

        return actividadRepositorioConsulta.consultarParticipantesPorEjecucionActividad(identificador);
    }

    private void validarSiExisteEjecucionActividad(UUID identificador) {
        var ejecucionActividad = actividadRepositorioConsulta.consultarEjecucionActividadPorIdentificador(identificador);

        if (esNulo(ejecucionActividad)) {
            throw new ValorInvalidoExcepcion(obtenerMensajeConParametro(EJECUCION_ACTIVIDAD_NO_ENCONTRADA_CON_ID, identificador));
        }
    }
}
