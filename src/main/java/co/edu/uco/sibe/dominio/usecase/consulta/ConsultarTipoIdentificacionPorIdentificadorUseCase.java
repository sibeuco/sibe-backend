package co.edu.uco.sibe.dominio.usecase.consulta;

import co.edu.uco.sibe.dominio.dto.TipoIdentificacionDTO;
import co.edu.uco.sibe.dominio.puerto.consulta.TipoIdentificacionRepositorioConsulta;
import co.edu.uco.sibe.dominio.transversal.excepcion.ValorInvalidoExcepcion;
import co.edu.uco.sibe.dominio.transversal.utilitarios.Mensajes;
import co.edu.uco.sibe.dominio.transversal.utilitarios.UtilObjeto;

import java.util.UUID;

public class ConsultarTipoIdentificacionPorIdentificadorUseCase {

    private final TipoIdentificacionRepositorioConsulta tipoIdentificacionRepositorioConsulta;

    public ConsultarTipoIdentificacionPorIdentificadorUseCase(TipoIdentificacionRepositorioConsulta tipoIdentificacionRepositorioConsulta) {
        this.tipoIdentificacionRepositorioConsulta = tipoIdentificacionRepositorioConsulta;
    }

    public TipoIdentificacionDTO ejecutar(UUID identificador){
        validarSiNoExisteTipoIdentificacionConId(identificador);

        return this.tipoIdentificacionRepositorioConsulta.consultarTipoIdentificacionPorIdentificador(identificador);

    }

    private void validarSiNoExisteTipoIdentificacionConId(UUID identificador) {
        if (UtilObjeto.getInstance().esNulo(this.tipoIdentificacionRepositorioConsulta.consultarTipoIdentificacionPorIdentificador(identificador))) {
            throw new ValorInvalidoExcepcion(Mensajes.obtenerNoExisteTipoIdentificacionConId(identificador));
        }
    }

}
