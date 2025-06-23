package co.edu.uco.sibe.infraestructura.controlador;

import co.edu.uco.sibe.aplicacion.comando.manejador.LoginManejador;
import co.edu.uco.sibe.aplicacion.transversal.ComandoRespuesta;
import co.edu.uco.sibe.dominio.transversal.constante.TextoConstante;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.UUID;

@RestController
@AllArgsConstructor
public class LoginControlador {
    private final LoginManejador loginManejador;

    @RequestMapping(TextoConstante.LOGIN_API)
    public ComandoRespuesta<UUID> login(Principal usuario){
        return this.loginManejador.ejecutar(usuario.getName());
    }

}
