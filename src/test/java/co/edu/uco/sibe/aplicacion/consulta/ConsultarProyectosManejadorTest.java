package co.edu.uco.sibe.aplicacion.consulta;

import co.edu.uco.sibe.dominio.dto.ProyectoDTO;
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

}
