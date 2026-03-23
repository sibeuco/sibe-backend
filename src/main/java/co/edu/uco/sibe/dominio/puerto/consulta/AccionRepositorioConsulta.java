package co.edu.uco.sibe.dominio.puerto.consulta;

import co.edu.uco.sibe.dominio.dto.AccionDTO;
import co.edu.uco.sibe.dominio.dto.RespuestaPaginada;
import co.edu.uco.sibe.dominio.dto.SolicitudPaginacion;
import co.edu.uco.sibe.dominio.modelo.Accion;
import java.util.List;
import java.util.UUID;

public interface AccionRepositorioConsulta {
    List<AccionDTO> consultarDTOs();

    RespuestaPaginada<AccionDTO> consultarDTOsPaginado(SolicitudPaginacion solicitud);

    List<Accion> consultarTodosPorIdentificadores(List<UUID> identificadores);

    Accion consultarPorIdentificador(UUID identificador);

    List<Accion> consultarTodos();

    Accion consultarPorDetalle(String detalle);
}