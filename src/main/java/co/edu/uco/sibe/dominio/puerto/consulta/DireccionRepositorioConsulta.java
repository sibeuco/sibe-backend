package co.edu.uco.sibe.dominio.puerto.consulta;

import co.edu.uco.sibe.dominio.modelo.Direccion;
import java.util.UUID;

public interface DireccionRepositorioConsulta {
    Direccion consultarPorIdentificador(UUID identificador);

    boolean hayDatos();
}