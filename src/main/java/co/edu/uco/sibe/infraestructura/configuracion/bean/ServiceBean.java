package co.edu.uco.sibe.infraestructura.configuracion.bean;

import co.edu.uco.sibe.dominio.puerto.comando.AreaRepositorioComando;
import co.edu.uco.sibe.dominio.puerto.comando.DireccionRepositorioComando;
import co.edu.uco.sibe.dominio.puerto.comando.SubareaRepositorioComando;
import co.edu.uco.sibe.dominio.puerto.comando.UsuarioOrganizacionComando;
import co.edu.uco.sibe.dominio.puerto.consulta.AreaRepositorioConsulta;
import co.edu.uco.sibe.dominio.puerto.consulta.DireccionRepositorioConsulta;
import co.edu.uco.sibe.dominio.puerto.consulta.SubareaRepositorioConsulta;
import co.edu.uco.sibe.dominio.service.ModificarVinculacionActividadConAreaService;
import co.edu.uco.sibe.dominio.service.ModificarVinculacionUsuarioConAreaService;
import co.edu.uco.sibe.dominio.service.VincularActividadConAreaService;
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

    @Bean
    public VincularActividadConAreaService vincularActividadConAreaService(
            SubareaRepositorioComando subareaRepositorioComando,
            AreaRepositorioComando areaRepositorioComando,
            DireccionRepositorioComando direccionRepositorioComando) {
        return new VincularActividadConAreaService(subareaRepositorioComando, areaRepositorioComando, direccionRepositorioComando);
    }

    @Bean
    public ModificarVinculacionActividadConAreaService modificarVinculacionActividadConAreaService(
            SubareaRepositorioComando subareaRepositorioComando,
            AreaRepositorioComando areaRepositorioComando,
            DireccionRepositorioComando direccionRepositorioComando,
            SubareaRepositorioConsulta subareaRepositorioConsulta,
            AreaRepositorioConsulta areaRepositorioConsulta,
            DireccionRepositorioConsulta direccionRepositorioConsulta,
            VincularActividadConAreaService vincularActividadConAreaService) {
        return new ModificarVinculacionActividadConAreaService(
                subareaRepositorioComando,
                areaRepositorioComando,
                direccionRepositorioComando,
                subareaRepositorioConsulta,
                areaRepositorioConsulta,
                direccionRepositorioConsulta,
                vincularActividadConAreaService
        );
    }
}