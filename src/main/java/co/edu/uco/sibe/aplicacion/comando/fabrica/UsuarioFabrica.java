package co.edu.uco.sibe.aplicacion.comando.fabrica;

import co.edu.uco.sibe.aplicacion.comando.UsuarioComando;
import co.edu.uco.sibe.aplicacion.comando.UsuarioModificacionComando;
import co.edu.uco.sibe.dominio.modelo.Usuario;
import co.edu.uco.sibe.dominio.puerto.consulta.PersonaRepositorioConsulta;
import co.edu.uco.sibe.dominio.puerto.consulta.TipoUsuarioRepositorioConsulta;
import co.edu.uco.sibe.dominio.regla.TipoOperacion;
import co.edu.uco.sibe.dominio.regla.fabrica.MotoresFabrica;
import co.edu.uco.sibe.dominio.transversal.utilitarios.UtilUUID;
import org.springframework.stereotype.Component;
import java.util.UUID;

@Component
public class UsuarioFabrica {
    private final TipoUsuarioRepositorioConsulta tipoUsuarioRepositorioConsulta;
    private final PersonaRepositorioConsulta personaRepositorioConsulta;

    public UsuarioFabrica(TipoUsuarioRepositorioConsulta tipoUsuarioRepositorioConsulta, PersonaRepositorioConsulta personaRepositorioConsulta) {
        this.tipoUsuarioRepositorioConsulta = tipoUsuarioRepositorioConsulta;
        this.personaRepositorioConsulta = personaRepositorioConsulta;
    }

    public Usuario construir(UsuarioComando comando){
        var identificadorUsuario = generarNuevoUUIDUnico();
        var tipoUsuario = tipoUsuarioRepositorioConsulta.consultarTiposUsuario(comando.getTipoUsuario());
        var usuario = Usuario.construir(identificadorUsuario, comando.getCorreo(), comando.getClave(), tipoUsuario, true);

        MotoresFabrica.MOTOR_USUARIO.ejecutar(usuario, TipoOperacion.CREAR);

        return usuario;
    }

    public Usuario construirActualizar(UsuarioModificacionComando comando, UUID identificador){
        var tipoUsuario = tipoUsuarioRepositorioConsulta.consultarTiposUsuario(comando.getTipoUsuario());
        var usuarioActual = personaRepositorioConsulta.consultarUsuarioPorIdentificador(identificador);
        var usuario = Usuario.construir(identificador, comando.getCorreo(), usuarioActual.getClave(), tipoUsuario, usuarioActual.isEstaActivo());

        MotoresFabrica.MOTOR_USUARIO.ejecutar(usuario, TipoOperacion.ACTUALIZAR);

        return usuario;

    }

    public UUID generarNuevoUUIDUnico() {
        UUID nuevoUUID;
        do {
            nuevoUUID = UtilUUID.generarNuevoUUID();
        } while (personaRepositorioConsulta.consultarUsuarioPorIdentificador(nuevoUUID) != null);
        return nuevoUUID;
    }
}