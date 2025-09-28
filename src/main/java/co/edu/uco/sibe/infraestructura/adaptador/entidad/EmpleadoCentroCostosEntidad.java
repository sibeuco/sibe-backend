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
@Table(name = "empleado_centro_costos")
public class EmpleadoCentroCostosEntidad {
    @Id
    private UUID identificador;

    @ManyToOne
    @JoinColumn(name = "empleado_centro_costos")
    private CentroCostosEntidad centroCostos;
}