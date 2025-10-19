package co.edu.uco.sibe.infraestructura.adaptador.mapeador;

import co.edu.uco.sibe.dominio.modelo.PublicoInteres;
import co.edu.uco.sibe.dominio.transversal.utilitarios.UtilUUID;
import co.edu.uco.sibe.infraestructura.adaptador.dao.IndicadorPublicoInteresDAO;
import co.edu.uco.sibe.infraestructura.adaptador.entidad.IndicadorPublicoInteresEntidad;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import java.util.UUID;

@Component
@AllArgsConstructor
public class IndicadorPublicoInteresMapeador {
    private final PublicoInteresMapeador publicoInteresMapeador;
    private final IndicadorPublicoInteresDAO indicadorPublicoInteresDAO;

    public IndicadorPublicoInteresEntidad construirEntidad(PublicoInteres publicoInteres) {
        return new IndicadorPublicoInteresEntidad(
                generarNuevoUUID(),
                this.publicoInteresMapeador.construirEntidad(publicoInteres)
        );
    }

    public PublicoInteres construirModelo(IndicadorPublicoInteresEntidad publicoInteres) {
        return publicoInteresMapeador.construriModelo(publicoInteres.getPublicoInteres());
    }

    public UUID generarNuevoUUID() {
        UUID nuevoUUID;

        do {
            nuevoUUID = UtilUUID.generarNuevoUUID();
        } while (indicadorPublicoInteresDAO.findById(nuevoUUID).orElse(null) != null);

        return nuevoUUID;
    }
}