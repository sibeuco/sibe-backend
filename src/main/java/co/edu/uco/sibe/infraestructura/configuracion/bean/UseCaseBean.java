package co.edu.uco.sibe.infraestructura.configuracion.bean;

import co.edu.uco.sibe.dominio.puerto.comando.*;
import co.edu.uco.sibe.dominio.puerto.consulta.*;
import co.edu.uco.sibe.dominio.puerto.servicio.EncriptarClaveServicio;
import co.edu.uco.sibe.dominio.puerto.servicio.EnviarCorreoElectronicoService;
import co.edu.uco.sibe.dominio.service.ModificarVinculacionUsuarioConAreaService;
import co.edu.uco.sibe.dominio.service.VincularUsuarioConAreaService;
import co.edu.uco.sibe.dominio.usecase.comando.*;
import co.edu.uco.sibe.dominio.usecase.consulta.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCaseBean {
    @Bean
    public AgregarNuevaAccionUseCase agregarNuevaAccionUseCase(AccionRepositorioComando accionRepositorioComando, AccionRepositorioConsulta accionRepositorioConsulta){
        return new AgregarNuevaAccionUseCase(accionRepositorioComando, accionRepositorioConsulta);
    }

    @Bean
    public AgregarNuevoProyectoUseCase agregarNuevoProyectoUseCase(ProyectoRepositorioComando proyectoRepositorioComando, ProyectoRepositorioConsulta proyectoRepositorioConsulta){
        return new AgregarNuevoProyectoUseCase(proyectoRepositorioComando, proyectoRepositorioConsulta);
    }

    @Bean
    public AgregarNuevoUsuarioUseCase agregarNuevoUsuarioUseCase(PersonaRepositorioComando personaRepositorioComando, PersonaRepositorioConsulta personaRepositorioConsulta, EncriptarClaveServicio encriptarClaveServicio, VincularUsuarioConAreaService vincularUsuarioConAreaService) {
        return new AgregarNuevoUsuarioUseCase(personaRepositorioComando, personaRepositorioConsulta, encriptarClaveServicio, vincularUsuarioConAreaService);
    }

    @Bean
    public EliminarUsuarioUseCase eliminarUsuarioUseCase(PersonaRepositorioComando personaRepositorioComando, PersonaRepositorioConsulta personaRepositorioConsulta) {
        return new EliminarUsuarioUseCase(personaRepositorioComando, personaRepositorioConsulta);
    }

    @Bean
    public ModificarUsuarioUseCase modificarUsuarioUseCase(PersonaRepositorioComando personaRepositorioComando, PersonaRepositorioConsulta personaRepositorioConsulta, ModificarVinculacionUsuarioConAreaService modificarVinculacionUsuarioConAreaServicea) {
        return new ModificarUsuarioUseCase(personaRepositorioComando, personaRepositorioConsulta, modificarVinculacionUsuarioConAreaServicea);
    }

    @Bean
    public ModificarContrasenaUseCase modificarContrasenaUseCase(PersonaRepositorioComando personaRepositorioComando, PersonaRepositorioConsulta personaRepositorioConsulta) {
        return new ModificarContrasenaUseCase(personaRepositorioComando, personaRepositorioConsulta);
    }

    @Bean
    public LoginUseCase loginUseCase(PersonaRepositorioConsulta personaRepositorioConsulta, EncriptarClaveServicio encryptTextService) {
        return new LoginUseCase(personaRepositorioConsulta, encryptTextService);
    }

    @Bean
    public ConsultarUsuarioPorIdentificadorUseCase consultarUsuarioPorIdentificadorUseCase(PersonaRepositorioConsulta personaRepositorioConsulta) {
        return new ConsultarUsuarioPorIdentificadorUseCase(personaRepositorioConsulta);
    }

    @Bean
    public ConsultarUsuarioPorCorreoUseCase consultarUsuarioPorCorreoUseCase(PersonaRepositorioConsulta personaRepositorioConsulta) {
        return new ConsultarUsuarioPorCorreoUseCase(personaRepositorioConsulta);
    }

    @Bean
    public ConsultarUsuariosUseCase consultarUsuariosUseCase(PersonaRepositorioConsulta personaRepositorioConsulta) {
        return new ConsultarUsuariosUseCase(personaRepositorioConsulta);
    }

    @Bean
    public ConsultarDireccionPorNombreUseCase consultarDireccionPorNombreUseCase(DireccionRepositorioConsulta direccionRepositorioConsulta) {
        return new ConsultarDireccionPorNombreUseCase(direccionRepositorioConsulta);
    }

    @Bean
    public ConsultarTipoIdentificacionPorSiglaUseCase consultarTipoIdentificacionPorSiglaUseCase(TipoIdentificacionRepositorioConsulta tipoIdentificacionRepositorioConsulta) {
        return new ConsultarTipoIdentificacionPorSiglaUseCase(tipoIdentificacionRepositorioConsulta);
    }

    @Bean
    public ConsultarTipoUsuarioPorCodigoUseCase consultarTipoUsuarioPorCodigoUseCase(TipoUsuarioRepositorioConsulta tipoUsuarioRepositorioConsulta) {
        return new ConsultarTipoUsuarioPorCodigoUseCase(tipoUsuarioRepositorioConsulta);
    }

    @Bean
    public GuardarTipoUsuarioUseCase guardarTipoUsuarioUseCase(TipoUsuarioRepositorioComando tipoUsuarioRepositorioComando) {
        return new GuardarTipoUsuarioUseCase(tipoUsuarioRepositorioComando);
    }

    @Bean
    public GuardarTipoIdentificacionUseCase guardarTipoIdentificacionUseCase(TipoIdentificacionRepositorioComando tipoIdentificacionRepositorioComando) {
        return new GuardarTipoIdentificacionUseCase(tipoIdentificacionRepositorioComando);
    }

    @Bean
    public GuardarSubareaUseCase guardarSubareaUseCase(SubareaRepositorioComando subareaRepositorioComando) {
        return new GuardarSubareaUseCase(subareaRepositorioComando);
    }

    @Bean
    public GuardarAreaUseCase guardarAreaUseCase(AreaRepositorioComando areaRepositorioComando) {
        return new GuardarAreaUseCase(areaRepositorioComando);
    }

    @Bean
    public GuardarDireccionUseCase guardarDireccionUseCase(DireccionRepositorioComando direccionRepositorioComando) {
        return new GuardarDireccionUseCase(direccionRepositorioComando);
    }

    @Bean
    public GuardarEstadoActividadUseCase guardarEstadoActividadUseCase(EstadoActividadRepositorioComando estadoActividadRepositorioComando) {
        return new GuardarEstadoActividadUseCase(estadoActividadRepositorioComando);
    }

    @Bean
    public GuardarTemporalidadUseCase guardarTemporalidadUseCase(TemporalidadRepositorioComando temporalidadRepositorioComando) {
        return new GuardarTemporalidadUseCase(temporalidadRepositorioComando);
    }

    @Bean
    public SolicitarCodigoUseCase solicitarCodigoUseCase(PersonaRepositorioConsulta personaRepositorioConsulta, PersonaRepositorioComando personaRepositorioComando, EncriptarClaveServicio encriptarClaveServicio, EnviarCorreoElectronicoService enviarCorreoElectronicoService) {
        return new SolicitarCodigoUseCase(personaRepositorioConsulta, personaRepositorioComando, encriptarClaveServicio, enviarCorreoElectronicoService);
    }

    @Bean
    public ValidarCodigoRecuperacionClaveUseCase validarCodigoRecuperacionClaveUseCase(PersonaRepositorioConsulta personaRepositorioConsulta, PersonaRepositorioComando personaRepositorioComando, EncriptarClaveServicio encriptarClaveServicio) {
        return new ValidarCodigoRecuperacionClaveUseCase(personaRepositorioConsulta, personaRepositorioComando, encriptarClaveServicio);
    }

    @Bean
    public RecuperarClaveUseCase recuperarClaveUseCase(PersonaRepositorioComando personaRepositorioComando, PersonaRepositorioConsulta personaRepositorioConsulta, EncriptarClaveServicio encriptarClaveServicio) {
        return new RecuperarClaveUseCase(personaRepositorioComando, personaRepositorioConsulta, encriptarClaveServicio);
    }

    @Bean
    public ModificarClaveUseCase modificarClaveUseCase(PersonaRepositorioComando personaRepositorioComando, PersonaRepositorioConsulta personaRepositorioConsulta, EncriptarClaveServicio encriptarClaveServicio) {
        return new ModificarClaveUseCase(personaRepositorioComando, personaRepositorioConsulta, encriptarClaveServicio);
    }

    @Bean
    public CargarMasivamenteEmpleadosUseCase cargarMasivamenteEmpleadosUseCase(EmpleadoRepositorioComando empleadoRepositorioComando, EmpleadoRepositorioConsulta empleadoRepositorioConsulta) {
        return new CargarMasivamenteEmpleadosUseCase(empleadoRepositorioComando, empleadoRepositorioConsulta);
    }

    @Bean
    public CargarMasivamenteEstudiantesUseCase cargarMasivamenteEstudiantesUseCase(EstudianteRepositorioComando estudianteRepositorioComando, EstudianteRepositorioConsulta estudianteRepositorioConsulta) {
        return new CargarMasivamenteEstudiantesUseCase(estudianteRepositorioComando, estudianteRepositorioConsulta);
    }

    @Bean
    public ModificarAccionUseCase modificarAccionUseCase(AccionRepositorioComando accionRepositorioComando, AccionRepositorioConsulta accionRepositorioConsulta) {
        return new ModificarAccionUseCase(accionRepositorioComando, accionRepositorioConsulta);
    }

    @Bean
    public ModificarProyectoUseCase modificarProyectoUseCase(ProyectoRepositorioComando proyectoRepositorioComando, ProyectoRepositorioConsulta proyectoRepositorioConsulta) {
        return new ModificarProyectoUseCase(proyectoRepositorioComando, proyectoRepositorioConsulta);
    }
}