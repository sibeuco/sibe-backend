package co.edu.uco.sibe.infraestructura.adaptador.dao;

import co.edu.uco.sibe.infraestructura.adaptador.entidad.ProyectoEntidad;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.UUID;

public interface ProyectoDAO extends JpaRepository<ProyectoEntidad, UUID> {
    ProyectoEntidad findByNumeroProyecto(String numeroProyecto);

    @Query("SELECT p FROM ProyectoEntidad p WHERE LOWER(p.numeroProyecto) LIKE LOWER(CONCAT('%', :busqueda, '%')) OR LOWER(p.nombre) LIKE LOWER(CONCAT('%', :busqueda, '%')) OR LOWER(p.objetivo) LIKE LOWER(CONCAT('%', :busqueda, '%'))")
    Page<ProyectoEntidad> buscarPaginado(@Param("busqueda") String busqueda, Pageable pageable);
}