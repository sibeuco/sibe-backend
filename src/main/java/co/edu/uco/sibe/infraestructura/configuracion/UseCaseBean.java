package co.edu.uco.sibe.infraestructura.configuracion;

import co.edu.uco.sibe.dominio.puerto.comando.PersonaRepositorioComando;
import co.edu.uco.sibe.dominio.puerto.consulta.PersonaRepositorioConsulta;
import co.edu.uco.sibe.dominio.puerto.consulta.TipoIdentificacionRepositorioConsulta;
import co.edu.uco.sibe.dominio.puerto.consulta.TipoUsuarioRepositorioConsulta;
import co.edu.uco.sibe.dominio.puerto.servicio.EncriptarClaveServicio;
import co.edu.uco.sibe.dominio.service.ModificarVinculacionUsuarioConAreaService;
import co.edu.uco.sibe.dominio.service.VincularUsuarioConAreaService;
import co.edu.uco.sibe.dominio.usecase.comando.*;
import co.edu.uco.sibe.dominio.usecase.consulta.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCaseBean {
    @Bean
    public AgregarNuevoUsuarioUseCase agregarNuevoUsuarioUseCase(PersonaRepositorioComando personaRepositorioComando, PersonaRepositorioConsulta personaRepositorioConsulta, EncriptarClaveServicio encriptarClaveServicio, VincularUsuarioConAreaService vincularUsuarioConAreaService){
        return new AgregarNuevoUsuarioUseCase(personaRepositorioComando, personaRepositorioConsulta, encriptarClaveServicio, vincularUsuarioConAreaService);
    }

    @Bean
    public EliminarUsuarioUseCase eliminarUsuarioUseCase(PersonaRepositorioComando personaRepositorioComando, PersonaRepositorioConsulta personaRepositorioConsulta){
        return new EliminarUsuarioUseCase(personaRepositorioComando, personaRepositorioConsulta);
    }

    @Bean
    public ModificarUsuarioUseCase modificarUsuarioUseCase(PersonaRepositorioComando personaRepositorioComando, PersonaRepositorioConsulta personaRepositorioConsulta, ModificarVinculacionUsuarioConAreaService modificarVinculacionUsuarioConAreaServicea){
        return new ModificarUsuarioUseCase(personaRepositorioComando, personaRepositorioConsulta, modificarVinculacionUsuarioConAreaServicea);
    }

    @Bean
    public ModificarContrasenaUseCase modificarContrasenaUseCase(PersonaRepositorioComando personaRepositorioComando, PersonaRepositorioConsulta personaRepositorioConsulta){
        return new ModificarContrasenaUseCase(personaRepositorioComando, personaRepositorioConsulta);
    }

    @Bean
    public LoginUseCase loginUseCase(PersonaRepositorioConsulta personaRepositorioConsulta, EncriptarClaveServicio encryptTextService) {
        return new LoginUseCase(personaRepositorioConsulta, encryptTextService);
    }

    @Bean
    public ConsultarTiposIdentificacionUseCase consultarTiposIdentificacionUseCase(TipoIdentificacionRepositorioConsulta tipoIdentificacionRepositorioConsulta){
        return new ConsultarTiposIdentificacionUseCase(tipoIdentificacionRepositorioConsulta);
    }

    @Bean
    public ConsultarTiposUsuarioUseCase consultarTiposUsuarioUseCase(TipoUsuarioRepositorioConsulta tipoUsuarioRepositorioConsulta){
        return new ConsultarTiposUsuarioUseCase(tipoUsuarioRepositorioConsulta);
    }

    @Bean
    public ConsultarUsuarioPorIdentificadorUseCase consultarUsuarioPorIdentificadorUseCase(PersonaRepositorioConsulta personaRepositorioConsulta){
        return new ConsultarUsuarioPorIdentificadorUseCase(personaRepositorioConsulta);
    }

    @Bean
    public ConsultarUsuarioPorCorreoUseCase consultarUsuarioPorCorreoUseCase(PersonaRepositorioConsulta personaRepositorioConsulta){
        return new ConsultarUsuarioPorCorreoUseCase(personaRepositorioConsulta);
    }

    @Bean
    public ConsultarUsuariosUseCase consultarUsuariosUseCase(PersonaRepositorioConsulta personaRepositorioConsulta){
        return new ConsultarUsuariosUseCase(personaRepositorioConsulta);
    }
}