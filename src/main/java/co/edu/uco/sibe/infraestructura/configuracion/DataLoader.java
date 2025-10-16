package co.edu.uco.sibe.infraestructura.configuracion;

import co.edu.uco.sibe.infraestructura.adaptador.dao.TipoIdentificacionDAO;
import co.edu.uco.sibe.infraestructura.adaptador.dao.TipoUsuarioDAO;
import co.edu.uco.sibe.infraestructura.adaptador.entidad.TipoIdentificacionEntidad;
import co.edu.uco.sibe.infraestructura.adaptador.entidad.TipoUsuarioEntidad;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class DataLoader implements CommandLineRunner {
    private final TipoUsuarioDAO tipoUsuarioDAO;
    private final TipoIdentificacionDAO tipoIdentificacionDAO;

    @Override
    public void run(String... args) throws Exception {
        cargarTiposDeUsuario();
        cargarTiposDeIdentificacion();
    }

    private void cargarTiposDeUsuario() {
        if (this.tipoUsuarioDAO.count() == 0) {
            var admin = mapearTipoUsuario("d1e2f3a4-b5c6-d7e8-f9a0-b1c2d3e4f5a6",
                    "Administrador",
                    true, true, true, true
            );

            var usuario = mapearTipoUsuario("a0b9c8d7-e6f5-a4b3-c2d1-e0f9a8b7c6d5",
                    "Usuario",
                    true, true, false, true
            );

            tipoUsuarioDAO.save(admin);
            tipoUsuarioDAO.save(usuario);
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
            var cedula = mapearTipoIdentificacion("b3c8f8e0-5e3e-4b7e-8b0e-8e5e8e5e8e5e",
                    "CC",
                    "Cédula de Ciudadanía"
            );

            var tarjetaIdentidad = mapearTipoIdentificacion("a1b2c3d4-5e6f-7a8b-9c0d-1e2f3a4b5c6d",
                    "TI",
                    "Tarjeta de Identidad"
            );

            var cedulaExtranjeria = mapearTipoIdentificacion("f9e8d7c6-5b4a-3f2e-1d0c-9b8a7f6e5d4c",
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
}