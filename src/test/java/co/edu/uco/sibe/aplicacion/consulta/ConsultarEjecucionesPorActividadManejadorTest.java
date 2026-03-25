package co.edu.uco.sibe.aplicacion.consulta;

import co.edu.uco.sibe.dominio.dto.EjecucionActividadDTO;
import co.edu.uco.sibe.dominio.dto.RespuestaPaginada;
import co.edu.uco.sibe.dominio.dto.SolicitudPaginacion;
import co.edu.uco.sibe.dominio.usecase.consulta.ConsultarEjecucionesPorActividadUseCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ConsultarEjecucionesPorActividadManejadorTest {

    @Mock private ConsultarEjecucionesPorActividadUseCase consultarEjecucionesPorActividadUseCase;

    private ConsultarEjecucionesPorActividadManejador manejador;

    @BeforeEach
    void setUp() {
        manejador = new ConsultarEjecucionesPorActividadManejador(consultarEjecucionesPorActividadUseCase);
    }

    @Test
    void deberiaConsultarEjecucionesPorActividad() {
        List<EjecucionActividadDTO> esperado = List.of(mock(EjecucionActividadDTO.class));
        when(consultarEjecucionesPorActividadUseCase.ejecutar("actividad1")).thenReturn(esperado);

        List<EjecucionActividadDTO> resultado = manejador.ejecutar("actividad1");

        assertEquals(esperado, resultado);
        verify(consultarEjecucionesPorActividadUseCase).ejecutar("actividad1");
    }

    @Test
    void deberiaConsultarEjecucionesPorActividadPaginadas() {
        SolicitudPaginacion solicitud = new SolicitudPaginacion(0, 10, null, null, null);
        RespuestaPaginada<EjecucionActividadDTO> respuesta = new RespuestaPaginada<>(List.of(mock(EjecucionActividadDTO.class)), 1L, 1, 0);
        when(consultarEjecucionesPorActividadUseCase.ejecutar("actividad1", solicitud)).thenReturn(respuesta);

        RespuestaPaginada<EjecucionActividadDTO> resultado = manejador.ejecutar("actividad1", solicitud);

        assertEquals(respuesta, resultado);
    }
}
