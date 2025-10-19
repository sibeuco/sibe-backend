package co.edu.uco.sibe.infraestructura.adaptador.mapeador;

import co.edu.uco.sibe.dominio.modelo.TipoIndicador;
import co.edu.uco.sibe.dominio.transversal.utilitarios.UtilUUID;
import co.edu.uco.sibe.infraestructura.adaptador.dao.IndicadorTipoIndicadorDAO;
import co.edu.uco.sibe.infraestructura.adaptador.entidad.IndicadorTipoIndicadorEntidad;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import java.util.UUID;

@Component
@AllArgsConstructor
public class IndicadorTipoIndicadorMapeador {
    private final TipoIndicadorMapeador tipoIndicadorMapeador;
    private final IndicadorTipoIndicadorDAO indicadorTipoIndicadorDAO;

    public IndicadorTipoIndicadorEntidad construirEntidad(TipoIndicador tipoIndicador) {
        return new IndicadorTipoIndicadorEntidad(
                generarNuevoUUID(),
                this.tipoIndicadorMapeador.construirEntidad(tipoIndicador)
        );
    }

    public TipoIndicador construirModelo(IndicadorTipoIndicadorEntidad tipoIndicador) {
        return tipoIndicadorMapeador.construirModelo(tipoIndicador.getTipoIndicador());
    }

    public UUID generarNuevoUUID() {
        UUID nuevoUUID;

        do {
            nuevoUUID = UtilUUID.generarNuevoUUID();
        } while (indicadorTipoIndicadorDAO.findById(nuevoUUID).orElse(null) != null);

        return nuevoUUID;
    }
}
