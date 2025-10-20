package co.edu.uco.sibe.dominio.transversal.excepcion;

import co.edu.uco.sibe.dominio.transversal.constante.NumeroConstante;
import java.io.Serial;

public class AuthorizationException extends RuntimeException {
    @Serial
    private static final long serialVersionUID = NumeroConstante.UNO_LONG;

    public AuthorizationException(String message) {
        super(message);
    }
}