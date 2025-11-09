package co.edu.uco.sibe.dominio.puerto.consulta;

import co.edu.uco.sibe.dominio.dto.MiembroDTO;
import co.edu.uco.sibe.dominio.modelo.Miembro;

public interface MiembroRepositorioConsulta {
    Miembro consultarPorIdentificacion(String identificacion);

    MiembroDTO consultarPorIdentificacionDTO(String identificacion);

    MiembroDTO consultarPorIdCarnetDTO(String idCarnet);
}