package co.edu.uco.sibe.aplicacion.consulta;

import co.edu.uco.sibe.dominio.dto.AccionDTO;
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

}
