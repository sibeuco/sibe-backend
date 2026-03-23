package co.edu.uco.sibe.infraestructura.adaptador.dao;

import co.edu.uco.sibe.infraestructura.adaptador.entidad.AccionEntidad;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.UUID;

public interface AccionDAO extends JpaRepository<AccionEntidad, UUID> {
    AccionEntidad findByDetalle(String detalle);

    @Query("SELECT a FROM AccionEntidad a WHERE LOWER(a.detalle) LIKE LOWER(CONCAT('%', :busqueda, '%')) OR LOWER(a.objetivo) LIKE LOWER(CONCAT('%', :busqueda, '%'))")
    Page<AccionEntidad> buscarPaginado(@Param("busqueda") String busqueda, Pageable pageable);
}