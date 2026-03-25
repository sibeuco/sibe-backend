package co.edu.uco.sibe.dominio.usecase.consulta;

import co.edu.uco.sibe.dominio.dto.EjecucionActividadDTO;
import co.edu.uco.sibe.dominio.dto.RespuestaPaginada;
import co.edu.uco.sibe.dominio.dto.SolicitudPaginacion;
import co.edu.uco.sibe.dominio.modelo.Actividad;
import co.edu.uco.sibe.dominio.puerto.consulta.ActividadRepositorioConsulta;
import co.edu.uco.sibe.dominio.service.AutorizacionContextoOrganizacionalServicio;
import co.edu.uco.sibe.dominio.testdatabuilder.ActividadTestDataBuilder;
import co.edu.uco.sibe.dominio.testdatabuilder.RespuestaPaginadaTestDataBuilder;
import co.edu.uco.sibe.dominio.testdatabuilder.SolicitudPaginacionTestDataBuilder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ConsultarEjecucionesPorActividadUseCaseTest {

    @Mock
    private ActividadRepositorioConsulta actividadRepositorioConsulta;

    @Mock
    private AutorizacionContextoOrganizacionalServicio autorizacionServicio;

    private ConsultarEjecucionesPorActividadUseCase useCase;

    @BeforeEach
    void setUp() {
        useCase = new ConsultarEjecucionesPorActividadUseCase(actividadRepositorioConsulta, autorizacionServicio);
    }

    @Test
    void deberiaConsultarEjecucionesPaginadasPorActividadCuandoTieneAcceso() {
        UUID actividadId = UUID.randomUUID();
        Actividad actividad = new ActividadTestDataBuilder().conIdentificador(actividadId).construir();
        SolicitudPaginacion solicitud = new SolicitudPaginacionTestDataBuilder().construir();
        RespuestaPaginada<EjecucionActividadDTO> respuestaEsperada = new RespuestaPaginadaTestDataBuilder<EjecucionActividadDTO>()
                .conContenido(List.of(new EjecucionActividadDTO()))
                .conTotalElementos(1)
                .conTotalPaginas(1)
                .conPaginaActual(0)
                .construir();

        doNothing().when(autorizacionServicio).validarAccesoAActividad(actividadId);
        when(actividadRepositorioConsulta.consultarPorIdentificador(actividadId)).thenReturn(actividad);
        when(actividadRepositorioConsulta.consultarFechasProgramadasPorActividad(actividad, solicitud)).thenReturn(respuestaEsperada);

        RespuestaPaginada<EjecucionActividadDTO> resultado = useCase.ejecutar(actividadId.toString(), solicitud);

        assertEquals(respuestaEsperada, resultado);
        verify(autorizacionServicio).validarAccesoAActividad(actividadId);
        verify(actividadRepositorioConsulta).consultarFechasProgramadasPorActividad(actividad, solicitud);
    }

    @Test
    void deberiaConsultarEjecucionesSinPaginacionCuandoTieneAcceso() {
        UUID actividadId = UUID.randomUUID();
        Actividad actividad = new ActividadTestDataBuilder().conIdentificador(actividadId).construir();
        List<EjecucionActividadDTO> listaEsperada = List.of(new EjecucionActividadDTO());

        doNothing().when(autorizacionServicio).validarAccesoAActividad(actividadId);
        when(actividadRepositorioConsulta.consultarPorIdentificador(actividadId)).thenReturn(actividad);
        when(actividadRepositorioConsulta.consultarFechasProgramadasPorActividad(actividad)).thenReturn(listaEsperada);

        List<EjecucionActividadDTO> resultado = useCase.ejecutar(actividadId.toString());

        assertEquals(listaEsperada, resultado);
    }

    @Test
    void deberiaLanzarExcepcionCuandoActividadNoExisteEnConsultaSinPaginacion() {
        UUID actividadId = UUID.randomUUID();

        doNothing().when(autorizacionServicio).validarAccesoAActividad(actividadId);
        when(actividadRepositorioConsulta.consultarPorIdentificador(actividadId)).thenReturn(null);

        assertThrows(co.edu.uco.sibe.dominio.transversal.excepcion.ValorInvalidoExcepcion.class,
                () -> useCase.ejecutar(actividadId.toString()));
    }

    @Test
    void deberiaLanzarExcepcionCuandoActividadNoExisteEnConsultaPaginada() {
        UUID actividadId = UUID.randomUUID();
        SolicitudPaginacion solicitud = new SolicitudPaginacionTestDataBuilder().construir();

        doNothing().when(autorizacionServicio).validarAccesoAActividad(actividadId);
        when(actividadRepositorioConsulta.consultarPorIdentificador(actividadId)).thenReturn(null);

        assertThrows(co.edu.uco.sibe.dominio.transversal.excepcion.ValorInvalidoExcepcion.class,
                () -> useCase.ejecutar(actividadId.toString(), solicitud));
    }
}
