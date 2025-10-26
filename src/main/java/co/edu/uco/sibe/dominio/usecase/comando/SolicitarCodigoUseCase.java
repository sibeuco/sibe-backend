package co.edu.uco.sibe.dominio.usecase.comando;

import co.edu.uco.sibe.dominio.puerto.comando.PersonaRepositorioComando;
import co.edu.uco.sibe.dominio.puerto.consulta.PersonaRepositorioConsulta;
import co.edu.uco.sibe.dominio.puerto.servicio.EncriptarClaveServicio;
import co.edu.uco.sibe.dominio.puerto.servicio.EnviarCorreoElectronicoService;
import co.edu.uco.sibe.dominio.transversal.excepcion.ValorInvalidoExcepcion;
import co.edu.uco.sibe.dominio.transversal.utilitarios.UtilMensaje;
import co.edu.uco.sibe.dominio.transversal.utilitarios.ValidadorObjeto;

import java.time.LocalDateTime;
import java.util.UUID;

import static co.edu.uco.sibe.dominio.transversal.constante.TextoConstante.*;

public class SolicitarCodigoUseCase {
    private final PersonaRepositorioConsulta personaRepositorioConsulta;
    private final PersonaRepositorioComando personaRepositorioComando;
    private final EncriptarClaveServicio encriptarClaveServicio;
    private final EnviarCorreoElectronicoService enviarCorreoElectronicoService;

    public SolicitarCodigoUseCase(PersonaRepositorioConsulta personaRepositorioConsulta, PersonaRepositorioComando personaRepositorioComando, EncriptarClaveServicio encriptarClaveServicio, EnviarCorreoElectronicoService enviarCorreoElectronicoService) {
        this.personaRepositorioConsulta = personaRepositorioConsulta;
        this.personaRepositorioComando = personaRepositorioComando;
        this.encriptarClaveServicio = encriptarClaveServicio;
        this.enviarCorreoElectronicoService = enviarCorreoElectronicoService;
    }

    public UUID ejecutar(String correo) {
        validarSiNoExisteUsuarioConCoreo(correo);

        var codigo = (UUID.randomUUID()).toString().replace(GUION, VACIO).substring(0, 6);
        var codigoCifrado = this.encriptarClaveServicio.ejecutar(codigo);
        var fecha = LocalDateTime.now();

        this.enviarCorreoElectronicoService.enviarCorreo(correo, ASUNTO_CORREO, codigo);

        return personaRepositorioComando.crearPeticionRecuperacionClave(codigoCifrado, correo, fecha);
    }

    private void validarSiNoExisteUsuarioConCoreo(String correo) {
        if (ValidadorObjeto.esNulo(this.personaRepositorioConsulta.consultarUsuarioPorCorreo(correo))) {
            throw new ValorInvalidoExcepcion(UtilMensaje.obtenerNoExisteUsuarioConCorreo(correo));
        }
    }
}
