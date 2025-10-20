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
public class IndicadorDTO {
    private UUID identificador;
    private String nombre;
    private TipoIndicadorDTO tipoIndicador;
    private TemporalidadDTO temporalidad;
    private ProyectoDTO proyecto;
    private PublicoInteresDTO publicoInteres;
}