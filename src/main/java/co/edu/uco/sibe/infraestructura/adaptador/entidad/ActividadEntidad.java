package co.edu.uco.sibe.infraestructura.adaptador.entidad;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import jakarta.persistence.*;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "actividad")
public class ActividadEntidad {
    @Id
    @Column(name = "identificador", nullable = false, updatable = false)
    private UUID identificador;

    @Column(name = "nombre", nullable = false, length = 200)
    private String nombre;

    @Column(name = "objetivo", nullable = false, length = 500)
    private String objetivo;

    @Column(name = "semestre", nullable = false, length = 6)
    private String semestre;

    @Column(name = "ruta_insumos", nullable = false, length = 3000)
    private String rutaInsumos;

    @ManyToOne
    @JoinColumn(name = "indicador")
    private IndicadorEntidad indicador;

    @JoinColumn(name = "colaborador", nullable = false)
    private UUID colaborador;
    
    @JoinColumn(name = "creador", nullable = false)
    private UUID creador;
}
