package co.edu.uco.sibe.infraestructura.adaptador.repositorio.consulta;

import co.edu.uco.sibe.dominio.puerto.consulta.UsuarioOrganizacionRepositorioConsulta;
import co.edu.uco.sibe.infraestructura.adaptador.dao.UsuarioOrganizacionDAO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import java.util.UUID;

@Repository
@AllArgsConstructor
public class UsuarioOrganizacionRepositorioConsultaImplementacion implements UsuarioOrganizacionRepositorioConsulta {
    private final UsuarioOrganizacionDAO usuarioOrganizacionDAO;

    @Override
    public long contarPorDireccion(UUID direccionId) {
        return usuarioOrganizacionDAO.countByDireccionIdentificador(direccionId);
    }

    @Override
    public long contarPorArea(UUID areaId) {
        return usuarioOrganizacionDAO.countByAreaIdentificador(areaId);
    }

    @Override
    public long contarPorSubarea(UUID subareaId) {
        return usuarioOrganizacionDAO.countBySubareaIdentificador(subareaId);
    }
}