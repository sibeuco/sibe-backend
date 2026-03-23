package co.edu.uco.sibe.dominio.usecase.consulta;

import co.edu.uco.sibe.dominio.dto.ActividadDTO;
import co.edu.uco.sibe.dominio.dto.RespuestaPaginada;
import co.edu.uco.sibe.dominio.dto.SolicitudPaginacion;
import co.edu.uco.sibe.dominio.modelo.Area;
import co.edu.uco.sibe.dominio.puerto.consulta.ActividadRepositorioConsulta;
import co.edu.uco.sibe.dominio.puerto.consulta.AreaRepositorioConsulta;
import co.edu.uco.sibe.dominio.service.AutorizacionContextoOrganizacionalServicio;
import co.edu.uco.sibe.dominio.testdatabuilder.RespuestaPaginadaTestDataBuilder;
import co.edu.uco.sibe.dominio.testdatabuilder.SolicitudPaginacionTestDataBuilder;
import co.edu.uco.sibe.dominio.transversal.excepcion.AuthorizationException;
import co.edu.uco.sibe.dominio.transversal.excepcion.ValorInvalidoExcepcion;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ConsultarActividadesPorAreaUseCaseTest {

    @Mock
    private ActividadRepositorioConsulta actividadRepositorioConsulta;

    @Mock
    private AreaRepositorioConsulta areaRepositorioConsulta;

    @Mock
    private AutorizacionContextoOrganizacionalServicio autorizacionServicio;

    private ConsultarActividadesPorAreaUseCase useCase;

    @BeforeEach
    void setUp() {
        useCase = new ConsultarActividadesPorAreaUseCase(actividadRepositorioConsulta, areaRepositorioConsulta,
                autorizacionServicio);
    }

    @Test
    void deberiaConsultarActividadesPorAreaCuandoTieneAcceso() {
        UUID areaId = UUID.randomUUID();
        Area area = Area.construir(areaId, "Area Test", new ArrayList<>(), new ArrayList<>());
        List<ActividadDTO> actividadesEsperadas = List.of(new ActividadDTO());

        doNothing().when(autorizacionServicio).validarAccesoAArea(areaId);
        when(areaRepositorioConsulta.consultarPorIdentificador(areaId)).thenReturn(area);
        when(actividadRepositorioConsulta.consultarPorArea(area)).thenReturn(actividadesEsperadas);

        List<ActividadDTO> resultado = useCase.ejecutar(areaId.toString());

        assertEquals(actividadesEsperadas, resultado);
        verify(autorizacionServicio).validarAccesoAArea(areaId);
        verify(areaRepositorioConsulta).consultarPorIdentificador(areaId);
        verify(actividadRepositorioConsulta).consultarPorArea(area);
    }

    @Test
    void deberiaLanzarAuthorizationExceptionCuandoNoTieneAccesoAlArea() {
        UUID areaId = UUID.randomUUID();

        doThrow(new AuthorizationException("No tiene acceso")).when(autorizacionServicio).validarAccesoAArea(areaId);

        assertThrows(AuthorizationException.class, () -> useCase.ejecutar(areaId.toString()));

        verify(autorizacionServicio).validarAccesoAArea(areaId);
        verify(areaRepositorioConsulta, never()).consultarPorIdentificador(any());
    }

    @Test
    void deberiaLanzarValorInvalidoExcepcionCuandoAreaNoExiste() {
        UUID areaId = UUID.randomUUID();

        doNothing().when(autorizacionServicio).validarAccesoAArea(areaId);
        when(areaRepositorioConsulta.consultarPorIdentificador(areaId)).thenReturn(null);

        assertThrows(ValorInvalidoExcepcion.class, () -> useCase.ejecutar(areaId.toString()));

        verify(autorizacionServicio).validarAccesoAArea(areaId);
    }

    @Test
    void deberiaValidarAccesoAntesDeConsultarArea() {
        UUID areaId = UUID.randomUUID();

        doThrow(new AuthorizationException("Sin acceso")).when(autorizacionServicio).validarAccesoAArea(areaId);

        assertThrows(AuthorizationException.class, () -> useCase.ejecutar(areaId.toString()));

        verify(actividadRepositorioConsulta, never()).consultarPorArea(any());
    }

    @Test
    void deberiaConsultarActividadesPaginadasPorAreaCuandoTieneAcceso() {
        UUID areaId = UUID.randomUUID();
        Area area = Area.construir(areaId, "Area Test", new ArrayList<>(), new ArrayList<>());
        SolicitudPaginacion solicitud = new SolicitudPaginacionTestDataBuilder().construir();
        RespuestaPaginada<ActividadDTO> respuestaEsperada = new RespuestaPaginadaTestDataBuilder<ActividadDTO>()
                .conContenido(List.of(new ActividadDTO()))
                .conTotalElementos(1)
                .conTotalPaginas(1)
                .conPaginaActual(0)
                .construir();

        doNothing().when(autorizacionServicio).validarAccesoAArea(areaId);
        when(areaRepositorioConsulta.consultarPorIdentificador(areaId)).thenReturn(area);
        when(actividadRepositorioConsulta.consultarPorArea(area, solicitud)).thenReturn(respuestaEsperada);

        RespuestaPaginada<ActividadDTO> resultado = useCase.ejecutar(areaId.toString(), solicitud);

        assertEquals(respuestaEsperada, resultado);
        assertEquals(1, resultado.getContenido().size());
        assertEquals(1, resultado.getTotalElementos());
        verify(autorizacionServicio).validarAccesoAArea(areaId);
        verify(actividadRepositorioConsulta).consultarPorArea(area, solicitud);
    }

    @Test
    void deberiaRetornarRespuestaPaginadaConTotalElementosYPaginas() {
        UUID areaId = UUID.randomUUID();
        Area area = Area.construir(areaId, "Area Test", new ArrayList<>(), new ArrayList<>());
        SolicitudPaginacion solicitud = new SolicitudPaginacionTestDataBuilder().conTamanio(5).construir();
        RespuestaPaginada<ActividadDTO> respuestaEsperada = new RespuestaPaginadaTestDataBuilder<ActividadDTO>()
                .conContenido(List.of(new ActividadDTO(), new ActividadDTO(), new ActividadDTO(), new ActividadDTO(), new ActividadDTO()))
                .conTotalElementos(12)
                .conTotalPaginas(3)
                .conPaginaActual(0)
                .construir();

        doNothing().when(autorizacionServicio).validarAccesoAArea(areaId);
        when(areaRepositorioConsulta.consultarPorIdentificador(areaId)).thenReturn(area);
        when(actividadRepositorioConsulta.consultarPorArea(area, solicitud)).thenReturn(respuestaEsperada);

        RespuestaPaginada<ActividadDTO> resultado = useCase.ejecutar(areaId.toString(), solicitud);

        assertEquals(12, resultado.getTotalElementos());
        assertEquals(3, resultado.getTotalPaginas());
        assertEquals(0, resultado.getPaginaActual());
        assertEquals(5, resultado.getContenido().size());
    }
}
