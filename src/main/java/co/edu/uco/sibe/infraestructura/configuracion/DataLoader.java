package co.edu.uco.sibe.infraestructura.configuracion;

import co.edu.uco.sibe.dominio.enums.TipoArea;
import co.edu.uco.sibe.dominio.modelo.*;
import co.edu.uco.sibe.dominio.puerto.comando.PersonaRepositorioComando;
import co.edu.uco.sibe.dominio.puerto.servicio.EncriptarClaveServicio;
import co.edu.uco.sibe.dominio.service.VincularUsuarioConAreaService;
import co.edu.uco.sibe.infraestructura.adaptador.dao.*;
import co.edu.uco.sibe.infraestructura.adaptador.entidad.*;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class DataLoader implements CommandLineRunner {
    private final TipoUsuarioDAO tipoUsuarioDAO;
    private final TipoIdentificacionDAO tipoIdentificacionDAO;
    private final TemporalidadDAO temporalidadDAO;
    private final EstadoActividadDAO estadoActividadDAO;
    private final SubareaDAO subareaDAO;
    private final AreaDAO areaDAO;
    private final DireccionDAO direccionDAO;
    private final UsuarioDAO usuarioDAO;
    private final PersonaRepositorioComando personaRepositorioComando;
    private final EncriptarClaveServicio encriptarClaveServicio;
    private final VincularUsuarioConAreaService vincularUsuarioConAreaService;

    @Override
    public void run(String... args) throws Exception {
        cargarTiposDeUsuario();
        cargarTiposDeIdentificacion();
        cargarTemporalidades();
        cargarEstadosActividad();
        cargarSubareas();
        cargarAreas();
        cargarDirecciones();
        cargarUsuarioAdministradorDeDireccion();
    }

    private void cargarTiposDeUsuario() {
        if (this.tipoUsuarioDAO.count() == 0) {
            var administradorDireccion = mapearTipoUsuario("6a4c8c50-73c9-4f4d-9a31-3df78592d8ab",
                    "Administrador de dirección",
                    true, true, true, true
            );

            var administradorArea = mapearTipoUsuario("a0f0d8b1-1c15-46d8-b226-24ac77c51c28",
                    "Administrador de Area",
                    true, true, true, true
            );

            var colaborador = mapearTipoUsuario("f4b6f51e-5416-46a9-9f1a-c1eecac1738f",
                    "Colaborador",
                    true, true, false, true
            );

            tipoUsuarioDAO.save(administradorDireccion);
            tipoUsuarioDAO.save(administradorArea);
            tipoUsuarioDAO.save(colaborador);
        }
    }

    private TipoUsuarioEntidad mapearTipoUsuario(
            String identificador,
            String nombre,
            boolean crear,
            boolean modificar,
            boolean eliminar,
            boolean consultar
    ) {
        return new TipoUsuarioEntidad(
                UUID.fromString(identificador),
                nombre,
                crear,
                modificar,
                eliminar,
                consultar
        );
    }

    private void cargarTiposDeIdentificacion() {
        if (this.tipoIdentificacionDAO.count() == 0) {
            var cedula = mapearTipoIdentificacion("37a1f93d-6391-48d0-bf31-15cfc4b62f64",
                    "CC",
                    "Cédula de Ciudadanía"
            );

            var tarjetaIdentidad = mapearTipoIdentificacion("b87c8b61-86a2-46d0-8b91-98d7a4fce1d8",
                    "TI",
                    "Tarjeta de Identidad"
            );

            var cedulaExtranjeria = mapearTipoIdentificacion("b19b7848-3d9d-4821-96c3-27806f8779df",
                    "CE",
                    "Cédula de Extranjería"
            );

            tipoIdentificacionDAO.save(cedula);
            tipoIdentificacionDAO.save(tarjetaIdentidad);
            tipoIdentificacionDAO.save(cedulaExtranjeria);
        }
    }

    private TipoIdentificacionEntidad mapearTipoIdentificacion(
            String identificador,
            String sigla,
            String descripcion
    ) {
        return new TipoIdentificacionEntidad(
                UUID.fromString(identificador),
                sigla,
                descripcion
        );
    }

    private void cargarTemporalidades() {
        if (this.temporalidadDAO.count() == 0) {
            var diaria = mapearTemporalidad("51b93685-544f-4f43-8c52-7f96f593b9a7",
                    "Diaria"
            );

            var semanal = mapearTemporalidad("1a5b8d16-34ee-4627-b8a0-5bfa35cbd82e",
                    "Semanal"
            );

            var mensual = mapearTemporalidad("d66bca08-8c44-4ac5-8f26-5b4d804563c7",
                    "Mensual"
            );

            var trimestral = mapearTemporalidad("c2b68c8d-3098-4e93-97b2-217beec2a0f9",
                    "Trimestral"
            );

            var anual = mapearTemporalidad("55f8d7a2-1867-4df8-80e3-0e3b2ff4c1f0",
                    "Anual"
            );

            temporalidadDAO.save(diaria);
            temporalidadDAO.save(semanal);
            temporalidadDAO.save(mensual);
            temporalidadDAO.save(trimestral);
            temporalidadDAO.save(anual);
        }
    }

    private TemporalidadEntidad mapearTemporalidad(
            String identificador,
            String nombre
    ) {
        return new TemporalidadEntidad(
                UUID.fromString(identificador),
                nombre
        );
    }

    private void cargarEstadosActividad() {
        if(estadoActividadDAO.count() == 0) {
            var pendiente = mapearEstadoActividad("1eec4c78-2786-47a1-aeb8-3faeb406404b",
                    "Pendiente"
            );

            var enCurso = mapearEstadoActividad("97d6789c-f4b5-42f9-8d8a-71c087a0c238",
                    "En curso"
            );

            var Finalizada = mapearEstadoActividad("20b8b4f0-f99a-4c49-9c9e-38dc3022b1b8",
                    "Finalizada"
            );

            estadoActividadDAO.save(pendiente);
            estadoActividadDAO.save(enCurso);
            estadoActividadDAO.save(Finalizada);
        }
    }

    private EstadoActividadEntidad mapearEstadoActividad(
            String identificador,
            String nombre
    ) {
        return new EstadoActividadEntidad(
                UUID.fromString(identificador),
                nombre
        );
    }

    private void cargarSubareas() {
        if(subareaDAO.count() == 0) {
            var deportes = mapearSubareas("a4bb1df3-8d26-42df-9946-9a6c3eeaa5cb",
                    "Deportes",
                    new ArrayList<>()
            );

            var canchaSintetica = mapearSubareas("f48cf87e-8a8f-489c-983b-1b8b6d7e2248",
                    "Cancha sintética",
                    new ArrayList<>()
            );

            var extensionCultural = mapearSubareas("f7459a7e-8b7c-47b3-9a2f-2e90ac9e14b6",
                    "Extensión cultural ",
                    new ArrayList<>()
            );

            var bandaSinfonica = mapearSubareas("7b5a1b54-47db-4ab4-bae4-67c8b7f595c5",
                    "Banda Sinfónica ",
                    new ArrayList<>()
            );

            var gimnasio = mapearSubareas("14575a68-7322-4bb3-97ee-8c6f9451f3a8",
                    "Gimnasio",
                    new ArrayList<>()
            );

            var unidadDeSalud = mapearSubareas("c7a8d8b0-0a24-4d11-aea4-47899e4047c7",
                    "Unidad de Salud",
                    new ArrayList<>()
            );

            var acompanamientoPsicosocial = mapearSubareas("0a62a7e8-2433-4a3a-bec0-b532ce1b87e3",
                    "Acompañamiento psicosocial",
                    new ArrayList<>()
            );

            var trabajoSocial = mapearSubareas("58fd1c2a-d14b-495a-a18c-25452e72e4a0",
                    "Trabajo social",
                    new ArrayList<>()
            );

            subareaDAO.save(deportes);
            subareaDAO.save(canchaSintetica);
            subareaDAO.save(extensionCultural);
            subareaDAO.save(bandaSinfonica);
            subareaDAO.save(unidadDeSalud);
            subareaDAO.save(acompanamientoPsicosocial);
            subareaDAO.save(deportes);
            subareaDAO.save(trabajoSocial);
        }
    }

    private SubareaEntidad mapearSubareas(
            String identificador,
            String nombre,
            List<ActividadEntidad> actividades
    ) {
        return new SubareaEntidad(
                UUID.fromString(identificador),
                nombre,
                actividades
        );
    }

    private void cargarAreas() {
        if(areaDAO.count() == 0) {
            var subareas = subareaDAO.findAll();

            var bienestar = mapearAreas("f0167ff5-2e63-4e30-8e29-f4899e3cbbe1",
                    "Bienestar",
                    subareas,
                    new ArrayList<>()
            );

            var evangelizacion = mapearAreas("12f24332-8b12-4804-b4fc-cae2dbfe7499",
                    "Evangelización",
                    new ArrayList<>(),
                    new ArrayList<>()
            );

            var hogarJuvenilSantaMaria = mapearAreas("3acb0838-18b8-4b0d-9231-3b5da60e06e5",
                    "Hogar Juvenil Santa María",
                    new ArrayList<>(),
                    new ArrayList<>()
            );

            var servicioAtencionUsuario = mapearAreas("ba7ee594-0197-4049-8e9f-4b2fcbac6e36",
                    "Servicio y atención al usuario",
                    new ArrayList<>(),
                    new ArrayList<>()
            );

            areaDAO.save(bienestar);
            areaDAO.save(evangelizacion);
            areaDAO.save(hogarJuvenilSantaMaria);
            areaDAO.save(servicioAtencionUsuario);
        }
    }

    private AreaEntidad mapearAreas(
            String identificador,
            String nombre,
            List<SubareaEntidad> subareas,
            List<ActividadEntidad> actividades
    ) {
        return new AreaEntidad(
                UUID.fromString(identificador),
                nombre,
                subareas,
                actividades
        );
    }

    private void cargarDirecciones() {
        if(direccionDAO.count() == 0) {
            var areas = areaDAO.findAll();

            var bienestar = mapearDirecciones("7c02a46c-7410-4411-8b6a-f442b7b456d3",
                    "Dirección de Bienestar y Evangelización",
                    areas,
                    new ArrayList<>()
            );

            direccionDAO.save(bienestar);
        }
    }

    private DireccionEntidad mapearDirecciones(
            String identificador,
            String nombre,
            List<AreaEntidad> areas,
            List<ActividadEntidad> actividades
    ) {
        return new DireccionEntidad(
                UUID.fromString(identificador),
                nombre,
                areas,
                actividades
        );
    }

    private void cargarUsuarioAdministradorDeDireccion() {
        if(usuarioDAO.count() == 0) {
            var tipoUsuario = TipoUsuario.construir(
                    UUID.fromString("6a4c8c50-73c9-4f4d-9a31-3df78592d8ab"),
                    "Administrador de dirección",
                    true, true, true, true
            );

            var usuario = Usuario.construir(
                    UUID.fromString("f2cf3d75-8d18-4a88-8dd4-568f3c2d7b2d"),
                    "administrador@uco.net.co",
                    "Admin1234",
                    tipoUsuario,
                    true
            );

            var tipoIdentificacion = TipoIdentificacion.construir(
                    UUID.fromString("37a1f93d-6391-48d0-bf31-15cfc4b62f64"),
                    "CC",
                    "Cédula de Ciudadanía"
            );

            var identificacion = Identificacion.construir(
                    UUID.fromString("df21eb62-52ef-49e5-b20e-1ff6bb2baf8d"),
                    "1111111111",
                    tipoIdentificacion
            );

            var persona = Persona.construir(
                    UUID.fromString("eec5fda2-3264-40c0-9ae3-179f05b016dc"),
                    "Administrador",
                    "UCO",
                    "administrador@uco.net.co",
                    identificacion
            );

            var area = UUID.fromString("7c02a46c-7410-4411-8b6a-f442b7b456d3");
            var tipoArea = TipoArea.DIRECCION;
            var contrasenaEncriptada = this.encriptarClaveServicio.ejecutar(usuario.getClave());

            var identificador = this.personaRepositorioComando.agregarNuevoUsuario(usuario, persona, contrasenaEncriptada);

            this.vincularUsuarioConAreaService.ejecutar(identificador, area, tipoArea);
        }
    }
}