package co.edu.uco.sibe.dominio.usecase.comando;

import co.edu.uco.sibe.dominio.modelo.TipoArea;
import co.edu.uco.sibe.dominio.puerto.comando.TipoAreaRepositorioComando;

import java.util.UUID;

public class AgregarNuevoTipoAreaUseCase {
    private final TipoAreaRepositorioComando tipoAreaRepositorioComando;

    public AgregarNuevoTipoAreaUseCase(TipoAreaRepositorioComando tipoAreaRepositorioComando) {
        this.tipoAreaRepositorioComando = tipoAreaRepositorioComando;
    }

    public UUID ejecutar(TipoArea tipoArea){
        return this.tipoAreaRepositorioComando.agregarNuevoTipoArea(tipoArea);
    }

}
