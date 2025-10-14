package co.edu.uco.sibe.dominio.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ParticipanteEmpleadoDTO {
    private RelacionLaboralDTO relacionLaboral;
    private CentroCostosDTO centroCostos;
}