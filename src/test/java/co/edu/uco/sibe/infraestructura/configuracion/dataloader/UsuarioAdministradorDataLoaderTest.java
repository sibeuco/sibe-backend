package co.edu.uco.sibe.infraestructura.configuracion.dataloader;

import co.edu.uco.sibe.aplicacion.comando.manejador.GuardarUsuarioManejador;
import co.edu.uco.sibe.aplicacion.consulta.ConsultarDireccionPorNombreManejador;
import co.edu.uco.sibe.aplicacion.consulta.ConsultarTipoIdentificacionPorSiglaManejador;
import co.edu.uco.sibe.aplicacion.consulta.ConsultarTipoUsuarioPorCodigoManejador;
import co.edu.uco.sibe.aplicacion.consulta.HayDatosUsuarioManejador;
import co.edu.uco.sibe.dominio.modelo.Direccion;
import co.edu.uco.sibe.dominio.modelo.TipoIdentificacion;
import co.edu.uco.sibe.dominio.modelo.TipoUsuario;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.UUID;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UsuarioAdministradorDataLoaderTest {

    @Mock private HayDatosUsuarioManejador hayDatosUsuarioManejador;
    @Mock private GuardarUsuarioManejador guardarUsuarioManejador;
    @Mock private ConsultarTipoUsuarioPorCodigoManejador consultarTipoUsuarioPorCodigoManejador;
    @Mock private ConsultarTipoIdentificacionPorSiglaManejador consultarTipoIdentificacionPorSiglaManejador;
    @Mock private ConsultarDireccionPorNombreManejador consultarDireccionPorNombreManejador;

    private UsuarioAdministradorDataLoader dataLoader;

    @BeforeEach
    void setUp() {
        dataLoader = new UsuarioAdministradorDataLoader(
                hayDatosUsuarioManejador,
                guardarUsuarioManejador,
                consultarTipoUsuarioPorCodigoManejador,
                consultarTipoIdentificacionPorSiglaManejador,
                consultarDireccionPorNombreManejador
        );
    }

    @Test
    void deberiaCargarDatosCuandoNoExistenUsuarios() throws Exception {
        TipoUsuario tipoUsuario = mock(TipoUsuario.class);
        TipoIdentificacion tipoIdentificacion = mock(TipoIdentificacion.class);
        Direccion direccion = mock(Direccion.class);

        when(hayDatosUsuarioManejador.ejecutar()).thenReturn(false);
        when(consultarTipoUsuarioPorCodigoManejador.ejecutar(any())).thenReturn(tipoUsuario);
        when(consultarTipoIdentificacionPorSiglaManejador.ejecutar(any())).thenReturn(tipoIdentificacion);
        when(consultarDireccionPorNombreManejador.ejecutar(any())).thenReturn(direccion);
        when(tipoUsuario.getIdentificador()).thenReturn(UUID.randomUUID());
        when(tipoIdentificacion.getIdentificador()).thenReturn(UUID.randomUUID());
        when(direccion.getIdentificador()).thenReturn(UUID.randomUUID());

        dataLoader.run();

        verify(guardarUsuarioManejador).ejecutar(any());
    }

    @Test
    void noDeberiaCargarDatosCuandoYaExistenUsuarios() throws Exception {
        when(hayDatosUsuarioManejador.ejecutar()).thenReturn(true);

        dataLoader.run();

        verify(guardarUsuarioManejador, never()).ejecutar(any());
    }
}
