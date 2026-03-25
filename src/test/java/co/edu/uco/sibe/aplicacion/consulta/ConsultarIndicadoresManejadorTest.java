package co.edu.uco.sibe.aplicacion.consulta;

import co.edu.uco.sibe.dominio.dto.IndicadorDTO;
import co.edu.uco.sibe.dominio.dto.RespuestaPaginada;
import co.edu.uco.sibe.dominio.dto.SolicitudPaginacion;
import co.edu.uco.sibe.dominio.puerto.consulta.IndicadorRepositorioConsulta;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ConsultarIndicadoresManejadorTest {

    @Mock private IndicadorRepositorioConsulta indicadorRepositorioConsulta;

    private ConsultarIndicadoresManejador manejador;

    @BeforeEach
    void setUp() {
        manejador = new ConsultarIndicadoresManejador(indicadorRepositorioConsulta);
    }

    @Test
    void deberiaConsultarIndicadores() {
        List<IndicadorDTO> esperado = List.of(mock(IndicadorDTO.class));
        when(indicadorRepositorioConsulta.consultarDTOs()).thenReturn(esperado);

        List<IndicadorDTO> resultado = manejador.ejecutar();

        assertEquals(esperado, resultado);
        verify(indicadorRepositorioConsulta).consultarDTOs();
    }

    @Test
    void deberiaConsultarIndicadoresPaginados() {
        SolicitudPaginacion solicitud = new SolicitudPaginacion(0, 10, null, null, null);
        RespuestaPaginada<IndicadorDTO> respuesta = new RespuestaPaginada<>(List.of(mock(IndicadorDTO.class)), 1L, 1, 0);
        when(indicadorRepositorioConsulta.consultarDTOsPaginado(solicitud)).thenReturn(respuesta);

        RespuestaPaginada<IndicadorDTO> resultado = manejador.ejecutar(solicitud);

        assertEquals(respuesta, resultado);
    }
}
