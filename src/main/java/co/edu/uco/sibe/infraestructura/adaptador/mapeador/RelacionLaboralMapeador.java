package co.edu.uco.sibe.infraestructura.adaptador.mapeador;

import co.edu.uco.sibe.dominio.modelo.RelacionLaboral;
import co.edu.uco.sibe.infraestructura.adaptador.entidad.CentroCostosEntidad;
import co.edu.uco.sibe.infraestructura.adaptador.entidad.RelacionLaboralEntidad;
import org.springframework.stereotype.Component;

@Component
public class RelacionLaboralMapeador {
    public RelacionLaboral construirModelo(RelacionLaboralEntidad relacionLaboralEntidad) {
        return RelacionLaboral.construir(
                relacionLaboralEntidad.getIdentificador(),
                relacionLaboralEntidad.getCodigo(),
                relacionLaboralEntidad.getDescripcion()
        );
    }

    public RelacionLaboralEntidad construirEntidad(RelacionLaboral relacionLaboral) {
        return new RelacionLaboralEntidad(
                relacionLaboral.getIdentificador(),
                relacionLaboral.getCodigo(),
                relacionLaboral.getDescripcion()
        );
    }
}