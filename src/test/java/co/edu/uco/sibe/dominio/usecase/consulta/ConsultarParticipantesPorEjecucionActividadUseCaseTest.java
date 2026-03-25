package co.edu.uco.sibe.dominio.usecase.consulta;

import co.edu.uco.sibe.dominio.dto.ParticipanteDTO;
import co.edu.uco.sibe.dominio.dto.RespuestaPaginada;
import co.edu.uco.sibe.dominio.dto.SolicitudPaginacion;
import co.edu.uco.sibe.dominio.modelo.EjecucionActividad;
import co.edu.uco.sibe.dominio.puerto.consulta.ActividadRepositorioConsulta;
import co.edu.uco.sibe.dominio.service.AutorizacionContextoOrganizacionalServicio;
import co.edu.uco.sibe.dominio.testdatabuilder.EjecucionActividadTestDataBuilder;
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
class ConsultarParticipantesPorEjecucionActividadUseCaseTest {

    @Mock
    private ActividadRepositorioConsulta actividadRepositorioConsulta;

    @Mock
    private AutorizacionContextoOrganizacionalServicio autorizacionServicio;

    private ConsultarParticipantesPorEjecucionActividadUseCase useCase;

    @BeforeEach
    void setUp() {
        useCase = new ConsultarParticipantesPorEjecucionActividadUseCase(actividadRepositorioConsulta, autorizacionServicio);
    }

    @Test
    void deberiaConsultarParticipantesPaginadosPorEjecucionCuandoTieneAcceso() {
        UUID ejecucionId = UUID.randomUUID();
        EjecucionActividad ejecucion = new EjecucionActividadTestDataBuilder().conIdentificador(ejecucionId).construir();
        SolicitudPaginacion solicitud = new SolicitudPaginacionTestDataBuilder().construir();
        RespuestaPaginada<ParticipanteDTO> respuestaEsperada = new RespuestaPaginadaTestDataBuilder<ParticipanteDTO>()
                .conContenido(List.of(new ParticipanteDTO()))
                .conTotalElementos(1)
                .conTotalPaginas(1)
                .conPaginaActual(0)
                .construir();

        doNothing().when(autorizacionServicio).validarAccesoAEjecucionActividad(ejecucionId);
        when(actividadRepositorioConsulta.consultarEjecucionActividadPorIdentificador(ejecucionId)).thenReturn(ejecucion);
        when(actividadRepositorioConsulta.consultarParticipantesPorEjecucionActividad(ejecucionId, solicitud)).thenReturn(respuestaEsperada);

        RespuestaPaginada<ParticipanteDTO> resultado = useCase.ejecutar(ejecucionId, solicitud);

        assertEquals(respuestaEsperada, resultado);
        verify(autorizacionServicio).validarAccesoAEjecucionActividad(ejecucionId);
        verify(actividadRepositorioConsulta).consultarParticipantesPorEjecucionActividad(ejecucionId, solicitud);
    }

    @Test
    void deberiaConsultarParticipantesSinPaginacionCuandoTieneAcceso() {
        UUID ejecucionId = UUID.randomUUID();
        EjecucionActividad ejecucion = new EjecucionActividadTestDataBuilder().conIdentificador(ejecucionId).construir();
        List<ParticipanteDTO> listaEsperada = List.of(new ParticipanteDTO());

        doNothing().when(autorizacionServicio).validarAccesoAEjecucionActividad(ejecucionId);
        when(actividadRepositorioConsulta.consultarEjecucionActividadPorIdentificador(ejecucionId)).thenReturn(ejecucion);
        when(actividadRepositorioConsulta.consultarParticipantesPorEjecucionActividad(ejecucionId)).thenReturn(listaEsperada);

        List<ParticipanteDTO> resultado = useCase.ejecutar(ejecucionId);

        assertEquals(listaEsperada, resultado);
    }

    @Test
    void deberiaLanzarExcepcionCuandoEjecucionNoExiste() {
        UUID ejecucionId = UUID.randomUUID();

        doNothing().when(autorizacionServicio).validarAccesoAEjecucionActividad(ejecucionId);
        when(actividadRepositorioConsulta.consultarEjecucionActividadPorIdentificador(ejecucionId)).thenReturn(null);

        assertThrows(co.edu.uco.sibe.dominio.transversal.excepcion.ValorInvalidoExcepcion.class,
                () -> useCase.ejecutar(ejecucionId));
    }

    @Test
    void deberiaLanzarExcepcionCuandoEjecucionNoExisteEnConsultaPaginada() {
        UUID ejecucionId = UUID.randomUUID();
        SolicitudPaginacion solicitud = new SolicitudPaginacionTestDataBuilder().construir();

        doNothing().when(autorizacionServicio).validarAccesoAEjecucionActividad(ejecucionId);
        when(actividadRepositorioConsulta.consultarEjecucionActividadPorIdentificador(ejecucionId)).thenReturn(null);

        assertThrows(co.edu.uco.sibe.dominio.transversal.excepcion.ValorInvalidoExcepcion.class,
                () -> useCase.ejecutar(ejecucionId, solicitud));
    }
}
