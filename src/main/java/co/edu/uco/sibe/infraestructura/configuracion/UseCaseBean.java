package co.edu.uco.sibe.infraestructura.configuracion;

import co.edu.uco.sibe.dominio.puerto.comando.*;
import co.edu.uco.sibe.dominio.puerto.consulta.*;
import co.edu.uco.sibe.dominio.usecase.comando.*;
import co.edu.uco.sibe.dominio.usecase.consulta.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCaseBean {

    @Bean
    public AgregarNuevoUsuarioUseCase agregarNuevoUsuarioUseCase(PersonaRepositorioComando personaRepositorioComando, PersonaRepositorioConsulta personaRepositorioConsulta){
        return new AgregarNuevoUsuarioUseCase(personaRepositorioComando, personaRepositorioConsulta);
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
    public ConsultarAreaPorIdentificadorUseCase consultarAreaPorIdentificadorUseCase(AreaRepositorioConsulta areaRepositorioConsulta){
        return new ConsultarAreaPorIdentificadorUseCase(areaRepositorioConsulta);
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
    public ConsultarPersonaPorDocumentoUseCase consultarPersonaPorDocumentoUseCase(PersonaRepositorioConsulta personaRepositorioConsulta){
        return new ConsultarPersonaPorDocumentoUseCase(personaRepositorioConsulta);
    }

    @Bean
    public ConsultarPersonasUseCase consultarPersonasUseCase(PersonaRepositorioConsulta personaRepositorioConsulta){
        return new ConsultarPersonasUseCase(personaRepositorioConsulta);
    }

    @Bean
    public ConsultarTipoAreaPorIdentificadorUseCase consultarTipoAreaPorIdentificadorUseCase(TipoAreaRepositorioConsulta tipoAreaRepositorioConsulta){
        return new ConsultarTipoAreaPorIdentificadorUseCase(tipoAreaRepositorioConsulta);
    }

    @Bean
    public ConsultarTiposAreaUseCase consultarTiposAreaUseCase(TipoAreaRepositorioConsulta tipoAreaRepositorioConsulta){
        return new ConsultarTiposAreaUseCase(tipoAreaRepositorioConsulta);
    }

    @Bean
    public ConsultarTipoIdentificacionPorIdentificadorUseCase consultarTipoIdentificacionPorIdentificadorUseCase(TipoIdentificacionRepositorioConsulta tipoIdentificacionRepositorioConsulta){
        return new ConsultarTipoIdentificacionPorIdentificadorUseCase(tipoIdentificacionRepositorioConsulta);
    }

    @Bean
    public ConsultarTiposIdentificacionUseCase consultarTiposIdentificacionUseCase(TipoIdentificacionRepositorioConsulta tipoIdentificacionRepositorioConsulta){
        return new ConsultarTiposIdentificacionUseCase(tipoIdentificacionRepositorioConsulta);
    }

    @Bean
    public ConsultarTipoUsuarioPorIdentificadorUseCase consultarTipoUsuarioPorIdentificador(TipoUsuarioRepositorioConsulta tipoUsuarioRepositorioConsulta){
        return new ConsultarTipoUsuarioPorIdentificadorUseCase(tipoUsuarioRepositorioConsulta);
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
