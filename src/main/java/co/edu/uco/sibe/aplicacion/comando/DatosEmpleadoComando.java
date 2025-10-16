package co.edu.uco.sibe.aplicacion.comando;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DatosEmpleadoComando {
    private String nombre;
    private String genero;
    private String identificacion;
    private String id_carnet;
    private String codigo_clasificacion_7;
    private String grupo_relacion_laboral;
    private String codigo_centro_costos;
    private String centro_costos_n1;
    private String codigo_ciudad_residencia;
    private String ciudad_de_residencia;
}