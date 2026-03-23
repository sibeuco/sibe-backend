package co.edu.uco.sibe.infraestructura.adaptador.dao;

import co.edu.uco.sibe.infraestructura.adaptador.entidad.IdentificacionEntidad;
import co.edu.uco.sibe.infraestructura.adaptador.entidad.PersonaEntidad;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;
import java.util.UUID;

public interface PersonaDAO extends JpaRepository<PersonaEntidad, UUID> {
    PersonaEntidad findByCorreo(String correo);

    PersonaEntidad findByIdentificacion(IdentificacionEntidad identificacion);

    @Query(value = "SELECT DISTINCT p FROM PersonaEntidad p JOIN UsuarioEntidad u ON p.correo = u.correo JOIN u.rol utu JOIN utu.tipoUsuario tu JOIN UsuarioOrganizacionEntidad uo ON u.identificador = uo.usuario.identificador WHERE u.estaActivo = true AND (:tipoUsuario IS NULL OR tu.nombre = :tipoUsuario) AND (:excluirTipoUsuario IS NULL OR tu.nombre <> :excluirTipoUsuario) AND (:busqueda IS NULL OR LOWER(p.nombres) LIKE LOWER(CONCAT('%', :busqueda, '%')) OR LOWER(p.apellidos) LIKE LOWER(CONCAT('%', :busqueda, '%')) OR LOWER(p.correo) LIKE LOWER(CONCAT('%', :busqueda, '%')))",
           countQuery = "SELECT count(DISTINCT p) FROM PersonaEntidad p JOIN UsuarioEntidad u ON p.correo = u.correo JOIN u.rol utu JOIN utu.tipoUsuario tu JOIN UsuarioOrganizacionEntidad uo ON u.identificador = uo.usuario.identificador WHERE u.estaActivo = true AND (:tipoUsuario IS NULL OR tu.nombre = :tipoUsuario) AND (:excluirTipoUsuario IS NULL OR tu.nombre <> :excluirTipoUsuario) AND (:busqueda IS NULL OR LOWER(p.nombres) LIKE LOWER(CONCAT('%', :busqueda, '%')) OR LOWER(p.apellidos) LIKE LOWER(CONCAT('%', :busqueda, '%')) OR LOWER(p.correo) LIKE LOWER(CONCAT('%', :busqueda, '%')))")
    Page<PersonaEntidad> buscarUsuariosPaginado(
            @Param("busqueda") String busqueda,
            @Param("tipoUsuario") String tipoUsuario,
            @Param("excluirTipoUsuario") String excluirTipoUsuario,
            Pageable pageable);

    @Query(value = "SELECT DISTINCT p FROM PersonaEntidad p JOIN UsuarioEntidad u ON p.correo = u.correo JOIN u.rol utu JOIN utu.tipoUsuario tu JOIN UsuarioOrganizacionEntidad uo ON u.identificador = uo.usuario.identificador WHERE u.estaActivo = true AND (uo.area.identificador IN :idsOrganizacionales OR uo.subarea.identificador IN :idsOrganizacionales) AND (:tipoUsuario IS NULL OR tu.nombre = :tipoUsuario) AND (:excluirTipoUsuario IS NULL OR tu.nombre <> :excluirTipoUsuario) AND (:busqueda IS NULL OR LOWER(p.nombres) LIKE LOWER(CONCAT('%', :busqueda, '%')) OR LOWER(p.apellidos) LIKE LOWER(CONCAT('%', :busqueda, '%')) OR LOWER(p.correo) LIKE LOWER(CONCAT('%', :busqueda, '%')))",
           countQuery = "SELECT count(DISTINCT p) FROM PersonaEntidad p JOIN UsuarioEntidad u ON p.correo = u.correo JOIN u.rol utu JOIN utu.tipoUsuario tu JOIN UsuarioOrganizacionEntidad uo ON u.identificador = uo.usuario.identificador WHERE u.estaActivo = true AND (uo.area.identificador IN :idsOrganizacionales OR uo.subarea.identificador IN :idsOrganizacionales) AND (:tipoUsuario IS NULL OR tu.nombre = :tipoUsuario) AND (:excluirTipoUsuario IS NULL OR tu.nombre <> :excluirTipoUsuario) AND (:busqueda IS NULL OR LOWER(p.nombres) LIKE LOWER(CONCAT('%', :busqueda, '%')) OR LOWER(p.apellidos) LIKE LOWER(CONCAT('%', :busqueda, '%')) OR LOWER(p.correo) LIKE LOWER(CONCAT('%', :busqueda, '%')))")
    Page<PersonaEntidad> buscarUsuariosPaginadoConFiltroOrganizacional(
            @Param("idsOrganizacionales") List<UUID> idsOrganizacionales,
            @Param("busqueda") String busqueda,
            @Param("tipoUsuario") String tipoUsuario,
            @Param("excluirTipoUsuario") String excluirTipoUsuario,
            Pageable pageable);
}