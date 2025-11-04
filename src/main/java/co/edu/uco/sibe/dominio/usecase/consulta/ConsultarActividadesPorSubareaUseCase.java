package co.edu.uco.sibe.dominio.usecase.consulta;

import co.edu.uco.sibe.dominio.dto.ActividadDTO;
import co.edu.uco.sibe.dominio.modelo.Subarea;
import co.edu.uco.sibe.dominio.puerto.consulta.ActividadRepositorioConsulta;
import co.edu.uco.sibe.dominio.puerto.consulta.SubareaRepositorioConsulta;
import co.edu.uco.sibe.dominio.transversal.excepcion.ValorInvalidoExcepcion;
import co.edu.uco.sibe.dominio.transversal.utilitarios.UtilUUID;
import java.util.List;
import java.util.UUID;
import static co.edu.uco.sibe.dominio.transversal.constante.MensajesErrorConstante.SUBAREA_NO_ENCONTRADA_CON_ID;
import static co.edu.uco.sibe.dominio.transversal.constante.MensajesSistemaConstante.obtenerMensajeConParametro;
import static co.edu.uco.sibe.dominio.transversal.utilitarios.ValidadorObjeto.esNulo;

public class ConsultarActividadesPorSubareaUseCase {
    private final ActividadRepositorioConsulta actividadRepositorioConsulta;
    private final SubareaRepositorioConsulta subareaRepositorioConsulta;

    public ConsultarActividadesPorSubareaUseCase(ActividadRepositorioConsulta actividadRepositorioConsulta, SubareaRepositorioConsulta subareaRepositorioConsulta) {
        this.actividadRepositorioConsulta = actividadRepositorioConsulta;
        this.subareaRepositorioConsulta = subareaRepositorioConsulta;
    }

    public List<ActividadDTO> ejecutar(String identificadorSubarea) {
        var id = UtilUUID.textoAUUID(identificadorSubarea);
        var subarea = validarSiExisteSubarea(id, identificadorSubarea);
        return actividadRepositorioConsulta.consultarPorSubarea(subarea);
    }

    private Subarea validarSiExisteSubarea(UUID id, String idComando) {
        var subarea = subareaRepositorioConsulta.consultarPorIdentificador(id);
        if (esNulo(subarea)) {
            throw new ValorInvalidoExcepcion(obtenerMensajeConParametro(SUBAREA_NO_ENCONTRADA_CON_ID, idComando));
        }
        return subarea;
    }
}