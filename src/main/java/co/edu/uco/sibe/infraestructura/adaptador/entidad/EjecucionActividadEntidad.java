package co.edu.uco.sibe.infraestructura.adaptador.entidad;

import java.util.UUID;
import java.time.LocalDate;
import java.time.LocalTime;
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
@Table(name = "ejecucion_actividad")
public class EjecucionActividadEntidad {
    @Id
    private UUID identificador;

    @Column(name = "fechaProgramada", nullable = false)
    private LocalDate fechaProgramada;

    @Column(name = "fechaRealizacion", nullable = false)
    private LocalDate fechaRealizacion;

    @Column(name = "horaInicio", nullable = false)
    private LocalTime horaInicio;

    @Column(name = "horaFin", nullable = false)
    private LocalTime horaFin;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "actividad", nullable = false)
    private ActividadEntidad actividad;
}
