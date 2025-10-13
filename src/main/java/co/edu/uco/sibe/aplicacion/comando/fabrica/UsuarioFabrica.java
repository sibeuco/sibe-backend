package co.edu.uco.sibe.aplicacion.comando.fabrica;

import co.edu.uco.sibe.aplicacion.comando.UsuarioComando;
import co.edu.uco.sibe.aplicacion.comando.UsuarioModificacionComando;
import co.edu.uco.sibe.dominio.dto.TipoUsuarioDTO;
import co.edu.uco.sibe.dominio.modelo.TipoUsuario;
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

    public Usuario construir(UsuarioComando usuario){
        var identificadorUsuario = generarNuevoUUIDUnico();

        TipoUsuarioDTO tipoUsuarioDTO = tipoUsuarioRepositorioConsulta.consultarTipoUsuarioPorIdentificador(usuario.getTipoUsuario());
        TipoUsuario tipoUsuario = TipoUsuario.construir(tipoUsuarioDTO.getIdentificador(),
                tipoUsuarioDTO.getNombre(),
                tipoUsuarioDTO.isCrear(),
                tipoUsuarioDTO.isModificar(),
                tipoUsuarioDTO.isEliminar(),
                tipoUsuarioDTO.isConsultar());



        var modelo = Usuario.construir(identificadorUsuario, usuario.getCorreo(), usuario.getContrasena(), tipoUsuario);

        MotoresFabrica.MOTOR_USUARIO.ejecutar(modelo, TipoOperacion.CREAR);

        return modelo;
    }

    public Usuario construirActualizar(UsuarioModificacionComando usuario, UUID identificador){
        TipoUsuarioDTO tipoUsuarioDTO = tipoUsuarioRepositorioConsulta.consultarTipoUsuarioPorIdentificador(usuario.getTipoUsuario());
        TipoUsuario tipoUsuario = TipoUsuario.construir(tipoUsuarioDTO.getIdentificador(),
                tipoUsuarioDTO.getNombre(),
                tipoUsuarioDTO.isCrear(), tipoUsuarioDTO.isModificar(),
                tipoUsuarioDTO.isEliminar(),
                tipoUsuarioDTO.isConsultar());

        return Usuario.construir(identificador, usuario.getCorreo(), "", tipoUsuario);

    }

    public UUID generarNuevoUUIDUnico() {
        UUID nuevoUUID;
        do {
            nuevoUUID = UtilUUID.generarNuevoUUID();
        } while (personaRepositorioConsulta.consultarUsuarioPorIdentificadorDTO(nuevoUUID) != null);
        return nuevoUUID;
    }

}
