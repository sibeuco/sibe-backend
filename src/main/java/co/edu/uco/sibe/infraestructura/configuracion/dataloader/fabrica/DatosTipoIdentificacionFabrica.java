package co.edu.uco.sibe.infraestructura.configuracion.dataloader.fabrica;

import co.edu.uco.sibe.aplicacion.comando.TipoIdentificacionComando;

public final class DatosTipoIdentificacionFabrica {
    private DatosTipoIdentificacionFabrica() {
        super();
    }

    public static TipoIdentificacionComando crearCedulaCiudadania() {
        return new TipoIdentificacionComando(
                "CC",
                "Cédula de Ciudadanía"
        );
    }

    public static TipoIdentificacionComando crearTarjetaIdentidad() {
        return new TipoIdentificacionComando(
                "TI",
                "Tarjeta de Identidad"
        );
    }

    public static TipoIdentificacionComando crearCedulaExtranjeria() {
        return new TipoIdentificacionComando(
                "CE",
                "Cédula de Extranjería"
        );
    }
}