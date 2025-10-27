package co.edu.uco.sibe.infraestructura.adaptador.repositorio.consulta;

import co.edu.uco.sibe.dominio.modelo.Identificacion;
import co.edu.uco.sibe.dominio.puerto.consulta.IdentificacionRepositorioConsulta;
import co.edu.uco.sibe.dominio.transversal.utilitarios.ValidadorObjeto;
import co.edu.uco.sibe.infraestructura.adaptador.dao.IdentificacionDAO;
import co.edu.uco.sibe.infraestructura.adaptador.mapeador.IdentificacionMapeador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public class IdentificacionRepositorioConsultaImplementacion implements IdentificacionRepositorioConsulta {
    @Autowired
    IdentificacionDAO identificacionDAO;

    @Autowired
    IdentificacionMapeador identificacionMapeador;

    @Override
    public Identificacion consultarPorIdentificador(UUID identificador) {
        var entidad = identificacionDAO.findById(identificador).orElse(null);

        if(ValidadorObjeto.esNulo(entidad)) {
            return null;
        }

        return this.identificacionMapeador.construirModelo(entidad);
    }

    @Override
    public Identificacion consultarPorNumeroIdentificacion(String numeroIdentificacion) {
        var entidad = identificacionDAO.findByNumeroIdentificacion(numeroIdentificacion);

        if(ValidadorObjeto.esNulo(entidad)) {
            return null;
        }

        return this.identificacionMapeador.construirModelo(entidad);
    }
}