package co.edu.uco.sibe.aplicacion.consulta;

import co.edu.uco.sibe.dominio.dto.ActividadDTO;
import co.edu.uco.sibe.dominio.dto.RespuestaPaginada;
import co.edu.uco.sibe.dominio.dto.SolicitudPaginacion;
import co.edu.uco.sibe.dominio.usecase.consulta.ConsultarActividadesPorAreaUseCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ConsultarActividadesPorAreaManejadorTest {

    @Mock private ConsultarActividadesPorAreaUseCase consultarActividadesPorAreaUseCase;

    private ConsultarActividadesPorAreaManejador manejador;

    @BeforeEach
    void setUp() {
        manejador = new ConsultarActividadesPorAreaManejador(consultarActividadesPorAreaUseCase);
    }

    @Test
    void deberiaConsultarActividadesPorArea() {
        List<ActividadDTO> esperado = List.of(mock(ActividadDTO.class));
        when(consultarActividadesPorAreaUseCase.ejecutar("area1")).thenReturn(esperado);

        List<ActividadDTO> resultado = manejador.ejecutar("area1");

        assertEquals(esperado, resultado);
        verify(consultarActividadesPorAreaUseCase).ejecutar("area1");
    }

    @Test
    void deberiaConsultarActividadesPorAreaPaginadas() {
        SolicitudPaginacion solicitud = new SolicitudPaginacion(0, 10, null, null, null);
        RespuestaPaginada<ActividadDTO> respuesta = new RespuestaPaginada<>(List.of(mock(ActividadDTO.class)), 1L, 1, 0);
        when(consultarActividadesPorAreaUseCase.ejecutar("area1", solicitud)).thenReturn(respuesta);

        RespuestaPaginada<ActividadDTO> resultado = manejador.ejecutar("area1", solicitud);

        assertEquals(respuesta, resultado);
    }
}
