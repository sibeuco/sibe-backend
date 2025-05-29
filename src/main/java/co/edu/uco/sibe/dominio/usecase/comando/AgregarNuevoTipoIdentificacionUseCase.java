package co.edu.uco.sibe.dominio.usecase.comando;

import co.edu.uco.sibe.dominio.modelo.TipoIdentificacion;
import co.edu.uco.sibe.dominio.puerto.comando.TipoIdentificacionRepositorioComando;

import java.util.UUID;

public class AgregarNuevoTipoIdentificacionUseCase {

    private final TipoIdentificacionRepositorioComando tipoIdentificacionRepositorioComando;

    public AgregarNuevoTipoIdentificacionUseCase(TipoIdentificacionRepositorioComando tipoIdentificacionRepositorioComando) {
        this.tipoIdentificacionRepositorioComando = tipoIdentificacionRepositorioComando;
    }

    public UUID ejecutar(TipoIdentificacion tipoIdentificacion){
        return this.tipoIdentificacionRepositorioComando.agregarNuevoTipoIdentificacion(tipoIdentificacion);
    }
}
