package co.edu.uco.sibe.infraestructura.configuracion.bean;

import co.edu.uco.sibe.dominio.puerto.comando.*;
import co.edu.uco.sibe.dominio.puerto.consulta.*;
import co.edu.uco.sibe.dominio.puerto.servicio.EncriptarClaveServicio;
import co.edu.uco.sibe.dominio.puerto.servicio.EnviarCorreoElectronicoService;
import co.edu.uco.sibe.dominio.service.ModificarVinculacionActividadConAreaService;
import co.edu.uco.sibe.dominio.service.ModificarVinculacionUsuarioConAreaService;
import co.edu.uco.sibe.dominio.service.RegistrarParticipanteService;
import co.edu.uco.sibe.dominio.service.VincularActividadConAreaService;
import co.edu.uco.sibe.dominio.service.VincularUsuarioConAreaService;
import co.edu.uco.sibe.dominio.usecase.comando.*;
import co.edu.uco.sibe.dominio.usecase.consulta.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCaseBean {

    @Bean
    public GuardarAccionUseCase agregarNuevaAccionUseCase(AccionRepositorioComando accionRepositorioComando, AccionRepositorioConsulta accionRepositorioConsulta){
        return new GuardarAccionUseCase(accionRepositorioComando, accionRepositorioConsulta);
    }

    @Bean
    public GuardarProyectoUseCase agregarNuevoProyectoUseCase(ProyectoRepositorioComando proyectoRepositorioComando, ProyectoRepositorioConsulta proyectoRepositorioConsulta){
        return new GuardarProyectoUseCase(proyectoRepositorioComando, proyectoRepositorioConsulta);
    }

    @Bean
    public GuardarUsuarioUseCase agregarNuevoUsuarioUseCase(PersonaRepositorioComando personaRepositorioComando, PersonaRepositorioConsulta personaRepositorioConsulta, EncriptarClaveServicio encriptarClaveServicio, VincularUsuarioConAreaService vincularUsuarioConAreaService) {
        return new GuardarUsuarioUseCase(personaRepositorioComando, personaRepositorioConsulta, encriptarClaveServicio, vincularUsuarioConAreaService);
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
    public GuardarTipoUsuarioUseCase guardarTipoUsuarioUseCase(TipoUsuarioRepositorioComando tipoUsuarioRepositorioComando, TipoUsuarioRepositorioConsulta tipoUsuarioRepositorioConsulta) {
        return new GuardarTipoUsuarioUseCase(tipoUsuarioRepositorioComando, tipoUsuarioRepositorioConsulta);
    }

    @Bean
    public GuardarTipoIdentificacionUseCase guardarTipoIdentificacionUseCase(TipoIdentificacionRepositorioComando tipoIdentificacionRepositorioComando, TipoIdentificacionRepositorioConsulta tipoIdentificacionRepositorioConsulta) {
        return new GuardarTipoIdentificacionUseCase(tipoIdentificacionRepositorioComando, tipoIdentificacionRepositorioConsulta);
    }

    @Bean
    public GuardarSubareaUseCase guardarSubareaUseCase(SubareaRepositorioComando subareaRepositorioComando, SubareaRepositorioConsulta subareaRepositorioConsulta) {
        return new GuardarSubareaUseCase(subareaRepositorioComando, subareaRepositorioConsulta);
    }

    @Bean
    public GuardarAreaUseCase guardarAreaUseCase(AreaRepositorioComando areaRepositorioComando, AreaRepositorioConsulta areaRepositorioConsulta) {
        return new GuardarAreaUseCase(areaRepositorioComando, areaRepositorioConsulta);
    }

    @Bean
    public GuardarDireccionUseCase guardarDireccionUseCase(DireccionRepositorioComando direccionRepositorioComando, DireccionRepositorioConsulta direccionRepositorioConsulta) {
        return new GuardarDireccionUseCase(direccionRepositorioComando, direccionRepositorioConsulta);
    }

    @Bean
    public GuardarEstadoActividadUseCase guardarEstadoActividadUseCase(EstadoActividadRepositorioComando estadoActividadRepositorioComando, EstadoActividadRepositorioConsulta estadoActividadRepositorioConsulta) {
        return new GuardarEstadoActividadUseCase(estadoActividadRepositorioComando, estadoActividadRepositorioConsulta);
    }

    @Bean
    public GuardarTemporalidadUseCase guardarTemporalidadUseCase(TemporalidadRepositorioComando temporalidadRepositorioComando, TemporalidadRepositorioConsulta temporalidadRepositorioConsulta) {
        return new GuardarTemporalidadUseCase(temporalidadRepositorioComando, temporalidadRepositorioConsulta);
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

    @Bean
    public GuardarIndicadorUseCase agregarNuevoIndicadorUseCase(IndicadorRepositorioComando indicadorRepositorioComando, IndicadorRepositorioConsulta indicadorRepositorioConsulta) {
        return new GuardarIndicadorUseCase(indicadorRepositorioComando, indicadorRepositorioConsulta);
    }

    @Bean
    public ModificarIndicadorUseCase modificarIndicadorUseCase(IndicadorRepositorioComando indicadorRepositorioComando, IndicadorRepositorioConsulta indicadorRepositorioConsulta) {
        return new ModificarIndicadorUseCase(indicadorRepositorioComando, indicadorRepositorioConsulta);
    }

    @Bean
    public GuardarPublicoInteresUseCase guardarPublicoInteresUseCase(PublicoInteresRepositorioComando publicoInteresRepositorioComando, PublicoInteresRepositorioConsulta publicoInteresRepositorioConsulta) {
        return new GuardarPublicoInteresUseCase(publicoInteresRepositorioComando, publicoInteresRepositorioConsulta);
    }

    @Bean
    public GuardarTipoIndicadorUseCase guardarTipoIndicadorUseCase(TipoIndicadorRepositorioComando tipoIndicadorRepositorioComando, TipoIndicadorRepositorioConsulta tipoIndicadorRepositorioConsulta) {
        return new GuardarTipoIndicadorUseCase(tipoIndicadorRepositorioComando, tipoIndicadorRepositorioConsulta);
    }

    @Bean
    public GuardarActividadUseCase guardarActividadUseCase(ActividadRepositorioComando actividadRepositorioComando, ActividadRepositorioConsulta actividadRepositorioConsulta, VincularActividadConAreaService vincularActividadConAreaService) {
        return new GuardarActividadUseCase(actividadRepositorioComando, actividadRepositorioConsulta, vincularActividadConAreaService);
    }

    @Bean
    public ModificarActividadUseCase modificarActividadUseCase(ActividadRepositorioComando actividadRepositorioComando, ActividadRepositorioConsulta actividadRepositorioConsulta, ModificarVinculacionActividadConAreaService modificarVinculacionActividadConAreaService) {
        return new ModificarActividadUseCase(actividadRepositorioComando, actividadRepositorioConsulta, modificarVinculacionActividadConAreaService);
    }

    @Bean
    public ConsultarActividadesPorAreaUseCase consultarActividadesPorAreaUseCase(ActividadRepositorioConsulta actividadRepositorioConsulta, AreaRepositorioConsulta areaRepositorioConsulta) {
        return new ConsultarActividadesPorAreaUseCase(actividadRepositorioConsulta, areaRepositorioConsulta);
    }

    @Bean
    public ConsultarActividadesPorDireccionUseCase consultarActividadesPorDireccionUseCase(ActividadRepositorioConsulta actividadRepositorioConsulta, DireccionRepositorioConsulta direccionRepositorioConsulta) {
        return new ConsultarActividadesPorDireccionUseCase(actividadRepositorioConsulta, direccionRepositorioConsulta);
    }

    @Bean
    public ConsultarActividadesPorSubareaUseCase consultarActividadesPorSubareaUseCase(ActividadRepositorioConsulta actividadRepositorioConsulta, SubareaRepositorioConsulta subareaRepositorioConsulta) {
        return new ConsultarActividadesPorSubareaUseCase(actividadRepositorioConsulta, subareaRepositorioConsulta);
    }

    @Bean
    public ConsultarEjecucionesPorActividadUseCase consultarEjecucionesPorActividadUseCase(ActividadRepositorioConsulta actividadRepositorioConsulta) {
        return new ConsultarEjecucionesPorActividadUseCase(actividadRepositorioConsulta);
    }

    @Bean
    public ConsultarMiembroPorIdentificacionUseCase consultarMiembroPorIdentificacionUseCase(MiembroRepositorioConsulta miembroRepositorioConsulta) {
        return new ConsultarMiembroPorIdentificacionUseCase(miembroRepositorioConsulta);
    }

    @Bean
    public ConsultarMiembroPorIdCarnetUseCase consultarMiembroPorIdCarnetUseCase(MiembroRepositorioConsulta miembroRepositorioConsulta) {
        return new ConsultarMiembroPorIdCarnetUseCase(miembroRepositorioConsulta);
    }

    @Bean
    public IniciarActividadUseCase iniciarActividadUseCase(ActividadRepositorioComando actividadRepositorioComando, ActividadRepositorioConsulta actividadRepositorioConsulta, EstadoActividadRepositorioConsulta estadoActividadRepositorioConsulta) {
        return new IniciarActividadUseCase(actividadRepositorioComando, actividadRepositorioConsulta, estadoActividadRepositorioConsulta);
    }

    @Bean
    public FinalizarActividadUseCase finalizarActividadUseCase(ActividadRepositorioComando actividadRepositorioComando, ActividadRepositorioConsulta actividadRepositorioConsulta, EstadoActividadRepositorioConsulta estadoActividadRepositorioConsulta, RegistrarParticipanteService registrarParticipanteService, RegistroAsistenciaRepositorioComando registroAsistenciaRepositorioComando, RegistroAsistenciaRepositorioConsulta registroAsistenciaRepositorioConsulta) {
        return new FinalizarActividadUseCase(actividadRepositorioComando, actividadRepositorioConsulta, estadoActividadRepositorioConsulta, registrarParticipanteService, registroAsistenciaRepositorioComando, registroAsistenciaRepositorioConsulta);
    }
}