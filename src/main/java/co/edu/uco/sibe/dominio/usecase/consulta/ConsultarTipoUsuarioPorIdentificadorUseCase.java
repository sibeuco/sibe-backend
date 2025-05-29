package co.edu.uco.sibe.dominio.usecase.consulta;

import co.edu.uco.sibe.dominio.dto.TipoUsuarioDTO;
import co.edu.uco.sibe.dominio.puerto.consulta.TipoUsuarioRepositorioConsulta;
import co.edu.uco.sibe.dominio.transversal.excepcion.ValorInvalidoExcepcion;
import co.edu.uco.sibe.dominio.transversal.utilitarios.Mensajes;
import co.edu.uco.sibe.dominio.transversal.utilitarios.UtilObjeto;

import java.util.UUID;

public class ConsultarTipoUsuarioPorIdentificadorUseCase {

    private final TipoUsuarioRepositorioConsulta tipoUsuarioRepositorioConsulta;

    public ConsultarTipoUsuarioPorIdentificadorUseCase(TipoUsuarioRepositorioConsulta tipoUsuarioRepositorioConsulta) {
        this.tipoUsuarioRepositorioConsulta = tipoUsuarioRepositorioConsulta;
    }

    public TipoUsuarioDTO ejecutar(UUID identificador){
        validarSiNoExisteTipoUsuarioConId(identificador);

        return this.tipoUsuarioRepositorioConsulta.consultarTipoUsuarioPorIdentificador(identificador);

    }

    private void validarSiNoExisteTipoUsuarioConId(UUID identificador) {
        if (UtilObjeto.getInstance().esNulo(this.tipoUsuarioRepositorioConsulta.consultarTipoUsuarioPorIdentificador(identificador))) {
            throw new ValorInvalidoExcepcion(Mensajes.obtenerNoExisteTipoUsuarioConId(identificador));
        }
    }

}
