package co.edu.uco.sibe.infraestructura.controlador.consulta;

import co.edu.uco.sibe.aplicacion.consulta.ConsultarProyectosManejador;
import co.edu.uco.sibe.dominio.dto.ProyectoDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ProyectoConsultaControladorTest {

    @Mock
    private ConsultarProyectosManejador consultarProyectosManejador;

    private ProyectoConsultaControlador controlador;

    @BeforeEach
    void setUp() {
        controlador = new ProyectoConsultaControlador(consultarProyectosManejador);
    }

    @Test
    void deberiaConsultarTodos() {
        List<ProyectoDTO> proyectos = List.of(new ProyectoDTO("1", "P001", "Proyecto 1", "Objetivo"));
        when(consultarProyectosManejador.ejecutar()).thenReturn(proyectos);

        List<ProyectoDTO> resultado = controlador.consultarTodos();

        assertEquals(1, resultado.size());
        verify(consultarProyectosManejador).ejecutar();
    }

}
