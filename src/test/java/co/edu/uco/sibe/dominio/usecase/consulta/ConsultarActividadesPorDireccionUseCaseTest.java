package co.edu.uco.sibe.dominio.usecase.consulta;

import co.edu.uco.sibe.dominio.dto.ActividadDTO;
import co.edu.uco.sibe.dominio.dto.RespuestaPaginada;
import co.edu.uco.sibe.dominio.dto.SolicitudPaginacion;
import co.edu.uco.sibe.dominio.modelo.Direccion;
import co.edu.uco.sibe.dominio.puerto.consulta.ActividadRepositorioConsulta;
import co.edu.uco.sibe.dominio.puerto.consulta.DireccionRepositorioConsulta;
import co.edu.uco.sibe.dominio.service.AutorizacionContextoOrganizacionalServicio;
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
class ConsultarActividadesPorDireccionUseCaseTest {

    @Mock
    private ActividadRepositorioConsulta actividadRepositorioConsulta;

    @Mock
    private DireccionRepositorioConsulta direccionRepositorioConsulta;

    @Mock
    private AutorizacionContextoOrganizacionalServicio autorizacionServicio;

    private ConsultarActividadesPorDireccionUseCase useCase;

    @BeforeEach
    void setUp() {
        useCase = new ConsultarActividadesPorDireccionUseCase(actividadRepositorioConsulta, direccionRepositorioConsulta,
                autorizacionServicio);
    }

    @Test
    void deberiaConsultarActividadesPaginadasPorDireccionCuandoTieneAcceso() {
        UUID direccionId = UUID.randomUUID();
        Direccion direccion = Direccion.construir(direccionId, "Direccion Test", new ArrayList<>(), new ArrayList<>());
        SolicitudPaginacion solicitud = new SolicitudPaginacionTestDataBuilder().construir();
        RespuestaPaginada<ActividadDTO> respuestaEsperada = new RespuestaPaginadaTestDataBuilder<ActividadDTO>()
                .conContenido(List.of(new ActividadDTO()))
                .conTotalElementos(1)
                .conTotalPaginas(1)
                .conPaginaActual(0)
                .construir();

        doNothing().when(autorizacionServicio).validarAccesoADireccion(direccionId);
        when(direccionRepositorioConsulta.consultarPorIdentificador(direccionId)).thenReturn(direccion);
        when(actividadRepositorioConsulta.consultarPorDireccion(direccion, solicitud)).thenReturn(respuestaEsperada);

        RespuestaPaginada<ActividadDTO> resultado = useCase.ejecutar(direccionId.toString(), solicitud);

        assertEquals(respuestaEsperada, resultado);
        verify(autorizacionServicio).validarAccesoADireccion(direccionId);
        verify(actividadRepositorioConsulta).consultarPorDireccion(direccion, solicitud);
    }
}
