package co.edu.uco.sibe.infraestructura.adaptador.mapeador;

import co.edu.uco.sibe.dominio.modelo.PublicoInteres;
import co.edu.uco.sibe.infraestructura.adaptador.dao.IndicadorPublicoInteresDAO;
import co.edu.uco.sibe.infraestructura.adaptador.entidad.IndicadorPublicoInteresEntidad;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import static co.edu.uco.sibe.dominio.transversal.utilitarios.UtilUUID.generar;
import static co.edu.uco.sibe.dominio.transversal.utilitarios.ValidadorObjeto.esNulo;

@Component
@AllArgsConstructor
public class IndicadorPublicoInteresMapeador {
    private final PublicoInteresMapeador publicoInteresMapeador;
    private final IndicadorPublicoInteresDAO indicadorPublicoInteresDAO;

    public IndicadorPublicoInteresEntidad construirEntidad(PublicoInteres publicoInteres) {
        return new IndicadorPublicoInteresEntidad(
                generar(uuid -> !esNulo(indicadorPublicoInteresDAO.findById(uuid).orElse(null))),
                this.publicoInteresMapeador.construirEntidad(publicoInteres)
        );
    }

    public PublicoInteres construirModelo(IndicadorPublicoInteresEntidad publicoInteres) {
        return publicoInteresMapeador.construriModelo(publicoInteres.getPublicoInteres());
    }
}