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
@Table(name = "actividad")
public class ActividadEntidad {
    @Id
    private UUID identificador;

    @Column(length = 30, nullable = false)
    private String nombre;

    @Column(length = 30, nullable = false)
    private String objetivo;

    @Column(length = 30, nullable = false)
    private String semestre;

    @Column(name = "ruta_insumos", length = 30, nullable = false)
    private String rutaInsumos;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "indicador", nullable = false)
    private IndicadorEntidad indicador;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "colaborador", nullable = false)
    private UsuarioEntidad colaborador;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "creador", nullable = false)
    private UsuarioEntidad creador;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "direccion", nullable = false)
    private DireccionEntidad direccion;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "area", nullable = false)
    private AreaEntidad area;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "subarea", nullable = false)
    private SubareaEntidad subarea;
}