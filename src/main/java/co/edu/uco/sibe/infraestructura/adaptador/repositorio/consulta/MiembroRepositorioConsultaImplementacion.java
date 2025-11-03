package co.edu.uco.sibe.infraestructura.adaptador.repositorio.consulta;

import co.edu.uco.sibe.dominio.dto.MiembroDTO;
import co.edu.uco.sibe.dominio.puerto.consulta.MiembroRepositorioConsulta;
import co.edu.uco.sibe.infraestructura.adaptador.dao.EmpleadoDAO;
import co.edu.uco.sibe.infraestructura.adaptador.dao.EstudianteDAO;
import co.edu.uco.sibe.infraestructura.adaptador.dao.ExternoDAO;
import co.edu.uco.sibe.infraestructura.adaptador.entidad.MiembroEntidad;
import co.edu.uco.sibe.infraestructura.adaptador.mapeador.MiembroMapeador;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import static co.edu.uco.sibe.dominio.transversal.utilitarios.ValidadorObjeto.esNulo;

@Repository
@AllArgsConstructor
public class MiembroRepositorioConsultaImplementacion implements MiembroRepositorioConsulta {

    private final EstudianteDAO estudianteDAO;
    private final EmpleadoDAO empleadoDAO;
    private final ExternoDAO externoDAO;
    private final MiembroMapeador miembroMapeador;

    @Override
    public MiembroDTO consultarPorIdentificacion(String identificacion) {
        MiembroEntidad miembro = estudianteDAO.findByNumeroIdentificacion(identificacion);

        if (esNulo(miembro)) {
            miembro = empleadoDAO.findByNumeroIdentificacion(identificacion);
        }

        if (esNulo(miembro)) {
            miembro = externoDAO.findByNumeroIdentificacion(identificacion);
        }

        if (esNulo(miembro)) {
            return null;
        }

        return miembroMapeador.construirDTO(miembro);
    }

    @Override
    public MiembroDTO consultarPorIdCarnet(String idCarnet) {
        MiembroEntidad miembro = estudianteDAO.findByIdCarnet(idCarnet);

        if (esNulo(miembro)) {
            miembro = empleadoDAO.findByIdCarnet(idCarnet);
        }

        if (esNulo(miembro)) {
            return null;
        }

        return miembroMapeador.construirDTO(miembro);
    }
}