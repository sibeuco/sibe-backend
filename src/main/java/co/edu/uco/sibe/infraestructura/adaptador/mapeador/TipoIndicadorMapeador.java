package co.edu.uco.sibe.infraestructura.adaptador.mapeador;

import co.edu.uco.sibe.dominio.modelo.TipoIndicador;
import co.edu.uco.sibe.infraestructura.adaptador.entidad.TipoIndicadorEntidad;
import org.springframework.stereotype.Component;

@Component
public class TipoIndicadorMapeador {
    public TipoIndicadorEntidad construirEntidad(TipoIndicador tipoIndicador){
        return new TipoIndicadorEntidad(tipoIndicador.getIdentificador(), tipoIndicador.getNaturaleza(), tipoIndicador.getTipologia());
    }

    public TipoIndicador construirModelo(TipoIndicadorEntidad tipoIndicador){
        return TipoIndicador.construir(tipoIndicador.getIdentificador(), tipoIndicador.getNaturaleza(), tipoIndicador.getTipologia());
    }
}
