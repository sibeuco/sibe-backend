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
@Table(name = "interno")
public class InternoEntidad {
    @Id
    private UUID identificador;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ciudad_residencia", nullable = false)
    private CiudadResidenciaEntidad ciudadResidencia;

    @Column(name = "id_carnet", length = 30, nullable = false)
    private String idCarnet;

    @Column(length = 30, nullable = false)
    private String sexo;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "miembro", nullable = false)
    private MiembroEntidad miembro;
}
