package co.edu.uco.sibe.infraestructura.adaptador.repositorio.consulta;

import co.edu.uco.sibe.dominio.modelo.Area;
import co.edu.uco.sibe.dominio.puerto.consulta.AreaRepositorioConsulta;
import co.edu.uco.sibe.dominio.transversal.constante.NumeroConstante;
import co.edu.uco.sibe.dominio.transversal.utilitarios.ValidadorNumero;
import co.edu.uco.sibe.dominio.transversal.utilitarios.ValidadorObjeto;
import co.edu.uco.sibe.infraestructura.adaptador.dao.AreaDAO;
import co.edu.uco.sibe.infraestructura.adaptador.mapeador.AreaMapeador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public class AreaRepositorioConsultaImplementacion implements AreaRepositorioConsulta {
    @Autowired
    private AreaDAO areaDAO;

    @Autowired
    private AreaMapeador areaMapeador;

    @Override
    public List<Area> consultarTodos() {
        var entidades = this.areaDAO.findAll();

        return this.areaMapeador.construirModelos(entidades);
    }

    @Override
    public Area consultarPorIdentificador(UUID identificador) {
        var entidad = this.areaDAO.findById(identificador).orElse(null);

        if(ValidadorObjeto.esNulo(entidad)) {
            return null;
        }

        return this.areaMapeador.construirModelo(entidad);
    }

    @Override
    public boolean hayDatos() {
        var cantidad = areaDAO.count();

        return ValidadorNumero.esNumeroMayor(cantidad, NumeroConstante.CERO);
    }
}