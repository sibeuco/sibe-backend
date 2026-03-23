package co.edu.uco.sibe.infraestructura.adaptador.dao;

import co.edu.uco.sibe.infraestructura.adaptador.entidad.ActividadEntidad;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.UUID;

public interface ActividadDAO extends JpaRepository<ActividadEntidad, UUID> {
    ActividadEntidad findByNombreAndSemestre(String nombre, String semestre);

    @Query(value = "SELECT act FROM AreaEntidad a JOIN a.actividades act LEFT JOIN PersonaEntidad persona ON persona.identificador = act.colaborador WHERE a.identificador = :areaId",
           countQuery = "SELECT count(act) FROM AreaEntidad a JOIN a.actividades act WHERE a.identificador = :areaId")
    Page<ActividadEntidad> consultarPorArea(@Param("areaId") UUID areaId, Pageable pageable);

    @Query(value = "SELECT act FROM AreaEntidad a JOIN a.actividades act LEFT JOIN PersonaEntidad persona ON persona.identificador = act.colaborador WHERE a.identificador = :areaId AND (LOWER(act.nombre) LIKE LOWER(CONCAT('%', :busqueda, '%')) OR LOWER(CONCAT(persona.nombres, ' ', persona.apellidos)) LIKE LOWER(CONCAT('%', :busqueda, '%')))",
           countQuery = "SELECT count(act) FROM AreaEntidad a JOIN a.actividades act LEFT JOIN PersonaEntidad persona ON persona.identificador = act.colaborador WHERE a.identificador = :areaId AND (LOWER(act.nombre) LIKE LOWER(CONCAT('%', :busqueda, '%')) OR LOWER(CONCAT(persona.nombres, ' ', persona.apellidos)) LIKE LOWER(CONCAT('%', :busqueda, '%')))")
    Page<ActividadEntidad> consultarPorAreaConBusqueda(@Param("areaId") UUID areaId, @Param("busqueda") String busqueda, Pageable pageable);

    @Query(value = "SELECT act FROM DireccionEntidad d JOIN d.actividades act LEFT JOIN PersonaEntidad persona ON persona.identificador = act.colaborador WHERE d.identificador = :direccionId",
           countQuery = "SELECT count(act) FROM DireccionEntidad d JOIN d.actividades act WHERE d.identificador = :direccionId")
    Page<ActividadEntidad> consultarPorDireccion(@Param("direccionId") UUID direccionId, Pageable pageable);

    @Query(value = "SELECT act FROM DireccionEntidad d JOIN d.actividades act LEFT JOIN PersonaEntidad persona ON persona.identificador = act.colaborador WHERE d.identificador = :direccionId AND (LOWER(act.nombre) LIKE LOWER(CONCAT('%', :busqueda, '%')) OR LOWER(CONCAT(persona.nombres, ' ', persona.apellidos)) LIKE LOWER(CONCAT('%', :busqueda, '%')))",
           countQuery = "SELECT count(act) FROM DireccionEntidad d JOIN d.actividades act LEFT JOIN PersonaEntidad persona ON persona.identificador = act.colaborador WHERE d.identificador = :direccionId AND (LOWER(act.nombre) LIKE LOWER(CONCAT('%', :busqueda, '%')) OR LOWER(CONCAT(persona.nombres, ' ', persona.apellidos)) LIKE LOWER(CONCAT('%', :busqueda, '%')))")
    Page<ActividadEntidad> consultarPorDireccionConBusqueda(@Param("direccionId") UUID direccionId, @Param("busqueda") String busqueda, Pageable pageable);

    @Query(value = "SELECT act FROM SubareaEntidad s JOIN s.actividades act LEFT JOIN PersonaEntidad persona ON persona.identificador = act.colaborador WHERE s.identificador = :subareaId",
           countQuery = "SELECT count(act) FROM SubareaEntidad s JOIN s.actividades act WHERE s.identificador = :subareaId")
    Page<ActividadEntidad> consultarPorSubarea(@Param("subareaId") UUID subareaId, Pageable pageable);

    @Query(value = "SELECT act FROM SubareaEntidad s JOIN s.actividades act LEFT JOIN PersonaEntidad persona ON persona.identificador = act.colaborador WHERE s.identificador = :subareaId AND (LOWER(act.nombre) LIKE LOWER(CONCAT('%', :busqueda, '%')) OR LOWER(CONCAT(persona.nombres, ' ', persona.apellidos)) LIKE LOWER(CONCAT('%', :busqueda, '%')))",
           countQuery = "SELECT count(act) FROM SubareaEntidad s JOIN s.actividades act LEFT JOIN PersonaEntidad persona ON persona.identificador = act.colaborador WHERE s.identificador = :subareaId AND (LOWER(act.nombre) LIKE LOWER(CONCAT('%', :busqueda, '%')) OR LOWER(CONCAT(persona.nombres, ' ', persona.apellidos)) LIKE LOWER(CONCAT('%', :busqueda, '%')))")
    Page<ActividadEntidad> consultarPorSubareaConBusqueda(@Param("subareaId") UUID subareaId, @Param("busqueda") String busqueda, Pageable pageable);
}