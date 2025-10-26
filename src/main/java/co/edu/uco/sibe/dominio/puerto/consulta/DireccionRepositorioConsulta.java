package co.edu.uco.sibe.dominio.puerto.consulta;

import co.edu.uco.sibe.dominio.dto.DireccionDTO;
import co.edu.uco.sibe.dominio.modelo.Direccion;

import java.util.List;
import java.util.UUID;

public interface DireccionRepositorioConsulta {
    List<DireccionDTO> consultarDTOs();

    Direccion consultarPorIdentificador(UUID identificador);

    boolean hayDatos();

    Direccion consultarPorNombre(String nombre);
}