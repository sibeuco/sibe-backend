package co.edu.uco.sibe.dominio.usecase.consulta;

import co.edu.uco.sibe.dominio.dto.ContextoUsuarioAutenticado;
import co.edu.uco.sibe.dominio.dto.UsuarioAreaDTO;
import co.edu.uco.sibe.dominio.dto.UsuarioDTO;
import co.edu.uco.sibe.dominio.puerto.consulta.PersonaRepositorioConsulta;
import co.edu.uco.sibe.dominio.service.AutorizacionContextoOrganizacionalServicio;
import co.edu.uco.sibe.dominio.testdatabuilder.ContextoUsuarioAutenticadoTestDataBuilder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.UUID;

import static co.edu.uco.sibe.dominio.transversal.constante.SeguridadConstante.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ConsultarUsuariosUseCaseTest {

    @Mock
    private PersonaRepositorioConsulta personaRepositorioConsulta;

    @Mock
    private AutorizacionContextoOrganizacionalServicio autorizacionServicio;

    private ConsultarUsuariosUseCase useCase;

    @BeforeEach
    void setUp() {
        useCase = new ConsultarUsuariosUseCase(personaRepositorioConsulta, autorizacionServicio);
    }

    @Test
    void deberiaRetornarTodosLosUsuariosCuandoEsAdminDireccion() {
        UUID areaId = UUID.randomUUID();
        ContextoUsuarioAutenticado contexto = new ContextoUsuarioAutenticadoTestDataBuilder()
                .conRol(ADMINISTRADOR_DIRECCION).conAreaId(areaId).construir();

        UsuarioDTO usuario1 = crearUsuarioConArea(areaId);
        UsuarioDTO usuario2 = crearUsuarioConArea(UUID.randomUUID());

        when(personaRepositorioConsulta.consultarUsuariosDTO()).thenReturn(List.of(usuario1, usuario2));
        when(autorizacionServicio.obtenerContexto()).thenReturn(contexto);

        List<UsuarioDTO> resultado = useCase.ejecutar();

        assertEquals(2, resultado.size());
    }

    @Test
    void deberiaFiltrarUsuariosPorAreaCuandoEsAdminArea() {
        UUID areaId = UUID.randomUUID();
        UUID otraAreaId = UUID.randomUUID();
        ContextoUsuarioAutenticado contexto = new ContextoUsuarioAutenticadoTestDataBuilder()
                .conRol(ADMINISTRADOR_AREA).conAreaId(areaId).construir();

        UsuarioDTO usuarioMismaArea = crearUsuarioConArea(areaId);
        UsuarioDTO usuarioOtraArea = crearUsuarioConArea(otraAreaId);

        when(personaRepositorioConsulta.consultarUsuariosDTO()).thenReturn(List.of(usuarioMismaArea, usuarioOtraArea));
        when(autorizacionServicio.obtenerContexto()).thenReturn(contexto);

        List<UsuarioDTO> resultado = useCase.ejecutar();

        assertEquals(1, resultado.size());
        assertEquals(areaId.toString(), resultado.get(0).getArea().getIdentificador());
    }

    private UsuarioDTO crearUsuarioConArea(UUID areaId) {
        UsuarioDTO dto = new UsuarioDTO();
        dto.setIdentificador(UUID.randomUUID().toString());
        UsuarioAreaDTO area = new UsuarioAreaDTO();
        area.setIdentificador(areaId.toString());
        dto.setArea(area);
        return dto;
    }
}
