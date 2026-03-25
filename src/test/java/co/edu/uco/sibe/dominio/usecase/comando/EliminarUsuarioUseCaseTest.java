package co.edu.uco.sibe.dominio.usecase.comando;

import co.edu.uco.sibe.dominio.puerto.comando.PersonaRepositorioComando;
import co.edu.uco.sibe.dominio.puerto.consulta.PersonaRepositorioConsulta;
import co.edu.uco.sibe.dominio.service.AutorizacionContextoOrganizacionalServicio;
import co.edu.uco.sibe.dominio.transversal.excepcion.AuthorizationException;
import co.edu.uco.sibe.dominio.transversal.excepcion.ValorInvalidoExcepcion;
import co.edu.uco.sibe.dominio.modelo.Persona;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class EliminarUsuarioUseCaseTest {

    @Mock
    private PersonaRepositorioComando personaRepositorioComando;
    @Mock
    private PersonaRepositorioConsulta personaRepositorioConsulta;
    @Mock
    private AutorizacionContextoOrganizacionalServicio autorizacionServicio;

    private EliminarUsuarioUseCase useCase;

    @BeforeEach
    void setUp() {
        useCase = new EliminarUsuarioUseCase(personaRepositorioComando, personaRepositorioConsulta,
                autorizacionServicio);
    }

    @Test
    void deberiaEliminarUsuarioExitosamente() {
        UUID identificador = UUID.randomUUID();
        Persona persona = mock(Persona.class);

        doNothing().when(autorizacionServicio).validarAccesoAUsuario(identificador);
        when(personaRepositorioConsulta.consultarPersonaPorIdentificador(identificador)).thenReturn(persona);

        UUID resultado = useCase.ejecutar(identificador);

        assertEquals(identificador, resultado);
        verify(personaRepositorioComando).eliminarUsuario(identificador);
    }

    @Test
    void deberiaLanzarAuthorizationExceptionCuandoNoTieneAcceso() {
        UUID identificador = UUID.randomUUID();

        doThrow(new AuthorizationException("No tiene acceso")).when(autorizacionServicio)
                .validarAccesoAUsuario(identificador);

        assertThrows(AuthorizationException.class, () -> useCase.ejecutar(identificador));

        verify(personaRepositorioComando, never()).eliminarUsuario(any());
    }

    @Test
    void deberiaLanzarValorInvalidoExcepcionCuandoUsuarioNoExiste() {
        UUID identificador = UUID.randomUUID();

        doNothing().when(autorizacionServicio).validarAccesoAUsuario(identificador);
        when(personaRepositorioConsulta.consultarPersonaPorIdentificador(identificador)).thenReturn(null);

        assertThrows(ValorInvalidoExcepcion.class, () -> useCase.ejecutar(identificador));

        verify(personaRepositorioComando, never()).eliminarUsuario(any());
    }
}
