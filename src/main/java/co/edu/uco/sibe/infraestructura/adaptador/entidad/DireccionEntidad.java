package co.edu.uco.sibe.infraestructura.adaptador.entidad;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import jakarta.persistence.*;
import java.util.UUID;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "direccion")
public class DireccionEntidad {
    @Id
    @Column(name = "identificador", nullable = false, updatable = false)
    private UUID identificador;

    @Column(name = "nombre", nullable = false, length = 70)
    private String nombre;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "direccion") // Columna FK en AreaEntidad
    private List<AreaEntidad> areas;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "direccion_actividad",
            joinColumns = @JoinColumn(name = "direccion", referencedColumnName = "identificador"),
            inverseJoinColumns = @JoinColumn(name = "actividad", referencedColumnName = "identificador")
    )
    private List<ActividadEntidad> actividades;
}
