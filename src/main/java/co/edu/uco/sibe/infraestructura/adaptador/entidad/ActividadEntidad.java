package co.edu.uco.sibe.infraestructura.adaptador.entidad;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "accion")
public class ActividadEntidad {
    @Id
    private UUID identificador;

    @Column(name = "nombre_capacitacion_o_evento", length = 100, nullable = false)
    private String nombreCapacitacionOEvento;

    @Column(length = 400, nullable = false)
    private String objetivo;

    @ManyToOne(optional = false)
    @JoinColumn(name = "colaborador", nullable = false)
    private UsuarioEntidad colaborador;

    @ManyToOne(optional = false)
    @JoinColumn(name = "creador", nullable = false)
    private UsuarioEntidad creador;

    @ManyToOne(optional = false)
    @JoinColumn(name = "indicador", nullable = false)
    private IndicadorEntidad indicador;

    @Column(name = "fecha_creacion", nullable = false)
    private LocalDateTime fechaCreacion;

    @Column(name = "fecha_programada", nullable = false)
    private LocalDate fechaProgramada;

    @Column(name = "fecha_realizacion")
    private LocalDate fechaRealizacion;

    @Column(name = "hora_inicio")
    private LocalTime horaInicio;

    @Column(name = "hora_fin")
    private LocalTime horaFin;

    @ManyToOne(optional = false)
    @JoinColumn(name = "estado_actividad", nullable = false)
    private EstadoActividadEntidad estadoActividad;

    @ManyToOne(optional = false)
    @JoinColumn(name = "area", nullable = false)
    private AreaEntidad area;

    @Column(name = "link_insumos", length = 200)
    private String linkInsumos;
}
