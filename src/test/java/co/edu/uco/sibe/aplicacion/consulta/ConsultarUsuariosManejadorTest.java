package co.edu.uco.sibe.aplicacion.consulta;

import co.edu.uco.sibe.dominio.dto.RespuestaPaginada;
import co.edu.uco.sibe.dominio.dto.SolicitudPaginacion;
import co.edu.uco.sibe.dominio.dto.UsuarioDTO;
import co.edu.uco.sibe.dominio.usecase.consulta.ConsultarUsuariosUseCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ConsultarUsuariosManejadorTest {

    @Mock private ConsultarUsuariosUseCase consultarUsuariosUseCase;

    private ConsultarUsuariosManejador manejador;

    @BeforeEach
    void setUp() {
        manejador = new ConsultarUsuariosManejador(consultarUsuariosUseCase);
    }

    @Test
    void deberiaConsultarUsuarios() {
        List<UsuarioDTO> esperado = List.of(mock(UsuarioDTO.class));
        when(consultarUsuariosUseCase.ejecutar()).thenReturn(esperado);

        List<UsuarioDTO> resultado = manejador.ejecutar();

        assertEquals(esperado, resultado);
        verify(consultarUsuariosUseCase).ejecutar();
    }

    @Test
    void deberiaConsultarUsuariosPaginados() {
        SolicitudPaginacion solicitud = new SolicitudPaginacion(0, 10, null, null, null);
        RespuestaPaginada<UsuarioDTO> respuesta = new RespuestaPaginada<>(List.of(mock(UsuarioDTO.class)), 1L, 1, 0);
        when(consultarUsuariosUseCase.ejecutar(solicitud, null, null)).thenReturn(respuesta);

        RespuestaPaginada<UsuarioDTO> resultado = manejador.ejecutar(solicitud, null, null);

        assertEquals(respuesta, resultado);
    }
}
