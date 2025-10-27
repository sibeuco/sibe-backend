package co.edu.uco.sibe.dominio.usecase.comando;

import co.edu.uco.sibe.dominio.enums.TipoArea;
import co.edu.uco.sibe.dominio.modelo.Persona;
import co.edu.uco.sibe.dominio.modelo.Usuario;
import co.edu.uco.sibe.dominio.puerto.comando.PersonaRepositorioComando;
import co.edu.uco.sibe.dominio.puerto.consulta.IdentificacionRepositorioConsulta;
import co.edu.uco.sibe.dominio.puerto.consulta.PersonaRepositorioConsulta;
import co.edu.uco.sibe.dominio.puerto.servicio.EncriptarClaveServicio;
import co.edu.uco.sibe.dominio.regla.TipoOperacion;
import co.edu.uco.sibe.dominio.regla.fabrica.MotoresFabrica;
import co.edu.uco.sibe.dominio.service.VincularUsuarioConAreaService;
import co.edu.uco.sibe.dominio.transversal.excepcion.ValorDuplicadoExcepcion;
import co.edu.uco.sibe.dominio.transversal.utilitarios.ValidadorObjeto;

import java.util.UUID;

import static co.edu.uco.sibe.dominio.transversal.utilitarios.UtilMensaje.*;

public class AgregarNuevoUsuarioUseCase {
    private final PersonaRepositorioComando personaRepositorioComando;
    private final PersonaRepositorioConsulta personaRepositorioConsulta;
    private final EncriptarClaveServicio encriptarClaveServicio;
    private final VincularUsuarioConAreaService vincularUsuarioConAreaService;

    public AgregarNuevoUsuarioUseCase(PersonaRepositorioComando personaRepositorioComando, PersonaRepositorioConsulta personaRepositorioConsulta, EncriptarClaveServicio encriptarClaveServicio, VincularUsuarioConAreaService vincularUsuarioConAreaService) {
        this.personaRepositorioComando = personaRepositorioComando;
        this.personaRepositorioConsulta = personaRepositorioConsulta;
        this.encriptarClaveServicio = encriptarClaveServicio;
        this.vincularUsuarioConAreaService = vincularUsuarioConAreaService;
    }

    public UUID ejecutar(Usuario usuario, Persona persona, UUID area, TipoArea tipoArea){
        MotoresFabrica.MOTOR_USUARIO.ejecutar(usuario, TipoOperacion.CREAR);
        MotoresFabrica.MOTOR_IDENTIFICACION.ejecutar(persona.getIdentificacion(), TipoOperacion.CREAR);
        MotoresFabrica.MOTOR_PERSONA.ejecutar(persona, TipoOperacion.CREAR);

        validarUsuarioExisteConCorreo(usuario.getCorreo());
        validarUsuarioExisteConDocumento(persona.getIdentificacion().getNumeroIdentificacion());

        var claveEncriptada = this.encriptarClaveServicio.ejecutar(usuario.getClave());
        var identificador = this.personaRepositorioComando.agregarNuevoUsuario(usuario, persona, claveEncriptada);

        this.vincularUsuarioConAreaService.ejecutar(identificador, area, tipoArea);

        return identificador;
    }

    private void validarUsuarioExisteConCorreo(String correo) {
        if (!ValidadorObjeto.esNulo(this.personaRepositorioConsulta.consultarUsuarioPorCorreo(correo))){
            throw new ValorDuplicadoExcepcion(CORREO_EXISTENTE);
        }
    }

    private void validarUsuarioExisteConDocumento(String numeroIdentificacion) {
        if (!ValidadorObjeto.esNulo(this.personaRepositorioConsulta.consultarPersonaPorDocumento(numeroIdentificacion))){
            throw new ValorDuplicadoExcepcion(DOCUMENTO_EXISTENTE);
        }
    }
}