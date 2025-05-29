package co.edu.uco.sibe.dominio.usecase.comando;

import co.edu.uco.sibe.dominio.modelo.TipoUsuario;
import co.edu.uco.sibe.dominio.puerto.comando.TipoUsuarioRepositorioComando;

import java.util.UUID;

public class AgregarNuevoTipoUsuarioUseCase {

    private final TipoUsuarioRepositorioComando tipoUsuarioRepositorioComando;

    public AgregarNuevoTipoUsuarioUseCase(TipoUsuarioRepositorioComando tipoUsuarioRepositorioComando) {
        this.tipoUsuarioRepositorioComando = tipoUsuarioRepositorioComando;
    }

    public UUID ejecutar(TipoUsuario tipoUsuario){
        return this.tipoUsuarioRepositorioComando.agregarNuevoTipoUsuario(tipoUsuario);
    }
}
