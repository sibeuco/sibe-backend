package co.edu.uco.sibe.dominio.testdatabuilder;

import co.edu.uco.sibe.dominio.dto.SolicitudPaginacion;

public class SolicitudPaginacionTestDataBuilder {
    private int pagina = 0;
    private int tamanio = 10;
    private String busqueda = null;
    private String ordenarPor = null;
    private String direccionOrdenamiento = null;

    public SolicitudPaginacionTestDataBuilder conPagina(int pagina) {
        this.pagina = pagina;
        return this;
    }

    public SolicitudPaginacionTestDataBuilder conTamanio(int tamanio) {
        this.tamanio = tamanio;
        return this;
    }

    public SolicitudPaginacionTestDataBuilder conBusqueda(String busqueda) {
        this.busqueda = busqueda;
        return this;
    }

    public SolicitudPaginacionTestDataBuilder conOrdenarPor(String ordenarPor) {
        this.ordenarPor = ordenarPor;
        return this;
    }

    public SolicitudPaginacionTestDataBuilder conDireccionOrdenamiento(String direccionOrdenamiento) {
        this.direccionOrdenamiento = direccionOrdenamiento;
        return this;
    }

    public SolicitudPaginacion construir() {
        return new SolicitudPaginacion(pagina, tamanio, busqueda, ordenarPor, direccionOrdenamiento);
    }
}
