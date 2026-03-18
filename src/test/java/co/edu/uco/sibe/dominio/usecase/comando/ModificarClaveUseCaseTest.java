package co.edu.uco.sibe.dominio.usecase.comando;

import co.edu.uco.sibe.dominio.puerto.comando.PersonaRepositorioComando;
import co.edu.uco.sibe.dominio.puerto.consulta.PersonaRepositorioConsulta;
import co.edu.uco.sibe.dominio.puerto.servicio.EncriptarClaveServicio;
import co.edu.uco.sibe.dominio.service.AutorizacionContextoOrganizacionalServicio;
import co.edu.uco.sibe.dominio.transversal.excepcion.AuthorizationException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ModificarClaveUseCaseTest {

    @Mock
    private PersonaRepositorioComando personaRepositorioComando;

    @Mock
    private PersonaRepositorioConsulta personaRepositorioConsulta;

    @Mock
    private EncriptarClaveServicio encriptarClaveServicio;

    @Mock
    private AutorizacionContextoOrganizacionalServicio autorizacionServicio;

    private ModificarClaveUseCase useCase;

    @BeforeEach
    void setUp() {
        useCase = new ModificarClaveUseCase(personaRepositorioComando, personaRepositorioConsulta,
                encriptarClaveServicio, autorizacionServicio);
    }

    @Test
    void deberiaLanzarAuthorizationExceptionCuandoNoTieneAccesoAlUsuario() {
        UUID userId = UUID.randomUUID();

        doThrow(new AuthorizationException("No tiene acceso")).when(autorizacionServicio).validarAccesoAUsuario(userId);

        assertThrows(AuthorizationException.class, () -> useCase.ejecutar("oldPass", "newPass", userId));

        verify(autorizacionServicio).validarAccesoAUsuario(userId);
        verify(personaRepositorioConsulta, never()).consultarPersonaPorIdentificador(any());
    }

    @Test
    void deberiaValidarAccesoAntesDeModificarClave() {
        UUID userId = UUID.randomUUID();

        doThrow(new AuthorizationException("Sin acceso")).when(autorizacionServicio).validarAccesoAUsuario(userId);

        assertThrows(AuthorizationException.class, () -> useCase.ejecutar("old", "new", userId));

        verify(personaRepositorioComando, never()).modificarClave(any(), any());
    }
}
