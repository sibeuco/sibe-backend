package co.edu.uco.sibe.dominio.usecase.consulta;

import co.edu.uco.sibe.dominio.modelo.TipoIdentificacion;
import co.edu.uco.sibe.dominio.puerto.consulta.TipoIdentificacionRepositorioConsulta;
import co.edu.uco.sibe.dominio.transversal.excepcion.ValorInvalidoExcepcion;
import co.edu.uco.sibe.dominio.transversal.utilitarios.UtilMensaje;
import co.edu.uco.sibe.dominio.transversal.utilitarios.ValidadorObjeto;

public class ConsultarTipoIdentificacionPorSiglaUseCase {
    private final TipoIdentificacionRepositorioConsulta tipoIdentificacionRepositorioConsulta;

    public ConsultarTipoIdentificacionPorSiglaUseCase(TipoIdentificacionRepositorioConsulta tipoIdentificacionRepositorioConsulta) {
        this.tipoIdentificacionRepositorioConsulta = tipoIdentificacionRepositorioConsulta;
    }

    public TipoIdentificacion ejecutar(String nombre) {
        validarSiNoExisteTipoIdentificacionConSigla(nombre);

        return this.tipoIdentificacionRepositorioConsulta.consultarPorSigla(nombre);
    }

    private void validarSiNoExisteTipoIdentificacionConSigla(String sigla) {
        if (ValidadorObjeto.esNulo(this.tipoIdentificacionRepositorioConsulta.consultarPorSigla(sigla))) {
            throw new ValorInvalidoExcepcion(UtilMensaje.consultarPorSigla(sigla));
        }
    }
}