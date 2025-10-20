package co.edu.uco.sibe.infraestructura.configuracion.dataloader.fabrica;

import co.edu.uco.sibe.aplicacion.comando.AreaComando;
import co.edu.uco.sibe.aplicacion.comando.UsuarioComando;
import co.edu.uco.sibe.dominio.enums.TipoArea;

import java.util.UUID;

public final class DatosUsuarioFabrica {
    private static final String NUMERO_ID_ADMIN = "1111111111";
    private static final String NOMBRE_ADMIN = "Administrador";
    private static final String APELLIDO_ADMIN = "UCO";
    private static final String EMAIL_ADMIN = "administrador@uco.net.co";
    private static final String CLAVE_ADMIN = "Administrador123";

    private DatosUsuarioFabrica() {
        super();
    }

    public static UsuarioComando crearAdministradorUCO(UUID tipoIdentificacion, UUID tipoUsuario, UUID direccion) {
        var area = new AreaComando(
                direccion.toString(),
                TipoArea.DIRECCION.toString()
        );

        return new UsuarioComando(
                tipoIdentificacion.toString(),
                NUMERO_ID_ADMIN,
                NOMBRE_ADMIN,
                APELLIDO_ADMIN,
                EMAIL_ADMIN,
                CLAVE_ADMIN,
                tipoUsuario.toString(),
                area
        );
    }
}