package co.edu.uco.sibe.infraestructura.adaptador.entidad;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "empleado_relacion_laboral")
public class EmpleadoRelacionLaboralEntidad {
    @Id
    private UUID identificador;

    @ManyToOne
    @JoinColumn(name = "relacion_laboral")
    private RelacionLaboralEntidad relacionLaboral;
}