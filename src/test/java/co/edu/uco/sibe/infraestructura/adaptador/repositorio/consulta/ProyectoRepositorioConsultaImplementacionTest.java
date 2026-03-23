package co.edu.uco.sibe.infraestructura.adaptador.repositorio.consulta;

import co.edu.uco.sibe.dominio.dto.ProyectoDTO;
import co.edu.uco.sibe.dominio.dto.RespuestaPaginada;
import co.edu.uco.sibe.dominio.dto.SolicitudPaginacion;
import co.edu.uco.sibe.dominio.testdatabuilder.SolicitudPaginacionTestDataBuilder;
import co.edu.uco.sibe.infraestructura.adaptador.dao.ProyectoDAO;
import co.edu.uco.sibe.infraestructura.adaptador.entidad.ProyectoEntidad;
import co.edu.uco.sibe.infraestructura.adaptador.mapeador.ProyectoMapeador;
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
class ProyectoRepositorioConsultaImplementacionTest {

    @Mock
    private ProyectoDAO proyectoDAO;

    @Mock
    private ProyectoMapeador proyectoMapeador;

    private ProyectoRepositorioConsultaImplementacion repositorio;

    @BeforeEach
    void setUp() {
        repositorio = new ProyectoRepositorioConsultaImplementacion(proyectoDAO, proyectoMapeador);
    }

    @Test
    void deberiaRetornarProyectosPaginadosSinBusqueda() {
        SolicitudPaginacion solicitud = new SolicitudPaginacionTestDataBuilder().construir();
        ProyectoEntidad entidad = new ProyectoEntidad();
        Page<ProyectoEntidad> page = new PageImpl<>(List.of(entidad));
        ProyectoDTO dto = new ProyectoDTO();

        when(proyectoDAO.findAll(any(Pageable.class))).thenReturn(page);
        when(proyectoMapeador.construirDTO(entidad)).thenReturn(dto);

        RespuestaPaginada<ProyectoDTO> resultado = repositorio.consultarDTOsPaginado(solicitud);

        assertNotNull(resultado);
        assertEquals(1, resultado.getContenido().size());
        assertEquals(1L, resultado.getTotalElementos());
    }

    @Test
    void deberiaRetornarProyectosPaginadosConBusqueda() {
        SolicitudPaginacion solicitud = new SolicitudPaginacionTestDataBuilder().conBusqueda("PRY").construir();
        ProyectoEntidad entidad = new ProyectoEntidad();
        Page<ProyectoEntidad> page = new PageImpl<>(List.of(entidad));
        ProyectoDTO dto = new ProyectoDTO();

        when(proyectoDAO.buscarPaginado(eq("PRY"), any(Pageable.class))).thenReturn(page);
        when(proyectoMapeador.construirDTO(entidad)).thenReturn(dto);

        RespuestaPaginada<ProyectoDTO> resultado = repositorio.consultarDTOsPaginado(solicitud);

        assertNotNull(resultado);
        assertEquals(1, resultado.getContenido().size());
    }
}
