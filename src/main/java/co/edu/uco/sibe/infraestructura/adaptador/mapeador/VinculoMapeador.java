package co.edu.uco.sibe.infraestructura.adaptador.mapeador;

import org.springframework.stereotype.Component;

@Component
public class VinculoMapeador {

    public VinculoDTO construirDTO(VinculoEntidad vinculo){
        return new VinculoDTO(vinculo.getIdentificador(), vinculo.getNombre());
    }

    public VinculoEntidad construirEntidad(Vinculo vinculo){
        return new VinculoEntidad(vinculo.getIdentificador(), vinculo.getNombre());
    }

}
