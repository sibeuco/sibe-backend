package co.edu.uco.sibe.infraestructura.adaptador.mapeador;

import co.edu.uco.sibe.infraestructura.adaptador.entidad.PublicoInteresEntidad;
import org.springframework.stereotype.Component;

@Component
public class PublicoInteresMapeador {

    public PublicoInteresDTO construirDTO(PublicoInteresEntidad publicoInteres){
        return new PublicoInteresDTO(publicoInteres.getIdentificador(), publicoInteres.getNombre());
    }

    public PublicoInteresEntidad construirEntidad(PublicoInteres publicoInteres){
        return new PublicoInteresEntidad(publicoInteres.getIdentificador(), publicoInteres.getNombre());
    }

}
