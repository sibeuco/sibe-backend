package co.edu.uco.sibe.dominio.usecase.consulta;

import co.edu.uco.sibe.dominio.dto.AreaDetalladaDTO;
import co.edu.uco.sibe.dominio.puerto.consulta.AreaRepositorioConsulta;
import co.edu.uco.sibe.dominio.transversal.excepcion.ValorInvalidoExcepcion;
import java.util.UUID;
import static co.edu.uco.sibe.dominio.transversal.constante.MensajeConstante.AREA_NO_ENCONTRADA_CON_ID;
import static co.edu.uco.sibe.dominio.transversal.constante.MensajeConstante.obtenerMensajeConParametro;
import static co.edu.uco.sibe.dominio.transversal.utilitarios.ValidadorObjeto.esNulo;

public class ConsultarAreaDetalladaUseCase {

    private final AreaRepositorioConsulta areaRepositorioConsulta;

    public ConsultarAreaDetalladaUseCase(AreaRepositorioConsulta areaRepositorioConsulta) {
        this.areaRepositorioConsulta = areaRepositorioConsulta;
    }

    public AreaDetalladaDTO ejecutar(UUID identificador) {
        return validarSiExisteArea(identificador);
    }

    private AreaDetalladaDTO validarSiExisteArea(UUID id) {
        var area = areaRepositorioConsulta.consultarDetallePorIdentificador(id);
        if (esNulo(area)) {
            throw new ValorInvalidoExcepcion(obtenerMensajeConParametro(AREA_NO_ENCONTRADA_CON_ID, id));
        }
        return area;
    }
}