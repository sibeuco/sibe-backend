package co.edu.uco.sibe.dominio.usecase.consulta;

import co.edu.uco.sibe.dominio.dto.ActividadDTO;
import co.edu.uco.sibe.dominio.modelo.Area;
import co.edu.uco.sibe.dominio.puerto.consulta.ActividadRepositorioConsulta;
import co.edu.uco.sibe.dominio.puerto.consulta.AreaRepositorioConsulta;
import co.edu.uco.sibe.dominio.transversal.excepcion.ValorInvalidoExcepcion;
import co.edu.uco.sibe.dominio.transversal.utilitarios.UtilUUID;
import java.util.List;
import java.util.UUID;
import static co.edu.uco.sibe.dominio.transversal.constante.MensajeConstante.AREA_NO_ENCONTRADA_CON_ID;
import static co.edu.uco.sibe.dominio.transversal.constante.MensajeConstante.obtenerMensajeConParametro;
import static co.edu.uco.sibe.dominio.transversal.utilitarios.ValidadorObjeto.esNulo;

public class ConsultarActividadesPorAreaUseCase {
    private final ActividadRepositorioConsulta actividadRepositorioConsulta;
    private final AreaRepositorioConsulta areaRepositorioConsulta;

    public ConsultarActividadesPorAreaUseCase(ActividadRepositorioConsulta actividadRepositorioConsulta, AreaRepositorioConsulta areaRepositorioConsulta) {
        this.actividadRepositorioConsulta = actividadRepositorioConsulta;
        this.areaRepositorioConsulta = areaRepositorioConsulta;
    }

    public List<ActividadDTO> ejecutar(String identificadorDireccion) {
        var id = UtilUUID.textoAUUID(identificadorDireccion);
        var area = validarSiExisteArea(id, identificadorDireccion);

        return actividadRepositorioConsulta.consultarPorArea(area);
    }

    private Area validarSiExisteArea(UUID id, String idComando) {
        var area = areaRepositorioConsulta.consultarPorIdentificador(id);

        if (esNulo(area)) {
            throw new ValorInvalidoExcepcion(obtenerMensajeConParametro(AREA_NO_ENCONTRADA_CON_ID, idComando));
        }

        return area;
    }
}