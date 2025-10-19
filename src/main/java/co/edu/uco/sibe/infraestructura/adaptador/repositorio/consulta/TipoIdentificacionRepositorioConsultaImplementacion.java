package co.edu.uco.sibe.infraestructura.adaptador.repositorio.consulta;

import co.edu.uco.sibe.dominio.dto.TipoIdentificacionDTO;
import co.edu.uco.sibe.dominio.modelo.TipoIdentificacion;
import co.edu.uco.sibe.dominio.puerto.consulta.TipoIdentificacionRepositorioConsulta;
import co.edu.uco.sibe.dominio.transversal.constante.NumeroConstante;
import co.edu.uco.sibe.dominio.transversal.utilitarios.ValidadorNumero;
import co.edu.uco.sibe.dominio.transversal.utilitarios.ValidadorObjeto;
import co.edu.uco.sibe.infraestructura.adaptador.dao.TipoIdentificacionDAO;
import co.edu.uco.sibe.infraestructura.adaptador.mapeador.TipoIdentificacionMapeador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.UUID;

@Repository
public class TipoIdentificacionRepositorioConsultaImplementacion implements TipoIdentificacionRepositorioConsulta {
    @Autowired
    TipoIdentificacionDAO tipoIdentificacionDAO;

    @Autowired
    TipoIdentificacionMapeador tipoIdentificacionMapeador;

    @Override
    public List<TipoIdentificacionDTO> consultarDTOs() {
        var entidades = this.tipoIdentificacionDAO.findAll();

        return this.tipoIdentificacionMapeador.construirDTOs(entidades);
    }

    @Override
    public TipoIdentificacion consultarPorIdentificador(UUID identificador) {
        var entidad = this.tipoIdentificacionDAO.findById(identificador).orElse(null);

        if (ValidadorObjeto.esNulo(entidad)){
            return null;
        }

        return this.tipoIdentificacionMapeador.construirModelo(entidad);
    }

    @Override
    public boolean hayDatos() {
        var cantidad = tipoIdentificacionDAO.count();

        return ValidadorNumero.esNumeroMayor(cantidad, NumeroConstante.CERO);
    }
}