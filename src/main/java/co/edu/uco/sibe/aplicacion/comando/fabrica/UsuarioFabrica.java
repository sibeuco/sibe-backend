package co.edu.uco.sibe.aplicacion.comando.fabrica;

import co.edu.uco.sibe.aplicacion.comando.UsuarioComando;
import co.edu.uco.sibe.aplicacion.comando.UsuarioModificacionComando;
import co.edu.uco.sibe.dominio.modelo.Usuario;
import co.edu.uco.sibe.dominio.puerto.consulta.PersonaRepositorioConsulta;
import co.edu.uco.sibe.dominio.puerto.consulta.TipoUsuarioRepositorioConsulta;
import co.edu.uco.sibe.dominio.regla.TipoOperacion;
import co.edu.uco.sibe.dominio.regla.fabrica.MotoresFabrica;
import co.edu.uco.sibe.dominio.transversal.utilitarios.UtilUUID;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import java.util.UUID;

@Component
@AllArgsConstructor
public class UsuarioFabrica {
    private final TipoUsuarioRepositorioConsulta tipoUsuarioRepositorioConsulta;
    private final PersonaRepositorioConsulta personaRepositorioConsulta;

    public Usuario construir(UsuarioComando comando){
        var identificadorUsuario = generarNuevoUUIDUnico();
        var tipoUsuario = tipoUsuarioRepositorioConsulta.consultarPorIdentificador(UtilUUID.textoAUUID(comando.getTipoUsuario()));
        var usuario = Usuario.construir(identificadorUsuario, comando.getCorreo(), comando.getClave(), tipoUsuario, true);

        return usuario;
    }

    public Usuario construirActualizar(UsuarioModificacionComando comando, UUID identificador){
        var tipoUsuario = tipoUsuarioRepositorioConsulta.consultarPorIdentificador(UtilUUID.textoAUUID(comando.getTipoUsuario()));
        var correoActual = personaRepositorioConsulta.consultarPersonaPorIdentificador(identificador).getCorreo();
        var usuarioActual = personaRepositorioConsulta.consultarUsuarioPorCorreo(correoActual);
        var usuario = Usuario.construir(usuarioActual.getIdentificador(), comando.getCorreo(), usuarioActual.getClave(), tipoUsuario, usuarioActual.isEstaActivo());



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