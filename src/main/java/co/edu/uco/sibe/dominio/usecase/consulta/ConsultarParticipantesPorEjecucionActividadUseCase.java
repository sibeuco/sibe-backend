package co.edu.uco.sibe.dominio.usecase.consulta;

import co.edu.uco.sibe.dominio.dto.MiembroDTO;
import co.edu.uco.sibe.dominio.dto.ParticipanteDTO;
import co.edu.uco.sibe.dominio.dto.RespuestaPaginada;
import co.edu.uco.sibe.dominio.dto.SolicitudPaginacion;
import co.edu.uco.sibe.dominio.puerto.consulta.ActividadRepositorioConsulta;
import co.edu.uco.sibe.dominio.service.AutorizacionContextoOrganizacionalServicio;
import co.edu.uco.sibe.dominio.transversal.excepcion.ValorInvalidoExcepcion;
import java.util.List;
import java.util.UUID;
import static co.edu.uco.sibe.dominio.transversal.constante.MensajesErrorConstante.EJECUCION_ACTIVIDAD_NO_ENCONTRADA_CON_ID;
import static co.edu.uco.sibe.dominio.transversal.constante.MensajesSistemaConstante.obtenerMensajeConParametro;
import static co.edu.uco.sibe.dominio.transversal.utilitarios.ValidadorObjeto.esNulo;

public class ConsultarParticipantesPorEjecucionActividadUseCase {
    private final ActividadRepositorioConsulta actividadRepositorioConsulta;
    private final AutorizacionContextoOrganizacionalServicio autorizacionServicio;

    public ConsultarParticipantesPorEjecucionActividadUseCase(ActividadRepositorioConsulta actividadRepositorioConsulta,
            AutorizacionContextoOrganizacionalServicio autorizacionServicio) {
        this.actividadRepositorioConsulta = actividadRepositorioConsulta;
        this.autorizacionServicio = autorizacionServicio;
    }

    public List<ParticipanteDTO> ejecutar(UUID identificador) {
        autorizacionServicio.validarAccesoAEjecucionActividad(identificador);
        validarSiExisteEjecucionActividad(identificador);

        return actividadRepositorioConsulta.consultarParticipantesPorEjecucionActividad(identificador);
    }

    public RespuestaPaginada<ParticipanteDTO> ejecutar(UUID identificador, SolicitudPaginacion solicitud) {
        autorizacionServicio.validarAccesoAEjecucionActividad(identificador);
        validarSiExisteEjecucionActividad(identificador);

        return actividadRepositorioConsulta.consultarParticipantesPorEjecucionActividad(identificador, solicitud);
    }

    private void validarSiExisteEjecucionActividad(UUID identificador) {
        var ejecucionActividad = actividadRepositorioConsulta
                .consultarEjecucionActividadPorIdentificador(identificador);

        if (esNulo(ejecucionActividad)) {
            throw new ValorInvalidoExcepcion(
                    obtenerMensajeConParametro(EJECUCION_ACTIVIDAD_NO_ENCONTRADA_CON_ID, identificador));
        }
    }
}