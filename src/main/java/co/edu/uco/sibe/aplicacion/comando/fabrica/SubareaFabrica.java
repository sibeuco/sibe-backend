package co.edu.uco.sibe.aplicacion.comando.fabrica;

import co.edu.uco.sibe.dominio.modelo.Actividad;
import co.edu.uco.sibe.dominio.modelo.EstadoActividad;
import co.edu.uco.sibe.dominio.modelo.Subarea;
import co.edu.uco.sibe.dominio.puerto.consulta.EstadoActividadRepositorioConsulta;
import co.edu.uco.sibe.dominio.puerto.consulta.SubareaRepositorioConsulta;
import co.edu.uco.sibe.dominio.transversal.utilitarios.UtilUUID;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
@AllArgsConstructor
public class SubareaFabrica {
    private final SubareaRepositorioConsulta subareaRepositorioConsulta;

    public Subarea construir(String nombre, List<Actividad> actividades) {
        return Subarea.construir(
                generarNuevoUUID(),
                nombre,
                actividades
        );
    }

    public UUID generarNuevoUUID() {
        UUID nuevoUUID;
        do {
            nuevoUUID = UtilUUID.generarNuevoUUID();
        } while (subareaRepositorioConsulta.consultarPorIdentificador(nuevoUUID) != null);
        return nuevoUUID;
    }
}
