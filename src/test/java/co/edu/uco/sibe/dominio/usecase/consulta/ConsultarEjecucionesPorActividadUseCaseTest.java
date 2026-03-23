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
}
