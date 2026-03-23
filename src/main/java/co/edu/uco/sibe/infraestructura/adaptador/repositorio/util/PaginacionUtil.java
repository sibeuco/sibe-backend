package co.edu.uco.sibe.infraestructura.adaptador.repositorio.util;

import co.edu.uco.sibe.dominio.dto.RespuestaPaginada;
import co.edu.uco.sibe.dominio.dto.SolicitudPaginacion;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import static co.edu.uco.sibe.dominio.transversal.utilitarios.ValidadorTexto.estaCadenaVacia;

public final class PaginacionUtil {

    private PaginacionUtil() {
        throw new UnsupportedOperationException("Clase utilitaria, no instanciable");
    }

    private static final java.util.Map<String, String> ALIAS_SORT = java.util.Map.of(
            "colaborador", "persona.nombres"
    );

    public static PageRequest crearPageRequest(SolicitudPaginacion solicitud, Sort defaultSort) {
        Sort sort;
        if (!estaCadenaVacia(solicitud.getOrdenarPor())) {
            String campo = ALIAS_SORT.getOrDefault(solicitud.getOrdenarPor(), solicitud.getOrdenarPor());
            Sort.Direction direction = "desc".equalsIgnoreCase(solicitud.getDireccionOrdenamiento())
                    ? Sort.Direction.DESC
                    : Sort.Direction.ASC;
            sort = Sort.by(direction, campo)
                    .and(Sort.by(Sort.Direction.ASC, "identificador"));
        } else {
            sort = defaultSort.and(Sort.by(Sort.Direction.ASC, "identificador"));
        }
        return PageRequest.of(solicitud.getPagina(), solicitud.getTamanio(), sort);
    }

    public static <E, D> RespuestaPaginada<D> convertir(Page<E> page, Function<E, D> mapper) {
        List<D> contenido = page.getContent().stream()
                .map(mapper)
                .collect(Collectors.toList());
        return new RespuestaPaginada<>(
                contenido,
                page.getTotalElements(),
                page.getTotalPages(),
                page.getNumber()
        );
    }
}
