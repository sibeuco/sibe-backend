package co.edu.uco.sibe.dominio.puerto.consulta;

import co.edu.uco.sibe.dominio.dto.MiembroDTO;

public interface MiembroRepositorioConsulta {
    MiembroDTO consultarPorIdentificacion(String identificacion);

    MiembroDTO consultarPorIdCarnet(String idCarnet);
}