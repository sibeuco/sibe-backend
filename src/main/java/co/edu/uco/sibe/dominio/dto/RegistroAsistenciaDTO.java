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
public class RegistroAsistenciaDTO {
    private String identificador;
    private EjecucionActividadDTO ejecucionActividad;
    private ParticipanteDTO participante;
}