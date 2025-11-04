package co.edu.uco.sibe.infraestructura.configuracion.dataloader;

import co.edu.uco.sibe.aplicacion.comando.manejador.GuardarUsuarioManejador;
import co.edu.uco.sibe.aplicacion.consulta.ConsultarDireccionPorNombreManejador;
import co.edu.uco.sibe.aplicacion.consulta.ConsultarTipoIdentificacionPorSiglaManejador;
import co.edu.uco.sibe.aplicacion.consulta.ConsultarTipoUsuarioPorCodigoManejador;
import co.edu.uco.sibe.aplicacion.consulta.HayDatosUsuarioManejador;
import co.edu.uco.sibe.infraestructura.configuracion.dataloader.fabrica.DatosUsuarioFabrica;
import lombok.RequiredArgsConstructor;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import static co.edu.uco.sibe.dominio.transversal.constante.NumeroConstante.DIEZ;
import static co.edu.uco.sibe.dominio.transversal.constante.DatoConstante.*;
import static co.edu.uco.sibe.dominio.transversal.constante.SeguridadConstante.ADMINISTRADOR_DIRECCION;

@Component
@Order(DIEZ)
@RequiredArgsConstructor
public class UsuarioAdministradorDataLoader extends DataLoader {
    private final HayDatosUsuarioManejador hayDatosUsuarioManejador;
    private final GuardarUsuarioManejador guardarUsuarioManejador;
    private final ConsultarTipoUsuarioPorCodigoManejador consultarTipoUsuarioPorCodigoManejador;
    private final ConsultarTipoIdentificacionPorSiglaManejador consultarTipoIdentificacionPorSiglaManejador;
    private final ConsultarDireccionPorNombreManejador consultarDireccionPorNombreManejador;

    @Override
    protected boolean debenCargarseDatos() {
        return this.hayDatosUsuarioManejador.ejecutar();
    }

    @Override
    protected void cargarDatos() {
        var tipoUsuario = consultarTipoUsuarioPorCodigoManejador.ejecutar(ADMINISTRADOR_DIRECCION);
        var tipoIdentificacion = consultarTipoIdentificacionPorSiglaManejador.ejecutar(SIGLA_CC);
        var direccion = consultarDireccionPorNombreManejador.ejecutar(NOMBRE_DIRECCION_BIENESTAR_EVANGELIZACION);

        var comando = DatosUsuarioFabrica.crearAdministradorUCO(
                tipoIdentificacion.getIdentificador(),
                tipoUsuario.getIdentificador(),
                direccion.getIdentificador()
        );

        this.guardarUsuarioManejador.ejecutar(comando);
    }
}