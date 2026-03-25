package co.edu.uco.sibe.aplicacion.consulta;

import co.edu.uco.sibe.dominio.dto.AccionDTO;
import co.edu.uco.sibe.dominio.dto.RespuestaPaginada;
import co.edu.uco.sibe.dominio.dto.SolicitudPaginacion;
import co.edu.uco.sibe.dominio.puerto.consulta.AccionRepositorioConsulta;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ConsultarAccionesManejadorTest {

    @Mock private AccionRepositorioConsulta accionRepositorioConsulta;

    private ConsultarAccionesManejador manejador;

    @BeforeEach
    void setUp() {
        manejador = new ConsultarAccionesManejador(accionRepositorioConsulta);
    }

    @Test
    void deberiaConsultarAcciones() {
        List<AccionDTO> esperado = List.of(mock(AccionDTO.class));
        when(accionRepositorioConsulta.consultarDTOs()).thenReturn(esperado);

        List<AccionDTO> resultado = manejador.ejecutar();

        assertEquals(esperado, resultado);
        verify(accionRepositorioConsulta).consultarDTOs();
    }

    @Test
    void deberiaConsultarAccionesPaginadas() {
        SolicitudPaginacion solicitud = new SolicitudPaginacion(0, 10, null, null, null);
        RespuestaPaginada<AccionDTO> respuesta = new RespuestaPaginada<>(List.of(mock(AccionDTO.class)), 1L, 1, 0);
        when(accionRepositorioConsulta.consultarDTOsPaginado(solicitud)).thenReturn(respuesta);

        RespuestaPaginada<AccionDTO> resultado = manejador.ejecutar(solicitud);

        assertEquals(respuesta, resultado);
    }
}
