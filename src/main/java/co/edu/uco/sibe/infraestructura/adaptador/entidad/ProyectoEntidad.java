package co.edu.uco.sibe.infraestructura.adaptador.entidad;

import java.util.List;
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
@Table(name = "proyecto")
public class ProyectoEntidad {
    @Id
    @Column(name = "identificador", nullable = false, updatable = false)
    private UUID identificador;

    @Column(name = "numero_proyecto", nullable = false, length = 12)
    private String numeroProyecto;

    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    @Column(name = "objetivo", nullable = false, length = 500)
    private String objetivo;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "proyecto", referencedColumnName = "identificador")
    private List<ProyectoAccionEntidad> acciones;
}
