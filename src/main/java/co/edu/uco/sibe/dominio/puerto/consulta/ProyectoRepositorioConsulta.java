package co.edu.uco.sibe.dominio.puerto.consulta;

import co.edu.uco.sibe.dominio.dto.ProyectoDTO;

import java.util.List;

public interface ProyectoRepositorioConsulta {
    List<ProyectoDTO> consultarDTOs();
}
