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
@Table(name = "interno_ciudad_residencia")
public class InternoCiudadResidenciaEntidad {
    @Id
    private UUID identificador;

    @ManyToOne
    @JoinColumn(name = "ciudad_residencia")
    private CiudadResidenciaEntidad ciudadResidencia;
}
