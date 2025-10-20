package co.edu.uco.sibe.aplicacion.comando;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class IndicadorComando {
    private String nombre;
    private String tipoIndicador;
    private String temporalidad;
    private String proyecto;
    private String publicointeres;
}