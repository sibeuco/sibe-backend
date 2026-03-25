package co.edu.uco.sibe.infraestructura.adaptador.mapeador;

import co.edu.uco.sibe.dominio.modelo.RelacionLaboral;
import co.edu.uco.sibe.infraestructura.adaptador.dao.EmpleadoRelacionLaboralDAO;
import co.edu.uco.sibe.infraestructura.adaptador.dao.RelacionLaboralDAO;
import co.edu.uco.sibe.infraestructura.adaptador.entidad.EmpleadoRelacionLaboralEntidad;
import co.edu.uco.sibe.infraestructura.adaptador.entidad.RelacionLaboralEntidad;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class EmpleadoRelacionLaboralMapeadorTest {

    @Mock
    private RelacionLaboralMapeador relacionLaboralMapeador;

    @Mock
    private EmpleadoRelacionLaboralDAO empleadoRelacionLaboralDAO;

    @Mock
    private RelacionLaboralDAO relacionLaboralDAO;

    private EmpleadoRelacionLaboralMapeador mapeador;

    @BeforeEach
    void setUp() {
        mapeador = new EmpleadoRelacionLaboralMapeador(relacionLaboralMapeador, empleadoRelacionLaboralDAO, relacionLaboralDAO);
    }

    @Test
    void deberiaConstruirEntidadCuandoRelacionLaboralExiste() {
        UUID id = UUID.randomUUID();
        RelacionLaboral rl = RelacionLaboral.construir(id, "RL-001", "Planta");
        RelacionLaboralEntidad rlEntidad = new RelacionLaboralEntidad(id, "RL-001", "Planta");

        when(relacionLaboralDAO.findByCodigo("RL-001")).thenReturn(rlEntidad);
        when(empleadoRelacionLaboralDAO.findById(any(UUID.class))).thenReturn(Optional.empty());

        EmpleadoRelacionLaboralEntidad entidad = mapeador.construirEntidad(rl);

        assertNotNull(entidad);
        assertEquals(rlEntidad, entidad.getRelacionLaboral());
    }

    @Test
    void deberiaConstruirEntidadCuandoRelacionLaboralNoExiste() {
        UUID id = UUID.randomUUID();
        RelacionLaboral rl = RelacionLaboral.construir(id, "RL-NEW", "Nueva");
        RelacionLaboralEntidad rlEntidad = new RelacionLaboralEntidad(id, "RL-NEW", "Nueva");

        when(relacionLaboralDAO.findByCodigo("RL-NEW")).thenReturn(null);
        when(relacionLaboralMapeador.construirEntidad(rl)).thenReturn(rlEntidad);
        when(relacionLaboralDAO.save(rlEntidad)).thenReturn(rlEntidad);
        when(empleadoRelacionLaboralDAO.findById(any(UUID.class))).thenReturn(Optional.empty());

        EmpleadoRelacionLaboralEntidad entidad = mapeador.construirEntidad(rl);

        assertNotNull(entidad);
    }

    @Test
    void deberiaConstruirModeloDesdeEntidad() {
        UUID id = UUID.randomUUID();
        RelacionLaboralEntidad rlEntidad = new RelacionLaboralEntidad(id, "RL-001", "Planta");
        EmpleadoRelacionLaboralEntidad entidad = new EmpleadoRelacionLaboralEntidad(UUID.randomUUID(), rlEntidad);
        RelacionLaboral rl = RelacionLaboral.construir(id, "RL-001", "Planta");

        when(relacionLaboralMapeador.construirModelo(rlEntidad)).thenReturn(rl);

        RelacionLaboral resultado = mapeador.construirModelo(entidad);

        assertEquals(id, resultado.getIdentificador());
    }

    @Test
    void deberiaModificarEntidad() {
        UUID id = UUID.randomUUID();
        RelacionLaboralEntidad entidad = new RelacionLaboralEntidad(id, "RL-OLD", "Vieja");
        RelacionLaboral rl = RelacionLaboral.construir(UUID.randomUUID(), "RL-NEW", "Nueva");

        mapeador.modificarEntidad(entidad, rl);

        assertEquals("RL-NEW", entidad.getCodigo());
        assertEquals("Nueva", entidad.getDescripcion());
    }
}
