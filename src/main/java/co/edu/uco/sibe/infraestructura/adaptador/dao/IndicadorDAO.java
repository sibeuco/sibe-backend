package co.edu.uco.sibe.infraestructura.adaptador.dao;

import co.edu.uco.sibe.infraestructura.adaptador.entidad.IndicadorEntidad;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.UUID;

public interface IndicadorDAO extends JpaRepository<IndicadorEntidad, UUID> {
    IndicadorEntidad findByNombre(String nombre);

    @Query("SELECT i FROM IndicadorEntidad i JOIN i.tipoIndicador iti JOIN iti.tipoIndicador ti JOIN i.proyecto ip JOIN ip.proyecto p WHERE LOWER(i.nombre) LIKE LOWER(CONCAT('%', :busqueda, '%')) OR LOWER(ti.tipologia) LIKE LOWER(CONCAT('%', :busqueda, '%')) OR LOWER(p.nombre) LIKE LOWER(CONCAT('%', :busqueda, '%'))")
    Page<IndicadorEntidad> buscarPaginado(@Param("busqueda") String busqueda, Pageable pageable);
}