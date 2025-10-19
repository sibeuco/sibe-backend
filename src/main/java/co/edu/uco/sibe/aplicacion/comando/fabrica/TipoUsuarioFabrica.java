package co.edu.uco.sibe.aplicacion.comando.fabrica;

import co.edu.uco.sibe.aplicacion.comando.TipoUsuarioComando;
import co.edu.uco.sibe.dominio.modelo.TipoUsuario;
import co.edu.uco.sibe.dominio.puerto.consulta.TipoUsuarioRepositorioConsulta;
import co.edu.uco.sibe.dominio.transversal.utilitarios.UtilUUID;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import java.util.UUID;

@Component
@AllArgsConstructor
public class TipoUsuarioFabrica {
    private final TipoUsuarioRepositorioConsulta tipoUsuarioRepositorioConsulta;

    public TipoUsuario construir(TipoUsuarioComando comando) {
        return TipoUsuario.construir(
                generarNuevoUUID(),
                comando.getCodigo(),
                comando.getNombre(),
                comando.isCrear(),
                comando.isModificar(),
                comando.isEliminar(),
                comando.isConsultar()
        );
    }

    public UUID generarNuevoUUID() {
        UUID nuevoUUID;
        do {
            nuevoUUID = UtilUUID.generarNuevoUUID();
        } while (tipoUsuarioRepositorioConsulta.consultarPorIdentificador(nuevoUUID) != null);
        return nuevoUUID;
    }
}
