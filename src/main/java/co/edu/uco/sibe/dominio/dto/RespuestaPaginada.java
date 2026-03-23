package co.edu.uco.sibe.dominio.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RespuestaPaginada<T> {
    private List<T> contenido;
    private long totalElementos;
    private int totalPaginas;
    private int paginaActual;
}
