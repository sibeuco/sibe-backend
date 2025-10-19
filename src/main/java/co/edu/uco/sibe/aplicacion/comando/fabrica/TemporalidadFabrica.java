package co.edu.uco.sibe.aplicacion.comando.fabrica;

import co.edu.uco.sibe.dominio.modelo.Temporalidad;
import co.edu.uco.sibe.dominio.puerto.consulta.TemporalidadRepositorioConsulta;
import co.edu.uco.sibe.dominio.transversal.utilitarios.UtilUUID;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@AllArgsConstructor
public class TemporalidadFabrica {
    private final TemporalidadRepositorioConsulta temporalidadRepositorioConsulta;

    public Temporalidad construir(String comando) {
        return Temporalidad.construir(
                generarNuevoUUID(),
                comando
        );
    }

    public UUID generarNuevoUUID() {
        UUID nuevoUUID;
        do {
            nuevoUUID = UtilUUID.generarNuevoUUID();
        } while (temporalidadRepositorioConsulta.consultarPorIdentificador(nuevoUUID) != null);
        return nuevoUUID;
    }
}