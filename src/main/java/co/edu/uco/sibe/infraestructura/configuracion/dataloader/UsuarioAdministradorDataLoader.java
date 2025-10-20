package co.edu.uco.sibe.infraestructura.configuracion.dataloader;

import co.edu.uco.sibe.aplicacion.comando.manejador.AgregarNuevoUsuarioManejador;
import co.edu.uco.sibe.aplicacion.consulta.ConsultarDireccionPorNombreManejador;
import co.edu.uco.sibe.aplicacion.consulta.ConsultarTipoIdentificacionPorSiglaManejador;
import co.edu.uco.sibe.aplicacion.consulta.ConsultarTipoUsuarioPorCodigoManejador;
import co.edu.uco.sibe.aplicacion.consulta.HayDatosUsuarioManejador;
import co.edu.uco.sibe.infraestructura.configuracion.dataloader.fabrica.DatosUsuarioFabrica;
import lombok.RequiredArgsConstructor;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import static co.edu.uco.sibe.dominio.transversal.constante.NumeroConstante.OCHO;
import static co.edu.uco.sibe.infraestructura.configuracion.dataloader.fabrica.DatosDireccionFabrica.NOMBRE_DIRECCION_BIENESTAR;

@Component
@Order(OCHO)
@RequiredArgsConstructor
public class UsuarioAdministradorDataLoader extends DataLoader {
    private final HayDatosUsuarioManejador hayDatosUsuarioManejador;
    private final AgregarNuevoUsuarioManejador agregarNuevoUsuarioManejador;
    private final ConsultarTipoUsuarioPorCodigoManejador consultarTipoUsuarioPorCodigoManejador;
    private final ConsultarTipoIdentificacionPorSiglaManejador consultarTipoIdentificacionPorSiglaManejador;
    private final ConsultarDireccionPorNombreManejador consultarDireccionPorNombreManejador;

    @Override
    protected boolean debenCargarseDatos() {
        return this.hayDatosUsuarioManejador.ejecutar();
    }

    @Override
    protected void cargarDatos() {
        var tipoUsuario = consultarTipoUsuarioPorCodigoManejador.ejecutar("ADMINISTRADOR_DIRECCION");
        var tipoIdentificacion = consultarTipoIdentificacionPorSiglaManejador.ejecutar("CC");
        var direccion = consultarDireccionPorNombreManejador.ejecutar(NOMBRE_DIRECCION_BIENESTAR);

        var comando = DatosUsuarioFabrica.crearAdministradorUCO(
                tipoIdentificacion.getIdentificador(),
                tipoUsuario.getIdentificador(),
                direccion.getIdentificador()
        );

        this.agregarNuevoUsuarioManejador.ejecutar(comando);
    }
}