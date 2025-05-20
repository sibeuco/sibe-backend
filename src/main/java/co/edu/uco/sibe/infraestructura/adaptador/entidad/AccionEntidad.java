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
@Table(name = "accion")
public class AccionEntidad {
    @Id
    private UUID identificador;

    @Column(length = 400, nullable = false)
    private String detalle;

    @Column(length = 750, nullable = false)
    private String objetivo;

    @ManyToOne(optional = false)
    @JoinColumn(name = "proyecto", nullable = false)
    private ProyectoEntidad proyecto;
}
