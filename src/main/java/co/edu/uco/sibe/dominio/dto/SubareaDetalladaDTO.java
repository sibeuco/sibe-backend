package co.edu.uco.sibe.dominio.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SubareaDetalladaDTO {
    private String identificador;
    private String nombre;
    private List<ActividadDetalladaDTO> actividades;
}