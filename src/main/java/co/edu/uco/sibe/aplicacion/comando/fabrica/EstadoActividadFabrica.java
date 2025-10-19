package co.edu.uco.sibe.aplicacion.comando.fabrica;

import co.edu.uco.sibe.dominio.modelo.EstadoActividad;
import co.edu.uco.sibe.dominio.puerto.consulta.EstadoActividadRepositorioConsulta;
import co.edu.uco.sibe.dominio.transversal.utilitarios.UtilUUID;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@AllArgsConstructor
public class EstadoActividadFabrica {
    private final EstadoActividadRepositorioConsulta estadoActividadRepositorioConsulta;

    public EstadoActividad construir(String comando) {
        return EstadoActividad.construir(
                generarNuevoUUID(),
                comando
        );
    }

    public UUID generarNuevoUUID() {
        UUID nuevoUUID;
        do {
            nuevoUUID = UtilUUID.generarNuevoUUID();
        } while (estadoActividadRepositorioConsulta.consultarPorIdentificador(nuevoUUID) != null);
        return nuevoUUID;
    }
}