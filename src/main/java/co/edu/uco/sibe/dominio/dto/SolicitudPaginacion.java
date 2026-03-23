package co.edu.uco.sibe.dominio.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SolicitudPaginacion {
    private int pagina;
    private int tamanio;
    private String busqueda;
    private String ordenarPor;
    private String direccionOrdenamiento;
}
