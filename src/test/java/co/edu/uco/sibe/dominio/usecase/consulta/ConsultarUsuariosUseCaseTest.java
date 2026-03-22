package co.edu.uco.sibe.dominio.usecase.consulta;

import co.edu.uco.sibe.dominio.dto.ContextoUsuarioAutenticado;
import co.edu.uco.sibe.dominio.dto.UsuarioAreaDTO;
import co.edu.uco.sibe.dominio.dto.UsuarioDTO;
import co.edu.uco.sibe.dominio.modelo.Area;
import co.edu.uco.sibe.dominio.modelo.Subarea;
import co.edu.uco.sibe.dominio.puerto.consulta.AreaRepositorioConsulta;
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

    @Mock
    private AreaRepositorioConsulta areaRepositorioConsulta;

    private ConsultarUsuariosUseCase useCase;

    @BeforeEach
    void setUp() {
        useCase = new ConsultarUsuariosUseCase(personaRepositorioConsulta, autorizacionServicio, areaRepositorioConsulta);
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
    void deberiaFiltrarUsuariosPorAreaYSubareasCuandoEsAdminArea() {
        UUID areaId = UUID.randomUUID();
        UUID subareaId = UUID.randomUUID();
        UUID otraAreaId = UUID.randomUUID();
        ContextoUsuarioAutenticado contexto = new ContextoUsuarioAutenticadoTestDataBuilder()
                .conRol(ADMINISTRADOR_AREA).conAreaId(areaId).construir();

        UsuarioDTO usuarioMismaArea = crearUsuarioConArea(areaId);
        UsuarioDTO usuarioSubarea = crearUsuarioConArea(subareaId);
        UsuarioDTO usuarioOtraArea = crearUsuarioConArea(otraAreaId);

        when(personaRepositorioConsulta.consultarUsuariosDTO()).thenReturn(List.of(usuarioMismaArea, usuarioSubarea, usuarioOtraArea));
        when(autorizacionServicio.obtenerContexto()).thenReturn(contexto);

        Subarea subarea = Subarea.construir(subareaId, "SubareaTest", null);
        Area area = Area.construir(areaId, "AreaTest", List.of(subarea), null);
        when(areaRepositorioConsulta.consultarPorIdentificador(areaId)).thenReturn(area);

        List<UsuarioDTO> resultado = useCase.ejecutar();

        assertEquals(2, resultado.size());
        assertTrue(resultado.stream().anyMatch(u -> u.getArea().getIdentificador().equals(areaId.toString())));
        assertTrue(resultado.stream().anyMatch(u -> u.getArea().getIdentificador().equals(subareaId.toString())));
        assertFalse(resultado.stream().anyMatch(u -> u.getArea().getIdentificador().equals(otraAreaId.toString())));
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
