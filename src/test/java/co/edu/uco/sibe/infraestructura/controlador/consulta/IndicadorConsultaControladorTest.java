package co.edu.uco.sibe.infraestructura.controlador.consulta;

import co.edu.uco.sibe.aplicacion.consulta.ConsultarIndicadoresManejador;
import co.edu.uco.sibe.aplicacion.consulta.ConsultarIndicadoresParaActividadesManejador;
import co.edu.uco.sibe.dominio.dto.IndicadorDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class IndicadorConsultaControladorTest {

    @Mock private ConsultarIndicadoresManejador consultarIndicadoresManejador;
    @Mock private ConsultarIndicadoresParaActividadesManejador consultarIndicadoresParaActividadesManejador;

    private IndicadorConsultaControlador controlador;

    @BeforeEach
    void setUp() {
        controlador = new IndicadorConsultaControlador(consultarIndicadoresManejador, consultarIndicadoresParaActividadesManejador);
    }

    @Test
    void deberiaConsultarTodos() {
        List<IndicadorDTO> indicadores = List.of();
        when(consultarIndicadoresManejador.ejecutar()).thenReturn(indicadores);

        List<IndicadorDTO> resultado = controlador.consultarTodos();

        assertEquals(0, resultado.size());
    }

    @Test
    void deberiaConsultarParaActividades() {
        List<IndicadorDTO> indicadores = List.of();
        when(consultarIndicadoresParaActividadesManejador.ejecutar()).thenReturn(indicadores);

        List<IndicadorDTO> resultado = controlador.consultarParaActividades();

        assertNotNull(resultado);
    }

}
