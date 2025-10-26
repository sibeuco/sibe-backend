package co.edu.uco.sibe.dominio.usecase.comando;

import co.edu.uco.sibe.dominio.puerto.comando.PersonaRepositorioComando;
import co.edu.uco.sibe.dominio.puerto.consulta.PersonaRepositorioConsulta;
import co.edu.uco.sibe.dominio.puerto.servicio.EncriptarClaveServicio;
import co.edu.uco.sibe.dominio.regla.TipoOperacion;
import co.edu.uco.sibe.dominio.regla.fabrica.MotoresFabrica;
import co.edu.uco.sibe.dominio.transversal.excepcion.ValorInvalidoExcepcion;
import co.edu.uco.sibe.dominio.transversal.utilitarios.ValidadorObjeto;
import java.util.UUID;
import static co.edu.uco.sibe.dominio.transversal.utilitarios.UtilMensaje.*;

public class ModificarClaveUseCase {
    private final PersonaRepositorioComando personaRepositorioComando;
    private final PersonaRepositorioConsulta personaRepositorioConsulta;
    private final EncriptarClaveServicio encriptarClaveServicio;

    public ModificarClaveUseCase(PersonaRepositorioComando personaRepositorioComando, PersonaRepositorioConsulta personaRepositorioConsulta, EncriptarClaveServicio encriptarClaveServicio) {
        this.personaRepositorioComando = personaRepositorioComando;
        this.personaRepositorioConsulta = personaRepositorioConsulta;
        this.encriptarClaveServicio = encriptarClaveServicio;
    }

    public UUID ejecutar(String claveAntigua, String claveNueva, UUID identificador) {
        validarSiNoExisteUsuarioConIdentificador(identificador);
        validarSiClaveNuevaNoEsLaAntigua(claveAntigua, claveNueva);

        var persona = this.personaRepositorioConsulta.consultarPersonaPorIdentificador(identificador);
        var usuario = this.personaRepositorioConsulta.consultarUsuarioPorCorreo(persona.getCorreo());

        validarSiClaveAntiguaExiste(claveAntigua, usuario.getCorreo());

        usuario.actualizarClave(claveNueva);

        MotoresFabrica.MOTOR_USUARIO.ejecutar(usuario, TipoOperacion.ACTUALIZAR);

        var claveCifrada = this.encriptarClaveServicio.ejecutar(usuario.getClave());

        return this.personaRepositorioComando.modificarClave(claveCifrada, identificador);
    }

    private void validarSiNoExisteUsuarioConIdentificador(UUID identificador) {
        if (ValidadorObjeto.esNulo(this.personaRepositorioConsulta.consultarPersonaPorIdentificador(identificador))) {
            throw new NullPointerException(obtenerNoExisteUsuarioConId(identificador));
        }
    }

    private void validarSiClaveNuevaNoEsLaAntigua(String claveAntigua, String claveNueva) {
        if (claveNueva.equals(claveAntigua)) {
            throw new ValorInvalidoExcepcion(LA_CLAVE_NUEVA_NO_PUEDE_SER_IGUAL_A_LA_ANTIGUA);
        }
    }

    private void validarSiClaveAntiguaExiste(String claveAntigua, String correo) {
        var claveCifrada = this.personaRepositorioConsulta.consultarClaveConCorreo(correo);

        if (!this.encriptarClaveServicio.existe(claveAntigua, claveCifrada)) {
            throw new ValorInvalidoExcepcion(LA_CLAVE_ANTIGUA_ES_INCORRECTA);
        }
    }
}
