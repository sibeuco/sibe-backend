package co.edu.uco.sibe.dominio.testdatabuilder;

import co.edu.uco.sibe.dominio.dto.RespuestaPaginada;

import java.util.Collections;
import java.util.List;

public class RespuestaPaginadaTestDataBuilder<T> {
    private List<T> contenido = Collections.emptyList();
    private long totalElementos = 0;
    private int totalPaginas = 0;
    private int paginaActual = 0;

    public RespuestaPaginadaTestDataBuilder<T> conContenido(List<T> contenido) {
        this.contenido = contenido;
        return this;
    }

    public RespuestaPaginadaTestDataBuilder<T> conTotalElementos(long totalElementos) {
        this.totalElementos = totalElementos;
        return this;
    }

    public RespuestaPaginadaTestDataBuilder<T> conTotalPaginas(int totalPaginas) {
        this.totalPaginas = totalPaginas;
        return this;
    }

    public RespuestaPaginadaTestDataBuilder<T> conPaginaActual(int paginaActual) {
        this.paginaActual = paginaActual;
        return this;
    }

    public RespuestaPaginada<T> construir() {
        return new RespuestaPaginada<>(contenido, totalElementos, totalPaginas, paginaActual);
    }
}
