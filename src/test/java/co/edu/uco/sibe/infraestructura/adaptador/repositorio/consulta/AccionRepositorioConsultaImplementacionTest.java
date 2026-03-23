package co.edu.uco.sibe.infraestructura.adaptador.repositorio.consulta;

import co.edu.uco.sibe.dominio.dto.AccionDTO;
import co.edu.uco.sibe.dominio.dto.RespuestaPaginada;
import co.edu.uco.sibe.dominio.dto.SolicitudPaginacion;
import co.edu.uco.sibe.dominio.testdatabuilder.SolicitudPaginacionTestDataBuilder;
import co.edu.uco.sibe.infraestructura.adaptador.dao.AccionDAO;
import co.edu.uco.sibe.infraestructura.adaptador.entidad.AccionEntidad;
import co.edu.uco.sibe.infraestructura.adaptador.mapeador.AccionMapeador;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AccionRepositorioConsultaImplementacionTest {

    @Mock
    private AccionDAO accionDAO;

    @Mock
    private AccionMapeador accionMapeador;

    private AccionRepositorioConsultaImplementacion repositorio;

    @BeforeEach
    void setUp() {
        repositorio = new AccionRepositorioConsultaImplementacion(accionDAO, accionMapeador);
    }

    @Test
    void deberiaRetornarAccionesPaginadasSinBusqueda() {
        SolicitudPaginacion solicitud = new SolicitudPaginacionTestDataBuilder().construir();
        AccionEntidad entidad = new AccionEntidad();
        Page<AccionEntidad> page = new PageImpl<>(List.of(entidad));
        AccionDTO dto = new AccionDTO();

        when(accionDAO.findAll(any(Pageable.class))).thenReturn(page);
        when(accionMapeador.construirDTO(entidad)).thenReturn(dto);

        RespuestaPaginada<AccionDTO> resultado = repositorio.consultarDTOsPaginado(solicitud);

        assertNotNull(resultado);
        assertEquals(1, resultado.getContenido().size());
        assertEquals(1L, resultado.getTotalElementos());
    }

    @Test
    void deberiaRetornarAccionesPaginadasConBusqueda() {
        SolicitudPaginacion solicitud = new SolicitudPaginacionTestDataBuilder().conBusqueda("accion").construir();
        AccionEntidad entidad = new AccionEntidad();
        Page<AccionEntidad> page = new PageImpl<>(List.of(entidad));
        AccionDTO dto = new AccionDTO();

        when(accionDAO.buscarPaginado(eq("accion"), any(Pageable.class))).thenReturn(page);
        when(accionMapeador.construirDTO(entidad)).thenReturn(dto);

        RespuestaPaginada<AccionDTO> resultado = repositorio.consultarDTOsPaginado(solicitud);

        assertNotNull(resultado);
        assertEquals(1, resultado.getContenido().size());
    }
}
