package co.edu.uco.sibe.dominio.usecase.consulta;

import co.edu.uco.sibe.dominio.modelo.TipoUsuario;
import co.edu.uco.sibe.dominio.puerto.consulta.TipoUsuarioRepositorioConsulta;
import co.edu.uco.sibe.dominio.transversal.excepcion.ValorInvalidoExcepcion;
import co.edu.uco.sibe.dominio.transversal.utilitarios.UtilMensaje;
import co.edu.uco.sibe.dominio.transversal.utilitarios.ValidadorObjeto;

public class ConsultarTipoUsuarioPorCodigoUseCase {
    private final TipoUsuarioRepositorioConsulta tipoUsuarioRepositorioConsulta;

    public ConsultarTipoUsuarioPorCodigoUseCase(TipoUsuarioRepositorioConsulta tipoUsuarioRepositorioConsulta) {
        this.tipoUsuarioRepositorioConsulta = tipoUsuarioRepositorioConsulta;
    }

    public TipoUsuario ejecutar(String codigo) {
        validarSiNoExisteTipoUsuarioConCodigo(codigo);

        return this.tipoUsuarioRepositorioConsulta.consultarPorCodigo(codigo);
    }

    private void validarSiNoExisteTipoUsuarioConCodigo(String codigo) {
        if (ValidadorObjeto.esNulo(this.tipoUsuarioRepositorioConsulta.consultarPorCodigo(codigo))) {
            throw new ValorInvalidoExcepcion(UtilMensaje.consultarPorCodigo(codigo));
        }
    }
}