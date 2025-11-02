package co.edu.uco.sibe.infraestructura.adaptador.repositorio.consulta;

import co.edu.uco.sibe.dominio.dto.DireccionDTO;
import co.edu.uco.sibe.dominio.modelo.Actividad;
import co.edu.uco.sibe.dominio.modelo.Direccion;
import co.edu.uco.sibe.dominio.puerto.consulta.DireccionRepositorioConsulta;
import co.edu.uco.sibe.dominio.transversal.utilitarios.ValidadorNumero;
import co.edu.uco.sibe.dominio.transversal.utilitarios.ValidadorObjeto;
import co.edu.uco.sibe.infraestructura.adaptador.dao.DireccionDAO;
import co.edu.uco.sibe.infraestructura.adaptador.mapeador.DireccionMapeador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

import static co.edu.uco.sibe.dominio.transversal.constante.NumeroConstante.CERO;
import static co.edu.uco.sibe.dominio.transversal.utilitarios.ValidadorObjeto.esNulo;

@Repository
public class DireccionRepositorioConsultaImplementacion implements DireccionRepositorioConsulta {
    @Autowired
    private DireccionDAO direccionDAO;

    @Autowired
    private DireccionMapeador direccionMapeador;

    @Override
    public List<DireccionDTO> consultarDTOs() {
        var entidades = this.direccionDAO.findAll();
        return this.direccionMapeador.construirDTOs(entidades);
    }

    @Override
    public Direccion consultarPorIdentificador(UUID identificador) {
        var entidad = this.direccionDAO.findById(identificador).orElse(null);

        if(ValidadorObjeto.esNulo(entidad)) {
            return null;
        }

        return this.direccionMapeador.construirModelo(entidad);
    }

    @Override
    public boolean hayDatos() {
        var cantidad = direccionDAO.count();
        return ValidadorNumero.esNumeroMayor(cantidad, CERO);
    }

    @Override
    public Direccion consultarPorNombre(String nombre) {
        var entidad = this.direccionDAO.findByNombre(nombre);

        if(ValidadorObjeto.esNulo(entidad)) {
            return null;
        }

        return this.direccionMapeador.construirModelo(entidad);
    }

    @Override
    public Direccion consultarPorActividad(Actividad actividad) {
        var entidad = this.direccionDAO.findByActividades_Identificador(actividad.getIdentificador());
        if(esNulo(entidad)) {
            return null;
        }
        return this.direccionMapeador.construirModelo(entidad);
    }
}