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
@Table(name = "area")
public class AreaEntidad {
    @Id
    @Column(name = "identificador", nullable = false, updatable = false)
    private UUID identificador;

    @Column(name = "nombre", nullable = false, length = 70)
    private String nombre;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "area")
    private List<SubareaEntidad> subareas;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "area_actividad",
            joinColumns = @JoinColumn(name = "area", referencedColumnName = "identificador"),
            inverseJoinColumns = @JoinColumn(name = "actividad", referencedColumnName = "identificador")
    )
    private List<ActividadEntidad> actividades;
}
