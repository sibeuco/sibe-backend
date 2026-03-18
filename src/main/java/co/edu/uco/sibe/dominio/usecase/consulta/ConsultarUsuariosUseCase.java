package co.edu.uco.sibe.dominio.usecase.consulta;

import co.edu.uco.sibe.dominio.dto.ContextoUsuarioAutenticado;
import co.edu.uco.sibe.dominio.dto.UsuarioDTO;
import co.edu.uco.sibe.dominio.puerto.consulta.PersonaRepositorioConsulta;
import co.edu.uco.sibe.dominio.service.AutorizacionContextoOrganizacionalServicio;
import co.edu.uco.sibe.dominio.transversal.excepcion.ValorInvalidoExcepcion;

import java.util.List;

import static co.edu.uco.sibe.dominio.transversal.constante.MensajesErrorConstante.NO_SE_ECONTRARON_USUARIOS;
import static co.edu.uco.sibe.dominio.transversal.constante.SeguridadConstante.ADMINISTRADOR_DIRECCION;

public class ConsultarUsuariosUseCase {
    private final PersonaRepositorioConsulta personaRepositorioConsulta;
    private final AutorizacionContextoOrganizacionalServicio autorizacionServicio;

    public ConsultarUsuariosUseCase(PersonaRepositorioConsulta personaRepositorioConsulta,
            AutorizacionContextoOrganizacionalServicio autorizacionServicio) {
        this.personaRepositorioConsulta = personaRepositorioConsulta;
        this.autorizacionServicio = autorizacionServicio;
    }

    public List<UsuarioDTO> ejecutar() {
        List<UsuarioDTO> usuarios = personaRepositorioConsulta.consultarUsuariosDTO();

        if (usuarios.isEmpty()) {
            throw new ValorInvalidoExcepcion(NO_SE_ECONTRARON_USUARIOS);
        }

        ContextoUsuarioAutenticado contexto = autorizacionServicio.obtenerContexto();
        if (ADMINISTRADOR_DIRECCION.equals(contexto.getRol())) {
            return usuarios;
        }

        return usuarios.stream()
                .filter(u -> u.getArea() != null && u.getArea().getIdentificador() != null
                        && u.getArea().getIdentificador().equals(contexto.getAreaId().toString()))
                .toList();
    }
}