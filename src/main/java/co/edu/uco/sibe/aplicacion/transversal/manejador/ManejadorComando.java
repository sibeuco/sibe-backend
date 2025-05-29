package co.edu.uco.sibe.aplicacion.transversal.manejador;

import org.springframework.transaction.annotation.Transactional;

public interface ManejadorComando<C> {
    @Transactional
    void ejecutar(C comando);
}
