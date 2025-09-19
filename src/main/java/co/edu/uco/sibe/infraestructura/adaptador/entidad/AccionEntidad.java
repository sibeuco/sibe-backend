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
@Table(name = "accion")
public class AccionEntidad {
    @Id
    private UUID identificador;

    @Column(length = 100, nullable = false)
    private String detalle;

    @Column(length = 100, nullable = false)
    private String objetivo;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "proyecto", nullable = false)
    private ProyectoEntidad proyecto;
}