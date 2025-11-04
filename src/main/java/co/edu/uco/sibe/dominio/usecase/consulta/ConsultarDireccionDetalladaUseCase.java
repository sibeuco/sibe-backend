package co.edu.uco.sibe.dominio.usecase.consulta;

import co.edu.uco.sibe.dominio.dto.DireccionDetalladaDTO;
import co.edu.uco.sibe.dominio.puerto.consulta.DireccionRepositorioConsulta;
import co.edu.uco.sibe.dominio.transversal.excepcion.ValorInvalidoExcepcion;
import java.util.UUID;
import static co.edu.uco.sibe.dominio.transversal.constante.MensajesErrorConstante.DIRECCION_NO_ENCONTRADA_CON_ID;
import static co.edu.uco.sibe.dominio.transversal.constante.MensajesSistemaConstante.obtenerMensajeConParametro;
import static co.edu.uco.sibe.dominio.transversal.utilitarios.ValidadorObjeto.esNulo;

public class ConsultarDireccionDetalladaUseCase {

    private final DireccionRepositorioConsulta direccionRepositorioConsulta;

    public ConsultarDireccionDetalladaUseCase(DireccionRepositorioConsulta direccionRepositorioConsulta) {
        this.direccionRepositorioConsulta = direccionRepositorioConsulta;
    }

    public DireccionDetalladaDTO ejecutar(UUID identificador) {
        return validarSiExisteDireccion(identificador);
    }

    private DireccionDetalladaDTO validarSiExisteDireccion(UUID id) {
        var direccion = direccionRepositorioConsulta.consultarDetallePorIdentificador(id);
        if (esNulo(direccion)) {
            throw new ValorInvalidoExcepcion(obtenerMensajeConParametro(DIRECCION_NO_ENCONTRADA_CON_ID, id));
        }
        return direccion;
    }
}