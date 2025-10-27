package co.edu.uco.sibe.infraestructura.adaptador.mapeador;

import co.edu.uco.sibe.dominio.modelo.CentroCostos;
import co.edu.uco.sibe.infraestructura.adaptador.dao.EmpleadoCentroCostosDAO;
import co.edu.uco.sibe.infraestructura.adaptador.entidad.CentroCostosEntidad;
import co.edu.uco.sibe.infraestructura.adaptador.entidad.EmpleadoCentroCostosEntidad;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import static co.edu.uco.sibe.dominio.transversal.utilitarios.UtilUUID.generar;
import static co.edu.uco.sibe.dominio.transversal.utilitarios.ValidadorObjeto.esNulo;

@Component
@AllArgsConstructor
public class EmpleadoCentroCostosMapeador {
    private final CentroCostosMapeador centroCostosMapeador;
    private final EmpleadoCentroCostosDAO empleadoCentroCostosDAO;

    public EmpleadoCentroCostosEntidad construirEntidad(CentroCostos centroCostos) {
        return new EmpleadoCentroCostosEntidad(
                generar(uuid -> !esNulo(empleadoCentroCostosDAO.findById(uuid).orElse(null))),
                this.centroCostosMapeador.construirEntidad(centroCostos)
        );
    }

    public CentroCostos construirModelo(EmpleadoCentroCostosEntidad empleadoCentroCostosEntidad) {
        return centroCostosMapeador.construirModelo(empleadoCentroCostosEntidad.getCentroCostos());
    }

    public void modificarEntidad(CentroCostosEntidad entidad, CentroCostos centroCostos) {
        entidad.setCodigo(centroCostos.getCodigo());
        entidad.setDescripcion(centroCostos.getDescripcion());
    }
}