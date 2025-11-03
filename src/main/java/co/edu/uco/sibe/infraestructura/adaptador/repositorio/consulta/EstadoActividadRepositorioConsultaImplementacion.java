package co.edu.uco.sibe.infraestructura.adaptador.repositorio.consulta;

import co.edu.uco.sibe.dominio.modelo.EstadoActividad;
import co.edu.uco.sibe.dominio.puerto.consulta.EstadoActividadRepositorioConsulta;
import co.edu.uco.sibe.dominio.transversal.utilitarios.ValidadorNumero;
import co.edu.uco.sibe.infraestructura.adaptador.dao.EstadoActividadDAO;
import co.edu.uco.sibe.infraestructura.adaptador.mapeador.EstadoActividadMapeador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.UUID;
import static co.edu.uco.sibe.dominio.transversal.constante.NumeroConstante.CERO;
import static co.edu.uco.sibe.dominio.transversal.utilitarios.ValidadorObjeto.esNulo;

@Repository
public class EstadoActividadRepositorioConsultaImplementacion implements EstadoActividadRepositorioConsulta {
    @Autowired
    private EstadoActividadDAO estadoActividadDAO;

    @Autowired
    private EstadoActividadMapeador estadoActividadMapeador;

    @Override
    public EstadoActividad consultarPorIdentificador(UUID identificador) {
        var entidad = this.estadoActividadDAO.findById(identificador).orElse(null);

        if (esNulo(entidad)) {
            return null;
        }

        return this.estadoActividadMapeador.construirModelo(entidad);
    }

    @Override
    public boolean hayDatos() {
        var cantidad = this.estadoActividadDAO.count();

        return ValidadorNumero.esNumeroMayor(cantidad, CERO);
    }

    @Override
    public EstadoActividad consultarPorNombre(String nombre) {
        var entidad = this.estadoActividadDAO.findByNombre(nombre);

        if (esNulo(entidad)) {
            return null;
        }

        return this.estadoActividadMapeador.construirModelo(entidad);
    }
}