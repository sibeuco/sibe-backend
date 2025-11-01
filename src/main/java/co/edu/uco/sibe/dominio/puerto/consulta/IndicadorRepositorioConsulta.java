package co.edu.uco.sibe.dominio.puerto.consulta;

import co.edu.uco.sibe.dominio.dto.IndicadorDTO;
import co.edu.uco.sibe.dominio.modelo.Indicador;
import java.util.List;
import java.util.UUID;

public interface IndicadorRepositorioConsulta {
    List<IndicadorDTO> consultarDTOs();

    Indicador consultarPorIdentificador(UUID identificador);

    Indicador consultarPorNombre(String nombre);
}