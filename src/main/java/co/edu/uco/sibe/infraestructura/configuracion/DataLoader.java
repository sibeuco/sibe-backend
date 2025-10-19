package co.edu.uco.sibe.infraestructura.configuracion;

import co.edu.uco.sibe.aplicacion.comando.*;
import co.edu.uco.sibe.aplicacion.comando.manejador.*;
import co.edu.uco.sibe.aplicacion.consulta.*;
import co.edu.uco.sibe.dominio.enums.TipoArea;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class DataLoader implements CommandLineRunner {
    private final HayDatosTipoUsuarioManejador hayDatosTipoUsuarioManejador;
    private final GuardarTipoUsuarioManejador guardarTipoUsuarioManejador;
    private final HayDatosTipoIdentificacionManejador hayDatosTipoIdentificacionManejador;
    private final GuardarTipoIdentificacionManejador guardarTipoIdentificacionManejador;
    private final GuardarTemporalidadManejador guardarTemporalidadManejador;
    private final HayDatosTemporalidadManejador hayDatosTemporalidadManejador;
    private final GuardarEstadoActividadManejador guardarEstadoActividadManejador;
    private final HayDatosEstadoActividadManejador hayDatosEstadoActividadManejador;
    private final GuardarSubareaManejador guardarSubareaManejador;
    private final HayDatosSubareaManejador hayDatosSubareaManejador;
    private final ConsultarSubareasManejador consultarSubareasManejador;
    private final GuardarAreaManejador guardarAreaManejador;
    private final HayDatosAreaManejador hayDatosAreaManejador;
    private final ConsultarAreaManejador consultarAreaManejador;
    private final GuardarDireccionManejador guardarDireccionManejador;
    private final HayDatosDireccionManejador hayDatosDireccionManejador;
    private final AgregarNuevoUsuarioManejador agregarNuevoUsuarioManejador;
    private final HayDatosUsuarioManejador hayDatosUsuarioManejador;

    @Override
    public void run(String... args) throws Exception {
        var tipoUsuario = cargarTiposDeUsuario();
        var tipoIdentificacion = cargarTiposDeIdentificacion();
        cargarTemporalidades();
        cargarEstadosActividad();
        cargarSubareas();
        cargarAreas();
        var direccion = cargarDirecciones();
        cargarUsuarioAdministradorDeDireccion(tipoUsuario, tipoIdentificacion, direccion);
    }

    private UUID cargarTiposDeUsuario() {
        if (!this.hayDatosTipoUsuarioManejador.ejecutar()) {
            var administradorDireccion = new TipoUsuarioComando(
                    "ADMINISTRADOR_DIRECCION",
                    "Administrador de dirección",
                    true, true, true, true
            );

            var administradorArea = new TipoUsuarioComando(
                    "ADMINISTRADOR_AREA",
                    "Administrador de Area",
                    true, true, true, true
            );

            var colaborador = new TipoUsuarioComando(
                    "COLABORADOR",
                    "Colaborador",
                    true, true, false, true
            );

            var administradorDireccionRegistrado = this.guardarTipoUsuarioManejador.ejecutar(administradorDireccion);
            this.guardarTipoUsuarioManejador.ejecutar(administradorArea);
            this.guardarTipoUsuarioManejador.ejecutar(colaborador);

            return administradorDireccionRegistrado.getValor();
        }

        return null;
    }

    private UUID cargarTiposDeIdentificacion() {
        if (!this.hayDatosTipoIdentificacionManejador.ejecutar()) {
            var cedula = new TipoIdentificacionComando(
                    "CC",
                    "Cédula de Ciudadanía"
            );

            var tarjetaIdentidad = new TipoIdentificacionComando(
                    "TI",
                    "Tarjeta de Identidad"
            );

            var cedulaExtranjeria = new TipoIdentificacionComando(
                    "CE",
                    "Cédula de Extranjería"
            );

            var cedulaRegistrada = this.guardarTipoIdentificacionManejador.ejecutar(cedula);
            this.guardarTipoIdentificacionManejador.ejecutar(tarjetaIdentidad);
            this.guardarTipoIdentificacionManejador.ejecutar(cedulaExtranjeria);

            return cedulaRegistrada.getValor();
        }

        return null;
    }

    private void cargarTemporalidades() {
        if (!this.hayDatosTemporalidadManejador.ejecutar()) {
            this.guardarTemporalidadManejador.ejecutar("Diaria");
            this.guardarTemporalidadManejador.ejecutar("Semanal");
            this.guardarTemporalidadManejador.ejecutar("Mensual");
            this.guardarTemporalidadManejador.ejecutar("Trimestral");
            this.guardarTemporalidadManejador.ejecutar("Anual");
        }
    }

    private void cargarEstadosActividad() {
        if(!this.hayDatosEstadoActividadManejador.ejecutar()) {
            this.guardarEstadoActividadManejador.ejecutar("Pendiente");
            this.guardarEstadoActividadManejador.ejecutar("En curso");
            this.guardarEstadoActividadManejador.ejecutar("Finalizada");
        }
    }

    private void cargarSubareas() {
        if(!this.hayDatosSubareaManejador.ejecutar()) {
            this.guardarSubareaManejador.ejecutar("Deportes");
            this.guardarSubareaManejador.ejecutar("Cancha sintética");
            this.guardarSubareaManejador.ejecutar("Extensión cultural");
            this.guardarSubareaManejador.ejecutar("Banda Sinfónica");
            this.guardarSubareaManejador.ejecutar("Gimnasio");
            this.guardarSubareaManejador.ejecutar("Unidad de Salud");
            this.guardarSubareaManejador.ejecutar("Acompañamiento psicosocial");
            this.guardarSubareaManejador.ejecutar("Trabajo social");
        }
    }

    private void cargarAreas() {
        if(!this.hayDatosAreaManejador.ejecutar()) {
            var subareas = this.consultarSubareasManejador.ejecutar();

            var bienestar = new AreaBaseComando(
                    "Bienestar",
                    subareas
            );

            var evangelizacion = new AreaBaseComando(
                    "Evangelización",
                    new ArrayList<>()
            );

            var hogarJuvenilSantaMaria = new AreaBaseComando(
                    "Hogar Juvenil Santa María",
                    new ArrayList<>()
            );

            var servicioAtencionUsuario = new AreaBaseComando(
                    "Servicio y atención al usuario",
                    new ArrayList<>()
            );

            this.guardarAreaManejador.ejecutar(bienestar);
            this.guardarAreaManejador.ejecutar(evangelizacion);
            this.guardarAreaManejador.ejecutar(hogarJuvenilSantaMaria);
            this.guardarAreaManejador.ejecutar(servicioAtencionUsuario);
        }
    }

    private UUID cargarDirecciones() {
        if(!this.hayDatosDireccionManejador.ejecutar()) {
            var areas = this.consultarAreaManejador.ejecutar();

            var bienestar = new DireccionBaseComando(
                    "Dirección de Bienestar y Evangelización",
                    areas
            );

            return this.guardarDireccionManejador.ejecutar(bienestar).getValor();
        }

        return null;
    }

    private void cargarUsuarioAdministradorDeDireccion(UUID tipoUsuario, UUID tipoIdentificacion, UUID direccion) {
        if(!this.hayDatosUsuarioManejador.ejecutar()) {
            var area = new AreaComando(
                    direccion.toString(),
                    TipoArea.DIRECCION.toString()
            );

            var usuario = new UsuarioComando(
                    tipoIdentificacion.toString(),
                    "1111111111",
                    "Administrador",
                    "UCO",
                    "administrador@uco.net.co",
                    "Administrador123",
                    tipoUsuario.toString(),
                    area
            );

            this.agregarNuevoUsuarioManejador.ejecutar(usuario);
        }
    }
}