package co.edu.uco.sibe.infraestructura.configuracion.dataloader.fabrica;

import co.edu.uco.sibe.aplicacion.comando.TipoUsuarioComando;

public final class DatosTipoUsuarioFabrica {
    private DatosTipoUsuarioFabrica() {
        super();
    }

    public static TipoUsuarioComando crearAdministradorDireccion() {
        return new TipoUsuarioComando(
                "ADMINISTRADOR_DIRECCION",
                "Administrador de dirección",
                true, true, true, true
        );
    }

    public static TipoUsuarioComando crearAdministradorArea() {
        return new TipoUsuarioComando(
                "ADMINISTRADOR_AREA",
                "Administrador de Area",
                true, true, true, true
        );
    }

    public static TipoUsuarioComando crearColaborador() {
        return new TipoUsuarioComando(
                "COLABORADOR",
                "Colaborador",
                true, true, false, true
        );
    }
}
