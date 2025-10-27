package co.edu.uco.sibe.infraestructura.adaptador.repositorio.consulta;

import co.edu.uco.sibe.dominio.modelo.Estudiante;
import co.edu.uco.sibe.dominio.puerto.consulta.EstudianteRepositorioConsulta;
import co.edu.uco.sibe.dominio.transversal.utilitarios.ValidadorObjeto;
import co.edu.uco.sibe.infraestructura.adaptador.dao.EstudianteDAO;
import co.edu.uco.sibe.infraestructura.adaptador.mapeador.EstudianteMapeador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.UUID;

@Repository
public class EstudianteRepositorioConsultaImplementacion implements EstudianteRepositorioConsulta {
    @Autowired
    private EstudianteDAO estudianteDAO;

    @Autowired
    private EstudianteMapeador estudianteMapeador;

    @Override
    public Estudiante consultarPorIdentificador(UUID identificador) {
        var entidad = this.estudianteDAO.findById(identificador).orElse(null);

        if(ValidadorObjeto.esNulo(entidad)) {
            return null;
        }

        return this.estudianteMapeador.construirModelo(entidad);
    }

    @Override
    public Estudiante consultarPorIdentificacion(String identificacion) {
        var entidad = this.estudianteDAO.findByNumeroIdentificacion(identificacion);

        if(ValidadorObjeto.esNulo(entidad)) {
            return null;
        }

        return this.estudianteMapeador.construirModelo(entidad);
    }
}
