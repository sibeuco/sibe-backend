package co.edu.uco.sibe.aplicacion.comando;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class IndicadorComando {
    private String nombre;
    private UUID tipoIndicador;
    private UUID temporalidad;
    private UUID proyecto;
    private UUID publicointeres;
}
