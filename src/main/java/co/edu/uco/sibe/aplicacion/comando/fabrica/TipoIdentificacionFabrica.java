package co.edu.uco.sibe.aplicacion.comando.fabrica;

import co.edu.uco.sibe.aplicacion.comando.TipoIdentificacionComando;
import co.edu.uco.sibe.aplicacion.comando.TipoUsuarioComando;
import co.edu.uco.sibe.dominio.modelo.TipoIdentificacion;
import co.edu.uco.sibe.dominio.modelo.TipoUsuario;
import co.edu.uco.sibe.dominio.puerto.consulta.TipoIdentificacionRepositorioConsulta;
import co.edu.uco.sibe.dominio.puerto.consulta.TipoUsuarioRepositorioConsulta;
import co.edu.uco.sibe.dominio.transversal.utilitarios.UtilUUID;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@AllArgsConstructor
public class TipoIdentificacionFabrica {
    private final TipoIdentificacionRepositorioConsulta tipoIdentificacionRepositorioConsulta;

    public TipoIdentificacion construir(TipoIdentificacionComando comando) {
        return TipoIdentificacion.construir(
                generarNuevoUUID(),
                comando.getSigla(),
                comando.getDescripcion()
        );
    }

    public UUID generarNuevoUUID() {
        UUID nuevoUUID;
        do {
            nuevoUUID = UtilUUID.generarNuevoUUID();
        } while (tipoIdentificacionRepositorioConsulta.consultarPorIdentificador(nuevoUUID) != null);
        return nuevoUUID;
    }
}
