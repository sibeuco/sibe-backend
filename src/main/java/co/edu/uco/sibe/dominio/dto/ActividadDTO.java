package co.edu.uco.sibe.dominio.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ActividadDTO {
    private UUID identificador;
    private String nombre;
    private String objetivo;
    private String semestre;
    private String rutaInsumos;
    private IndicadorDTO indicador;
    private UUID colaborador;
    private UUID creador;
}
