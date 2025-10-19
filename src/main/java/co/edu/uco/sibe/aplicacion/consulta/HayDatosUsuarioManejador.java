package co.edu.uco.sibe.aplicacion.consulta;

import co.edu.uco.sibe.aplicacion.transversal.manejador.ManejadorRespuesta;
import co.edu.uco.sibe.dominio.puerto.consulta.TipoUsuarioRepositorioConsulta;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class HayDatosUsuarioManejador implements ManejadorRespuesta<Boolean> {
    private final TipoUsuarioRepositorioConsulta usuarioRepositorioConsulta;

    @Override
    public Boolean ejecutar() {
        return this.usuarioRepositorioConsulta.hayDatos();
    }
}
