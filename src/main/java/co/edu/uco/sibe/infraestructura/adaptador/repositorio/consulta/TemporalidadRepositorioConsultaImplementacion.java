package co.edu.uco.sibe.infraestructura.adaptador.repositorio.consulta;

import co.edu.uco.sibe.dominio.dto.TemporalidadDTO;
import co.edu.uco.sibe.dominio.modelo.Temporalidad;
import co.edu.uco.sibe.dominio.puerto.consulta.TemporalidadRepositorioConsulta;
import co.edu.uco.sibe.dominio.transversal.utilitarios.ValidadorNumero;
import co.edu.uco.sibe.infraestructura.adaptador.dao.TemporalidadDAO;
import co.edu.uco.sibe.infraestructura.adaptador.mapeador.TemporalidadMapeador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.UUID;
import static co.edu.uco.sibe.dominio.transversal.constante.NumeroConstante.CERO;
import static co.edu.uco.sibe.dominio.transversal.utilitarios.ValidadorObjeto.esNulo;

@Repository
public class TemporalidadRepositorioConsultaImplementacion implements TemporalidadRepositorioConsulta {
    @Autowired
    private TemporalidadDAO temporalidadDAO;

    @Autowired
    private TemporalidadMapeador temporalidadMapeador;

    @Override
    public List<TemporalidadDTO> consultarDTOs() {
        var entidades = temporalidadDAO.findAll();

        return this.temporalidadMapeador.construirDTOs(entidades);
    }

    @Override
    public Temporalidad consultarPorIdentificador(UUID identificador) {
        var entidad = temporalidadDAO.findById(identificador).orElse(null);

        if(esNulo(entidad)) {
            return null;
        }

        return this.temporalidadMapeador.construirModelo(entidad);
    }

    @Override
    public boolean hayDatos() {
        var cantidad = temporalidadDAO.count();

        return ValidadorNumero.esNumeroMayor(cantidad, CERO);
    }

    @Override
    public Temporalidad consultarPorNombre(String nombre) {
        var entidad = temporalidadDAO.findByNombre(nombre);

        if(esNulo(entidad)) {
            return null;
        }

        return this.temporalidadMapeador.construirModelo(entidad);
    }
}