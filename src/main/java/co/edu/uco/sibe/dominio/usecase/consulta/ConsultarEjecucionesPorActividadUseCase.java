package co.edu.uco.sibe.dominio.usecase.consulta;

import co.edu.uco.sibe.dominio.dto.EjecucionActividadDTO;
import co.edu.uco.sibe.dominio.modelo.Actividad;
import co.edu.uco.sibe.dominio.puerto.consulta.ActividadRepositorioConsulta;
import co.edu.uco.sibe.dominio.transversal.excepcion.ValorInvalidoExcepcion;
import co.edu.uco.sibe.dominio.transversal.utilitarios.UtilUUID;

import java.util.List;
import java.util.UUID;

import static co.edu.uco.sibe.dominio.transversal.utilitarios.UtilMensaje.ACTIVIDAD_NO_EXISTE_CON_IDENTIFICADOR;
import static co.edu.uco.sibe.dominio.transversal.utilitarios.ValidadorObjeto.esNulo;

public class ConsultarEjecucionesPorActividadUseCase {
    private final ActividadRepositorioConsulta actividadRepositorioConsulta;

    public ConsultarEjecucionesPorActividadUseCase(ActividadRepositorioConsulta actividadRepositorioConsulta) {
        this.actividadRepositorioConsulta = actividadRepositorioConsulta;
    }

    public List<EjecucionActividadDTO> ejecutar(String identificadorActvidad) {
        var id = UtilUUID.textoAUUID(identificadorActvidad);
        var actividad = validarSiExisteActividad(id, identificadorActvidad);

        return actividadRepositorioConsulta.consultarFechasProgramadasPorActividad(actividad);
    }

    private Actividad validarSiExisteActividad(UUID id, String idComando) {
        var actividad = actividadRepositorioConsulta.consultarPorIdentificador(id);
        if (esNulo(actividad)) {
            throw new ValorInvalidoExcepcion(ACTIVIDAD_NO_EXISTE_CON_IDENTIFICADOR + idComando);
        }
        return actividad;
    }
}