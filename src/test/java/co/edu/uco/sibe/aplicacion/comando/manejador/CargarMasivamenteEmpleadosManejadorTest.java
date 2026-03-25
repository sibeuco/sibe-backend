package co.edu.uco.sibe.aplicacion.comando.manejador;

import co.edu.uco.sibe.aplicacion.comando.fabrica.EmpleadoFabrica;
import co.edu.uco.sibe.aplicacion.puerto.servicio.ProcesadorArchivoEmpleadoServicio;
import co.edu.uco.sibe.aplicacion.transversal.ComandoRespuesta;
import co.edu.uco.sibe.dominio.modelo.Empleado;
import co.edu.uco.sibe.dominio.usecase.comando.CargarMasivamenteEmpleadosUseCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CargarMasivamenteEmpleadosManejadorTest {

    @Mock private ProcesadorArchivoEmpleadoServicio procesadorArchivoEmpleadoServicio;
    @Mock private EmpleadoFabrica empleadoFabrica;
    @Mock private CargarMasivamenteEmpleadosUseCase cargarMasivamenteEmpleadosUseCase;

    private CargarMasivamenteEmpleadosManejador manejador;

    @BeforeEach
    void setUp() {
        manejador = new CargarMasivamenteEmpleadosManejador(procesadorArchivoEmpleadoServicio, empleadoFabrica, cargarMasivamenteEmpleadosUseCase);
    }

    @Test
    void deberiaEjecutarCargarMasivamenteEmpleados() {
        MultipartFile archivo = mock(MultipartFile.class);
        var empleadoComando = mock(co.edu.uco.sibe.aplicacion.comando.DatosEmpleadoComando.class);
        Empleado empleado = mock(Empleado.class);
        UUID idEsperado = UUID.randomUUID();

        when(procesadorArchivoEmpleadoServicio.procesar(archivo)).thenReturn(List.of(empleadoComando));
        when(empleadoFabrica.construir(empleadoComando)).thenReturn(empleado);
        when(cargarMasivamenteEmpleadosUseCase.ejecutar(empleado)).thenReturn(idEsperado);

        ComandoRespuesta<List<UUID>> resultado = manejador.ejecutar(archivo);

        assertEquals(1, resultado.getValor().size());
        assertEquals(idEsperado, resultado.getValor().get(0));
        verify(procesadorArchivoEmpleadoServicio).procesar(archivo);
        verify(empleadoFabrica).construir(empleadoComando);
        verify(cargarMasivamenteEmpleadosUseCase).ejecutar(empleado);
    }
}
