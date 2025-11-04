package co.edu.uco.sibe.dominio.usecase.consulta;

import co.edu.uco.sibe.dominio.dto.ActividadDTO;
import co.edu.uco.sibe.dominio.modelo.Direccion;
import co.edu.uco.sibe.dominio.puerto.consulta.ActividadRepositorioConsulta;
import co.edu.uco.sibe.dominio.puerto.consulta.DireccionRepositorioConsulta;
import co.edu.uco.sibe.dominio.transversal.excepcion.ValorInvalidoExcepcion;
import co.edu.uco.sibe.dominio.transversal.utilitarios.UtilUUID;
import java.util.List;
import java.util.UUID;
import static co.edu.uco.sibe.dominio.transversal.constante.MensajesErrorConstante.DIRECCION_NO_ENCONTRADA_CON_ID;
import static co.edu.uco.sibe.dominio.transversal.constante.MensajesSistemaConstante.obtenerMensajeConParametro;
import static co.edu.uco.sibe.dominio.transversal.utilitarios.ValidadorObjeto.esNulo;

public class ConsultarActividadesPorDireccionUseCase {
    private final ActividadRepositorioConsulta actividadRepositorioConsulta;
    private final DireccionRepositorioConsulta direccionRepositorioConsulta;

    public ConsultarActividadesPorDireccionUseCase(ActividadRepositorioConsulta actividadRepositorioConsulta, DireccionRepositorioConsulta direccionRepositorioConsulta) {
        this.actividadRepositorioConsulta = actividadRepositorioConsulta;
        this.direccionRepositorioConsulta = direccionRepositorioConsulta;
    }

    public List<ActividadDTO> ejecutar(String identificadorDireccion) {
        var id = UtilUUID.textoAUUID(identificadorDireccion);
        var direccion = validarSiExisteDireccion(id, identificadorDireccion);

        return actividadRepositorioConsulta.consultarPorDireccion(direccion);
    }

    private Direccion validarSiExisteDireccion(UUID id, String idComando) {
        var direccion = direccionRepositorioConsulta.consultarPorIdentificador(id);

        if (esNulo(direccion)) {
            throw new ValorInvalidoExcepcion(obtenerMensajeConParametro(DIRECCION_NO_ENCONTRADA_CON_ID, idComando));
        }

        return direccion;
    }
}