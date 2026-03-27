package co.edu.uco.sibe.infraestructura.adaptador.repositorio.consulta;

import co.edu.uco.sibe.dominio.dto.ProyectoDTO;
import co.edu.uco.sibe.infraestructura.adaptador.dao.ProyectoDAO;
import co.edu.uco.sibe.infraestructura.adaptador.entidad.ProyectoEntidad;
import co.edu.uco.sibe.infraestructura.adaptador.mapeador.ProyectoMapeador;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import co.edu.uco.sibe.dominio.modelo.Proyecto;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

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
    void deberiaRetornarDTOs() {
        List<ProyectoEntidad> entidades = List.of(new ProyectoEntidad());
        ProyectoDTO dto = new ProyectoDTO();

        when(proyectoDAO.findAllConAcciones()).thenReturn(entidades);
        when(proyectoMapeador.construirDTOs(entidades)).thenReturn(List.of(dto));

        List<ProyectoDTO> resultado = repositorio.consultarDTOs();

        assertEquals(1, resultado.size());
    }

    @Test
    void deberiaRetornarProyectoCuandoExisteIdentificador() {
        UUID id = UUID.randomUUID();
        ProyectoEntidad entidad = new ProyectoEntidad();
        Proyecto modelo = mock(Proyecto.class);

        when(proyectoDAO.findById(id)).thenReturn(Optional.of(entidad));
        when(proyectoMapeador.construriModelo(entidad)).thenReturn(modelo);

        Proyecto resultado = repositorio.consultarPorIdentificador(id);

        assertNotNull(resultado);
        assertEquals(modelo, resultado);
    }

    @Test
    void deberiaRetornarNuloCuandoNoExisteIdentificador() {
        UUID id = UUID.randomUUID();

        when(proyectoDAO.findById(id)).thenReturn(Optional.empty());

        assertNull(repositorio.consultarPorIdentificador(id));
    }

    @Test
    void deberiaRetornarProyectoCuandoExisteNumeroProyecto() {
        String numero = "PRY001";
        ProyectoEntidad entidad = new ProyectoEntidad();
        Proyecto modelo = mock(Proyecto.class);

        when(proyectoDAO.findByNumeroProyecto(numero)).thenReturn(entidad);
        when(proyectoMapeador.construriModelo(entidad)).thenReturn(modelo);

        Proyecto resultado = repositorio.consultarPorNumeroProyecto(numero);

        assertNotNull(resultado);
        assertEquals(modelo, resultado);
    }

    @Test
    void deberiaRetornarNuloCuandoNoExisteNumeroProyecto() {
        when(proyectoDAO.findByNumeroProyecto("INVALIDO")).thenReturn(null);

        assertNull(repositorio.consultarPorNumeroProyecto("INVALIDO"));
    }
}
