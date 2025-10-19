package co.edu.uco.sibe.aplicacion.comando;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ActividadComando {
    private String nombre;
    private String objetivo;
    private String semestre;
    private String rutaInsumos;
    private String indicador;
    private String colaborador;
    private String creador;
    private List<String> fechaProgramada;
    private String area;
}
