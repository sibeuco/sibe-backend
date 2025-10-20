package co.edu.uco.sibe.infraestructura.adaptador.mapeador;

import co.edu.uco.sibe.dominio.modelo.PublicoInteres;
import co.edu.uco.sibe.infraestructura.adaptador.entidad.PublicoInteresEntidad;
import org.springframework.stereotype.Component;

@Component
public class PublicoInteresMapeador {
    public PublicoInteresEntidad construirEntidad(PublicoInteres publicoInteres) {
        return new PublicoInteresEntidad(publicoInteres.getIdentificador(), publicoInteres.getNombre());
    }

    public PublicoInteres construriModelo(PublicoInteresEntidad publicoInteres) {
        return PublicoInteres.construir(publicoInteres.getIdentificador(), publicoInteres.getNombre());
    }
}
