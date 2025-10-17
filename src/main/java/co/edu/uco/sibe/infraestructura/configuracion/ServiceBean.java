package co.edu.uco.sibe.infraestructura.configuracion;

import co.edu.uco.sibe.dominio.puerto.comando.UsuarioOrganizacionComando;
import co.edu.uco.sibe.dominio.service.ModificarVinculacionUsuarioConAreaService;
import co.edu.uco.sibe.dominio.service.VincularUsuarioConAreaService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceBean {
    @Bean
    public VincularUsuarioConAreaService vincularUsuarioConAreaService(UsuarioOrganizacionComando usuarioOrganizacionComando) {
        return new VincularUsuarioConAreaService(usuarioOrganizacionComando);
    }

    @Bean
    public ModificarVinculacionUsuarioConAreaService modificarVinculacionUsuarioConAreaService(UsuarioOrganizacionComando usuarioOrganizacionComando) {
        return new ModificarVinculacionUsuarioConAreaService(usuarioOrganizacionComando);
    }
}
