package co.edu.uco.sibe.dominio.usecase.comando;

import co.edu.uco.sibe.dominio.modelo.TipoUsuario;
import co.edu.uco.sibe.dominio.puerto.comando.TipoUsuarioRepositorioComando;
import co.edu.uco.sibe.dominio.regla.TipoOperacion;
import co.edu.uco.sibe.dominio.regla.fabrica.MotoresFabrica;
import java.util.UUID;

public class GuardarTipoUsuarioUseCase {
    private final TipoUsuarioRepositorioComando tipoUsuarioRepositorioComando;

    public GuardarTipoUsuarioUseCase(TipoUsuarioRepositorioComando tipoUsuarioRepositorioComando) {
        this.tipoUsuarioRepositorioComando = tipoUsuarioRepositorioComando;
    }

    public UUID ejecutar(TipoUsuario tipoUsuario) {
        MotoresFabrica.MOTOR_TIPO_USUARIO.ejecutar(tipoUsuario, TipoOperacion.CREAR);

        return this.tipoUsuarioRepositorioComando.guardar(tipoUsuario);
    }
}