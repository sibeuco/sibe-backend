package co.edu.uco.sibe.dominio.usecase.comando;

import co.edu.uco.sibe.dominio.modelo.Accion;
import co.edu.uco.sibe.dominio.puerto.comando.AccionRepositorioComando;
import co.edu.uco.sibe.dominio.puerto.consulta.AccionRepositorioConsulta;
import co.edu.uco.sibe.dominio.regla.TipoOperacion;
import co.edu.uco.sibe.dominio.regla.fabrica.MotoresFabrica;
import co.edu.uco.sibe.dominio.transversal.excepcion.ValorDuplicadoExcepcion;
import co.edu.uco.sibe.dominio.transversal.utilitarios.ValidadorObjeto;
import java.util.UUID;
import static co.edu.uco.sibe.dominio.transversal.utilitarios.UtilMensaje.DETALLE_EXISTENTE;

public class GuardarAccionUseCase {
    private final AccionRepositorioComando accionRepositorioComando;
    private final AccionRepositorioConsulta accionRepositorioConsulta;

    public GuardarAccionUseCase(AccionRepositorioComando accionRepositorioComando, AccionRepositorioConsulta accionRepositorioConsulta) {
        this.accionRepositorioComando = accionRepositorioComando;
        this.accionRepositorioConsulta = accionRepositorioConsulta;
    }

    public UUID ejecutar(Accion accion){
        MotoresFabrica.MOTOR_ACCION.ejecutar(accion, TipoOperacion.CREAR);

        validarNoExisteAccionConDetalle(accion.getDetalle());

        return this.accionRepositorioComando.guardar(accion);
    }

    private void validarNoExisteAccionConDetalle(String detalle) {
        if (!ValidadorObjeto.esNulo(this.accionRepositorioConsulta.consultarPorDetalle(detalle))){
            throw new ValorDuplicadoExcepcion(DETALLE_EXISTENTE);
        }
    }
}