package co.edu.uco.sibe.infraestructura.configuracion;

import co.edu.uco.sibe.dominio.puerto.comando.*;
import co.edu.uco.sibe.dominio.puerto.consulta.*;
import co.edu.uco.sibe.dominio.puerto.servicio.EncriptarClaveServicio;
import co.edu.uco.sibe.dominio.usecase.comando.*;
import co.edu.uco.sibe.dominio.usecase.consulta.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class UseCaseBean {

    @Bean
    public AgregarNuevoUsuarioUseCase agregarNuevoUsuarioUseCase(PersonaRepositorioComando personaRepositorioComando, PersonaRepositorioConsulta personaRepositorioConsulta, EncriptarClaveServicio encriptarClaveServicio){
        return new AgregarNuevoUsuarioUseCase(personaRepositorioComando, personaRepositorioConsulta, encriptarClaveServicio);
    }

    @Bean
    public EliminarUsuarioUseCase eliminarUsuarioUseCase(PersonaRepositorioComando personaRepositorioComando, PersonaRepositorioConsulta personaRepositorioConsulta){
        return new EliminarUsuarioUseCase(personaRepositorioComando, personaRepositorioConsulta);
    }

    @Bean
    public ModificarPersonaUseCase modificarPersonaUseCase(PersonaRepositorioComando personaRepositorioComando, PersonaRepositorioConsulta personaRepositorioConsulta){
        return new ModificarPersonaUseCase(personaRepositorioComando, personaRepositorioConsulta);
    }

    @Bean
    public ModificarUsuarioUseCase modificarUsuarioUseCase(PersonaRepositorioComando personaRepositorioComando, PersonaRepositorioConsulta personaRepositorioConsulta){
        return new ModificarUsuarioUseCase(personaRepositorioComando, personaRepositorioConsulta);
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
    public ConsultarAreasUseCase consultarAreasUseCase(AreaRepositorioConsulta areaRepositorioConsulta){
        return new ConsultarAreasUseCase(areaRepositorioConsulta);
    }

    @Bean
    public ConsultarPersonaPorIdentificadorUseCase consultarPersonaPorIdentificadorUseCase(PersonaRepositorioConsulta personaRepositorioConsulta){
        return new ConsultarPersonaPorIdentificadorUseCase(personaRepositorioConsulta);
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
