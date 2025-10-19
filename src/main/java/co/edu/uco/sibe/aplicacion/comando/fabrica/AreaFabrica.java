package co.edu.uco.sibe.aplicacion.comando.fabrica;

import co.edu.uco.sibe.dominio.modelo.Actividad;
import co.edu.uco.sibe.dominio.modelo.Area;
import co.edu.uco.sibe.dominio.modelo.Subarea;
import co.edu.uco.sibe.dominio.puerto.consulta.AreaRepositorioConsulta;
import co.edu.uco.sibe.dominio.puerto.consulta.SubareaRepositorioConsulta;
import co.edu.uco.sibe.dominio.transversal.utilitarios.UtilUUID;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
@AllArgsConstructor
public class AreaFabrica {
    private final AreaRepositorioConsulta areaRepositorioConsulta;

    public Area construir(String nombre, List<Subarea> subareas, List<Actividad> actividades) {
        return Area.construir(
                generarNuevoUUID(),
                nombre,
                subareas,
                actividades
        );
    }

    public UUID generarNuevoUUID() {
        UUID nuevoUUID;
        do {
            nuevoUUID = UtilUUID.generarNuevoUUID();
        } while (areaRepositorioConsulta.consultarPorIdentificador(nuevoUUID) != null);
        return nuevoUUID;
    }
}
