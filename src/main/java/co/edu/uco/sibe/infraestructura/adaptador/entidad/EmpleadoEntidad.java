package co.edu.uco.sibe.infraestructura.adaptador.entidad;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "empleado")
@PrimaryKeyJoinColumn(name = "identificador")
public class EmpleadoEntidad extends InternoEntidad {
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "relacion_laboral", nullable = false)
    private EmpleadoRelacionLaboralEntidad relacionLaboral;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "centro_costos", nullable = false)
    private EmpleadoCentroCostosEntidad centroCostos;
}