package co.edu.uco.sibe.aplicacion.consulta;

import co.edu.uco.sibe.dominio.dto.ProyectoDTO;
import co.edu.uco.sibe.dominio.dto.RespuestaPaginada;
import co.edu.uco.sibe.dominio.dto.SolicitudPaginacion;
import co.edu.uco.sibe.dominio.puerto.consulta.ProyectoRepositorioConsulta;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ConsultarProyectosManejadorTest {

    @Mock private ProyectoRepositorioConsulta proyectoRepositorioConsulta;

    private ConsultarProyectosManejador manejador;

    @BeforeEach
    void setUp() {
        manejador = new ConsultarProyectosManejador(proyectoRepositorioConsulta);
    }

    @Test
    void deberiaConsultarProyectos() {
        List<ProyectoDTO> esperado = List.of(mock(ProyectoDTO.class));
        when(proyectoRepositorioConsulta.consultarDTOs()).thenReturn(esperado);

        List<ProyectoDTO> resultado = manejador.ejecutar();

        assertEquals(esperado, resultado);
        verify(proyectoRepositorioConsulta).consultarDTOs();
    }

    @Test
    void deberiaConsultarProyectosPaginados() {
        SolicitudPaginacion solicitud = new SolicitudPaginacion(0, 10, null, null, null);
        RespuestaPaginada<ProyectoDTO> respuesta = new RespuestaPaginada<>(List.of(mock(ProyectoDTO.class)), 1L, 1, 0);
        when(proyectoRepositorioConsulta.consultarDTOsPaginado(solicitud)).thenReturn(respuesta);

        RespuestaPaginada<ProyectoDTO> resultado = manejador.ejecutar(solicitud);

        assertEquals(respuesta, resultado);
    }
}
