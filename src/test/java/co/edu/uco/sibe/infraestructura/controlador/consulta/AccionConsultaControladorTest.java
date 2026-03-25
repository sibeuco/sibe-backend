package co.edu.uco.sibe.infraestructura.controlador.consulta;

import co.edu.uco.sibe.aplicacion.consulta.ConsultarAccionesManejador;
import co.edu.uco.sibe.dominio.dto.AccionDTO;
import co.edu.uco.sibe.dominio.dto.RespuestaPaginada;
import co.edu.uco.sibe.dominio.dto.SolicitudPaginacion;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AccionConsultaControladorTest {

    @Mock
    private ConsultarAccionesManejador consultarAccionesManejador;

    private AccionConsultaControlador controlador;

    @BeforeEach
    void setUp() {
        controlador = new AccionConsultaControlador(consultarAccionesManejador);
    }

    @Test
    void deberiaConsultarTodos() {
        List<AccionDTO> acciones = List.of(new AccionDTO("1", "Detalle", "Objetivo"));
        when(consultarAccionesManejador.ejecutar()).thenReturn(acciones);

        List<AccionDTO> resultado = controlador.consultarTodos();

        assertEquals(1, resultado.size());
        verify(consultarAccionesManejador).ejecutar();
    }

    @Test
    void deberiaConsultarTodosPaginado() {
        RespuestaPaginada<AccionDTO> respuesta = new RespuestaPaginada<>(List.of(new AccionDTO("1", "D", "O")), 1L, 1, 0);
        when(consultarAccionesManejador.ejecutar(any(SolicitudPaginacion.class))).thenReturn(respuesta);

        RespuestaPaginada<AccionDTO> resultado = controlador.consultarTodosPaginado(0, 10, null, null, null);

        assertEquals(1, resultado.getContenido().size());
    }
}
