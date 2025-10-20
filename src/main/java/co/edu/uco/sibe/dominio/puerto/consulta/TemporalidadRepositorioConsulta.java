package co.edu.uco.sibe.dominio.puerto.consulta;

import co.edu.uco.sibe.dominio.modelo.Temporalidad;
import java.util.UUID;

public interface TemporalidadRepositorioConsulta {
    Temporalidad consultarPorIdentificador(UUID identificador);

    boolean hayDatos();
}