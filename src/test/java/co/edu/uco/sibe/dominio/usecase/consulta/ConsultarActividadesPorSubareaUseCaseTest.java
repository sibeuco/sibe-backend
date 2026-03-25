package co.edu.uco.sibe.dominio.usecase.consulta;

import co.edu.uco.sibe.dominio.dto.ActividadDTO;
import co.edu.uco.sibe.dominio.dto.RespuestaPaginada;
import co.edu.uco.sibe.dominio.dto.SolicitudPaginacion;
import co.edu.uco.sibe.dominio.modelo.Subarea;
import co.edu.uco.sibe.dominio.puerto.consulta.ActividadRepositorioConsulta;
import co.edu.uco.sibe.dominio.puerto.consulta.SubareaRepositorioConsulta;
import co.edu.uco.sibe.dominio.service.AutorizacionContextoOrganizacionalServicio;
import co.edu.uco.sibe.dominio.transversal.excepcion.ValorInvalidoExcepcion;
import co.edu.uco.sibe.dominio.testdatabuilder.RespuestaPaginadaTestDataBuilder;
import co.edu.uco.sibe.dominio.testdatabuilder.SolicitudPaginacionTestDataBuilder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ConsultarActividadesPorSubareaUseCaseTest {

    @Mock
    private ActividadRepositorioConsulta actividadRepositorioConsulta;

    @Mock
    private SubareaRepositorioConsulta subareaRepositorioConsulta;

    @Mock
    private AutorizacionContextoOrganizacionalServicio autorizacionServicio;

    private ConsultarActividadesPorSubareaUseCase useCase;

    @BeforeEach
    void setUp() {
        useCase = new ConsultarActividadesPorSubareaUseCase(actividadRepositorioConsulta, subareaRepositorioConsulta,
                autorizacionServicio);
    }

    @Test
    void deberiaConsultarActividadesPaginadasPorSubareaCuandoTieneAcceso() {
        UUID subareaId = UUID.randomUUID();
        Subarea subarea = Subarea.construir(subareaId, "Subarea Test", new ArrayList<>());
        SolicitudPaginacion solicitud = new SolicitudPaginacionTestDataBuilder().construir();
        RespuestaPaginada<ActividadDTO> respuestaEsperada = new RespuestaPaginadaTestDataBuilder<ActividadDTO>()
                .conContenido(List.of(new ActividadDTO()))
                .conTotalElementos(1)
                .conTotalPaginas(1)
                .conPaginaActual(0)
                .construir();

        doNothing().when(autorizacionServicio).validarAccesoASubarea(subareaId);
        when(subareaRepositorioConsulta.consultarPorIdentificador(subareaId)).thenReturn(subarea);
        when(actividadRepositorioConsulta.consultarPorSubarea(subarea, solicitud)).thenReturn(respuestaEsperada);

        RespuestaPaginada<ActividadDTO> resultado = useCase.ejecutar(subareaId.toString(), solicitud);

        assertEquals(respuestaEsperada, resultado);
        verify(autorizacionServicio).validarAccesoASubarea(subareaId);
        verify(actividadRepositorioConsulta).consultarPorSubarea(subarea, solicitud);
    }

    @Test
    void deberiaConsultarActividadesSinPaginacionPorSubarea() {
        UUID subareaId = UUID.randomUUID();
        Subarea subarea = Subarea.construir(subareaId, "Subarea Test", new ArrayList<>());
        List<ActividadDTO> esperado = List.of(new ActividadDTO());

        doNothing().when(autorizacionServicio).validarAccesoASubarea(subareaId);
        when(subareaRepositorioConsulta.consultarPorIdentificador(subareaId)).thenReturn(subarea);
        when(actividadRepositorioConsulta.consultarPorSubarea(subarea)).thenReturn(esperado);

        List<ActividadDTO> resultado = useCase.ejecutar(subareaId.toString());

        assertEquals(esperado, resultado);
    }

    @Test
    void deberiaLanzarExcepcionCuandoSubareaNoExiste() {
        UUID subareaId = UUID.randomUUID();

        doNothing().when(autorizacionServicio).validarAccesoASubarea(subareaId);
        when(subareaRepositorioConsulta.consultarPorIdentificador(subareaId)).thenReturn(null);

        assertThrows(ValorInvalidoExcepcion.class, () -> useCase.ejecutar(subareaId.toString()));
    }
}
