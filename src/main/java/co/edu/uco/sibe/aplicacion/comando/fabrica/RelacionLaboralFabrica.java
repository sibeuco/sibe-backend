package co.edu.uco.sibe.aplicacion.comando.fabrica;

import co.edu.uco.sibe.dominio.modelo.RelacionLaboral;
import org.springframework.stereotype.Component;
import java.util.UUID;

@Component
public class RelacionLaboralFabrica {
    public RelacionLaboral construir(String codigo, String descripcion) {
        return RelacionLaboral.construir(UUID.randomUUID(), codigo, descripcion);
    }
}
