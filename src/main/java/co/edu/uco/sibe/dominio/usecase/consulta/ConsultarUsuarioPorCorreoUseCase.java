package co.edu.uco.sibe.dominio.usecase.consulta;

import co.edu.uco.sibe.dominio.dto.UsuarioDTO;
import co.edu.uco.sibe.dominio.puerto.consulta.PersonaRepositorioConsulta;
import co.edu.uco.sibe.dominio.service.AutorizacionContextoOrganizacionalServicio;
import co.edu.uco.sibe.dominio.transversal.excepcion.ValorInvalidoExcepcion;
import static co.edu.uco.sibe.dominio.transversal.constante.MensajesErrorConstante.NO_EXISTE_USUARIO_CON_CORREO;
import static co.edu.uco.sibe.dominio.transversal.constante.MensajesSistemaConstante.obtenerMensajeConParametro;
import static co.edu.uco.sibe.dominio.transversal.utilitarios.ValidadorObjeto.esNulo;

public class ConsultarUsuarioPorCorreoUseCase {
    private final PersonaRepositorioConsulta personaRepositorioConsulta;
    private final AutorizacionContextoOrganizacionalServicio autorizacionServicio;

    public ConsultarUsuarioPorCorreoUseCase(PersonaRepositorioConsulta personaRepositorioConsulta,
            AutorizacionContextoOrganizacionalServicio autorizacionServicio) {
        this.personaRepositorioConsulta = personaRepositorioConsulta;
        this.autorizacionServicio = autorizacionServicio;
    }

    public UsuarioDTO ejecutar(String correo) {
        validarSiNoExisteUsuarioConCorreo(correo);

        var resultado = personaRepositorioConsulta.consultarUsuarioPorCorreoDTO(correo);
        if (resultado != null && resultado.getIdentificador() != null) {
            autorizacionServicio.validarAccesoAUsuario(java.util.UUID.fromString(resultado.getIdentificador()));
        }
        return resultado;

    }

    private void validarSiNoExisteUsuarioConCorreo(String correo) {
        if (esNulo(this.personaRepositorioConsulta.consultarUsuarioPorCorreo(correo))) {
            throw new ValorInvalidoExcepcion(obtenerMensajeConParametro(NO_EXISTE_USUARIO_CON_CORREO, correo));
        }
    }
}