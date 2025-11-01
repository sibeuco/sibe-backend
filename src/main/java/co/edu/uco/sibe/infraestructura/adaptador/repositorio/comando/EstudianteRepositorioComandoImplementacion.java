package co.edu.uco.sibe.infraestructura.adaptador.repositorio.comando;

import co.edu.uco.sibe.dominio.modelo.Estudiante;
import co.edu.uco.sibe.dominio.puerto.comando.EstudianteRepositorioComando;
import co.edu.uco.sibe.infraestructura.adaptador.dao.CiudadResidenciaDAO;
import co.edu.uco.sibe.infraestructura.adaptador.dao.EstudianteDAO;
import co.edu.uco.sibe.infraestructura.adaptador.mapeador.EstudianteMapeador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.UUID;
import static co.edu.uco.sibe.dominio.transversal.utilitarios.ValidadorObjeto.esNulo;

@Repository
public class EstudianteRepositorioComandoImplementacion implements EstudianteRepositorioComando {
    @Autowired
    private EstudianteDAO estudianteDAO;

    @Autowired
    private EstudianteMapeador estudianteMapeador;

    @Autowired
    private CiudadResidenciaDAO ciudadResidenciaDAO;

    @Override
    public UUID guardar(Estudiante estudiante) {
        var entidad = estudianteMapeador.construirEntidad(estudiante);

        if (esNulo(this.ciudadResidenciaDAO.findById(entidad.getCiudadResidencia().getCiudadResidencia().getIdentificador()).orElse(null))) {
            this.ciudadResidenciaDAO.save(entidad.getCiudadResidencia().getCiudadResidencia());
        }

        return this.estudianteDAO.save(entidad).getIdentificador();
    }

    @Override
    public UUID modificar(Estudiante estudiante, UUID identificador) {
        var entidad = estudianteDAO.findById(identificador).orElse(null);

        assert !esNulo(entidad);
        estudianteMapeador.modificarEntidad(entidad, estudiante);

        return this.estudianteDAO.save(entidad).getIdentificador();
    }
}
