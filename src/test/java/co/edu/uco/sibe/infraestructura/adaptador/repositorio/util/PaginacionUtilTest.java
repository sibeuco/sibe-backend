package co.edu.uco.sibe.infraestructura.adaptador.repositorio.util;

import co.edu.uco.sibe.dominio.dto.RespuestaPaginada;
import co.edu.uco.sibe.dominio.dto.SolicitudPaginacion;
import co.edu.uco.sibe.dominio.testdatabuilder.SolicitudPaginacionTestDataBuilder;
import org.junit.jupiter.api.Test;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PaginacionUtilTest {

    @Test
    void deberiaCrearPageRequestConDefaultSort() {
        SolicitudPaginacion solicitud = new SolicitudPaginacionTestDataBuilder().construir();
        Sort defaultSort = Sort.by(Sort.Direction.ASC, "nombre");

        PageRequest result = PaginacionUtil.crearPageRequest(solicitud, defaultSort);

        assertNotNull(result);
        assertEquals(0, result.getPageNumber());
        assertEquals(10, result.getPageSize());
    }

    @Test
    void deberiaCrearPageRequestConOrdenarPorPersonalizado() {
        SolicitudPaginacion solicitud = new SolicitudPaginacionTestDataBuilder()
                .conOrdenarPor("semestre")
                .construir();
        Sort defaultSort = Sort.by(Sort.Direction.ASC, "nombre");

        PageRequest result = PaginacionUtil.crearPageRequest(solicitud, defaultSort);

        assertNotNull(result);
        assertTrue(result.getSort().stream().anyMatch(o -> o.getProperty().equals("semestre") && o.isAscending()));
    }

    @Test
    void deberiaCrearPageRequestConAliasColaborador() {
        SolicitudPaginacion solicitud = new SolicitudPaginacionTestDataBuilder()
                .conOrdenarPor("colaborador")
                .construir();
        Sort defaultSort = Sort.by(Sort.Direction.ASC, "nombre");

        PageRequest result = PaginacionUtil.crearPageRequest(solicitud, defaultSort);

        assertNotNull(result);
        assertTrue(result.getSort().stream().anyMatch(o -> o.getProperty().equals("persona.nombres")));
    }

    @Test
    void deberiaCrearPageRequestConDireccionDesc() {
        SolicitudPaginacion solicitud = new SolicitudPaginacionTestDataBuilder()
                .conOrdenarPor("nombre")
                .conDireccionOrdenamiento("desc")
                .construir();
        Sort defaultSort = Sort.by(Sort.Direction.ASC, "nombre");

        PageRequest result = PaginacionUtil.crearPageRequest(solicitud, defaultSort);

        assertNotNull(result);
        assertTrue(result.getSort().stream().anyMatch(o -> o.getProperty().equals("nombre") && o.isDescending()));
    }

    @Test
    void deberiaCrearPageRequestConDireccionAscPorDefecto() {
        SolicitudPaginacion solicitud = new SolicitudPaginacionTestDataBuilder()
                .conOrdenarPor("nombre")
                .conDireccionOrdenamiento("asc")
                .construir();
        Sort defaultSort = Sort.by(Sort.Direction.ASC, "nombre");

        PageRequest result = PaginacionUtil.crearPageRequest(solicitud, defaultSort);

        assertNotNull(result);
        assertTrue(result.getSort().stream().anyMatch(o -> o.getProperty().equals("nombre") && o.isAscending()));
    }

    @Test
    void deberiaConvertirPageArespuestaPaginada() {
        Page<String> page = new PageImpl<>(List.of("a", "b"), PageRequest.of(0, 10), 2);

        RespuestaPaginada<Integer> resultado = PaginacionUtil.convertir(page, String::length);

        assertNotNull(resultado);
        assertEquals(2, resultado.getContenido().size());
        assertEquals(1, resultado.getContenido().get(0));
        assertEquals(1, resultado.getContenido().get(1));
        assertEquals(2, resultado.getTotalElementos());
        assertEquals(1, resultado.getTotalPaginas());
        assertEquals(0, resultado.getPaginaActual());
    }

    @Test
    void deberiaLanzarExcepcionAlInstanciarClaseUtilitaria() throws Exception {
        Constructor<PaginacionUtil> constructor = PaginacionUtil.class.getDeclaredConstructor();
        constructor.setAccessible(true);

        InvocationTargetException exception = assertThrows(InvocationTargetException.class, constructor::newInstance);
        assertInstanceOf(UnsupportedOperationException.class, exception.getCause());
    }

    @Test
    void deberiaAgregarSortSecundarioPorIdentificador() {
        SolicitudPaginacion solicitud = new SolicitudPaginacionTestDataBuilder()
                .conOrdenarPor("nombre")
                .construir();
        Sort defaultSort = Sort.by(Sort.Direction.ASC, "nombre");

        PageRequest result = PaginacionUtil.crearPageRequest(solicitud, defaultSort);

        assertTrue(result.getSort().stream().anyMatch(o -> o.getProperty().equals("identificador")));
    }

    @Test
    void deberiaConvertirPageVacia() {
        Page<String> page = new PageImpl<>(List.of(), PageRequest.of(0, 10), 0);

        RespuestaPaginada<String> resultado = PaginacionUtil.convertir(page, s -> s);

        assertNotNull(resultado);
        assertTrue(resultado.getContenido().isEmpty());
        assertEquals(0, resultado.getTotalElementos());
    }
}
