package co.edu.uco.sibe.infraestructura.adaptador.dao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
@ActiveProfiles("test")
class PaginacionQueryTest {

    @Autowired
    private ActividadDAO actividadDAO;

    @Autowired
    private PersonaDAO personaDAO;

    @Autowired
    private IndicadorDAO indicadorDAO;

    @Autowired
    private AccionDAO accionDAO;

    @Test
    void actividadConsultarPorArea_deberiaFuncionar() {
        var pageable = PageRequest.of(0, 10, Sort.by("nombre").and(Sort.by("identificador")));
        var page = actividadDAO.consultarPorArea(UUID.randomUUID(), pageable);
        assertNotNull(page);
    }

    @Test
    void actividadConsultarPorAreaConBusqueda_deberiaFuncionar() {
        var pageable = PageRequest.of(0, 10, Sort.by("nombre").and(Sort.by("identificador")));
        var page = actividadDAO.consultarPorAreaConBusqueda(UUID.randomUUID(), "test", pageable);
        assertNotNull(page);
    }

    @Test
    void actividadConsultarPorDireccion_deberiaFuncionar() {
        var pageable = PageRequest.of(0, 10, Sort.by("nombre").and(Sort.by("identificador")));
        var page = actividadDAO.consultarPorDireccion(UUID.randomUUID(), pageable);
        assertNotNull(page);
    }

    @Test
    void personaBuscarUsuariosPaginado_deberiaFuncionar() {
        var pageable = PageRequest.of(0, 10, Sort.by("nombres", "apellidos").and(Sort.by("identificador")));
        var page = personaDAO.buscarUsuariosPaginado(null, null, null, pageable);
        assertNotNull(page);
    }

    @Test
    void personaBuscarUsuariosPaginadoConFiltro_deberiaFuncionar() {
        var pageable = PageRequest.of(0, 10, Sort.by("nombres", "apellidos").and(Sort.by("identificador")));
        var page = personaDAO.buscarUsuariosPaginadoConFiltroOrganizacional(
                List.of(UUID.randomUUID()), null, null, null, pageable);
        assertNotNull(page);
    }

    @Test
    void indicadorFindAllPaginado_deberiaFuncionar() {
        var pageable = PageRequest.of(0, 10, Sort.by("nombre").and(Sort.by("identificador")));
        var page = indicadorDAO.findAll(pageable);
        assertNotNull(page);
    }

    @Test
    void indicadorBuscarPaginado_deberiaFuncionar() {
        var pageable = PageRequest.of(0, 10, Sort.by("nombre").and(Sort.by("identificador")));
        var page = indicadorDAO.buscarPaginado("test", pageable);
        assertNotNull(page);
    }

    @Test
    void accionBuscarPaginado_deberiaFuncionar() {
        var pageable = PageRequest.of(0, 10, Sort.by("detalle").and(Sort.by("identificador")));
        var page = accionDAO.buscarPaginado("test", pageable);
        assertNotNull(page);
    }
}
