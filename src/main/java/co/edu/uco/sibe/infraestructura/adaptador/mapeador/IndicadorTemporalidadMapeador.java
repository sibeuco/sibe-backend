package co.edu.uco.sibe.infraestructura.adaptador.mapeador;

import co.edu.uco.sibe.dominio.modelo.PublicoInteres;
import co.edu.uco.sibe.dominio.modelo.Temporalidad;
import co.edu.uco.sibe.dominio.transversal.utilitarios.UtilUUID;
import co.edu.uco.sibe.infraestructura.adaptador.dao.IndicadorPublicoInteresDAO;
import co.edu.uco.sibe.infraestructura.adaptador.dao.IndicadorTemporalidadDAO;
import co.edu.uco.sibe.infraestructura.adaptador.entidad.IndicadorPublicoInteresEntidad;
import co.edu.uco.sibe.infraestructura.adaptador.entidad.IndicadorTemporalidadEntidad;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import java.util.UUID;

@Component
@AllArgsConstructor
public class IndicadorTemporalidadMapeador {
    private final TemporalidadMapeador temporalidadMapeador;
    private final IndicadorTemporalidadDAO indicadorTemporalidadDAO;

    public IndicadorTemporalidadEntidad construirEntidad(Temporalidad temporalidad) {
        return new IndicadorTemporalidadEntidad(
                generarNuevoUUID(),
                this.temporalidadMapeador.construirEntidad(temporalidad)
        );
    }

    public Temporalidad construirModelo(IndicadorTemporalidadEntidad temporalidad) {
        return this.temporalidadMapeador.construirModelo(temporalidad.getTemporalidad());
    }

    public UUID generarNuevoUUID() {
        UUID nuevoUUID;

        do {
            nuevoUUID = UtilUUID.generarNuevoUUID();
        } while (indicadorTemporalidadDAO.findById(nuevoUUID).orElse(null) != null);

        return nuevoUUID;
    }
}