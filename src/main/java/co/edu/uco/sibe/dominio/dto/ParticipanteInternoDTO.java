package co.edu.uco.sibe.dominio.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ParticipanteInternoDTO extends ParticipanteDTO {
    private CiudadResidenciaDTO ciudadResidencia;
    private String idCarnet;
    private String sexo;
}
