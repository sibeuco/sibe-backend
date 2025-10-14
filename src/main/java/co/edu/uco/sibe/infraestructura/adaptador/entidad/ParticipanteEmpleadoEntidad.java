package co.edu.uco.sibe.infraestructura.adaptador.entidad;

import java.util.UUID;
import lombok.Getter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "participante_empleado")
@PrimaryKeyJoinColumn(name = "identificador")
public class ParticipanteEmpleadoEntidad extends ParticipanteInternoEntidad {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "relacion_laboral", nullable = false)
    private EmpleadoRelacionLaboralEntidad relacionLaboral;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "centro_costos", nullable = false)
    private EmpleadoCentroCostosEntidad centroCostos;
}
