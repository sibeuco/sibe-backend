package co.edu.uco.sibe.dominio.puerto.consulta;

import co.edu.uco.sibe.dominio.dto.ProyectoDTO;
import co.edu.uco.sibe.dominio.modelo.Proyecto;
import java.util.List;
import java.util.UUID;

public interface ProyectoRepositorioConsulta {
    List<ProyectoDTO> consultarDTOs();

    Proyecto consultarPorIdentificador(UUID identificador);

    Proyecto consultarPorNumeroProyecto(String numeroProyecto);
}