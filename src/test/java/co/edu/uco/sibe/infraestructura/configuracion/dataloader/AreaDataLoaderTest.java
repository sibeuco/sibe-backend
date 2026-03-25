package co.edu.uco.sibe.infraestructura.configuracion.dataloader;

import co.edu.uco.sibe.aplicacion.comando.manejador.GuardarAreaManejador;
import co.edu.uco.sibe.aplicacion.consulta.ConsultarSubareasManejador;
import co.edu.uco.sibe.aplicacion.consulta.HayDatosAreaManejador;
import co.edu.uco.sibe.dominio.modelo.Subarea;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AreaDataLoaderTest {

    @Mock private HayDatosAreaManejador hayDatosAreaManejador;
    @Mock private GuardarAreaManejador guardarAreaManejador;
    @Mock private ConsultarSubareasManejador consultarSubareasManejador;

    private AreaDataLoader dataLoader;

    @BeforeEach
    void setUp() {
        dataLoader = new AreaDataLoader(hayDatosAreaManejador, guardarAreaManejador, consultarSubareasManejador);
    }

    @Test
    void deberiaCargarDatosCuandoNoExistenAreas() throws Exception {
        List<Subarea> subareas = List.of(mock(Subarea.class));

        when(hayDatosAreaManejador.ejecutar()).thenReturn(false);
        when(consultarSubareasManejador.ejecutar()).thenReturn(subareas);

        dataLoader.run();

        verify(guardarAreaManejador, times(4)).ejecutar(any());
    }

    @Test
    void noDeberiaCargarDatosCuandoYaExistenAreas() throws Exception {
        when(hayDatosAreaManejador.ejecutar()).thenReturn(true);

        dataLoader.run();

        verify(guardarAreaManejador, never()).ejecutar(any());
    }
}
