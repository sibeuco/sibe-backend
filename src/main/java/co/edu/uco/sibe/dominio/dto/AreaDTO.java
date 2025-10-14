package co.edu.uco.sibe.dominio.dto;

import co.edu.uco.sibe.dominio.modelo.Actividad;
import co.edu.uco.sibe.dominio.modelo.Subarea;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AreaDTO {
    private UUID identificador;
    private String nombre;
    private List<SubareaDTO> subareas;
    private List<ActividadDTO> actividades;
}
