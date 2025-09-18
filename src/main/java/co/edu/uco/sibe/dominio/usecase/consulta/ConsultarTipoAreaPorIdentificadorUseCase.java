package co.edu.uco.sibe.dominio.usecase.consulta;

import co.edu.uco.sibe.dominio.puerto.consulta.TipoAreaRepositorioConsulta;
import co.edu.uco.sibe.dominio.transversal.excepcion.ValorInvalidoExcepcion;
import co.edu.uco.sibe.dominio.transversal.utilitarios.Mensajes;
import co.edu.uco.sibe.dominio.transversal.utilitarios.ValidadorObjeto;

import java.util.UUID;

public class ConsultarTipoAreaPorIdentificadorUseCase {

    private final TipoAreaRepositorioConsulta tipoAreaRepositorioConsulta;

    public ConsultarTipoAreaPorIdentificadorUseCase(TipoAreaRepositorioConsulta tipoAreaRepositorioConsulta) {
        this.tipoAreaRepositorioConsulta = tipoAreaRepositorioConsulta;
    }

    public TipoAreaDTO ejecutar(UUID identificador){
        validarSiNoExisteTipoAreaConId(identificador);

        return this.tipoAreaRepositorioConsulta.consultarTipoAreaPorIdentificador(identificador);

    }

    private void validarSiNoExisteTipoAreaConId(UUID identificador) {
        if (ValidadorObjeto.getInstance().esNulo(this.tipoAreaRepositorioConsulta.consultarTipoAreaPorIdentificador(identificador))) {
            throw new ValorInvalidoExcepcion(Mensajes.obtenerNoExisteTipoAreaConId(identificador));
        }
    }
}
