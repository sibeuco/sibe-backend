package co.edu.uco.sibe.dominio.usecase.consulta;

import co.edu.uco.sibe.dominio.dto.EjecucionActividadDTO;
import co.edu.uco.sibe.dominio.dto.RespuestaPaginada;
import co.edu.uco.sibe.dominio.dto.SolicitudPaginacion;
import co.edu.uco.sibe.dominio.modelo.Actividad;
import co.edu.uco.sibe.dominio.puerto.consulta.ActividadRepositorioConsulta;
import co.edu.uco.sibe.dominio.service.AutorizacionContextoOrganizacionalServicio;
import co.edu.uco.sibe.dominio.transversal.excepcion.ValorInvalidoExcepcion;
import co.edu.uco.sibe.dominio.transversal.utilitarios.UtilUUID;
import java.util.List;
import java.util.UUID;
import static co.edu.uco.sibe.dominio.transversal.constante.MensajesErrorConstante.ACTIVIDAD_NO_EXISTE_CON_IDENTIFICADOR;
import static co.edu.uco.sibe.dominio.transversal.constante.MensajesSistemaConstante.obtenerMensajeConParametro;
import static co.edu.uco.sibe.dominio.transversal.utilitarios.ValidadorObjeto.esNulo;

public class ConsultarEjecucionesPorActividadUseCase {
    private final ActividadRepositorioConsulta actividadRepositorioConsulta;
    private final AutorizacionContextoOrganizacionalServicio autorizacionServicio;

    public ConsultarEjecucionesPorActividadUseCase(ActividadRepositorioConsulta actividadRepositorioConsulta,
            AutorizacionContextoOrganizacionalServicio autorizacionServicio) {
        this.actividadRepositorioConsulta = actividadRepositorioConsulta;
        this.autorizacionServicio = autorizacionServicio;
    }

    public List<EjecucionActividadDTO> ejecutar(String identificadorActvidad) {
        var id = UtilUUID.textoAUUID(identificadorActvidad);
        autorizacionServicio.validarAccesoAActividad(id);
        var actividad = validarSiExisteActividad(id, identificadorActvidad);

        return actividadRepositorioConsulta.consultarFechasProgramadasPorActividad(actividad);
    }

    public RespuestaPaginada<EjecucionActividadDTO> ejecutar(String identificadorActividad, SolicitudPaginacion solicitud) {
        var id = UtilUUID.textoAUUID(identificadorActividad);
        autorizacionServicio.validarAccesoAActividad(id);
        var actividad = validarSiExisteActividad(id, identificadorActividad);

        return actividadRepositorioConsulta.consultarFechasProgramadasPorActividad(actividad, solicitud);
    }

    private Actividad validarSiExisteActividad(UUID id, String idComando) {
        var actividad = actividadRepositorioConsulta.consultarPorIdentificador(id);
        if (esNulo(actividad)) {
            throw new ValorInvalidoExcepcion(
                    obtenerMensajeConParametro(ACTIVIDAD_NO_EXISTE_CON_IDENTIFICADOR, idComando));
        }
        return actividad;
    }
}