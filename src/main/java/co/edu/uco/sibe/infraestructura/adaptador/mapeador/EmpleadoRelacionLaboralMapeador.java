package co.edu.uco.sibe.infraestructura.adaptador.mapeador;

import co.edu.uco.sibe.dominio.modelo.RelacionLaboral;
import co.edu.uco.sibe.infraestructura.adaptador.dao.EmpleadoRelacionLaboralDAO;
import co.edu.uco.sibe.infraestructura.adaptador.dao.RelacionLaboralDAO;
import co.edu.uco.sibe.infraestructura.adaptador.entidad.EmpleadoRelacionLaboralEntidad;
import co.edu.uco.sibe.infraestructura.adaptador.entidad.RelacionLaboralEntidad;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import static co.edu.uco.sibe.dominio.transversal.utilitarios.UtilUUID.generar;
import static co.edu.uco.sibe.dominio.transversal.utilitarios.ValidadorObjeto.esNulo;

@Component
@AllArgsConstructor
public class EmpleadoRelacionLaboralMapeador {
    private final RelacionLaboralMapeador relacionLaboralMapeador;
    private final EmpleadoRelacionLaboralDAO empleadoRelacionLaboralDAO;
    private final RelacionLaboralDAO relacionLaboralDAO;

    public EmpleadoRelacionLaboralEntidad construirEntidad(RelacionLaboral relacionLaboral) {
        var relacionLaboralEncontrada = relacionLaboralDAO.findByCodigo(relacionLaboral.getCodigo());

        return new EmpleadoRelacionLaboralEntidad(
                generar(uuid -> !esNulo(empleadoRelacionLaboralDAO.findById(uuid).orElse(null))),
                esNulo(relacionLaboralEncontrada) ? relacionLaboralDAO.save(this.relacionLaboralMapeador.construirEntidad(relacionLaboral)) : relacionLaboralEncontrada
        );
    }

    public RelacionLaboral construirModelo(EmpleadoRelacionLaboralEntidad empleadoRelacionLaboralEntidad) {
        return relacionLaboralMapeador.construirModelo(empleadoRelacionLaboralEntidad.getRelacionLaboral());
    }

    public void modificarEntidad(RelacionLaboralEntidad entidad, RelacionLaboral relacionLaboral) {
        entidad.setCodigo(relacionLaboral.getCodigo());
        entidad.setDescripcion(relacionLaboral.getDescripcion());
    }
}